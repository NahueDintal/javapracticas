-- ============================================
-- BASE DE DATOS: SISTEMA DE SEGURIDAD
-- ============================================

-- Crear base de datos si no existe
CREATE DATABASE IF NOT EXISTS seguridad_db 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_unicode_ci;

USE seguridad_db;

-- ============================================
-- TABLA: productos
-- ============================================
CREATE TABLE IF NOT EXISTS productos (
    id INT NOT NULL AUTO_INCREMENT,
    codigo VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) NOT NULL COMMENT 'ALARMA, CAMARA, CANDADO, CERRADURA, PASADOR, MANIJA',
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    precio DECIMAL(12, 2) NOT NULL,
    atributo_extra1 VARCHAR(255),
    atributo_extra2 VARCHAR(255),
    atributo_extra3 VARCHAR(255),
    fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    notas TEXT,
    
    PRIMARY KEY (id),
    UNIQUE KEY uk_producto_codigo (codigo),
    INDEX idx_producto_tipo (tipo),
    INDEX idx_producto_marca (marca),
    INDEX idx_producto_activo (activo),
    INDEX idx_producto_fecha_creacion (fecha_creacion),
    INDEX idx_producto_marca_modelo (marca, modelo),
    
    CONSTRAINT chk_stock_positivo CHECK (stock >= 0),
    CONSTRAINT chk_precio_positivo CHECK (precio > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
COMMENT='Tabla principal de productos del sistema';

-- ============================================
-- TABLA: historial_productos (auditoría)
-- ============================================
CREATE TABLE IF NOT EXISTS historial_productos (
    id INT NOT NULL AUTO_INCREMENT,
    producto_id INT NOT NULL,
    producto_codigo VARCHAR(50) NOT NULL,
    accion ENUM('INSERT', 'UPDATE', 'DELETE', 'STOCK_UPDATE', 'PRICE_UPDATE') NOT NULL,
    cambios JSON,
    usuario VARCHAR(100),
    ip_address VARCHAR(45),
    user_agent VARCHAR(500),
    fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (id),
    INDEX idx_historial_producto_id (producto_id),
    INDEX idx_historial_fecha (fecha),
    INDEX idx_historial_accion (accion),
    
    CONSTRAINT fk_historial_producto
        FOREIGN KEY (producto_id)
        REFERENCES productos(id)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
COMMENT='Auditoría de cambios en productos';

-- ============================================
-- TABLA: proveedores
-- ============================================
CREATE TABLE IF NOT EXISTS proveedores (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(200) NOT NULL,
    contacto VARCHAR(200),
    telefono VARCHAR(20),
    email VARCHAR(200),
    direccion TEXT,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    fecha_registro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (id),
    UNIQUE KEY uk_proveedor_nombre (nombre),
    INDEX idx_proveedor_activo (activo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ============================================
-- TABLA: producto_proveedor
-- ============================================
CREATE TABLE IF NOT EXISTS producto_proveedor (
    producto_id INT NOT NULL,
    proveedor_id INT NOT NULL,
    precio_proveedor DECIMAL(12, 2) NOT NULL,
    codigo_proveedor VARCHAR(100),
    fecha_actualizacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    PRIMARY KEY (producto_id, proveedor_id),
    
    CONSTRAINT fk_pp_producto
        FOREIGN KEY (producto_id)
        REFERENCES productos(id)
        ON DELETE CASCADE,
        
    CONSTRAINT fk_pp_proveedor
        FOREIGN KEY (proveedor_id)
        REFERENCES proveedores(id)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ============================================
-- TABLA: movimientos_stock
-- ============================================
CREATE TABLE IF NOT EXISTS movimientos_stock (
    id INT NOT NULL AUTO_INCREMENT,
    producto_id INT NOT NULL,
    tipo_movimiento ENUM('ENTRADA', 'SALIDA', 'AJUSTE', 'TRANSFERENCIA') NOT NULL,
    cantidad INT NOT NULL,
    stock_anterior INT NOT NULL,
    stock_nuevo INT NOT NULL,
    motivo VARCHAR(200),
    usuario VARCHAR(100),
    referencia VARCHAR(100),
    fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (id),
    INDEX idx_movimientos_producto (producto_id),
    INDEX idx_movimientos_fecha (fecha),
    INDEX idx_movimientos_tipo (tipo_movimiento),
    
    CONSTRAINT fk_movimientos_producto
        FOREIGN KEY (producto_id)
        REFERENCES productos(id)
        ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ============================================
-- VISTAS
-- ============================================

-- Vista: productos_resumen
CREATE OR REPLACE VIEW vw_productos_resumen AS
SELECT 
    p.id,
    p.codigo,
    p.tipo,
    p.marca,
    p.modelo,
    p.stock,
    p.precio,
    p.activo,
    COUNT(DISTINCT pp.proveedor_id) as cantidad_proveedores,
    MIN(pp.precio_proveedor) as precio_min_proveedor,
    MAX(ms.fecha) as ultimo_movimiento
FROM productos p
LEFT JOIN producto_proveedor pp ON p.id = pp.producto_id
LEFT JOIN movimientos_stock ms ON p.id = ms.producto_id
GROUP BY p.id, p.codigo, p.tipo, p.marca, p.modelo, p.stock, p.precio, p.activo;

-- Vista: stock_bajo
CREATE OR REPLACE VIEW vw_stock_bajo AS
SELECT 
    p.id,
    p.codigo,
    p.marca,
    p.modelo,
    p.stock,
    p.precio,
    CASE 
        WHEN p.stock = 0 THEN 'AGOTADO'
        WHEN p.stock < 5 THEN 'BAJO'
        ELSE 'NORMAL'
    END as estado_stock
FROM productos p
WHERE p.stock < 10 AND p.activo = TRUE;

-- ============================================
-- TRIGGERS
-- ============================================

-- Trigger: auditoría de productos
DELIMITER //
CREATE TRIGGER tr_productos_audit_insert
AFTER INSERT ON productos
FOR EACH ROW
BEGIN
    INSERT INTO historial_productos (
        producto_id,
        producto_codigo,
        accion,
        cambios,
        fecha
    ) VALUES (
        NEW.id,
        NEW.codigo,
        'INSERT',
        JSON_OBJECT(
            'nuevo_codigo', NEW.codigo,
            'nueva_marca', NEW.marca,
            'nuevo_modelo', NEW.modelo,
            'nuevo_stock', NEW.stock,
            'nuevo_precio', NEW.precio
        ),
        NOW()
    );
END//

CREATE TRIGGER tr_productos_audit_update
AFTER UPDATE ON productos
FOR EACH ROW
BEGIN
    DECLARE cambios_json JSON DEFAULT JSON_OBJECT();
    
    -- Comparar cambios
    IF OLD.codigo != NEW.codigo THEN
        SET cambios_json = JSON_SET(cambios_json, '$.codigo', JSON_OBJECT('anterior', OLD.codigo, 'nuevo', NEW.codigo));
    END IF;
    
    IF OLD.precio != NEW.precio THEN
        SET cambios_json = JSON_SET(cambios_json, '$.precio', JSON_OBJECT('anterior', OLD.precio, 'nuevo', NEW.precio));
    END IF;
    
    IF OLD.stock != NEW.stock THEN
        SET cambios_json = JSON_SET(cambios_json, '$.stock', JSON_OBJECT('anterior', OLD.stock, 'nuevo', NEW.stock));
    END IF;
    
    -- Insertar en auditoría solo si hay cambios
    IF JSON_LENGTH(cambios_json) > 0 THEN
        INSERT INTO historial_productos (
            producto_id,
            producto_codigo,
            accion,
            cambios,
            fecha
        ) VALUES (
            NEW.id,
            NEW.codigo,
            'UPDATE',
            cambios_json,
            NOW()
        );
    END IF;
END//

CREATE TRIGGER tr_movimientos_stock_insert
AFTER INSERT ON movimientos_stock
FOR EACH ROW
BEGIN
    -- Actualizar stock en productos
    UPDATE productos 
    SET stock = NEW.stock_nuevo,
        fecha_actualizacion = NOW()
    WHERE id = NEW.producto_id;
END//
DELIMITER ;

-- ============================================
-- PROCEDIMIENTOS ALMACENADOS
-- ============================================

-- Procedimiento: registrar_movimiento_stock
DELIMITER //
CREATE PROCEDURE sp_registrar_movimiento_stock(
    IN p_producto_id INT,
    IN p_tipo_movimiento VARCHAR(20),
    IN p_cantidad INT,
    IN p_motivo VARCHAR(200),
    IN p_usuario VARCHAR(100),
    IN p_referencia VARCHAR(100)
)
BEGIN
    DECLARE v_stock_actual INT;
    DECLARE v_stock_nuevo INT;
    
    -- Obtener stock actual
    SELECT stock INTO v_stock_actual
    FROM productos 
    WHERE id = p_producto_id;
    
    -- Calcular nuevo stock
    IF p_tipo_movimiento = 'ENTRADA' THEN
        SET v_stock_nuevo = v_stock_actual + p_cantidad;
    ELSEIF p_tipo_movimiento = 'SALIDA' THEN
        SET v_stock_nuevo = v_stock_actual - p_cantidad;
    ELSE
        SET v_stock_nuevo = p_cantidad; -- Para ajustes
    END IF;
    
    -- Insertar movimiento
    INSERT INTO movimientos_stock (
        producto_id,
        tipo_movimiento,
        cantidad,
        stock_anterior,
        stock_nuevo,
        motivo,
        usuario,
        referencia
    ) VALUES (
        p_producto_id,
        p_tipo_movimiento,
        p_cantidad,
        v_stock_actual,
        v_stock_nuevo,
        p_motivo,
        p_usuario,
        p_referencia
    );
END//

-- Procedimiento: obtener_reporte_productos
CREATE PROCEDURE sp_obtener_reporte_productos(
    IN p_tipo VARCHAR(20),
    IN p_marca VARCHAR(100),
    IN p_stock_min INT,
    IN p_stock_max INT
)
BEGIN
    SELECT 
        p.codigo,
        p.tipo,
        p.marca,
        p.modelo,
        p.stock,
        p.precio,
        CASE 
            WHEN p.stock = 0 THEN 'AGOTADO'
            WHEN p.stock < 5 THEN 'BAJO'
            WHEN p.stock > 20 THEN 'EXCESO'
            ELSE 'NORMAL'
        END as estado_inventario,
        COUNT(pp.proveedor_id) as proveedores,
        p.fecha_actualizacion
    FROM productos p
    LEFT JOIN producto_proveedor pp ON p.id = pp.producto_id
    WHERE (p_tipo IS NULL OR p.tipo = p_tipo)
        AND (p_marca IS NULL OR p.marca = p_marca)
        AND (p.stock BETWEEN p_stock_min AND p_stock_max)
        AND p.activo = TRUE
    GROUP BY p.id
    ORDER BY p.stock ASC, p.precio DESC;
END//
DELIMITER ;

-- ============================================
-- DATOS INICIALES
-- ============================================

-- Insertar proveedores de ejemplo
INSERT INTO proveedores (nombre, contacto, telefono, email, direccion) VALUES
('Seguridad Total S.A.', 'Juan Pérez', '+54 11 1234-5678', 'ventas@seguridadtotal.com', 'Av. Siempre Viva 123, CABA'),
('ElectroSeg SRL', 'María Gómez', '+54 351 987-6543', 'info@electroseg.com', 'Calle Falsa 456, Córdoba'),
('Alarmas Profesionales', 'Carlos Rodríguez', '+54 341 555-1234', 'contacto@alarmaspro.com', 'Bv. Oroño 789, Rosario')
ON DUPLICATE KEY UPDATE nombre = VALUES(nombre);

-- Insertar productos de ejemplo
INSERT INTO productos (codigo, tipo, marca, modelo, stock, precio, atributo_extra1, atributo_extra2) VALUES
('AL001', 'ALARMA', 'Ezviz', 'C9C', 4, 95000.00, 'true', NULL),
('AL002', 'ALARMA', 'Hikvision', 'DS-PWA', 8, 120000.00, 'false', NULL),
('Cam001', 'CAMARA', 'Hikvision', 'DS-2CD', 10, 120000.00, 'WiFi', '1080p'),
('Cam002', 'CAMARA', 'Dahua', 'IPC-HDW', 15, 85000.00, 'PoE', '4MP'),
('Can001', 'CANDADO', 'Olaen', 'Art.30', 5, 30000.00, '2', NULL),
('Can002', 'CANDADO', 'Master Lock', 'ProSeries', 3, 45000.00, '3', 'Resistente al agua'),
('Cer001', 'CERRADURA', 'Prive', '208', 6, 35000.00, '4', NULL),
('Cer002', 'CERRADURA', 'Yale', 'Nexus', 12, 55000.00, '6', 'Digital'),
('Pas001', 'PASADOR', 'FVP', 'Supra', 20, 15000.00, 'Blanco', 'true'),
('Man001', 'MANIJA', 'Ferrum', 'Linea D', 25, 18000.00, 'Cromo', NULL)
ON DUPLICATE KEY UPDATE 
    marca = VALUES(marca),
    modelo = VALUES(modelo),
    stock = VALUES(stock),
    precio = VALUES(precio);

-- Relacionar productos con proveedores
INSERT INTO producto_proveedor (producto_id, proveedor_id, precio_proveedor, codigo_proveedor) 
SELECT p.id, pr.id, 
    CASE 
        WHEN p.tipo = 'ALARMA' THEN p.precio * 0.7
        WHEN p.tipo = 'CAMARA' THEN p.precio * 0.65
        ELSE p.precio * 0.6
    END,
    CONCAT('PROV-', p.codigo)
FROM productos p
CROSS JOIN proveedores pr
WHERE pr.id IN (1, 2)  -- Solo primeros dos proveedores
ON DUPLICATE KEY UPDATE 
    precio_proveedor = VALUES(precio_proveedor);

-- ============================================
-- USUARIOS Y PERMISOS
-- ============================================

-- Crear usuario de aplicación con permisos limitados
CREATE USER IF NOT EXISTS 'seguridad_app'@'%' IDENTIFIED BY 'AppPassword123!';
GRANT SELECT, INSERT, UPDATE ON seguridad_db.productos TO 'seguridad_app'@'%';
GRANT SELECT, INSERT ON seguridad_db.movimientos_stock TO 'seguridad_app'@'%';
GRANT SELECT ON seguridad_db.proveedores TO 'seguridad_app'@'%';
GRANT SELECT ON seguridad_db.vw_productos_resumen TO 'seguridad_app'@'%';
GRANT SELECT ON seguridad_db.vw_stock_bajo TO 'seguridad_app'@'%';
GRANT EXECUTE ON PROCEDURE seguridad_db.sp_registrar_movimiento_stock TO 'seguridad_app'@'%';
GRANT EXECUTE ON PROCEDURE seguridad_db.sp_obtener_reporte_productos TO 'seguridad_app'@'%';

-- Crear usuario de solo lectura para reportes
CREATE USER IF NOT EXISTS 'seguridad_reportes'@'%' IDENTIFIED BY 'Reportes456!';
GRANT SELECT ON seguridad_db.* TO 'seguridad_reportes'@'%';
GRANT EXECUTE ON PROCEDURE seguridad_db.sp_obtener_reporte_productos TO 'seguridad_reportes'@'%';

-- Crear usuario administrador
CREATE USER IF NOT EXISTS 'seguridad_admin'@'%' IDENTIFIED BY 'Admin789!';
GRANT ALL PRIVILEGES ON seguridad_db.* TO 'seguridad_admin'@'%' WITH GRANT OPTION;

-- Actualizar privilegios
FLUSH PRIVILEGES;

-- ============================================
-- FINALIZACIÓN
-- ============================================
SHOW TABLES;
SELECT 'Base de datos seguridad_db inicializada correctamente' as Mensaje;

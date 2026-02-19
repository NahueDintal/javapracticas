CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) UNIQUE NOT NULL,
    marca VARCHAR(100),
    modelo VARCHAR(100),
    stock INT,
    precio DECIMAL(10,2),
    tipo VARCHAR(50),
    atributos JSON
);
-- Puedes agregar más tablas según tu modelo

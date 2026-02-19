-- Script de inicialización para MySQL
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) UNIQUE,
    marca VARCHAR(100),
    modelo VARCHAR(100),
    stock INT,
    precio DECIMAL(10,2)
);

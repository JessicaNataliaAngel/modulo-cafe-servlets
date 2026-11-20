-- Script de creación de base de datos para Evidencia GA7-220501096-AA2-EV02
CREATE DATABASE IF NOT EXISTS cafe_nueva_prueba
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE cafe_nueva_prueba;

CREATE TABLE IF NOT EXISTS productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cafe VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL
);

INSERT INTO productos (nombre_cafe, precio) VALUES
('Café Origen Huila', 24500.0),
('Café Premium Sierra Nevada', 28900.0),
('Café Especial Quindío', 26000.0),
('Café Nariño Supremo', 27500.0);

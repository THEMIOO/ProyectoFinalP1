DROP USER IF EXISTS 'final'@'localhost';
CREATE USER 'final'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON db_final.* TO 'final'@'localhost';

DROP DATABASE IF EXISTS db_final;
CREATE DATABASE db_final;

USE db_final;

CREATE TABLE contactos (
	id_contacto INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(25) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    empresa VARCHAR(45) NOT NULL, 
    telefono VARCHAR(13) NOT NULL,
    correo VARCHAR(60) NOT NULL,
    PRIMARY KEY (id_contacto)
);

INSERT INTO contactos (nombre, apellidos, empresa, telefono, correo) VALUES 
('Juan', 'Pérez', 'Tech Solutions', '809-555-1234', 'jurez@techsolutions.com'),
('María', 'Gómez', 'Innovatech', '809-555-5678', 'maez@innovatech.com'),
('Carlos', 'López', 'Creative Minds', '809-555-9012', 'carz@creativeminds.com'),
('Ana', 'Martínez', 'Global Industries', '809-555-3456', 'ana@globalind.com'),
('Luis', 'Rodríguez', 'Alpha Corp', '809-555-7890', 'luisz@alphacorp.com'),
('Laura', 'Fernández', 'NextGen Tech', '809-555-2345', 'laez@nextgentech.com'),
('Pedro', 'García', 'Future Innovators', '809-555-6789', 'pecia@futureinnovators.com'),
('Lucía', 'Hernández', 'Visionary Ltd.', '809-555-0123', 'luandez@visionaryltd.com'),
('Javier', 'Sánchez', 'Digital Pioneers', '809-555-4567', 'javchez@digitalpioneers.com'),
('Elena', 'Ramírez', 'Tech Innovators', '809-555-8901', 'elirez@techinnovators.com');
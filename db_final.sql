DROP USER IF EXISTS 'final'@'localhost';
CREATE USER 'final'@'localhost' IDENTIFIED BY '123456';

DROP DATABASE IF EXISTS db_final;
CREATE DATABASE db_final;

USE db_final;

CREATE TABLE contacto (
	id_empleado INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(25) NOT NULL,
    apellidos VARCHAR(30) NOT NULL,
    empresa VARCHAR(45) NOT NULL, 
    telefono VARCHAR(13) NOT NULL,
    correo VARCHAR(60) NOT NULL,
    PRIMARY KEY (id_empleado)
);
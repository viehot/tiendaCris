DROP DATABASE IF EXISTS negocioCris;
CREATE DATABASE negocioCris CHARACTER SET utf8mb4;
USE negocioCris;

CREATE TABLE producto (
	id INTEGER UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    stock INT(100) NOT NULL,
    precio DOUBLE(100,00) NOT NULL,
    descripcion VARCHAR(255) NULL,
    id_marca INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (id_marca) REFERENCES marca(id_mar)
);

CREATE TABLE marca (
	id_mar INTEGER UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_mar)
);

INSERT INTO marca VALUES (1,'GENIUS');
INSERT INTO marca VALUES (2,'ASUS');
INSERT INTO marca VALUES (3,'HP');

INSERT INTO producto VALUES (100,'Teclado RGB',10,1800.00,'Un Teclado para niños ratas',1);
INSERT INTO producto VALUES (150,'Placa Video',2,200000.00,'Para MinaR',2);
INSERT INTO producto VALUES (145,'Auris De Conejo',15,3000.00,NULL,1);
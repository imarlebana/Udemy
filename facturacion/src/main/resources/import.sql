INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Andres','Guzman','profesor@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Jose','Gonzalez','jgonzalez@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Carlos','Arebalo','arebalo@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Ines','Raya','iraya@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Adrian','Heredia','aheredia@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Sara','chavez','schavez@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Bernardo','moreno','bmoreno@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Mari','chavez','mchavez@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Marti','Teixido','mteixido@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Miguel','Blazquez','mblazquez@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Cesar','Conde','cconde@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Jaime','Arcos','jarcos@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Javier','Placer','jplacer@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Ana','Ramirez','aramirez@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Laura','Lazo','llazo@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Christian','Alvarez','calvarez@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Manuel','Perez','mperez@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Fernando','Rioja','frioja@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Alvaro','Simon','asimon@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Zaida','Benamed','zbenamed@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Julio','Sierra','jsierra@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Alex','Gomez','agomez@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Nicolas','Tenes','ntenes@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Jose','Fernandez','jfernandez@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Pepe','Pepon','ppepon@bolsadeideas.com','2017-08-28','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Juan','Grande','jgrande@bolsadeideas.com','2017-08-30','');
INSERT INTO CLIENTES (nombre,apellido,email,create_at,foto) VALUES('Ricardo','Romero','rromero@bolsadeideas.com','2017-08-28','');


/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

/* Creamos algunas facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);
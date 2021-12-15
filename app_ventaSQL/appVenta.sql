--Creacion de tablas

Create table TipoTransaccion(
	id_tipoTransaccion serial,
	concepto varchar(100),
	primary key (id_tipoTransaccion)
);

Create table CategoriaProducto(
	id_categoria serial,
	nombre varchar(100),
	primary key (id_categoria)
);

Create table Usuario(
	id_usuario serial,
	dni varchar(8),
	nombre varchar(100),
	apellido varchar(100),
	email varchar(100),
	contrasena varchar(100),
	primary key (id_usuario)
);

Create table UsuarioTelefono(
	telefono varchar(9),
	id_usuario int,
	primary key (telefono,id_usuario),
	foreign key (id_usuario) references Usuario(id_usuario)
);

Create table Presupuesto(
	id_presupuesto serial,
	nombre_presupuesto varchar(100),
	monto_presupuesto numeric(9,2),
	id_usuario int,
	primary key (id_presupuesto),
	foreign key (id_usuario) references Usuario(id_usuario)
);

Create table Producto(
	id_producto serial,
	nombre varchar(100),
	precio_unidad numeric(9,2),
	descripcion varchar(100),
	marca varchar(100),
	existencias int,
	id_categoria int,
	primary key (id_producto),
	foreign key (id_categoria) references CategoriaProducto(id_categoria)
);

Create table Transaccion(
	id_transaccion serial,
	monto numeric(9,2),
	fecha timestamp,
	id_tipoTransaccion int,
	id_usuario int,
	primary key (id_transaccion),
	foreign key (id_usuario) references Usuario(id_usuario),
	foreign key (id_tipoTransaccion) references TipoTransaccion(id_tipoTransaccion)
);

Create table DetalleTransaccion(
	id_detalleTransaccion serial,
	id_transaccion int,
	cantidad int,
	monto_subtotal numeric(9,2),
	id_producto int,
	primary key(id_detalleTransaccion,id_transaccion),
	foreign key (id_transaccion) references Transaccion (id_transaccion),
	foreign key (id_producto) references Producto (id_producto)
);

--Añadiendo algunos datos
--
Insert into TipoTransaccion(concepto) values ('Venta');
Insert into TipoTransaccion(concepto) values ('Compra');
Insert into TipoTransaccion(concepto) values ('Ingreso extra');
Insert into TipoTransaccion(concepto) values ('Egreso extra');

Select*from TipoTransaccion;

--
Insert into CategoriaProducto(nombre) values ('Lacteos');
Insert into CategoriaProducto(nombre) values ('Alcohol');
Insert into CategoriaProducto(nombre) values ('Bebidas energeticas');
Insert into CategoriaProducto(nombre) values ('Verduras');
Insert into CategoriaProducto(nombre) values ('Dulces');
Insert into CategoriaProducto(nombre) values ('Bebidas gaseosas');
Insert into CategoriaProducto(nombre) values ('Bebidas no gaseosas');
Insert into CategoriaProducto(nombre) values ('Snack');

Select*from CategoriaProducto;

--
Insert into Usuario(dni,nombre,apellido,email,contrasena) values ('20591822','Jose','Miguel','jmdad@mail.com','dsada5122');
Insert into Usuario(dni,nombre,apellido,email,contrasena) values ('47636030','Raul','Gonzales','rgonza455@mail.com','ggdagagad');
Insert into Usuario(dni,nombre,apellido,email,contrasena) values ('48711555','Daniel','Sanchez','Dado5445@mail.com','egaadfsa');

Select*from Usuario;
SELECT * FROM Usuario
WHERE dni = '48711555' AND contrasena = 'egaadfsa';

--
Insert into UsuarioTelefono(telefono,id_usuario) values ('894565501',1);
Insert into UsuarioTelefono(telefono,id_usuario) values ('905960323',2);
Insert into UsuarioTelefono(telefono,id_usuario) values ('950956262',3);
Insert into UsuarioTelefono(telefono,id_usuario) values ('650646132',2);
Insert into UsuarioTelefono(telefono,id_usuario) values ('975450432',3);

Select*from UsuarioTelefono;

--
Insert into Presupuesto(nombre_presupuesto,monto_presupuesto,id_usuario) values ('Presupuesto Marzo',2000,2);
Insert into Presupuesto(nombre_presupuesto,monto_presupuesto,id_usuario) values ('Presupuesto Marzo',5000,3);
Insert into Presupuesto(nombre_presupuesto,monto_presupuesto,id_usuario) values ('Presupuesto Marzo',1000,1);
Insert into Presupuesto(nombre_presupuesto,monto_presupuesto,id_usuario) values ('Presupuesto Mayo',4000,3);
Insert into Presupuesto(nombre_presupuesto,monto_presupuesto,id_usuario) values ('Presupuesto Mayo',3000,1);
Insert into Presupuesto(nombre_presupuesto,monto_presupuesto,id_usuario) values ('Presupuesto Junio',5000,2);
Insert into Presupuesto(nombre_presupuesto,monto_presupuesto,id_usuario) values ('Presupuesto Junio',1000,1);

Select*from Presupuesto;

--
Insert into Producto(nombre,precio_unidad,descripcion,marca,existencias,id_categoria) values ('Leche',3.5,'en tarro','Gloria',100,1);
Insert into Producto(nombre,precio_unidad,descripcion,marca,existencias,id_categoria) values ('Leche',3,'en tarro','Laive',100,1);
Insert into Producto(nombre,precio_unidad,descripcion,marca,existencias,id_categoria) values ('Leche',3.70,'en tarro','Pura Vida',100,1);
Insert into Producto(nombre,precio_unidad,descripcion,marca,existencias,id_categoria) values ('Navo',0.5,'unidades',' ',100,4);

Select*from Producto;

--
Insert into Transaccion(monto,fecha,id_tipoTransaccion,id_usuario) values (14,current_timestamp,1,1);
Insert into Transaccion(monto,fecha,id_tipoTransaccion,id_usuario) values (3.5,'2008/12/31 13:00:00.59',1,1);
Insert into Transaccion(monto,fecha,id_tipoTransaccion,id_usuario) values (7,current_timestamp,1,1);
Insert into Transaccion(monto,fecha,id_tipoTransaccion,id_usuario) values (5,current_timestamp,1,1);
Insert into Transaccion(monto,fecha,id_tipoTransaccion,id_usuario) values (6,current_timestamp,3,1);
Insert into Transaccion(monto,fecha,id_tipoTransaccion,id_usuario) values (4,current_timestamp,4,1);

Select*from Transaccion;

--
Insert into DetalleTransaccion(id_transaccion,cantidad,monto_subtotal,id_producto) values (1,4,14,1);
Insert into DetalleTransaccion(id_transaccion,cantidad,monto_subtotal,id_producto) values (2,1,3.5,1);
Insert into DetalleTransaccion(id_transaccion,cantidad,monto_subtotal,id_producto) values (3,2,7,1);
Insert into DetalleTransaccion(id_transaccion,cantidad,monto_subtotal,id_producto) values (4,1,3.5,1);
Insert into DetalleTransaccion(id_transaccion,cantidad,monto_subtotal,id_producto) values (4,3,1.5,4);
Insert into DetalleTransaccion(id_transaccion,cantidad,monto_subtotal) values (5,1,6);

Select*from DetalleTransaccion;

Select T.id_transaccion,D.id_detalleTransaccion,T.id_tipoTransaccion,T.fecha,D.cantidad,
D.monto_subtotal,T.monto,T.id_usuario,D.id_producto
from Transaccion T 
inner join DetalleTransaccion D
on T.id_transaccion = D.id_transaccion;

--Autenticar usuario
SELECT * FROM Usuario
WHERE dni = ? AND contrasena = ?;
--Registrar usuario
INSERT INTO Usuario(dni,nombre,apellido,email,contrasena) VALUES (?,?,?,?,?);


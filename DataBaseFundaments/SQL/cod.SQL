--   -------------------------------------------------- 
--   Generated by Enterprise Architect Version 6.1.787
--   Created On : lunes, 30 abril, 2018 
--   DBMS       : Oracle 
--   -------------------------------------------------- 




--  Create Tables 
CREATE TABLE Categoria ( 
	Id_categoria NUMBER(3) NOT NULL,    --  Id unico de la categoria, la cual clasifica los productos. 
	Nombre VARCHAR(22) NOT NULL,    --  Nombre de la categoria. 
	Descripcion VARCHAR(70),    --  Descripcion breve de la categoria 
	fk_Rut_proov NUMBER(8) NOT NULL    --  Registro unico tributario del proovedor que suministra los productos de la categoria especifica. 
)
;

COMMENT ON COLUMN Categoria.Id_categoria
    IS 'Id unico de la categoria, la cual clasifica los productos.'
;

COMMENT ON COLUMN Categoria.Nombre
    IS 'Nombre de la categoria.'
;

COMMENT ON COLUMN Categoria.Descripcion
    IS 'Descripcion breve de la categoria'
;

COMMENT ON COLUMN Categoria.fk_Rut_proov
    IS 'Registro unico tributario del proovedor que suministra los productos de la categoria especifica.'
;

CREATE TABLE Cliente ( 
	Rut_cliente NUMBER(8) NOT NULL,    --  Registro unico tributario del cliente. 
	Nombre VARCHAR(22) NOT NULL,    --  Nombre del proovedor. 
	Direccion VARCHAR(44),    --  Direccion del cliente. 
	Lim_credito NUMBER(7) NOT NULL,    --  Limite de credito del cliente, no puede ser mayor a 5.000.000 
	Saldo_credito NUMBER(11) NOT NULL,
	Telefonos NUMBER(12) NOT NULL    --  Telefono del cliente. 
)
;

COMMENT ON COLUMN Cliente.Rut_cliente
    IS 'Registro unico tributario del cliente.'
;

COMMENT ON COLUMN Cliente.Nombre
    IS 'Nombre del proovedor.'
;

COMMENT ON COLUMN Cliente.Direccion
    IS 'Direccion del cliente.'
;

COMMENT ON COLUMN Cliente.Lim_credito
    IS 'Limite de credito del cliente, no puede ser mayor a 5.000.000'
;

COMMENT ON COLUMN Cliente.Telefonos
    IS 'Telefono del cliente.'
;

CREATE TABLE Producto ( 
	Id_producto NUMBER(8) NOT NULL,    --  Identificacion unica del producto. 
	Nombre VARCHAR(18) NOT NULL,    --  Nombre del producto. 
	Precio_actual NUMBER(11,2) NOT NULL,    --  Precio actual del producto en stock. 
	Stock NUMBER(5) NOT NULL,    --  Cantidad de ejemplares de un producto en especifico. 
	fk_Id_categoria NUMBER(3) NOT NULL    --  Id unico  de la categoria a la cual pertenece el producto. 
)
;

COMMENT ON COLUMN Producto.Id_producto
    IS 'Identificacion unica del producto.'
;

COMMENT ON COLUMN Producto.Nombre
    IS 'Nombre del producto.'
;

COMMENT ON COLUMN Producto.Precio_actual
    IS 'Precio actual del producto en stock.'
;

COMMENT ON COLUMN Producto.Stock
    IS 'Cantidad de ejemplares de un producto en especifico.'
;

COMMENT ON COLUMN Producto.fk_Id_categoria
    IS 'Id unico  de la categoria a la cual pertenece el producto.'
;

CREATE TABLE Proovedor ( 
	Rut_proov NUMBER(8) NOT NULL,    --  Registro unico tributario del proovedor 
	Nombre VARCHAR(22) NOT NULL,    --  Nombre del proovedor. 
	Direccion VARCHAR(44),    --  Direccion del proovedor. 
	Telefono NUMBER(12) NOT NULL,    --  Telefono del proovedor 
	Web_page VARCHAR(30) NOT NULL    --  Pagina web del proovedor 
)
;

COMMENT ON COLUMN Proovedor.Rut_proov
    IS 'Registro unico tributario del proovedor'
;

COMMENT ON COLUMN Proovedor.Nombre
    IS 'Nombre del proovedor.'
;

COMMENT ON COLUMN Proovedor.Direccion
    IS 'Direccion del proovedor.'
;

COMMENT ON COLUMN Proovedor.Telefono
    IS 'Telefono del proovedor'
;

COMMENT ON COLUMN Proovedor.Web_page
    IS 'Pagina web del proovedor'
;

CREATE TABLE Ventas ( 
	Id_venta NUMBER(8) NOT NULL,    --  Id unica de la venta. 
	Fecha DATE NOT NULL,    --  Fecha en la cual se realiza la compra. 
	fk_Id_cliente NUMBER(8) NOT NULL,    --  Id del cliente que realiza la compra. 
	Descuento NUMBER(3) NOT NULL,    --  Porcentaje del descuento que se aplicara al producto. 
	Monto_final NUMBER(11,2) NOT NULL,    --  Precio final despues de aplicar el descuento. 
	fk_Id_producto NUMBER(8) NOT NULL    --  Id del producto que pertenece a la venta. 
)
;

COMMENT ON COLUMN Ventas.Id_venta
    IS 'Id unica de la venta.'
;

COMMENT ON COLUMN Ventas.Fecha
    IS 'Fecha en la cual se realiza la compra.'
;

COMMENT ON COLUMN Ventas.fk_Id_cliente
    IS 'Id del cliente que realiza la compra.'
;

COMMENT ON COLUMN Ventas.Descuento
    IS 'Porcentaje del descuento que se aplicara al producto.'
;

COMMENT ON COLUMN Ventas.Monto_final
    IS 'Precio final despues de aplicar el descuento.'
;

COMMENT ON COLUMN Ventas.fk_Id_producto
    IS 'Id del producto que pertenece a la venta.'
;


--  Create Primary Key Constraints 
ALTER TABLE Categoria ADD CONSTRAINT PK_Categoria 
	PRIMARY KEY (Id_categoria, fk_Rut_proov)
;

ALTER TABLE Cliente ADD CONSTRAINT PK_Cliente 
	PRIMARY KEY (Rut_cliente)
;

ALTER TABLE Producto ADD CONSTRAINT PK_Producto 
	PRIMARY KEY (Id_producto, fk_Id_categoria)
;

ALTER TABLE Proovedor ADD CONSTRAINT PK_Proovedor 
	PRIMARY KEY (Rut_proov)
;

ALTER TABLE Ventas ADD CONSTRAINT PK_Ventas 
	PRIMARY KEY (Id_venta, fk_Id_cliente, fk_Id_producto)
;




--  Create Foreign Key Constraints 
ALTER TABLE Categoria ADD CONSTRAINT FK_Categoria_Producto 
	FOREIGN KEY (fk_Rut_proov) REFERENCES Producto (Id_producto, fk_Id_categoria)
;

ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_Ventas 
	FOREIGN KEY (Rut_cliente) REFERENCES Ventas (Id_venta, fk_Id_cliente, fk_Id_producto)
;

ALTER TABLE Producto ADD CONSTRAINT FK_Producto_Ventas 
	FOREIGN KEY (Id_producto) REFERENCES Ventas (Id_venta, fk_Id_cliente, fk_Id_producto)
;

ALTER TABLE Proovedor ADD CONSTRAINT FK_Proovedor_Categoria 
	FOREIGN KEY (Rut_proov) REFERENCES Categoria (Id_categoria, fk_Rut_proov)
;

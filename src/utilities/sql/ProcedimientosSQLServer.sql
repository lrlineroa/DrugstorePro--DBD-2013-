--Procedimientos SQL Server

CREATE PROCEDURE HACER_INVENTARIO (@cantidad INT, @idProducto INT)
AS
BEGIN
	UPDATE 
		View_Medicamento 
	SET 
		cantidad_Producto = (SELECT CANTIDAD_PRODUCTO FROM VIEW_MEDICAMENTO WHERE ID_PRODUCTO = @idProducto) + @cantidad
	WHERE 
		id_Producto = @idProducto
END 
go

CREATE PROCEDURE HACER_VENTA (@cantidad INT, @idProducto INT)
AS
BEGIN
	UPDATE 
		View_Medicamento 
	SET 
		cantidad_Producto = (SELECT CANTIDAD_PRODUCTO FROM VIEW_MEDICAMENTO WHERE ID_PRODUCTO = @idProducto) - @cantidad
	WHERE 
		id_Producto = @idProducto
END 
go
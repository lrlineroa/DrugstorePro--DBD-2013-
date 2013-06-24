CREATE PROCEDURE HACER_INVENTARIO (@cantidad INT, @idProducto INT, @succes INT OUT)
AS
BEGIN
	BEGIN TRANSACTION
	UPDATE 
		View_Medicamento 
	SET 
		cantidad_Producto = (SELECT CANTIDAD_PRODUCTO FROM VIEW_MEDICAMENTO WHERE ID_PRODUCTO = @idProducto) + @cantidad
	WHERE 
		id_Producto = @idProducto
	COMMIT
	SET @succes = 1
END 
go

CREATE PROCEDURE HACER_VENTA (@cantidad INT, @idProducto INT, @succes INT OUT)
AS
BEGIN
	BEGIN TRANSACTION
	IF (((SELECT CANTIDAD_PRODUCTO FROM VIEW_MEDICAMENTO WHERE ID_PRODUCTO = @idProducto) - @cantidad) >= 0)
		BEGIN	
			UPDATE 
				View_Medicamento 
			SET 
				cantidad_Producto = (SELECT CANTIDAD_PRODUCTO FROM VIEW_MEDICAMENTO WHERE ID_PRODUCTO = @idProducto) - @cantidad
			WHERE 
				id_Producto = @idProducto
			COMMIT
			SET @succes = 1
		END
	ELSE
		BEGIN
			SET @succes = 0
			COMMIT
		END
END 
go

GRANT EXECUTE ON HACER_INVENTARIO TO earojasc, dsgonzalezh, maherrerapu, jemmejiaca, capenap
GRANT EXECUTE ON HACER_VENTA TO earojasc, dsgonzalezh, maherrerapu, jemmejiaca, capenap

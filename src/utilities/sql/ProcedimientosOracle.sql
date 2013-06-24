create or replace 
PROCEDURE HACER_INVENTARIO (cantidad INT, idProducto INT, succes OUT INT)
IS
BEGIN
	UPDATE 
		View_Medicamento 
	SET 
		cantidad_Producto = cantidad_Producto + cantidad
	WHERE 
		id_Producto = idProducto;
  succes := 1;
END HACER_INVENTARIO;
/

create or replace 
PROCEDURE HACER_VENTA (cantidad INT, idProducto INT, succes OUT INT)
IS
  cant   INTEGER := 0;
BEGIN
  SELECT CANTIDAD_PRODUCTO INTO cant FROM VIEW_MEDICAMENTO WHERE ID_PRODUCTO = idProducto;
	IF (cant - cantidad) >= 0 THEN
		UPDATE 
			View_Medicamento 
		SET 
			cantidad_Producto = cantidad_Producto - cantidad
		WHERE 
			id_Producto = idProducto;
		succes := 1;
	ELSE
		succes := 0;
	END IF;
END HACER_VENTA;

GRANT EXECUTE ON HACER_INVENTARIO TO earojasc, dsgonzalezh, maherrerapu, jemmejiaca, capenap
GRANT EXECUTE ON HACER_VENTA TO earojasc, dsgonzalezh, maherrerapu, jemmejiaca, capenap
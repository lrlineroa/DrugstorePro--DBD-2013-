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
/

create or replace 
PROCEDURE ACTUALIZAR_CONSOLIDADO_MENSUAL 
is 
total INTEGER := 0;
id_CM integer := 0;
BEGIN
 select floor(dbms_random.value(1,1000)) into id_CM from dual; 
 select sum(TOTAL)into total
 from LRLINEROA.VIEW_FACTURA 
 Where to_char(fecha_factura, 'YYYY')=to_char(sysdate, 'YYYY')AND to_char(fecha_factura, 'MM')=to_char(sysdate, 'MM');
 INSERT INTO view_consolidado_mensual VALUES (id_CM,to_char(sysdate, 'YYYY'),to_char(sysdate, 'MM'),total);
END ACTUALIZAR_CONSOLIDADO_MENSUAL;
/

create or replace 
PROCEDURE ACTUALIZAR_CONSOLIDADO_ANUAL
is 
total INTEGER := 0;
id_CM integer := 0;
BEGIN
 select floor(dbms_random.value(1,1000000)) into id_CM from dual; 
 select sum(TOTAL)into total
 from LRLINEROA.VIEW_FACTURA 
 Where to_char(fecha_factura, 'YYYY')=to_char(sysdate, 'YYYY');
 INSERT INTO view_consolidado_Anual VALUES (id_CM,to_char(sysdate, 'YYYY'),total);
END ACTUALIZAR_CONSOLIDADO_ANUAL;
/

create or replace 
PROCEDURE ACTUALIZAR_CONSOLIDADO_SEMANAL(succes out int)
IS
total INTEGER := 0;
id_CM integer := 0;
BEGIN
  select floor(dbms_random.value(1,10000000)) into id_CM from dual;
  if to_char(sysdate, 'MM')=1 and to_char(sysdate, 'MM')=3 and to_char(sysdate, 'MM')=5 and to_char(sysdate, 'MM')=7 and to_char(sysdate, 'MM')=8 and to_char(sysdate, 'MM')=10 and to_char(sysdate, 'MM')=12 then
       --Procedimiento para meses de 31 dias
        if to_char(sysdate, 'DD')=8 or to_char(sysdate, 'DD')=16 or to_char(sysdate, 'DD')=24 then 
         --procedimiento sólo se puede hacer unos días específicos al finalizar la semana de cada mes (se divivde el mes en mas o menos 4 partes iguales)
         select  sum(total) into total
            from lrlineroa.view_factura 
            where to_char(fecha_factura, 'yyyy')=to_char(sysdate, 'yyyy') 
            AND to_char(fecha_factura, 'MM')=to_char(sysdate, 'MM')
            AND to_char(fecha_factura, 'DD')<=to_char(sysdate, 'DD')
            AND to_char(fecha_factura, 'DD')>=(to_char(sysdate, 'DD')-7);
            INSERT INTO view_consolidado_semanal VALUES
            (id_CM,to_char(sysdate, 'YYYY'),to_char(sysdate, 'MM'),to_char(sysdate, 'DD')-7,to_char(sysdate, 'DD'),total);
          succes:=1;
        elsif to_char(sysdate, 'DD')=31 then
          --procedimiento para el último día del mes
          select  sum(total) into total
          from lrlineroa.view_factura 
          where to_char(fecha_factura, 'yyyy')=to_char(sysdate, 'yyyy') 
          AND to_char(fecha_factura, 'MM')=to_char(sysdate, 'MM')
          AND to_char(fecha_factura, 'DD')<=to_char(sysdate, 'DD')
          AND to_char(fecha_factura, 'DD')>=(to_char(sysdate, 'DD')-6);
          INSERT INTO view_consolidado_semanal VALUES
            (id_CM,to_char(sysdate, 'YYYY'),to_char(sysdate, 'MM'),to_char(sysdate, 'DD')-6,to_char(sysdate, 'DD'),total);
          succes:=1;
        else
          succes:=0;
        end if;
  end if;
  if to_char(sysdate, 'MM')=4 and to_char(sysdate, 'MM')=6 and to_char(sysdate, 'MM')=9 and to_char(sysdate, 'MM')=11 then
       --procedimiento para meses de 30 dias
        if to_char(sysdate, 'DD')=7 or to_char(sysdate, 'DD')=14 or to_char(sysdate, 'DD')=21 then 
         --procedimiento sólo se puede hacer unos días específicos al finalizar la semana de cada mes (se divivde el mes en mas o menos 4 partes iguales)
          select  sum(total) into total
          from lrlineroa.view_factura 
          where to_char(fecha_factura, 'yyyy')=to_char(sysdate, 'yyyy') 
          AND to_char(fecha_factura, 'MM')=to_char(sysdate, 'MM')
          AND to_char(fecha_factura, 'DD')<=to_char(sysdate, 'DD')
          AND to_char(fecha_factura, 'DD')>=(to_char(sysdate, 'DD')-6);
          INSERT INTO view_consolidado_semanal VALUES
            (id_CM,to_char(sysdate, 'YYYY'),to_char(sysdate, 'MM'),to_char(sysdate, 'DD')-6,to_char(sysdate, 'DD'),total);
          succes:=1;
        elsif to_char(sysdate, 'DD')=30 then
          --procedimiento para el último día del mes
          select  sum(total) into total
          from lrlineroa.view_factura 
          where to_char(fecha_factura, 'yyyy')=to_char(sysdate, 'yyyy') 
          AND to_char(fecha_factura, 'MM')=to_char(sysdate, 'MM')
          AND to_char(fecha_factura, 'DD')<=to_char(sysdate, 'DD')
          AND to_char(fecha_factura, 'DD')>=(to_char(sysdate, 'DD')-8);
          INSERT INTO view_consolidado_semanal VALUES
            (id_CM,to_char(sysdate, 'YYYY'),to_char(sysdate, 'MM'),to_char(sysdate, 'DD')-8,to_char(sysdate, 'DD'),total);
          succes:=1;  
        else
          succes:=0;
        end if;
  end if;
  
  if to_char(sysdate, 'MM')=2 then
        --procedimiento para febrero mes de 29 o 28 dias
         if to_char(sysdate, 'DD')=7 or to_char(sysdate, 'DD')=14 or to_char(sysdate, 'DD')=21 then
            select  sum(total) into total
            from lrlineroa.view_factura 
            where to_char(fecha_factura, 'yyyy')=to_char(sysdate, 'yyyy') 
            AND to_char(fecha_factura, 'MM')=to_char(sysdate, 'MM')
            AND to_char(fecha_factura, 'DD')<=to_char(sysdate, 'DD')
            AND to_char(fecha_factura, 'DD')>=(to_char(sysdate, 'DD')-6);
            INSERT INTO view_consolidado_semanal VALUES
            (id_CM,to_char(sysdate, 'YYYY'),to_char(sysdate, 'MM'),to_char(sysdate, 'DD')-6,to_char(sysdate, 'DD'),total);
            succes :=1;
          elsif MOD(to_char(sysdate, 'YYYY'),4)<>0 AND to_char(sysdate, 'DD')=28 then
            select  sum(total) into total
            from lrlineroa.view_factura 
            where to_char(fecha_factura, 'yyyy')=to_char(sysdate, 'yyyy') 
            AND to_char(fecha_factura, 'MM')=to_char(sysdate, 'MM')
            AND to_char(fecha_factura, 'DD')<=to_char(sysdate, 'DD')
            AND to_char(fecha_factura, 'DD')>=(to_char(sysdate, 'DD')-6);
            INSERT INTO view_consolidado_semanal VALUES
            (id_CM,to_char(sysdate, 'YYYY'),to_char(sysdate, 'MM'),to_char(sysdate, 'DD')-6,to_char(sysdate, 'DD'),total);
            succes :=1;
          elsif MOD(to_char(sysdate, 'YYYY'),4)=0 and to_char(sysdate, 'DD')=29 then --si el a;o es bisiesto
            select  sum(total) into total
            from lrlineroa.view_factura 
            where to_char(fecha_factura, 'yyyy')=to_char(sysdate, 'yyyy') 
            AND to_char(fecha_factura, 'MM')=to_char(sysdate, 'MM')
            AND to_char(fecha_factura, 'DD')<=to_char(sysdate, 'DD')
            AND to_char(fecha_factura, 'DD')>=(to_char(sysdate, 'DD')-7);
            INSERT INTO view_consolidado_semanal VALUES
            (id_CM,to_char(sysdate, 'YYYY'),to_char(sysdate, 'MM'),to_char(sysdate, 'DD')-7,to_char(sysdate, 'DD'),total);
            succes :=1;
          else 
            succes:=0;
        end if;
  end if;
  
END ACTUALIZAR_CONSOLIDADO_SEMANAL;

GRANT EXECUTE ON HACER_INVENTARIO TO earojasc, dsgonzalezh, maherrerapu, jemmejiaca, capenap
GRANT EXECUTE ON HACER_VENTA TO earojasc, dsgonzalezh, maherrerapu, jemmejiaca, capenap
INSERT INTO lrlineroa.CARGO (ID_CARGO, TIPO_CARGO) 
	VALUES (1, 'Administrador');
INSERT INTO lrlineroa.CARGO (ID_CARGO, TIPO_CARGO) 
	VALUES (2, 'Vendedor');
	
INSERT INTO lrlineroa.DROGUERIA (ID_DROGUERIA, NOMBRE_DROGUERIA, TELEFONO_DROGUERIA, DIRECCION_DROGUERIA) 
	VALUES (1, 'Drogueria Nuevo MIlenio', '5555555', 'calle falsa 123');

CREATE OR REPLACE FUNCTION MD5HASH (str IN VARCHAR2)
	RETURN VARCHAR2
	IS v_checksum VARCHAR2(32);
 
	BEGIN
		v_checksum := LOWER( RAWTOHEX( UTL_RAW.CAST_TO_RAW( sys.dbms_obfuscation_toolkit.md5(input_string => str) ) ) );
		RETURN v_checksum;
		EXCEPTION
			WHEN NO_DATA_FOUND THEN
			NULL;
		WHEN OTHERS THEN
			-- Consider logging the error and then re-raise
			RAISE;
	END md5hash;
/

INSERT INTO lrlineroa.PERSONA (ID_PERSONA, ID_CARGO, ID_DROGUERIA, NOMBRE_PERSONA, APELLIDO_PERSONA, TELEFONO_PERSONA, DIRECCION_PERSONA, PASSWORD, NOMBRE_DE_USUARIO)
	VALUES (1055555555, 1, 1, 'Leonardo', 'Linero', '5555555', 'avenida siempre viva 2445', MD5HASH('s02258001'), 'lrlineroa');
INSERT INTO lrlineroa.PERSONA (ID_PERSONA, ID_CARGO, ID_DROGUERIA, NOMBRE_PERSONA, APELLIDO_PERSONA, TELEFONO_PERSONA, DIRECCION_PERSONA, PASSWORD, NOMBRE_DE_USUARIO)
	VALUES (1032333333, 1, 1, 'Edward', 'Rojas', '3333333', '345 oasis st', MD5HASH('s02258009'), 'earojasc');
INSERT INTO lrlineroa.PERSONA (ID_PERSONA, ID_CARGO, ID_DROGUERIA, NOMBRE_PERSONA, APELLIDO_PERSONA, TELEFONO_PERSONA, DIRECCION_PERSONA, PASSWORD, NOMBRE_DE_USUARIO)
	VALUES (1032333444, 2, 1, 'Stiven', 'Gonzalez', '3333333', 'cra 123', MD5HASH('s02257765'), 'dsgonzalezh');
INSERT INTO lrlineroa.PERSONA (ID_PERSONA, ID_CARGO, ID_DROGUERIA, NOMBRE_PERSONA, APELLIDO_PERSONA, TELEFONO_PERSONA, DIRECCION_PERSONA, PASSWORD, NOMBRE_DE_USUARIO)
	VALUES (1050500500, 2, 1, 'Mauricio', 'Herrera', '1111111', 'cll 9 # 98', MD5HASH('s02257771'), 'maherrerapu');
INSERT INTO lrlineroa.PERSONA (ID_PERSONA, ID_CARGO, ID_DROGUERIA, NOMBRE_PERSONA, APELLIDO_PERSONA, TELEFONO_PERSONA, DIRECCION_PERSONA, PASSWORD, NOMBRE_DE_USUARIO)
	VALUES (1060600600, 2, 1, 'Jesid', 'Mejia', '2222222', 'tr 32 # 90', MD5HASH('s02258258'), 'jemmejiaca');
INSERT INTO lrlineroa.PERSONA (ID_PERSONA, ID_CARGO, ID_DROGUERIA, NOMBRE_PERSONA, APELLIDO_PERSONA, TELEFONO_PERSONA, DIRECCION_PERSONA, PASSWORD, NOMBRE_DE_USUARIO)
	VALUES (1070700700, 2, 1, 'Camilo', 'Peña', '8888888', '345 oasis st', MD5HASH('s02257956'), 'capenap');
	
INSERT INTO lrlineroa.TIPO_PROVEEDOR (ID_TIPO_PROVEEDOR, TIPO_PROVEEDOR)
	VALUES (1, 'Productos Farmaceuticos');
INSERT INTO lrlineroa.TIPO_PROVEEDOR (ID_TIPO_PROVEEDOR, TIPO_PROVEEDOR)
	VALUES (2, 'Productos de Aseo');
INSERT INTO lrlineroa.TIPO_PROVEEDOR (ID_TIPO_PROVEEDOR, TIPO_PROVEEDOR)
	VALUES (3, 'Productos en General');
	
INSERT INTO lrlineroa.PROVEEDOR (ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, DIRECCION_PROVEEDOR)
	VALUES (342353452, 'TECNOQUIMICAS', 2569876, 1);
INSERT INTO lrlineroa.PROVEEDOR (ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, DIRECCION_PROVEEDOR)
	VALUES (654675672, 'BayerSchering Pharma', 2986756, 1);
INSERT INTO lrlineroa.PROVEEDOR (ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, DIRECCION_PROVEEDOR)
	VALUES (797644453, 'Biochem Farmacéutica', 6579825, 1);
INSERT INTO lrlineroa.PROVEEDOR (ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, DIRECCION_PROVEEDOR)
	VALUES (235678654, 'Colgate', 8986443, 2);
INSERT INTO lrlineroa.PROVEEDOR (ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, DIRECCION_PROVEEDOR)
	VALUES (467893441, 'Unilever', 3434234, 2);
INSERT INTO lrlineroa.PROVEEDOR (ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, DIRECCION_PROVEEDOR)
	VALUES (546456434, 'Azul K', 3657756, 2);
INSERT INTO lrlineroa.PROVEEDOR (ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, DIRECCION_PROVEEDOR)
	VALUES (756756734, 'Colombina', 4678934, 3);
INSERT INTO lrlineroa.PROVEEDOR (ID_PROVEEDOR, NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, DIRECCION_PROVEEDOR)
	VALUES (298764453, 'Crem Helado', 3978764, 3);
	
INSERT INTO lrlineroa.PRESENTACION (ID_PRESENTACION, TIPO_PRESENTACION) 
	VALUES (1, 'Jarabe');
INSERT INTO lrlineroa.PRESENTACION (ID_PRESENTACION, TIPO_PRESENTACION) 
	VALUES (2, 'Pastillas');
INSERT INTO lrlineroa.PRESENTACION (ID_PRESENTACION, TIPO_PRESENTACION) 
	VALUES (3, 'Gotas');
INSERT INTO lrlineroa.PRESENTACION (ID_PRESENTACION, TIPO_PRESENTACION) 
	VALUES (4, 'Gel');
INSERT INTO lrlineroa.PRESENTACION (ID_PRESENTACION, TIPO_PRESENTACION) 
	VALUES (5, 'Capsulas');
INSERT INTO lrlineroa.PRESENTACION (ID_PRESENTACION, TIPO_PRESENTACION) 
	VALUES (6, 'Unidad');
	
INSERT INTO lrlineroa.TIPO_PRODUCTO (ID_TIPO_PRODUCTO, TIPO)
	VALUES (1, 'Analgesico');
INSERT INTO lrlineroa.TIPO_PRODUCTO (ID_TIPO_PRODUCTO, TIPO)
	VALUES (2, 'Antibiotico');
INSERT INTO lrlineroa.TIPO_PRODUCTO (ID_TIPO_PRODUCTO, TIPO)
	VALUES (3, 'Antiseptico');
INSERT INTO lrlineroa.TIPO_PRODUCTO (ID_TIPO_PRODUCTO, TIPO)
	VALUES (4, 'Antiinflamatorio');
INSERT INTO lrlineroa.TIPO_PRODUCTO (ID_TIPO_PRODUCTO, TIPO)
	VALUES (5, 'Laxante');
INSERT INTO lrlineroa.TIPO_PRODUCTO (ID_TIPO_PRODUCTO, TIPO)
	VALUES (6, 'Inyectable');
INSERT INTO lrlineroa.TIPO_PRODUCTO (ID_TIPO_PRODUCTO, TIPO)
	VALUES (7, 'Aseo Personal');
INSERT INTO lrlineroa.TIPO_PRODUCTO (ID_TIPO_PRODUCTO, TIPO)
	VALUES (8, 'Uso Diario');
INSERT INTO lrlineroa.TIPO_PRODUCTO (ID_TIPO_PRODUCTO, TIPO)
	VALUES (9, 'Alimento');
	
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (1, 2, 'Metrozin', 10296, 'Receta Medica', 1, 654675672, 0, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (2, 5, 'Keflex', 29955, 'Receta Medica', 1, 654675672, 0, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (3, 1, 'Lincocin', 10656, 'Receta Medica', 6, 342353452, 0, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (4, 3, 'MIcrogynon', 9180, '5 cada 6 horas', 1, 797644453, 1, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (5, 1, 'Descongel', 10000, 'Receta Medica', 1, 342353452, 1, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (6, 1, 'Sinutab', 10000, '1 Cucharada diaria', 1, 342353452, 1, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (7, 2, 'Acetaminofem', 10000, '', 1, 797644453, 1, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (8, 6, 'Maquinade afeitar Gillete', 23000, '', 7, 235678654, 1, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (9, 6, 'Gel de afeitar Gillete', 11349, '', 7, 235678654, 1, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (10, 6, 'Crema Dental Colgate', 8000, '', 7, 235678654, 1, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (11, 6, 'Enjuague Bucal', 12000, '', 7, 467893441, 1, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (12, 6, 'Helado Casero', 1000, '', 9, 298764453, 1, 10);
INSERT INTO lrlineroa.MEDICAMENTO (ID_PRODUCTO, ID_PRESENTACION, NOMBRE_PRODUCTO, PRECIO_PRODUCTO, POSOLOGIA_PRODUCTO, ID_TIPO_PRODUCTO, ID_PROVEEDOR, VENTA_LIBRE, CANTIDAD_PRODUCTO)
	VALUES (13, 6, 'Chocolatina Jet', 500, '', 9, 756756734, 1, 10);
	
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 1);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 2);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 3);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 4);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 5);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 6);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 7);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 8);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 9);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 10);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 11);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 12);
INSERT INTO lrlineroa.PRODUCTO_DROGUERIA (ID_DROGUERIA, ID_PRODUCTO) VALUES (1, 13);
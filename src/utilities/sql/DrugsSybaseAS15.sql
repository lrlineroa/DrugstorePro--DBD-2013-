/*==============================================================*/
/* DBMS name:      Sybase AS Enterprise 15.0                    */
/* Created on:     28/05/2013 20:11:19                          */
/*==============================================================*/


if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_CARG')
            and   type = 'TR')
   drop trigger TRG_DEL_CARG
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_CARG')
            and   type = 'TR')
   drop trigger TRG_INS_CARG
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_CARG')
            and   type = 'TR')
   drop trigger TRG_UPD_CARG
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_DROG')
            and   type = 'TR')
   drop trigger TRG_DEL_DROG
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_DROG')
            and   type = 'TR')
   drop trigger TRG_INS_DROG
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_DROG')
            and   type = 'TR')
   drop trigger TRG_UPD_DROG
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_FAB')
            and   type = 'TR')
   drop trigger TRG_DEL_FAB
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_FAB')
            and   type = 'TR')
   drop trigger TRG_INS_FAB
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_FAB')
            and   type = 'TR')
   drop trigger TRG_UPD_FAB
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_FACTU')
            and   type = 'TR')
   drop trigger TRG_DEL_FACTU
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_FACTU')
            and   type = 'TR')
   drop trigger TRG_INS_FACTU
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_FACTU')
            and   type = 'TR')
   drop trigger TRG_UPD_FACTU
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_INVENT')
            and   type = 'TR')
   drop trigger TRG_DEL_INVENT
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_INVENT')
            and   type = 'TR')
   drop trigger TRG_INS_INVENT
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_INVENT')
            and   type = 'TR')
   drop trigger TRG_UPD_INVENT
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_MEDIC')
            and   type = 'TR')
   drop trigger TRG_DEL_MEDIC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_MEDIC')
            and   type = 'TR')
   drop trigger TRG_INS_MEDIC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_MEDIC')
            and   type = 'TR')
   drop trigger TRG_UPD_MEDIC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_PED')
            and   type = 'TR')
   drop trigger TRG_DEL_PED
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_PED')
            and   type = 'TR')
   drop trigger TRG_INS_PED
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_PED')
            and   type = 'TR')
   drop trigger TRG_UPD_PED
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_PERS')
            and   type = 'TR')
   drop trigger TRG_DEL_PERS
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_PERS')
            and   type = 'TR')
   drop trigger TRG_INS_PERS
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_PERS')
            and   type = 'TR')
   drop trigger TRG_UPD_PERS
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_PORDFAB')
            and   type = 'TR')
   drop trigger TRG_DEL_PORDFAB
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_PORDFAB')
            and   type = 'TR')
   drop trigger TRG_INS_PORDFAB
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_PORDFAB')
            and   type = 'TR')
   drop trigger TRG_UPD_PORDFAB
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_PRODFAC')
            and   type = 'TR')
   drop trigger TRG_DEL_PRODFAC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_PRODFAC')
            and   type = 'TR')
   drop trigger TRG_INS_PRODFAC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_PRODFAC')
            and   type = 'TR')
   drop trigger TRG_UPD_PRODFAC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_PRODINV')
            and   type = 'TR')
   drop trigger TRG_DEL_PRODINV
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_PRODINV')
            and   type = 'TR')
   drop trigger TRG_INS_PRODINV
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_PRODINV')
            and   type = 'TR')
   drop trigger TRG_UPD_PRODINV
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_PROVE')
            and   type = 'TR')
   drop trigger TRG_DEL_PROVE
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_PROVE')
            and   type = 'TR')
   drop trigger TRG_INS_PROVE
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_PROVE')
            and   type = 'TR')
   drop trigger TRG_UPD_PROVE
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_TIPOPROD')
            and   type = 'TR')
   drop trigger TRG_DEL_TIPOPROD
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_TIPOPROD')
            and   type = 'TR')
   drop trigger TRG_INS_TIPOPROD
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_TIPOPROD')
            and   type = 'TR')
   drop trigger TRG_UPD_TIPOPROD
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_DEL_USOMEDIC')
            and   type = 'TR')
   drop trigger TRG_DEL_USOMEDIC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_INS_USOMEDIC')
            and   type = 'TR')
   drop trigger TRG_INS_USOMEDIC
go

if exists (select 1
            from  sysobjects
            where id = object_id('TRG_UPD_USOMEDIC')
            and   type = 'TR')
   drop trigger TRG_UPD_USOMEDIC
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('FACTURA'))
            where name = 'FK_FACTURA_FACTURA_P_PERSONA' and type = 'RI')
   alter table FACTURA
      drop constraint FK_FACTURA_FACTURA_P_PERSONA
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('INVENTARIO_RPT'))
            where name = 'FK_INVENTAR_PERSONA_I_PERSONA' and type = 'RI')
   alter table INVENTARIO_RPT
      drop constraint FK_INVENTAR_PERSONA_I_PERSONA
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('MEDICAMENTO'))
            where name = 'FK_MEDICAME_PRESENTAC_PRESENTA' and type = 'RI')
   alter table MEDICAMENTO
      drop constraint FK_MEDICAME_PRESENTAC_PRESENTA
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('MEDICAMENTO'))
            where name = 'FK_MEDICAME_PRODUCTO__PROVEEDO' and type = 'RI')
   alter table MEDICAMENTO
      drop constraint FK_MEDICAME_PRODUCTO__PROVEEDO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('MEDICAMENTO'))
            where name = 'FK_MEDICAME_PRODUCTO__TIPO_PRO' and type = 'RI')
   alter table MEDICAMENTO
      drop constraint FK_MEDICAME_PRODUCTO__TIPO_PRO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('MEDICAMENTO'))
            where name = 'FK_MEDICAME_USO_MEDIC_USO_MEDI' and type = 'RI')
   alter table MEDICAMENTO
      drop constraint FK_MEDICAME_USO_MEDIC_USO_MEDI
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PEDIDO'))
            where name = 'FK_PEDIDO_PEDIDO_DR_DROGUERI' and type = 'RI')
   alter table PEDIDO
      drop constraint FK_PEDIDO_PEDIDO_DR_DROGUERI
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PEDIDO_PRODUCTO'))
            where name = 'FK_PEDIDO_P_PEDIDO_PR_PEDIDO' and type = 'RI')
   alter table PEDIDO_PRODUCTO
      drop constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PEDIDO_PRODUCTO'))
            where name = 'FK_PEDIDO_P_PEDIDO_PR_MEDICAME' and type = 'RI')
   alter table PEDIDO_PRODUCTO
      drop constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PERSONA'))
            where name = 'FK_PERSONA_PERSONA_C_CARGO' and type = 'RI')
   alter table PERSONA
      drop constraint FK_PERSONA_PERSONA_C_CARGO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PERSONA'))
            where name = 'FK_PERSONA_PERSONA_D_DROGUERI' and type = 'RI')
   alter table PERSONA
      drop constraint FK_PERSONA_PERSONA_D_DROGUERI
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_DROGUERIA'))
            where name = 'FK_PRODUCTO_PRODUCTO__DROGUERI' and type = 'RI')
   alter table PRODUCTO_DROGUERIA
      drop constraint FK_PRODUCTO_PRODUCTO__DROGUERI
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_DROGUERIA'))
            where name = 'FK_PRODUCTO_PRODUCTO__MEDICAM2' and type = 'RI')
   alter table PRODUCTO_DROGUERIA
      drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM2
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_FABRICANTE'))
            where name = 'FK_PRODUCTO_FABRICANT_FABRICAN' and type = 'RI')
   alter table PRODUCTO_FABRICANTE
      drop constraint FK_PRODUCTO_FABRICANT_FABRICAN
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_FABRICANTE'))
            where name = 'FK_PRODUCTO_PRODUCTO__MEDICAME' and type = 'RI')
   alter table PRODUCTO_FABRICANTE
      drop constraint FK_PRODUCTO_PRODUCTO__MEDICAME
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_FACTURA'))
            where name = 'FK_PRODUCTO_PRODUCTO__FACTURA' and type = 'RI')
   alter table PRODUCTO_FACTURA
      drop constraint FK_PRODUCTO_PRODUCTO__FACTURA
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_FACTURA'))
            where name = 'FK_PRODUCTO_PRODUCTO__MEDICAM3' and type = 'RI')
   alter table PRODUCTO_FACTURA
      drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM3
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_INVENTARIO'))
            where name = 'FK_PRODUCTO_PRODUCTO__INVENTAR' and type = 'RI')
   alter table PRODUCTO_INVENTARIO
      drop constraint FK_PRODUCTO_PRODUCTO__INVENTAR
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_INVENTARIO'))
            where name = 'FK_PRODUCTO_PRODUCTO__MEDICAM4' and type = 'RI')
   alter table PRODUCTO_INVENTARIO
      drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM4
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PROVEEDOR_TIPO_PROVEEDOR'))
            where name = 'FK_PROVEEDO_PROVEEDOR_TIPO_PRO' and type = 'RI')
   alter table PROVEEDOR_TIPO_PROVEEDOR
      drop constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PROVEEDOR_TIPO_PROVEEDOR'))
            where name = 'FK_PROVEEDO_PROVEEDOR_PROVEEDO' and type = 'RI')
   alter table PROVEEDOR_TIPO_PROVEEDOR
      drop constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_BITACORA')
            and   type = 'V')
   drop view VIEW_BITACORA
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_CARGO')
            and   type = 'V')
   drop view VIEW_CARGO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_DROGUERIA')
            and   type = 'V')
   drop view VIEW_DROGUERIA
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_FABRICANTE')
            and   type = 'V')
   drop view VIEW_FABRICANTE
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_FACTURA')
            and   type = 'V')
   drop view VIEW_FACTURA
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_INVENTARIORPT')
            and   type = 'V')
   drop view VIEW_INVENTARIORPT
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_MEDICAMENTO')
            and   type = 'V')
   drop view VIEW_MEDICAMENTO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PEDIDO')
            and   type = 'V')
   drop view VIEW_PEDIDO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PEDIDO_PRODUCTO')
            and   type = 'V')
   drop view VIEW_PEDIDO_PRODUCTO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PERSONA')
            and   type = 'V')
   drop view VIEW_PERSONA
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PRESENTACION')
            and   type = 'V')
   drop view VIEW_PRESENTACION
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PRODUCTO_DROGUERIA')
            and   type = 'V')
   drop view VIEW_PRODUCTO_DROGUERIA
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PRODUCTO_FABRICANTE')
            and   type = 'V')
   drop view VIEW_PRODUCTO_FABRICANTE
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PRODUCTO_FACTURA')
            and   type = 'V')
   drop view VIEW_PRODUCTO_FACTURA
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PRODUCTO_INVENTARIO')
            and   type = 'V')
   drop view VIEW_PRODUCTO_INVENTARIO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PROVEEDOR')
            and   type = 'V')
   drop view VIEW_PROVEEDOR
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_PROVEEDOR_TIPO_PROV')
            and   type = 'V')
   drop view VIEW_PROVEEDOR_TIPO_PROV
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_TIPO_PRODUCTO')
            and   type = 'V')
   drop view VIEW_TIPO_PRODUCTO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_USO_MEDIC')
            and   type = 'V')
   drop view VIEW_USO_MEDIC
go

if exists (select 1
            from  sysobjects
            where id = object_id('BITACORA')
            and   type = 'U')
   drop table BITACORA
go

if exists (select 1
            from  sysobjects
            where id = object_id('CARGO')
            and   type = 'U')
   drop table CARGO
go

if exists (select 1
            from  sysobjects
            where id = object_id('DROGUERIA')
            and   type = 'U')
   drop table DROGUERIA
go

if exists (select 1
            from  sysobjects
            where id = object_id('FABRICANTE')
            and   type = 'U')
   drop table FABRICANTE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('FACTURA')
            and   name  = 'FACTURA_PERSONA_FK'
            and   indid > 0
            and   indid < 255)
   drop index FACTURA.FACTURA_PERSONA_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('FACTURA')
            and   type = 'U')
   drop table FACTURA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('INVENTARIO_RPT')
            and   name  = 'PERSONA_INVENTARIO_FK'
            and   indid > 0
            and   indid < 255)
   drop index INVENTARIO_RPT.PERSONA_INVENTARIO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('INVENTARIO_RPT')
            and   type = 'U')
   drop table INVENTARIO_RPT
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEDICAMENTO')
            and   name  = 'PRODUCTO_PROVEEDOR_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEDICAMENTO.PRODUCTO_PROVEEDOR_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEDICAMENTO')
            and   name  = 'PRODUCTO_TIPO_PRODUCTO_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEDICAMENTO.PRODUCTO_TIPO_PRODUCTO_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEDICAMENTO')
            and   name  = 'PRESENTACION_PRODUCTO_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEDICAMENTO.PRESENTACION_PRODUCTO_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEDICAMENTO')
            and   name  = 'USO_MEDICAMENTO_PRODUCTO_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEDICAMENTO.USO_MEDICAMENTO_PRODUCTO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('MEDICAMENTO')
            and   type = 'U')
   drop table MEDICAMENTO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PEDIDO')
            and   name  = 'PEDIDO_DROGUERIA_FK'
            and   indid > 0
            and   indid < 255)
   drop index PEDIDO.PEDIDO_DROGUERIA_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PEDIDO')
            and   type = 'U')
   drop table PEDIDO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PEDIDO_PRODUCTO')
            and   name  = 'PEDIDO_PRODUCTO2_FK'
            and   indid > 0
            and   indid < 255)
   drop index PEDIDO_PRODUCTO.PEDIDO_PRODUCTO2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PEDIDO_PRODUCTO')
            and   name  = 'PEDIDO_PRODUCTO_FK'
            and   indid > 0
            and   indid < 255)
   drop index PEDIDO_PRODUCTO.PEDIDO_PRODUCTO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PEDIDO_PRODUCTO')
            and   type = 'U')
   drop table PEDIDO_PRODUCTO
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PERSONA')
            and   name  = 'PERSONA_DROGUERIA_FK'
            and   indid > 0
            and   indid < 255)
   drop index PERSONA.PERSONA_DROGUERIA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PERSONA')
            and   name  = 'PERSONA_CARGO_FK'
            and   indid > 0
            and   indid < 255)
   drop index PERSONA.PERSONA_CARGO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PERSONA')
            and   type = 'U')
   drop table PERSONA
go

if exists (select 1
            from  sysobjects
            where id = object_id('PRESENTACION')
            and   type = 'U')
   drop table PRESENTACION
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTO_DROGUERIA')
            and   name  = 'PRODUCTO_DROGUERIA2_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTO_DROGUERIA.PRODUCTO_DROGUERIA2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTO_DROGUERIA')
            and   name  = 'PRODUCTO_DROGUERIA_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTO_DROGUERIA.PRODUCTO_DROGUERIA_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PRODUCTO_DROGUERIA')
            and   type = 'U')
   drop table PRODUCTO_DROGUERIA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTO_FABRICANTE')
            and   name  = 'PRODUCTO_FABRICANTE_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTO_FABRICANTE.PRODUCTO_FABRICANTE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTO_FABRICANTE')
            and   name  = 'FABRICANTE_PRODUCTO_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTO_FABRICANTE.FABRICANTE_PRODUCTO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PRODUCTO_FABRICANTE')
            and   type = 'U')
   drop table PRODUCTO_FABRICANTE
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTO_FACTURA')
            and   name  = 'PRODUCTO_FACTURA2_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTO_FACTURA.PRODUCTO_FACTURA2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTO_FACTURA')
            and   name  = 'PRODUCTO_FACTURA_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTO_FACTURA.PRODUCTO_FACTURA_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PRODUCTO_FACTURA')
            and   type = 'U')
   drop table PRODUCTO_FACTURA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTO_INVENTARIO')
            and   name  = 'PRODUCTO_INVENTARIO2_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTO_INVENTARIO.PRODUCTO_INVENTARIO2_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTO_INVENTARIO')
            and   name  = 'PRODUCTO_INVENTARIO_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTO_INVENTARIO.PRODUCTO_INVENTARIO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PRODUCTO_INVENTARIO')
            and   type = 'U')
   drop table PRODUCTO_INVENTARIO
go

if exists (select 1
            from  sysobjects
            where id = object_id('PROVEEDOR')
            and   type = 'U')
   drop table PROVEEDOR
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PROVEEDOR_TIPO_PROVEEDOR')
            and   name  = 'PROVEEDOR_TIPO_PROVEEDOR_FK'
            and   indid > 0
            and   indid < 255)
   drop index PROVEEDOR_TIPO_PROVEEDOR.PROVEEDOR_TIPO_PROVEEDOR_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PROVEEDOR_TIPO_PROVEEDOR')
            and   name  = 'PROVEEDOR_TIPO_PROVEEDOR2_FK'
            and   indid > 0
            and   indid < 255)
   drop index PROVEEDOR_TIPO_PROVEEDOR.PROVEEDOR_TIPO_PROVEEDOR2_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PROVEEDOR_TIPO_PROVEEDOR')
            and   type = 'U')
   drop table PROVEEDOR_TIPO_PROVEEDOR
go

if exists (select 1
            from  sysobjects
            where id = object_id('TIPO_PRODUCTO')
            and   type = 'U')
   drop table TIPO_PRODUCTO
go

if exists (select 1
            from  sysobjects
            where id = object_id('TIPO_PROVEEDOR')
            and   type = 'U')
   drop table TIPO_PROVEEDOR
go

if exists (select 1
            from  sysobjects
            where id = object_id('USO_MEDICAMENTO')
            and   type = 'U')
   drop table USO_MEDICAMENTO
go

/*==============================================================*/
/* Table: BITACORA                                              */
/*==============================================================*/
create table BITACORA (
   ID_BITACORA          int                            not null,
   FECHA                datetime                       not null,
   TIPO_ACCION          char(20)                       not null,
   TABLA                char(50)                       null,
   USUARIO              varchar(25)                    null,
   constraint PK_BITACORA primary key nonclustered (ID_BITACORA)
)
go

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table CARGO (
   ID_CARGO             int                            not null,
   TIPO_CARGO           varchar(15)                    not null,
   constraint PK_CARGO primary key nonclustered (ID_CARGO)
)
go

/*==============================================================*/
/* Table: DROGUERIA                                             */
/*==============================================================*/
create table DROGUERIA (
   ID_DROGUERIA         int                            not null,
   NOMBRE_DROGUERIA     varchar(25)                    not null,
   TELEFONO_DROGUERIA   varchar(15)                    not null,
   DIRECCION_DROGUERIA  varchar(35)                    not null,
   constraint PK_DROGUERIA primary key nonclustered (ID_DROGUERIA)
)
go

/*==============================================================*/
/* Table: FABRICANTE                                            */
/*==============================================================*/
create table FABRICANTE (
   ID_FABRICANTE        int                            not null,
   NOMBRE_FABRICANTE    varchar(20)                    null,
   constraint PK_FABRICANTE primary key nonclustered (ID_FABRICANTE)
)
go

/*==============================================================*/
/* Table: FACTURA                                               */
/*==============================================================*/
create table FACTURA (
   ID_FACTURA           int                            not null,
   ID_PERSONA           int                            not null,
   TOTAL                float(10)                      not null,
   constraint PK_FACTURA primary key nonclustered (ID_FACTURA)
)
go

/*==============================================================*/
/* Index: FACTURA_PERSONA_FK                                    */
/*==============================================================*/
create index FACTURA_PERSONA_FK on FACTURA (
ID_PERSONA ASC
)
go

/*==============================================================*/
/* Table: INVENTARIO_RPT                                        */
/*==============================================================*/
create table INVENTARIO_RPT (
   ID_INVENTARIORPT     int                            not null,
   ID_PERSONA           int                            not null,
   FECHA_INV            datetime                       not null,
   constraint PK_INVENTARIO_RPT primary key nonclustered (ID_INVENTARIORPT)
)
go

/*==============================================================*/
/* Index: PERSONA_INVENTARIO_FK                                 */
/*==============================================================*/
create index PERSONA_INVENTARIO_FK on INVENTARIO_RPT (
ID_PERSONA ASC
)
go

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO (
   ID_PRODUCTO          int                            not null,
   ID_PRESENTACION      int                            not null,
   ID_USO_MEDICAMENTO   int                            null,
   NOMBRE_PRODUCTO      varchar(25)                    null,
   PRECIO_PRODUCTO      float(7)                       null,
   CANTIDAD_PRODUCTO    int                            null,
   POSOLOGIA_PRODUCTO   varchar(25)                    null,
   ID_TIPO_PRODUCTO     int                            not null,
   ID_PROVEEDOR         int                            not null,
   VENTA_LIBRE          smallint                       not null,
   constraint PK_MEDICAMENTO primary key nonclustered (ID_PRODUCTO)
)
go

/*==============================================================*/
/* Index: USO_MEDICAMENTO_PRODUCTO_FK                           */
/*==============================================================*/
create index USO_MEDICAMENTO_PRODUCTO_FK on MEDICAMENTO (
ID_USO_MEDICAMENTO ASC
)
go

/*==============================================================*/
/* Index: PRESENTACION_PRODUCTO_FK                              */
/*==============================================================*/
create index PRESENTACION_PRODUCTO_FK on MEDICAMENTO (
ID_PRESENTACION ASC
)
go

/*==============================================================*/
/* Index: PRODUCTO_TIPO_PRODUCTO_FK                             */
/*==============================================================*/
create index PRODUCTO_TIPO_PRODUCTO_FK on MEDICAMENTO (
ID_TIPO_PRODUCTO ASC
)
go

/*==============================================================*/
/* Index: PRODUCTO_PROVEEDOR_FK                                 */
/*==============================================================*/
create index PRODUCTO_PROVEEDOR_FK on MEDICAMENTO (
ID_PROVEEDOR ASC
)
go

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO (
   ID_PEDIDO            int                            not null,
   ID_DROGUERIA         int                            not null,
   FECHA_PEDIDO         datetime                       not null,
   HORA_PEDIDO          datetime                       not null,
   NOMBRE_CLIENTE_PED   varchar(35)                    not null,
   DIRECCION_CLIEN_PEDIDO varchar(50)                    not null,
   TELEFONO_CLIENTE_PED varchar(12)                    not null,
   SOLICITUD_EN_CURSO   smallint                       not null,
   SOLICITUD_FINALIZADA smallint                       not null,
   constraint PK_PEDIDO primary key nonclustered (ID_PEDIDO)
)
go

/*==============================================================*/
/* Index: PEDIDO_DROGUERIA_FK                                   */
/*==============================================================*/
create index PEDIDO_DROGUERIA_FK on PEDIDO (
ID_DROGUERIA ASC
)
go

/*==============================================================*/
/* Table: PEDIDO_PRODUCTO                                       */
/*==============================================================*/
create table PEDIDO_PRODUCTO (
   ID_PEDIDO            int                            not null,
   ID_PRODUCTO          int                            not null,
   constraint PK_PEDIDO_PRODUCTO primary key nonclustered (ID_PEDIDO, ID_PRODUCTO)
)
go

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO_FK                                    */
/*==============================================================*/
create index PEDIDO_PRODUCTO_FK on PEDIDO_PRODUCTO (
ID_PEDIDO ASC
)
go

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO2_FK                                   */
/*==============================================================*/
create index PEDIDO_PRODUCTO2_FK on PEDIDO_PRODUCTO (
ID_PRODUCTO ASC
)
go

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   ID_PERSONA           int                            not null,
   ID_CARGO             int                            not null,
   ID_DROGUERIA         int                            not null,
   NOMBRE_PERSONA       varchar(15)                    not null,
   APELLIDO_PERSONA     varchar(15)                    not null,
   TELEFONO_PERSONA     int                            not null
         constraint CKC_TELEFONO_PERSONA_PERSONA check (TELEFONO_PERSONA between 999999999 and 000000000),
   DIRECCION_PERSONA    varchar(25)                    not null,
   PASSWORD             text                           not null,
   constraint PK_PERSONA primary key nonclustered (ID_PERSONA)
)
go

/*==============================================================*/
/* Index: PERSONA_CARGO_FK                                      */
/*==============================================================*/
create index PERSONA_CARGO_FK on PERSONA (
ID_CARGO ASC
)
go

/*==============================================================*/
/* Index: PERSONA_DROGUERIA_FK                                  */
/*==============================================================*/
create index PERSONA_DROGUERIA_FK on PERSONA (
ID_DROGUERIA ASC
)
go

/*==============================================================*/
/* Table: PRESENTACION                                          */
/*==============================================================*/
create table PRESENTACION (
   ID_PRESENTACION      int                            not null,
   TIPO_PRESENTACION    varchar(25)                    not null,
   constraint PK_PRESENTACION primary key nonclustered (ID_PRESENTACION)
)
go

/*==============================================================*/
/* Table: PRODUCTO_DROGUERIA                                    */
/*==============================================================*/
create table PRODUCTO_DROGUERIA (
   ID_DROGUERIA         int                            not null,
   ID_PRODUCTO          int                            not null
)
go

/*==============================================================*/
/* Index: PRODUCTO_DROGUERIA_FK                                 */
/*==============================================================*/
create index PRODUCTO_DROGUERIA_FK on PRODUCTO_DROGUERIA (
ID_DROGUERIA ASC
)
go

/*==============================================================*/
/* Index: PRODUCTO_DROGUERIA2_FK                                */
/*==============================================================*/
create index PRODUCTO_DROGUERIA2_FK on PRODUCTO_DROGUERIA (
ID_PRODUCTO ASC
)
go

/*==============================================================*/
/* Table: PRODUCTO_FABRICANTE                                   */
/*==============================================================*/
create table PRODUCTO_FABRICANTE (
   ID_FABRICANTE        int                            not null,
   ID_PRODUCTO          int                            not null
)
go

/*==============================================================*/
/* Index: FABRICANTE_PRODUCTO_FK                                */
/*==============================================================*/
create index FABRICANTE_PRODUCTO_FK on PRODUCTO_FABRICANTE (
ID_FABRICANTE ASC
)
go

/*==============================================================*/
/* Index: PRODUCTO_FABRICANTE_FK                                */
/*==============================================================*/
create index PRODUCTO_FABRICANTE_FK on PRODUCTO_FABRICANTE (
ID_PRODUCTO ASC
)
go

/*==============================================================*/
/* Table: PRODUCTO_FACTURA                                      */
/*==============================================================*/
create table PRODUCTO_FACTURA (
   ID_FACTURA           int                            not null,
   ID_PRODUCTO          int                            not null
)
go

/*==============================================================*/
/* Index: PRODUCTO_FACTURA_FK                                   */
/*==============================================================*/
create index PRODUCTO_FACTURA_FK on PRODUCTO_FACTURA (
ID_FACTURA ASC
)
go

/*==============================================================*/
/* Index: PRODUCTO_FACTURA2_FK                                  */
/*==============================================================*/
create index PRODUCTO_FACTURA2_FK on PRODUCTO_FACTURA (
ID_PRODUCTO ASC
)
go

/*==============================================================*/
/* Table: PRODUCTO_INVENTARIO                                   */
/*==============================================================*/
create table PRODUCTO_INVENTARIO (
   ID_INVENTARIORPT     int                            not null,
   ID_PRODUCTO          int                            not null
)
go

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO_FK                                */
/*==============================================================*/
create index PRODUCTO_INVENTARIO_FK on PRODUCTO_INVENTARIO (
ID_INVENTARIORPT ASC
)
go

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO2_FK                               */
/*==============================================================*/
create index PRODUCTO_INVENTARIO2_FK on PRODUCTO_INVENTARIO (
ID_PRODUCTO ASC
)
go

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR (
   ID_PROVEEDOR         int                            not null,
   NOMBRE_PROVEEDOR     varchar(20)                    not null,
   TELEFONO_PROVEEDOR   varchar(12)                    not null,
   DIRECCION_PROVEEDOR  varchar(25)                    not null,
   constraint PK_PROVEEDOR primary key nonclustered (ID_PROVEEDOR)
)
go

/*==============================================================*/
/* Table: PROVEEDOR_TIPO_PROVEEDOR                              */
/*==============================================================*/
create table PROVEEDOR_TIPO_PROVEEDOR (
   ID_TIPO_PROVEEDOR    int                            not null,
   ID_PROVEEDOR         int                            not null,
   constraint PK_PROVEEDOR_TIPO_PROVEEDOR primary key nonclustered (ID_TIPO_PROVEEDOR, ID_PROVEEDOR)
)
go

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR2_FK                          */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR2_FK on PROVEEDOR_TIPO_PROVEEDOR (
ID_PROVEEDOR ASC
)
go

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR_FK                           */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR_FK on PROVEEDOR_TIPO_PROVEEDOR (
ID_TIPO_PROVEEDOR ASC
)
go

/*==============================================================*/
/* Table: TIPO_PRODUCTO                                         */
/*==============================================================*/
create table TIPO_PRODUCTO (
   ID_TIPO_PRODUCTO     int                            not null,
   TIPO                 varchar(20)                    not null,
   constraint PK_TIPO_PRODUCTO primary key nonclustered (ID_TIPO_PRODUCTO)
)
go

/*==============================================================*/
/* Table: TIPO_PROVEEDOR                                        */
/*==============================================================*/
create table TIPO_PROVEEDOR (
   ID_TIPO_PROVEEDOR    int                            not null,
   TIPO_PROVEEDOR       varchar(25)                    not null,
   constraint PK_TIPO_PROVEEDOR primary key nonclustered (ID_TIPO_PROVEEDOR)
)
go

/*==============================================================*/
/* Table: USO_MEDICAMENTO                                       */
/*==============================================================*/
create table USO_MEDICAMENTO (
   ID_USO_MEDICAMENTO   int                            not null,
   TIPO_USO_PRODUCTO    varchar(25)                    not null,
   constraint PK_USO_MEDICAMENTO primary key nonclustered (ID_USO_MEDICAMENTO)
)
go

/*==============================================================*/
/* View: VIEW_BITACORA                                          */
/*==============================================================*/
create view VIEW_BITACORA as
select * from BITACORA
go

/*==============================================================*/
/* View: VIEW_CARGO                                             */
/*==============================================================*/
create view VIEW_CARGO as
select * from CARGO
go

/*==============================================================*/
/* View: VIEW_DROGUERIA                                         */
/*==============================================================*/
create view VIEW_DROGUERIA as
select * from DROGUERIA
go

/*==============================================================*/
/* View: VIEW_FABRICANTE                                        */
/*==============================================================*/
create view VIEW_FABRICANTE as
select * from FABRICANTE
go

/*==============================================================*/
/* View: VIEW_FACTURA                                           */
/*==============================================================*/
create view VIEW_FACTURA as
select * from FACTURA
go

/*==============================================================*/
/* View: VIEW_INVENTARIORPT                                     */
/*==============================================================*/
create view VIEW_INVENTARIORPT as
select * from INVENTARIO_RPT
go

/*==============================================================*/
/* View: VIEW_MEDICAMENTO                                       */
/*==============================================================*/
create view VIEW_MEDICAMENTO as
select * from MEDICAMENTO
go

/*==============================================================*/
/* View: VIEW_PEDIDO                                            */
/*==============================================================*/
create view VIEW_PEDIDO as
select * from PEDIDO
go

/*==============================================================*/
/* View: VIEW_PEDIDO_PRODUCTO                                   */
/*==============================================================*/
create view VIEW_PEDIDO_PRODUCTO as
select * from PEDIDO_PRODUCTO
go

/*==============================================================*/
/* View: VIEW_PERSONA                                           */
/*==============================================================*/
create view VIEW_PERSONA as
select * from PERSONA
go

/*==============================================================*/
/* View: VIEW_PRESENTACION                                      */
/*==============================================================*/
create view VIEW_PRESENTACION as
select * from PRESENTACION
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_DROGUERIA                                */
/*==============================================================*/
create view VIEW_PRODUCTO_DROGUERIA as
select * from PRODUCTO_DROGUERIA
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_FABRICANTE                               */
/*==============================================================*/
create view VIEW_PRODUCTO_FABRICANTE as
select * from PRODUCTO_FABRICANTE
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_FACTURA                                  */
/*==============================================================*/
create view VIEW_PRODUCTO_FACTURA as
select * from PRODUCTO_FACTURA
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_INVENTARIO                               */
/*==============================================================*/
create view VIEW_PRODUCTO_INVENTARIO as
select * from PRODUCTO_INVENTARIO
go

/*==============================================================*/
/* View: VIEW_PROVEEDOR                                         */
/*==============================================================*/
create view VIEW_PROVEEDOR as
select * from PROVEEDOR
go

/*==============================================================*/
/* View: VIEW_PROVEEDOR_TIPO_PROV                               */
/*==============================================================*/
create view VIEW_PROVEEDOR_TIPO_PROV as
select * from PROVEEDOR_TIPO_PROVEEDOR
go

/*==============================================================*/
/* View: VIEW_TIPO_PRODUCTO                                     */
/*==============================================================*/
create view VIEW_TIPO_PRODUCTO as
select * from TIPO_PRODUCTO
go

/*==============================================================*/
/* View: VIEW_USO_MEDIC                                         */
/*==============================================================*/
create view VIEW_USO_MEDIC as
select * from USO_MEDICAMENTO
go

alter table FACTURA
   add constraint FK_FACTURA_FACTURA_P_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
go

alter table INVENTARIO_RPT
   add constraint FK_INVENTAR_PERSONA_I_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
go

alter table MEDICAMENTO
   add constraint FK_MEDICAME_PRESENTAC_PRESENTA foreign key (ID_PRESENTACION)
      references PRESENTACION (ID_PRESENTACION)
go

alter table MEDICAMENTO
   add constraint FK_MEDICAME_PRODUCTO__PROVEEDO foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR)
go

alter table MEDICAMENTO
   add constraint FK_MEDICAME_PRODUCTO__TIPO_PRO foreign key (ID_TIPO_PRODUCTO)
      references TIPO_PRODUCTO (ID_TIPO_PRODUCTO)
go

alter table MEDICAMENTO
   add constraint FK_MEDICAME_USO_MEDIC_USO_MEDI foreign key (ID_USO_MEDICAMENTO)
      references USO_MEDICAMENTO (ID_USO_MEDICAMENTO)
go

alter table PEDIDO
   add constraint FK_PEDIDO_PEDIDO_DR_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
go

alter table PEDIDO_PRODUCTO
   add constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO)
go

alter table PEDIDO_PRODUCTO
   add constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_C_CARGO foreign key (ID_CARGO)
      references CARGO (ID_CARGO)
go

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_D_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
go

alter table PRODUCTO_DROGUERIA
   add constraint FK_PRODUCTO_PRODUCTO__DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
go

alter table PRODUCTO_DROGUERIA
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM2 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PRODUCTO_FABRICANTE
   add constraint FK_PRODUCTO_FABRICANT_FABRICAN foreign key (ID_FABRICANTE)
      references FABRICANTE (ID_FABRICANTE)
go

alter table PRODUCTO_FABRICANTE
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__FACTURA foreign key (ID_FACTURA)
      references FACTURA (ID_FACTURA)
go

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM3 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__INVENTAR foreign key (ID_INVENTARIORPT)
      references INVENTARIO_RPT (ID_INVENTARIORPT)
go

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM4 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO foreign key (ID_TIPO_PROVEEDOR)
      references TIPO_PROVEEDOR (ID_TIPO_PROVEEDOR)
go

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR)
go


create trigger trg_del_carg AFTER DELETE ON dbd_3.Cargo
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","CARGO",USER)
go


create trigger trg_ins_carg AFTER INSERT ON dbd_3.Cargo
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","CARGO",USER)
go


create trigger trg_upd_carg AFTER UPDATE ON dbd_3.Cargo
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","CARGO",USER)
go


create trigger trg_del_drog AFTER DELETE ON dbd_3.Drogueria
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","DROGUERIA",USER)
go


create trigger trg_ins_drog AFTER INSERT ON dbd_3.Drogueria
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","DROGUERIA",USER)
go


create trigger trg_upd_drog AFTER UPDATE ON dbd_3.Drogueria
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","DROGUERIA",USER)
go


create trigger trg_ins_fab AFTER DELETE ON dbd_3.Faricante
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","FABRICANTE",USER)
go


create trigger trg_ins_fab AFTER INSERT ON dbd_3.Faricante
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","FABRICANTE",USER)
go


create trigger trg_upd_fab AFTER UPDATE ON dbd_3.Faricante
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","FABRICANTE",USER)
go


create trigger trg_del_factu AFTER DELETE ON dbd_3.Factura
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","FACTURA",USER)
go


create trigger trg_ins_factu AFTER INSERT ON dbd_3.Factura
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","FACTURA",USER)
go


create trigger trg_upd_factu AFTER UPDATE ON dbd_3.Factura
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","FACTURA",USER)
go


create trigger trg_del_invent AFTER DELETE ON dbd_3.InventarioRPT
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","INVENTARIORPT",USER)
go


create trigger trg_ins_invent AFTER INSERT ON dbd_3.InventarioRPT
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","INVENTARIORPT",USER)
go


create trigger trg_upd_invent AFTER UPDATE ON dbd_3.InventarioRPT
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","INVENTARIORPT",USER)
go


create trigger trg_del_medic AFTER DELETE ON dbd_3.Medicamento
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","MEDICAMENTO",USER)
go


create trigger trg_ins_medic AFTER INSERT ON dbd_3.Medicamento
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","MEDICAMENTO",USER)
go


create trigger trg_upd_medic AFTER UPDATE ON dbd_3.Medicamento
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","MEDICAMENTO",USER)
go


reate trigger trg_del_ped AFTER DELETE ON dbd_3.Pedido
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","PEDIDO",USER)
go


create trigger trg_ins_ped AFTER INSERT ON dbd_3.Pedido
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","PEDIDO",USER)
go


reate trigger trg_upd_ped AFTER UPDATE ON dbd_3.Pedido
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","PEDIDO",USER)
go


create trigger trg_del_pers AFTER DELETE ON dbd_3.Persona
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","PERSONA",USER)
go


create trigger trg_ins_pers AFTER INSERT ON dbd_3.Persona
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","PERSONA",USER)
go


create trigger trg_del_pers AFTER UPDATE ON dbd_3.Persona
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","PERSONA",USER)
go


create trigger trg_del_pordFab AFTER DELETE ON dbd_3.Producto_Fabricante
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","PRODUCTO_FABRICANTE",USER)
go


create trigger trg_ins_pordFab AFTER INSERT ON dbd_3.Producto_Fabricante
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","PRODUCTO_FABRICANTE",USER)
go


create trigger trg_upd_pordFab AFTER UPDATE ON dbd_3.Producto_Fabricante
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","PRODUCTO_FABRICANTE",USER)
go


create trigger trg_del_prodFac AFTER DELETE ON dbd_3.Producto_Factura
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","PRODUCTO_FACTURA",USER)
go


create trigger trg_ins_prodFac AFTER INSERT ON dbd_3.Producto_Factura
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","PRODUCTO_FACTURA",USER)
go


create trigger trg_upd_prodFac AFTER UPDATE ON dbd_3.Producto_Factura
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","PRODUCTO_FACTURA",USER)
go


create trigger trg_del_prodInv AFTER DELETE ON dbd_3.Producto_Inventario
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","PRODUCTO_INVENTARIO",USER)
go


create trigger trg_ins_prodInv AFTER INSERT ON dbd_3.Producto_Inventario
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","PRODUCTO_INVENTARIO",USER)
go


create trigger trg_upd_prodInv AFTER UPDATE ON dbd_3.Producto_Inventario
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","PRODUCTO_INVENTARIO",USER)
go


create trigger trg_del_prove AFTER DELETE ON dbd_3.Proveedor
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","PROVEEDOR",USER)
go


create trigger trg_ins_prove AFTER INSERT ON dbd_3.Proveedor
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","PROVEEDOR",USER)
go


create trigger trg_upd_prove AFTER UPDATE ON dbd_3.Proveedor
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","PROVEEDOR",USER)
go


create trigger trg_del_tipoProd AFTER DELETE ON dbd_3.Tipo_Producto
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","TIPO_PRODUCTO",USER)
go


create trigger trg_ins_tipoProd AFTER INSERT ON dbd_3.Tipo_Producto
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","TIPO_PRODUCTO",USER)
go


create trigger trg_upd_tipoProd AFTER UPDATE ON dbd_3.Tipo_Producto
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","TIPO_PRODUCTO",USER)
go


create trigger trg_del_usoMedic AFTER DELETE ON dbd_3.Uso_Medicamento
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","USO_MEDIC",USER)
go


create trigger trg_ins_usoMedic AFTER INSERT ON dbd_3.Uso_Medicamento
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","USO_MEDIC",USER)
go


create trigger trg_upd_usoMedic AFTER UPDATE ON dbd_3.Uso_Medicamento
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","USO_MEDIC",USER)
go


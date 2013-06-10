/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2005                    */
/* Created on:     10/06/2013 9:49:48 p. m.                     */
/*==============================================================*/


if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_CARG')
          and type = 'TR')
   drop trigger TRG_DEL_CARG
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_CARG')
          and type = 'TR')
   drop trigger TRG_INS_CARG
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_CARG')
          and type = 'TR')
   drop trigger TRG_UPD_CARG
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_DROG')
          and type = 'TR')
   drop trigger TRG_DEL_DROG
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_DROG')
          and type = 'TR')
   drop trigger TRG_INS_DROG
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_DROG')
          and type = 'TR')
   drop trigger TRG_UPD_DROG
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_FAB')
          and type = 'TR')
   drop trigger TRG_DEL_FAB
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_FAB')
          and type = 'TR')
   drop trigger TRG_INS_FAB
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_FAB')
          and type = 'TR')
   drop trigger TRG_UPD_FAB
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_FACTU')
          and type = 'TR')
   drop trigger TRG_DEL_FACTU
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_FACTU')
          and type = 'TR')
   drop trigger TRG_INS_FACTU
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_FACTU')
          and type = 'TR')
   drop trigger TRG_UPD_FACTU
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_INVENT')
          and type = 'TR')
   drop trigger TRG_DEL_INVENT
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_INVENT')
          and type = 'TR')
   drop trigger TRG_INS_INVENT
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_INVENT')
          and type = 'TR')
   drop trigger TRG_UPD_INVENT
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_MEDIC')
          and type = 'TR')
   drop trigger TRG_DEL_MEDIC
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_MEDIC')
          and type = 'TR')
   drop trigger TRG_INS_MEDIC
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_MEDIC')
          and type = 'TR')
   drop trigger TRG_UPD_MEDIC
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PED')
          and type = 'TR')
   drop trigger TRG_DEL_PED
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PED')
          and type = 'TR')
   drop trigger TRG_INS_PED
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PED')
          and type = 'TR')
   drop trigger TRG_UPD_PED
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PED_PROD')
          and type = 'TR')
   drop trigger TRG_DEL_PED_PROD
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PED_PROD')
          and type = 'TR')
   drop trigger TRG_UPD_PED_PROD
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PED_PROD')
          and type = 'TR')
   drop trigger TRG_INS_PED_PROD
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PERS')
          and type = 'TR')
   drop trigger TRG_DEL_PERS
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PERS')
          and type = 'TR')
   drop trigger TRG_INS_PERS
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PERS')
          and type = 'TR')
   drop trigger TRG_UPD_PERS
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PRE')
          and type = 'TR')
   drop trigger TRG_DEL_PRE
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PRE')
          and type = 'TR')
   drop trigger TRG_INS_PRE
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PRE')
          and type = 'TR')
   drop trigger TRG_UPD_PRE
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PRD_DROG')
          and type = 'TR')
   drop trigger TRG_DEL_PRD_DROG
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PRD_DROG')
          and type = 'TR')
   drop trigger TRG_INS_PRD_DROG
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PRD_DROG')
          and type = 'TR')
   drop trigger TRG_UPD_PRD_DROG
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PORDFAB')
          and type = 'TR')
   drop trigger TRG_DEL_PORDFAB
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PORDFAB')
          and type = 'TR')
   drop trigger TRG_INS_PORDFAB
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PORDFAB')
          and type = 'TR')
   drop trigger TRG_UPD_PORDFAB
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PRODFAC')
          and type = 'TR')
   drop trigger TRG_DEL_PRODFAC
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PRODFAC')
          and type = 'TR')
   drop trigger TRG_INS_PRODFAC
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PRODFAC')
          and type = 'TR')
   drop trigger TRG_UPD_PRODFAC
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PRODINV')
          and type = 'TR')
   drop trigger TRG_DEL_PRODINV
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PRODINV')
          and type = 'TR')
   drop trigger TRG_INS_PRODINV
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PRODINV')
          and type = 'TR')
   drop trigger TRG_UPD_PRODINV
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PROVE')
          and type = 'TR')
   drop trigger TRG_DEL_PROVE
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PROVE')
          and type = 'TR')
   drop trigger TRG_INS_PROVE
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PROVE')
          and type = 'TR')
   drop trigger TRG_UPD_PROVE
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_PROV_TPR')
          and type = 'TR')
   drop trigger TRG_DEL_PROV_TPR
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_PROV_TPR')
          and type = 'TR')
   drop trigger TRG_INS_PROV_TPR
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_PROV_TPR')
          and type = 'TR')
   drop trigger TRG_UPD_PROV_TPR
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_TIPOPROD')
          and type = 'TR')
   drop trigger TRG_DEL_TIPOPROD
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_TIPOPROD')
          and type = 'TR')
   drop trigger TRG_INS_TIPOPROD
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_TIPOPROD')
          and type = 'TR')
   drop trigger TRG_UPD_TIPOPROD
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_TIPOPROV')
          and type = 'TR')
   drop trigger TRG_DEL_TIPOPROV
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_TIPOPROV')
          and type = 'TR')
   drop trigger TRG_INS_TIPOPROV
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_TIPOPROV')
          and type = 'TR')
   drop trigger TRG_UPD_TIPOPROV
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_DEL_USOMEDIC')
          and type = 'TR')
   drop trigger TRG_DEL_USOMEDIC
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_INS_USOMEDIC')
          and type = 'TR')
   drop trigger TRG_INS_USOMEDIC
go

if exists (select 1
          from sysobjects
          where id = object_id('TRG_UPD_USOMEDIC')
          and type = 'TR')
   drop trigger TRG_UPD_USOMEDIC
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('FACTURA') and o.name = 'FK_FACTURA_FACTURA_P_PERSONA')
alter table FACTURA
   drop constraint FK_FACTURA_FACTURA_P_PERSONA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('INVENTARIO_RPT') and o.name = 'FK_INVENTAR_PERSONA_I_PERSONA')
alter table INVENTARIO_RPT
   drop constraint FK_INVENTAR_PERSONA_I_PERSONA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEDICAMENTO') and o.name = 'FK_MEDICAME_PRESENTAC_PRESENTA')
alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRESENTAC_PRESENTA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEDICAMENTO') and o.name = 'FK_MEDICAME_PRODUCTO__PROVEEDO')
alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRODUCTO__PROVEEDO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEDICAMENTO') and o.name = 'FK_MEDICAME_PRODUCTO__TIPO_PRO')
alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRODUCTO__TIPO_PRO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEDICAMENTO') and o.name = 'FK_MEDICAME_USO_MEDIC_USO_MEDI')
alter table MEDICAMENTO
   drop constraint FK_MEDICAME_USO_MEDIC_USO_MEDI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PEDIDO') and o.name = 'FK_PEDIDO_PEDIDO_DR_DROGUERI')
alter table PEDIDO
   drop constraint FK_PEDIDO_PEDIDO_DR_DROGUERI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PEDIDO_PRODUCTO') and o.name = 'FK_PEDIDO_P_PEDIDO_PR_PEDIDO')
alter table PEDIDO_PRODUCTO
   drop constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PEDIDO_PRODUCTO') and o.name = 'FK_PEDIDO_P_PEDIDO_PR_MEDICAME')
alter table PEDIDO_PRODUCTO
   drop constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PERSONA') and o.name = 'FK_PERSONA_PERSONA_C_CARGO')
alter table PERSONA
   drop constraint FK_PERSONA_PERSONA_C_CARGO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PERSONA') and o.name = 'FK_PERSONA_PERSONA_D_DROGUERI')
alter table PERSONA
   drop constraint FK_PERSONA_PERSONA_D_DROGUERI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_DROGUERIA') and o.name = 'FK_PRODUCTO_PRODUCTO__DROGUERI')
alter table PRODUCTO_DROGUERIA
   drop constraint FK_PRODUCTO_PRODUCTO__DROGUERI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_DROGUERIA') and o.name = 'FK_PRODUCTO_PRODUCTO__MEDICAM2')
alter table PRODUCTO_DROGUERIA
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM2
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_FABRICANTE') and o.name = 'FK_PRODUCTO_FABRICANT_FABRICAN')
alter table PRODUCTO_FABRICANTE
   drop constraint FK_PRODUCTO_FABRICANT_FABRICAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_FABRICANTE') and o.name = 'FK_PRODUCTO_PRODUCTO__MEDICAME')
alter table PRODUCTO_FABRICANTE
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAME
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_FACTURA') and o.name = 'FK_PRODUCTO_PRODUCTO__FACTURA')
alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__FACTURA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_FACTURA') and o.name = 'FK_PRODUCTO_PRODUCTO__MEDICAM3')
alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM3
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_INVENTARIO') and o.name = 'FK_PRODUCTO_PRODUCTO__INVENTAR')
alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__INVENTAR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_INVENTARIO') and o.name = 'FK_PRODUCTO_PRODUCTO__MEDICAM4')
alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM4
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PROVEEDOR_TIPO_PROVEEDOR') and o.name = 'FK_PROVEEDO_PROVEEDOR_TIPO_PRO')
alter table PROVEEDOR_TIPO_PROVEEDOR
   drop constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PROVEEDOR_TIPO_PROVEEDOR') and o.name = 'FK_PROVEEDO_PROVEEDOR_PROVEEDO')
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
           where  id = object_id('BITACORA')
            and   type = 'U')
   drop table BITACORA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARGO')
            and   type = 'U')
   drop table CARGO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('DROGUERIA')
            and   type = 'U')
   drop table DROGUERIA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('FABRICANTE')
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
           where  id = object_id('FACTURA')
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
           where  id = object_id('INVENTARIO_RPT')
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
           where  id = object_id('MEDICAMENTO')
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
           where  id = object_id('PEDIDO')
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
           where  id = object_id('PEDIDO_PRODUCTO')
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
           where  id = object_id('PERSONA')
            and   type = 'U')
   drop table PERSONA
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PRESENTACION')
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
           where  id = object_id('PRODUCTO_DROGUERIA')
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
           where  id = object_id('PRODUCTO_FABRICANTE')
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
           where  id = object_id('PRODUCTO_FACTURA')
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
           where  id = object_id('PRODUCTO_INVENTARIO')
            and   type = 'U')
   drop table PRODUCTO_INVENTARIO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PROVEEDOR')
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
           where  id = object_id('PROVEEDOR_TIPO_PROVEEDOR')
            and   type = 'U')
   drop table PROVEEDOR_TIPO_PROVEEDOR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIPO_PRODUCTO')
            and   type = 'U')
   drop table TIPO_PRODUCTO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIPO_PROVEEDOR')
            and   type = 'U')
   drop table TIPO_PROVEEDOR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('USO_MEDICAMENTO')
            and   type = 'U')
   drop table USO_MEDICAMENTO
go

/*==============================================================*/
/* Table: BITACORA                                              */
/*==============================================================*/
create table BITACORA (
   ID_BITACORA          int                  identity,
   FECHA                datetime             not null,
   TIPO_ACCION          char(20)             not null,
   TABLA                char(50)             null,
   USUARIO              varchar(25)          null,
   constraint PK_BITACORA primary key nonclustered (ID_BITACORA)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('BITACORA') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'BITACORA' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Tabla que guarda la información de las actividades que realizan los usuarios del sistema.', 
   'user', @CurrentUser, 'table', 'BITACORA'
go

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table CARGO (
   ID_CARGO             int                  not null,
   TIPO_CARGO           varchar(15)          not null,
   constraint PK_CARGO primary key nonclustered (ID_CARGO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('CARGO') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'CARGO' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Esta entidad va a tener los distinitos cargos en la droguería vendedor, administrador etc...', 
   'user', @CurrentUser, 'table', 'CARGO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('CARGO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_CARGO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'CARGO', 'column', 'ID_CARGO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este es el identificador de los cargos puede ser un autonumérico',
   'user', @CurrentUser, 'table', 'CARGO', 'column', 'ID_CARGO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('CARGO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'TIPO_CARGO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'CARGO', 'column', 'TIPO_CARGO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo va a guardar los tipos de cargos que hay en la droguería (administrador vendedor etc...',
   'user', @CurrentUser, 'table', 'CARGO', 'column', 'TIPO_CARGO'
go

/*==============================================================*/
/* Table: DROGUERIA                                             */
/*==============================================================*/
create table DROGUERIA (
   ID_DROGUERIA         int                  not null,
   NOMBRE_DROGUERIA     varchar(25)          not null,
   TELEFONO_DROGUERIA   varchar(15)          not null,
   DIRECCION_DROGUERIA  varchar(35)          not null,
   constraint PK_DROGUERIA primary key nonclustered (ID_DROGUERIA)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('DROGUERIA') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'DROGUERIA' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Esta entidad guardara informacion sobre cada una de las distintas sedes de la drogueria.', 
   'user', @CurrentUser, 'table', 'DROGUERIA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('DROGUERIA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_DROGUERIA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'DROGUERIA', 'column', 'ID_DROGUERIA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'identificador primario de esta entidad. ',
   'user', @CurrentUser, 'table', 'DROGUERIA', 'column', 'ID_DROGUERIA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('DROGUERIA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'NOMBRE_DROGUERIA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'DROGUERIA', 'column', 'NOMBRE_DROGUERIA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'este atributo indica el nombre de la drogueria o sede de la drogueria',
   'user', @CurrentUser, 'table', 'DROGUERIA', 'column', 'NOMBRE_DROGUERIA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('DROGUERIA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'TELEFONO_DROGUERIA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'DROGUERIA', 'column', 'TELEFONO_DROGUERIA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'el telefono principal de contacto de la sede o drogueria',
   'user', @CurrentUser, 'table', 'DROGUERIA', 'column', 'TELEFONO_DROGUERIA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('DROGUERIA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'DIRECCION_DROGUERIA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'DROGUERIA', 'column', 'DIRECCION_DROGUERIA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'la direccion de la ubicacion fisica de la sede o drogueria',
   'user', @CurrentUser, 'table', 'DROGUERIA', 'column', 'DIRECCION_DROGUERIA'
go

/*==============================================================*/
/* Table: FABRICANTE                                            */
/*==============================================================*/
create table FABRICANTE (
   ID_FABRICANTE        int                  not null,
   NOMBRE_FABRICANTE    varchar(20)          null,
   constraint PK_FABRICANTE primary key nonclustered (ID_FABRICANTE)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('FABRICANTE') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'FABRICANTE' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Esta Entidad va a guardar los diferentes fabricantes de los productos.', 
   'user', @CurrentUser, 'table', 'FABRICANTE'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_FABRICANTE')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'FABRICANTE', 'column', 'ID_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Es el identificador de el fabricante',
   'user', @CurrentUser, 'table', 'FABRICANTE', 'column', 'ID_FABRICANTE'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'NOMBRE_FABRICANTE')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'FABRICANTE', 'column', 'NOMBRE_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo va a guardar el nombre del fabricante
   ',
   'user', @CurrentUser, 'table', 'FABRICANTE', 'column', 'NOMBRE_FABRICANTE'
go

/*==============================================================*/
/* Table: FACTURA                                               */
/*==============================================================*/
create table FACTURA (
   ID_FACTURA           int                  not null,
   ID_PERSONA           int                  not null,
   TOTAL                float(10)            not null,
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
   ID_INVENTARIORPT     int                  not null,
   ID_PERSONA           int                  not null,
   FECHA_INV            datetime             not null,
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
   ID_PRODUCTO          int                  not null,
   ID_PRESENTACION      int                  not null,
   ID_USO_MEDICAMENTO   int                  null,
   NOMBRE_PRODUCTO      varchar(25)          null,
   PRECIO_PRODUCTO      float(7)             null,
   CANTIDAD_PRODUCTO    int                  null,
   POSOLOGIA_PRODUCTO   varchar(25)          null,
   ID_TIPO_PRODUCTO     int                  not null,
   ID_PROVEEDOR         int                  not null,
   VENTA_LIBRE          smallint             not null,
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
   ID_PEDIDO            int                  not null,
   ID_DROGUERIA         int                  not null,
   FECHA_PEDIDO         datetime             not null,
   HORA_PEDIDO          datetime             not null,
   NOMBRE_CLIENTE_PED   varchar(35)          not null,
   DIRECCION_CLIEN_PEDIDO varchar(50)          not null,
   TELEFONO_CLIENTE_PED varchar(12)          not null,
   SOLICITUD_EN_CURSO   smallint             not null,
   SOLICITUD_FINALIZADA smallint             not null,
   constraint PK_PEDIDO primary key nonclustered (ID_PEDIDO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('PEDIDO') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'PEDIDO' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'En esta clase se va a poner todo lo que tenga que ver con los pedidos que se hagan a un proveedor.', 
   'user', @CurrentUser, 'table', 'PEDIDO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_PEDIDO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'ID_PEDIDO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo identificara a la entidad con un codigo numerico irrepetible, es tipo integer debido a que solo nos interesa el numero como identificador para lo cual no es necesario exactitud decimal.',
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'ID_PEDIDO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_DROGUERIA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'ID_DROGUERIA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo relacionara a la entidad PEDIDO con la entidad DROGUERIA, y señalara cual sede es la que esta realizando el pedido. Es de tipo integer porque el identificador Id_Drogueria en la entidad DROGUERIA es de este tipo.',
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'ID_DROGUERIA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'FECHA_PEDIDO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'FECHA_PEDIDO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo guarda la fecha en la que se realizo el pedido.',
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'FECHA_PEDIDO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'HORA_PEDIDO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'HORA_PEDIDO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo guarda la hora en la que se realizo el pedido.',
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'HORA_PEDIDO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'NOMBRE_CLIENTE_PED')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'NOMBRE_CLIENTE_PED'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'En este atributo se guardara el nombre y apellido del cliente. Se definio un tamaño de 35 caracteres los cuales consideramos suficientes para guardar un nombre y los apellidos. Es de tipo varchar el cual maneja mejor el espacio cuando el tamaño de las entradas varia mucho.',
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'NOMBRE_CLIENTE_PED'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'DIRECCION_CLIEN_PEDIDO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'DIRECCION_CLIEN_PEDIDO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'En este atributo se guardara la direccion de entrega del pedido.',
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'DIRECCION_CLIEN_PEDIDO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'TELEFONO_CLIENTE_PED')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'TELEFONO_CLIENTE_PED'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Se guardara un numero telefonico fijo o celular para contactar al cliente.  Es de tipo integer debido a que los numeros telefonicos no requieren parte decimal.',
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'TELEFONO_CLIENTE_PED'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'SOLICITUD_EN_CURSO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'SOLICITUD_EN_CURSO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo sera verdadero solo si la solicitud esta actualmente en curso. Siempre tendra valor opuesto al atributo Solicitud_finalizada.',
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'SOLICITUD_EN_CURSO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'SOLICITUD_FINALIZADA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'SOLICITUD_FINALIZADA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo sera verdadero solo si el pedido a sido finalizado, ya sea por que el producto se entrego o porque el pedido se cancelo. Siempre tendra valor opuesto al atributo Solicitud_en_curso.',
   'user', @CurrentUser, 'table', 'PEDIDO', 'column', 'SOLICITUD_FINALIZADA'
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
   ID_PEDIDO            int                  not null,
   ID_PRODUCTO          int                  not null,
   constraint PK_PEDIDO_PRODUCTO primary key nonclustered (ID_PEDIDO, ID_PRODUCTO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('PEDIDO_PRODUCTO') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'PEDIDO_PRODUCTO' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Esta entidad nacio de la relacion n-m entre PEDIDO y PRODUCTO, y guardara información en donde se relacionaran los pedidos con los productos, es decir que producto fue pedido.', 
   'user', @CurrentUser, 'table', 'PEDIDO_PRODUCTO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO_PRODUCTO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_PEDIDO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO_PRODUCTO', 'column', 'ID_PEDIDO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo referenciara un pedido realizado para relacionarlo con un producto. Conserva el mismo tipo de dato del atributo Id_Pedido de la entidad PEDIDO',
   'user', @CurrentUser, 'table', 'PEDIDO_PRODUCTO', 'column', 'ID_PEDIDO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PEDIDO_PRODUCTO')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_PRODUCTO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PEDIDO_PRODUCTO', 'column', 'ID_PRODUCTO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo referenciara un producto para relacionarlo con un pedido realizado. Conserva el mismo tipo de dato del atributo Id_Producto de la entidad PRODUCTO',
   'user', @CurrentUser, 'table', 'PEDIDO_PRODUCTO', 'column', 'ID_PRODUCTO'
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
   ID_PERSONA           int                  not null,
   ID_CARGO             int                  not null,
   ID_DROGUERIA         int                  not null,
   NOMBRE_PERSONA       varchar(15)          not null,
   APELLIDO_PERSONA     varchar(15)          not null,
   TELEFONO_PERSONA     int                  not null
      constraint CKC_TELEFONO_PERSONA_PERSONA check (TELEFONO_PERSONA between 000000000 and 999999999),
   DIRECCION_PERSONA    varchar(25)          not null,
   PASSWORD             text                 not null,
   NOMBRE_DE_USUARIO    varchar(15)          not null,
   constraint PK_PERSONA primary key nonclustered (ID_PERSONA)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('PERSONA') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'PERSONA' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Esta entidad va a guardar la información de la persona que tiene alguna vinculación con la droguería, como administradores y vendedores.', 
   'user', @CurrentUser, 'table', 'PERSONA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PERSONA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_PERSONA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'ID_PERSONA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este es el número de identificación de la persona',
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'ID_PERSONA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PERSONA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_CARGO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'ID_CARGO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'este atributo va a guardar el número del cargo de la persona ',
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'ID_CARGO'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PERSONA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_DROGUERIA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'ID_DROGUERIA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo va a guardar el número de la sede en el cual tiene vinculación la persona',
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'ID_DROGUERIA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PERSONA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'NOMBRE_PERSONA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'NOMBRE_PERSONA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este campo significa el nombre de la persona. (Luis, Carlos, Hernando etc...)',
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'NOMBRE_PERSONA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PERSONA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'APELLIDO_PERSONA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'APELLIDO_PERSONA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo es el apellido de la persona, (Martinez, Ortega, etc..)',
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'APELLIDO_PERSONA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PERSONA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'TELEFONO_PERSONA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'TELEFONO_PERSONA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo va a contener el teléfono de la persona que corresponda.',
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'TELEFONO_PERSONA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PERSONA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'DIRECCION_PERSONA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'DIRECCION_PERSONA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Este atributo va a contener la dirección de vivienda de la persona.',
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'DIRECCION_PERSONA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PERSONA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'PASSWORD')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'PASSWORD'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Atributo que va a guardar la contrase;a de el usuario para entrar al sistema',
   'user', @CurrentUser, 'table', 'PERSONA', 'column', 'PASSWORD'
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
   ID_PRESENTACION      int                  not null,
   TIPO_PRESENTACION    varchar(25)          not null,
   constraint PK_PRESENTACION primary key nonclustered (ID_PRESENTACION)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('PRESENTACION') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'PRESENTACION' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Esta entidad recogera la informacion de cada una de las distintas presentaciones, formas, envases o maneras de comercializar los productos. eje: gel, pildora, jarabe, etc', 
   'user', @CurrentUser, 'table', 'PRESENTACION'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PRESENTACION')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_PRESENTACION')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PRESENTACION', 'column', 'ID_PRESENTACION'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'identificador primario para esta entidad. ',
   'user', @CurrentUser, 'table', 'PRESENTACION', 'column', 'ID_PRESENTACION'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PRESENTACION')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'TIPO_PRESENTACION')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PRESENTACION', 'column', 'TIPO_PRESENTACION'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'atributo que almacenará las distintas presentaciones en las que son vendidos los productos',
   'user', @CurrentUser, 'table', 'PRESENTACION', 'column', 'TIPO_PRESENTACION'
go

/*==============================================================*/
/* Table: PRODUCTO_DROGUERIA                                    */
/*==============================================================*/
create table PRODUCTO_DROGUERIA (
   ID_DROGUERIA         int                  not null,
   ID_PRODUCTO          int                  not null,
   constraint PK_PRODUCTO_DROGUERIA primary key (ID_DROGUERIA, ID_PRODUCTO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('PRODUCTO_DROGUERIA') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'PRODUCTO_DROGUERIA' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'entidad debil resultante de la relacion n-n. ', 
   'user', @CurrentUser, 'table', 'PRODUCTO_DROGUERIA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PRODUCTO_DROGUERIA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_DROGUERIA')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PRODUCTO_DROGUERIA', 'column', 'ID_DROGUERIA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'identificador heredado de la entidad DROGUERIA',
   'user', @CurrentUser, 'table', 'PRODUCTO_DROGUERIA', 'column', 'ID_DROGUERIA'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PRODUCTO_DROGUERIA')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_PRODUCTO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PRODUCTO_DROGUERIA', 'column', 'ID_PRODUCTO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'identificador heredado de la entidad PRODUCTO',
   'user', @CurrentUser, 'table', 'PRODUCTO_DROGUERIA', 'column', 'ID_PRODUCTO'
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
   ID_FABRICANTE        int                  not null,
   ID_PRODUCTO          int                  not null,
   constraint PK_PRODUCTO_FABRICANTE primary key (ID_FABRICANTE, ID_PRODUCTO)
)
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PRODUCTO_FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_FABRICANTE')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PRODUCTO_FABRICANTE', 'column', 'ID_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Es el identificador de el fabricante',
   'user', @CurrentUser, 'table', 'PRODUCTO_FABRICANTE', 'column', 'ID_FABRICANTE'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PRODUCTO_FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_PRODUCTO')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PRODUCTO_FABRICANTE', 'column', 'ID_PRODUCTO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Numero que identifica de forma unica el producto',
   'user', @CurrentUser, 'table', 'PRODUCTO_FABRICANTE', 'column', 'ID_PRODUCTO'
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
   ID_FACTURA           int                  not null,
   ID_PRODUCTO          int                  not null,
   constraint PK_PRODUCTO_FACTURA primary key (ID_FACTURA, ID_PRODUCTO)
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
   ID_INVENTARIORPT     int                  not null,
   ID_PRODUCTO          int                  not null,
   constraint PK_PRODUCTO_INVENTARIO primary key (ID_INVENTARIORPT, ID_PRODUCTO)
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
   ID_PROVEEDOR         int                  not null,
   NOMBRE_PROVEEDOR     varchar(20)          not null,
   TELEFONO_PROVEEDOR   varchar(12)          not null,
   DIRECCION_PROVEEDOR  varchar(25)          not null,
   constraint PK_PROVEEDOR primary key nonclustered (ID_PROVEEDOR)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('PROVEEDOR') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'PROVEEDOR' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'La tablap PROVEEDOR hace referencia a la entidad que surte de productos a la farmacia. Cada PRODUCTO tendra asociado un registro de la tabla PROVEEDOR', 
   'user', @CurrentUser, 'table', 'PROVEEDOR'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PROVEEDOR')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_PROVEEDOR')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'ID_PROVEEDOR'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador de la entidad fabricante',
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'ID_PROVEEDOR'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PROVEEDOR')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'NOMBRE_PROVEEDOR')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'NOMBRE_PROVEEDOR'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Razon social de la empresa que comercializa dicho producto',
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'NOMBRE_PROVEEDOR'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PROVEEDOR')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'TELEFONO_PROVEEDOR')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'TELEFONO_PROVEEDOR'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Telefono de contacto del proveedor del producto',
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'TELEFONO_PROVEEDOR'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PROVEEDOR')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'DIRECCION_PROVEEDOR')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'DIRECCION_PROVEEDOR'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Direccion de la empresa u oficina de la empresa que comercializa el producto.',
   'user', @CurrentUser, 'table', 'PROVEEDOR', 'column', 'DIRECCION_PROVEEDOR'
go

/*==============================================================*/
/* Table: PROVEEDOR_TIPO_PROVEEDOR                              */
/*==============================================================*/
create table PROVEEDOR_TIPO_PROVEEDOR (
   ID_TIPO_PROVEEDOR    int                  not null,
   ID_PROVEEDOR         int                  not null,
   constraint PK_PROVEEDOR_TIPO_PROVEEDOR primary key nonclustered (ID_TIPO_PROVEEDOR, ID_PROVEEDOR)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('PROVEEDOR_TIPO_PROVEEDOR') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'PROVEEDOR_TIPO_PROVEEDOR' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'relaciona las entidades PROVEEDOR y TIPO-PROVEEDOR', 
   'user', @CurrentUser, 'table', 'PROVEEDOR_TIPO_PROVEEDOR'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PROVEEDOR_TIPO_PROVEEDOR')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_TIPO_PROVEEDOR')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PROVEEDOR_TIPO_PROVEEDOR', 'column', 'ID_TIPO_PROVEEDOR'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador de Tipo Proveedor',
   'user', @CurrentUser, 'table', 'PROVEEDOR_TIPO_PROVEEDOR', 'column', 'ID_TIPO_PROVEEDOR'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('PROVEEDOR_TIPO_PROVEEDOR')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_PROVEEDOR')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'PROVEEDOR_TIPO_PROVEEDOR', 'column', 'ID_PROVEEDOR'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del proveedor',
   'user', @CurrentUser, 'table', 'PROVEEDOR_TIPO_PROVEEDOR', 'column', 'ID_PROVEEDOR'
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
   ID_TIPO_PRODUCTO     int                  not null,
   TIPO                 varchar(20)          not null,
   constraint PK_TIPO_PRODUCTO primary key nonclustered (ID_TIPO_PRODUCTO)
)
go

/*==============================================================*/
/* Table: TIPO_PROVEEDOR                                        */
/*==============================================================*/
create table TIPO_PROVEEDOR (
   ID_TIPO_PROVEEDOR    int                  not null,
   TIPO_PROVEEDOR       varchar(25)          not null,
   constraint PK_TIPO_PROVEEDOR primary key nonclustered (ID_TIPO_PROVEEDOR)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('TIPO_PROVEEDOR') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'TIPO_PROVEEDOR' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad que registra los diferentes tipos de proveedor según su actividad.', 
   'user', @CurrentUser, 'table', 'TIPO_PROVEEDOR'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('TIPO_PROVEEDOR')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_TIPO_PROVEEDOR')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'TIPO_PROVEEDOR', 'column', 'ID_TIPO_PROVEEDOR'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador de la entidad Tipo_Proveedor
   ',
   'user', @CurrentUser, 'table', 'TIPO_PROVEEDOR', 'column', 'ID_TIPO_PROVEEDOR'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('TIPO_PROVEEDOR')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'TIPO_PROVEEDOR')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'TIPO_PROVEEDOR', 'column', 'TIPO_PROVEEDOR'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'nombre del tipo de proveedor.',
   'user', @CurrentUser, 'table', 'TIPO_PROVEEDOR', 'column', 'TIPO_PROVEEDOR'
go

/*==============================================================*/
/* Table: USO_MEDICAMENTO                                       */
/*==============================================================*/
create table USO_MEDICAMENTO (
   ID_USO_MEDICAMENTO   int                  not null,
   TIPO_USO_PRODUCTO    varchar(25)          not null,
   constraint PK_USO_MEDICAMENTO primary key nonclustered (ID_USO_MEDICAMENTO)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('USO_MEDICAMENTO') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'USO_MEDICAMENTO' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Solo va a tener relacion con producto cuando este sea un medicamento', 
   'user', @CurrentUser, 'table', 'USO_MEDICAMENTO'
go

/*==============================================================*/
/* View: VIEW_BITACORA                                          */
/*==============================================================*/
create view VIEW_BITACORA as
select * from BITACORA
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_BITACORA') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_BITACORA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de los Logs del sistema',
   'user', @CurrentUser, 'view', 'VIEW_BITACORA'
go

/*==============================================================*/
/* View: VIEW_CARGO                                             */
/*==============================================================*/
create view VIEW_CARGO as
select * from CARGO
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_CARGO') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_CARGO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra la información acerca de los cargos ocupables en la drogueria',
   'user', @CurrentUser, 'view', 'VIEW_CARGO'
go

/*==============================================================*/
/* View: VIEW_DROGUERIA                                         */
/*==============================================================*/
create view VIEW_DROGUERIA as
select * from DROGUERIA
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_DROGUERIA') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_DROGUERIA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de las droguerias',
   'user', @CurrentUser, 'view', 'VIEW_DROGUERIA'
go

/*==============================================================*/
/* View: VIEW_FABRICANTE                                        */
/*==============================================================*/
create view VIEW_FABRICANTE as
select * from FABRICANTE
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_FABRICANTE') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca del Fabricante de medicamentos',
   'user', @CurrentUser, 'view', 'VIEW_FABRICANTE'
go

/*==============================================================*/
/* View: VIEW_FACTURA                                           */
/*==============================================================*/
create view VIEW_FACTURA as
select * from FACTURA
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_FACTURA') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_FACTURA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de las facturas',
   'user', @CurrentUser, 'view', 'VIEW_FACTURA'
go

/*==============================================================*/
/* View: VIEW_INVENTARIORPT                                     */
/*==============================================================*/
create view VIEW_INVENTARIORPT as
select * from INVENTARIO_RPT
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_INVENTARIORPT') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_INVENTARIORPT'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de los inventarios',
   'user', @CurrentUser, 'view', 'VIEW_INVENTARIORPT'
go

/*==============================================================*/
/* View: VIEW_MEDICAMENTO                                       */
/*==============================================================*/
create view VIEW_MEDICAMENTO as
select * from MEDICAMENTO
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_MEDICAMENTO') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_MEDICAMENTO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra infromación acerca de los mediacamentos que se ofertan en la Drogueria',
   'user', @CurrentUser, 'view', 'VIEW_MEDICAMENTO'
go

/*==============================================================*/
/* View: VIEW_PEDIDO                                            */
/*==============================================================*/
create view VIEW_PEDIDO as
select * from PEDIDO
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PEDIDO') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PEDIDO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de los pedidos',
   'user', @CurrentUser, 'view', 'VIEW_PEDIDO'
go

/*==============================================================*/
/* View: VIEW_PEDIDO_PRODUCTO                                   */
/*==============================================================*/
create view VIEW_PEDIDO_PRODUCTO as
select * from PEDIDO_PRODUCTO
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PEDIDO_PRODUCTO') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PEDIDO_PRODUCTO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de los pedidos de productos',
   'user', @CurrentUser, 'view', 'VIEW_PEDIDO_PRODUCTO'
go

/*==============================================================*/
/* View: VIEW_PERSONA                                           */
/*==============================================================*/
create view VIEW_PERSONA as
select * from PERSONA
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PERSONA') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PERSONA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra las caracteristicas mas importantes relacionadas con la tabla Persona',
   'user', @CurrentUser, 'view', 'VIEW_PERSONA'
go

/*==============================================================*/
/* View: VIEW_PRESENTACION                                      */
/*==============================================================*/
create view VIEW_PRESENTACION as
select * from PRESENTACION
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PRESENTACION') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PRESENTACION'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de la presentacion de los productos',
   'user', @CurrentUser, 'view', 'VIEW_PRESENTACION'
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_DROGUERIA                                */
/*==============================================================*/
create view VIEW_PRODUCTO_DROGUERIA as
select * from PRODUCTO_DROGUERIA
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PRODUCTO_DROGUERIA') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PRODUCTO_DROGUERIA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de los productos que ofrece una drogueria',
   'user', @CurrentUser, 'view', 'VIEW_PRODUCTO_DROGUERIA'
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_FABRICANTE                               */
/*==============================================================*/
create view VIEW_PRODUCTO_FABRICANTE as
select * from PRODUCTO_FABRICANTE
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PRODUCTO_FABRICANTE') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PRODUCTO_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de Fabrcinate y los productos que fabrica',
   'user', @CurrentUser, 'view', 'VIEW_PRODUCTO_FABRICANTE'
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_FACTURA                                  */
/*==============================================================*/
create view VIEW_PRODUCTO_FACTURA as
select * from PRODUCTO_FACTURA
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PRODUCTO_FACTURA') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PRODUCTO_FACTURA'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de la factura de compra de un producto',
   'user', @CurrentUser, 'view', 'VIEW_PRODUCTO_FACTURA'
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_INVENTARIO                               */
/*==============================================================*/
create view VIEW_PRODUCTO_INVENTARIO as
select * from PRODUCTO_INVENTARIO
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PRODUCTO_INVENTARIO') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PRODUCTO_INVENTARIO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de los productos que estan en inventario',
   'user', @CurrentUser, 'view', 'VIEW_PRODUCTO_INVENTARIO'
go

/*==============================================================*/
/* View: VIEW_PROVEEDOR                                         */
/*==============================================================*/
create view VIEW_PROVEEDOR as
select * from PROVEEDOR
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PROVEEDOR') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PROVEEDOR'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra infromación de los proveedores de productos de la empresa',
   'user', @CurrentUser, 'view', 'VIEW_PROVEEDOR'
go

/*==============================================================*/
/* View: VIEW_PROVEEDOR_TIPO_PROV                               */
/*==============================================================*/
create view VIEW_PROVEEDOR_TIPO_PROV as
select * from PROVEEDOR_TIPO_PROVEEDOR
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_PROVEEDOR_TIPO_PROV') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_PROVEEDOR_TIPO_PROV'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca del proveedor y su tipo de distribucion',
   'user', @CurrentUser, 'view', 'VIEW_PROVEEDOR_TIPO_PROV'
go

/*==============================================================*/
/* View: VIEW_TIPO_PRODUCTO                                     */
/*==============================================================*/
create view VIEW_TIPO_PRODUCTO as
select * from TIPO_PRODUCTO
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_TIPO_PRODUCTO') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_TIPO_PRODUCTO'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca de los tipos de productos',
   'user', @CurrentUser, 'view', 'VIEW_TIPO_PRODUCTO'
go

/*==============================================================*/
/* View: VIEW_USO_MEDIC                                         */
/*==============================================================*/
create view VIEW_USO_MEDIC as
select * from USO_MEDICAMENTO
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('VIEW_USO_MEDIC') and minor_id = 0)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'view', 'VIEW_USO_MEDIC'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Esta vista muestra informacion acerca del uso que tienen los diferntes medicamentos',
   'user', @CurrentUser, 'view', 'VIEW_USO_MEDIC'
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


create trigger trg_del_carg ON CARGO AFTER DELETE 
as
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','CARGO',USER)
go


create trigger trg_ins_carg ON CARGO AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','CARGO',USER)
go


create trigger trg_upd_carg ON CARGO AFTER UPDATE AS
   insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','CARGO',USER)
go


create trigger trg_del_drog ON DROGUERIA AFTER DELETE 
AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','DROGUERIA',USER)
go


create trigger trg_ins_drog ON DROGUERIA AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'INSERT','DROGUERIA',USER)
go


create trigger trg_upd_drog ON DROGUERIA AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','DROGUERIA',USER)
go


create trigger trg_del_fab ON FABRICANTE AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','FABRICANTE',USER)
go


create trigger trg_ins_fab ON FABRICANTE AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','FABRICANTE',USER)
go


create trigger trg_upd_fab ON FABRICANTE AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','FABRICANTE',USER)
go


create trigger trg_del_factu ON FACTURA AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','FACTURA',USER)
go


create trigger trg_ins_factu ON FACTURA AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','FACTURA',USER)
go


create trigger trg_upd_factu ON FACTURA AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','FACTURA',USER)
go


create trigger trg_del_invent ON INVENTARIO_RPT AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','INVENTARIO_RPT',USER)
go


create trigger trg_ins_invent ON INVENTARIO_RPT AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','INVENTARIO_RPT',USER)
go


create trigger trg_upd_invent ON INVENTARIO_RPT AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','INVENTARIO_RPT',USER)
go


create trigger trg_del_medic ON MEDICAMENTO AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','MEDICAMENTO',USER)
go


create trigger trg_ins_medic ON MEDICAMENTO AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'INSERT','MEDICAMENTO',USER)
go


create trigger trg_upd_medic ON MEDICAMENTO AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'UPDATE','MEDICAMENTO',USER)
go


create trigger trg_del_ped ON PEDIDO AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'DELETE','PEDIDO',USER)
go


create trigger trg_ins_ped ON PEDIDO AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'INSERT','PEDIDO',USER)
go


create trigger trg_upd_ped ON PEDIDO AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'UPDATE','PEDIDO',USER)
go


create trigger trg_del_ped_prod ON PEDIDO AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'DELETE','PEDIDO_PRODUCTO',USER)
go


create trigger trg_upd_ped_prod ON PEDIDO AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'UPDATE','PEDIDO_PRODUCTO',USER)
go


create trigger trg_ins_ped_prod ON PEDIDO AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'INSERT','PEDIDO_PRODUCTO',USER)
go


create trigger trg_del_pers ON PERSONA AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'DELETE','PERSONA',USER)
go


create trigger trg_ins_pers ON PERSONA AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','PERSONA',USER)
go


create trigger trg_upd_pers ON PERSONA AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'UPDATE','PERSONA',USER)
go


create trigger trg_del_pre ON PERSONA AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'DELETE','PRESENTACION',USER)
go


create trigger trg_ins_pre ON PERSONA AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','PRESENTACION',USER)
go


create trigger trg_upd_pre ON PERSONA AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'UPDATE','PRESENTACION',USER)
go


create trigger trg_del_prd_drog ON PERSONA AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'DELETE','PRODUCTO_DROGUERIA',USER)
go


create trigger trg_ins_prd_drog ON PERSONA AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','PRODUCTO_DROGUERIA',USER)
go


create trigger trg_upd_prd_drog ON PERSONA AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO)values(GETDATE(),'UPDATE','PRODUCTO_DROGUERIA',USER)
go


create trigger trg_del_pordFab ON PRODUCTO_FABRICANTE AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','PRODUCTO_FABRICANTE',USER)
go


create trigger trg_ins_pordFab ON PRODUCTO_FABRICANTE AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','PRODUCTO_FABRICANTE',USER)
go


create trigger trg_upd_pordFab ON PRODUCTO_FABRICANTE AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','PRODUCTO_FABRICANTE',USER)
go


create trigger trg_del_prodFac ON PRODUCTO_FACTURA AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','PRODUCTO_FACTURA',USER)
go


create trigger trg_ins_prodFac ON PRODUCTO_FACTURA AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','PRODUCTO_FACTURA',USER)
go


create trigger trg_upd_prodFac ON PRODUCTO_FACTURA AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','PRODUCTO_FACTURA',USER)
go


create trigger trg_del_prodInv ON PRODUCTO_INVENTARIO AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','PRODUCTO_INVENTARIO',USER)
go


create trigger trg_ins_prodInv ON PRODUCTO_INVENTARIO AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','PRODUCTO_INVENTARIO',USER)
go


create trigger trg_upd_prodInv ON PRODUCTO_INVENTARIO AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','PRODUCTO_INVENTARIO',USER)
go


create trigger trg_del_prove ON PROVEEDOR AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','PROVEEDOR',USER)
go


create trigger trg_ins_prove ON PROVEEDOR AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','PROVEEDOR',USER)
go


create trigger trg_upd_prove ON PROVEEDOR AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','PROVEEDOR',USER)
go


create trigger trg_del_prov_tpr ON PROVEEDOR AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','PROVEEDOR_TIPO_PROVEEDOR',USER)
go


create trigger trg_ins_prov_tpr ON PROVEEDOR AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','PROVEEDOR_TIPO_PROVEEDOR',USER)
go


create trigger trg_upd_prov_tpr ON PROVEEDOR AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','PROVEEDOR_TIPO_PROVEEDOR',USER)
go


create trigger trg_del_tipoProd ON TIPO_PRODUCTO AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','TIPO_PRODUCTO',USER)
go


create trigger trg_ins_tipoProd ON TIPO_PRODUCTO AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','TIPO_PRODUCTO',USER)
go


create trigger trg_upd_tipoProd ON TIPO_PRODUCTO AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','TIPO_PRODUCTO',USER)
go


create trigger trg_del_tipoProv ON TIPO_PRODUCTO AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','TIPO_PROVEEDOR',USER)
go


create trigger trg_ins_tipoProv ON TIPO_PRODUCTO AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','TIPO_PROVEEDOR',USER)
go


create trigger trg_upd_tipoProv ON TIPO_PRODUCTO AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','TIPO_PROVEEDOR',USER)
go


create trigger trg_del_usoMedic ON USO_MEDICAMENTO AFTER DELETE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'DELETE','USO_MEDICAMENTO',USER)
go


create trigger trg_ins_usoMedic ON USO_MEDICAMENTO AFTER INSERT AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'INSERT','USO_MEDICAMENTO',USER)
go


create trigger trg_upd_usoMedic ON USO_MEDICAMENTO AFTER UPDATE AS
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(GETDATE(),'UPDATE','USO_MEDICAMENTO',USER)
go


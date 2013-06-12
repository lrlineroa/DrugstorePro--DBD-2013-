/*==============================================================*/
/* DBMS name:      Sybase AS Enterprise 15.0                    */
/* Created on:     6/11/2013 10:36:07 PM                        */
/*==============================================================*/


if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('FACTURA'))
            where name = 'FK_FACTURA_FACTURA_P_PERSONA' and type = 'RI')
   alter table FACTURA
      drop constraint FK_FACTURA_FACTURA_P_PERSONA
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('INVETARIORPT'))
            where name = 'FK_INVETARI_PERSONA_I_PERSONA' and type = 'RI')
   alter table INVETARIORPT
      drop constraint FK_INVETARI_PERSONA_I_PERSONA
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
            where name = 'FK_PEDIDO_P_PEDIDO_PR_MEDICAME' and type = 'RI')
   alter table PEDIDO_PRODUCTO
      drop constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME
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
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTODROGUERIA'))
            where name = 'FK_PRODUCTO_PRODUCTOD_DROGUERI' and type = 'RI')
   alter table PRODUCTODROGUERIA
      drop constraint FK_PRODUCTO_PRODUCTOD_DROGUERI
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTODROGUERIA'))
            where name = 'FK_PRODUCTO_PRODUCTOD_MEDICAME' and type = 'RI')
   alter table PRODUCTODROGUERIA
      drop constraint FK_PRODUCTO_PRODUCTOD_MEDICAME
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
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_FABRICANTE'))
            where name = 'FK_PRODUCTO_PRODUCTO__FABRICAN' and type = 'RI')
   alter table PRODUCTO_FABRICANTE
      drop constraint FK_PRODUCTO_PRODUCTO__FABRICAN
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_FACTURA'))
            where name = 'FK_PRODUCTO_PRODUCTO__MEDICAM2' and type = 'RI')
   alter table PRODUCTO_FACTURA
      drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM2
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
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_INVENTARIO'))
            where name = 'FK_PRODUCTO_PRODUCTO__MEDICAM3' and type = 'RI')
   alter table PRODUCTO_INVENTARIO
      drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM3
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PRODUCTO_INVENTARIO'))
            where name = 'FK_PRODUCTO_PRODUCTO__INVETARI' and type = 'RI')
   alter table PRODUCTO_INVENTARIO
      drop constraint FK_PRODUCTO_PRODUCTO__INVETARI
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PROVEEDOR_TIPO_PROVEEDOR'))
            where name = 'FK_PROVEEDO_PROVEEDOR_PROVEEDO' and type = 'RI')
   alter table PROVEEDOR_TIPO_PROVEEDOR
      drop constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO
go

if exists (select 1 
            from  sysobjects c 
            join  sysconstraints s on (s.constrid = c.id and s.tableid = object_id('PROVEEDOR_TIPO_PROVEEDOR'))
            where name = 'FK_PROVEEDO_PROVEEDOR_TIPO_PRO' and type = 'RI')
   alter table PROVEEDOR_TIPO_PROVEEDOR
      drop constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO
go

if exists (select 1
            from  sysobjects
            where  id = object_id('VIEW_ADVICE')
            and   type = 'V')
   drop view VIEW_ADVICE
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
            where  id = object_id('VIEW_PRODUCTOS_DROGUERIA')
            and   type = 'V')
   drop view VIEW_PRODUCTOS_DROGUERIA
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
            where id = object_id('ADVICE')
            and   type = 'U')
   drop table ADVICE
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
           where  id    = object_id('INVETARIORPT')
            and   name  = 'PERSONA_INVENTARIO_FK'
            and   indid > 0
            and   indid < 255)
   drop index INVETARIORPT.PERSONA_INVENTARIO_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('INVETARIORPT')
            and   type = 'U')
   drop table INVETARIORPT
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
           where  id    = object_id('PRODUCTODROGUERIA')
            and   name  = 'PRODUCTODROGUERIA_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTODROGUERIA.PRODUCTODROGUERIA_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTODROGUERIA')
            and   name  = 'PRODUCTODROGUERIA2_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTODROGUERIA.PRODUCTODROGUERIA2_FK
go

if exists (select 1
            from  sysobjects
            where id = object_id('PRODUCTODROGUERIA')
            and   type = 'U')
   drop table PRODUCTODROGUERIA
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('PRODUCTO_FABRICANTE')
            and   name  = 'PRODUCTO_FABRICANTE2_FK'
            and   indid > 0
            and   indid < 255)
   drop index PRODUCTO_FABRICANTE.PRODUCTO_FABRICANTE2_FK
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
            and   name  = 'PROVEEDOR_TIPO_PROVEEDOR2_FK'
            and   indid > 0
            and   indid < 255)
   drop index PROVEEDOR_TIPO_PROVEEDOR.PROVEEDOR_TIPO_PROVEEDOR2_FK
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
/* Table: ADVICE                                                */
/*==============================================================*/
create table ADVICE (
   ID_ADVICE            int                            not null,
   ID_PROD_RELACIONADO  int                            not null,
   TIPO_O_NOTA          text                           null,
   CANT_REGISTRADA      int                            not null,
   constraint PK_ADVICE primary key nonclustered (ID_ADVICE)
)
go

/*==============================================================*/
/* Table: BITACORA                                              */
/*==============================================================*/
create table BITACORA (
   ID_BITACORA          int                            identity,
   FECHA                date                           not null,
   TIPO_ACCION          char(20)                       not null,
   TABLA                char(50)                       null,
   USUARIO              char(25)                       null,
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
   ID_PERSONA           bigint                         not null,
   FECHA_FACTURA        timestamp                      not null,
   TOTAL                float(10)                      null,
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
/* Table: INVETARIORPT                                          */
/*==============================================================*/
create table INVETARIORPT (
   ID_INVENTARIORPT     int                            not null,
   ID_PERSONA           bigint                         not null,
   FECHA_INV            datetime                       not null,
   constraint PK_INVETARIORPT primary key nonclustered (ID_INVENTARIORPT)
)
go

/*==============================================================*/
/* Index: PERSONA_INVENTARIO_FK                                 */
/*==============================================================*/
create index PERSONA_INVENTARIO_FK on INVETARIORPT (
ID_PERSONA ASC
)
go

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO (
   ID_PRODUCTO          bigint                         not null,
   ID_USO_MEDICAMENTO   int                            null,
   ID_TIPO_PRODUCTO     int                            not null,
   ID_PRESENTACION      int                            not null,
   ID_PROVEEDOR         int                            not null,
   NOMBRE_PRODUCTO      varchar(25)                    not null,
   PRECIO_PRODUCTO      float(7)                       not null,
   CANTIDAD_PRODUCTO    int                            not null,
   POSOLOGIA_PRODUCTO   varchar(12)                    not null,
   VENTA_LIBRE          bit                            not null,
   constraint PK_MEDICAMENTO primary key (ID_PRODUCTO)
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
   FECHA_PEDIDO         date                           not null,
   HORA_PEDIDO          time                           not null,
   NOMBRE_CLIENTE_PED   varchar(35)                    not null,
   DIRECCION_CLIEN_PEDIDO varchar(50)                    not null,
   TELEFONO_CLIENTE_PED varchar(12)                    not null,
   SOLICITUD_EN_CURSO   bit                            not null,
   SOLICITUD_FINALIZADA bit                            not null,
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
   ID_PRODUCTO          bigint                         not null,
   ID_PEDIDO            int                            not null,
   constraint PK_PEDIDO_PRODUCTO primary key (ID_PRODUCTO, ID_PEDIDO)
)
go

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO_FK                                    */
/*==============================================================*/
create index PEDIDO_PRODUCTO_FK on PEDIDO_PRODUCTO (
ID_PRODUCTO ASC
)
go

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO2_FK                                   */
/*==============================================================*/
create index PEDIDO_PRODUCTO2_FK on PEDIDO_PRODUCTO (
ID_PEDIDO ASC
)
go

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   ID_PERSONA           bigint                         not null,
   ID_CARGO             int                            not null,
   ID_DROGUERIA         int                            not null,
   NOMBRE_PERSONA       varchar(15)                    not null,
   APELLIDO_PERSONA     varchar(15)                    not null,
   TELEFONO_PERSONA     int                            not null
         constraint CKC_TELEFONO_PERSONA_PERSONA check (TELEFONO_PERSONA between 000000000 and 999999999),
   DIRECCION_PERSONA    varchar(25)                    not null,
   PASSWORD             text                           not null,
   NOMBRE_DE_USUARIO    varchar(10)                    not null,
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
/* Table: PRODUCTODROGUERIA                                     */
/*==============================================================*/
create table PRODUCTODROGUERIA (
   ID_PRODUCTO          bigint                         not null,
   ID_DROGUERIA         int                            not null,
   constraint PK_PRODUCTODROGUERIA primary key (ID_PRODUCTO, ID_DROGUERIA)
)
go

/*==============================================================*/
/* Index: PRODUCTODROGUERIA2_FK                                 */
/*==============================================================*/
create index PRODUCTODROGUERIA2_FK on PRODUCTODROGUERIA (
ID_PRODUCTO ASC
)
go

/*==============================================================*/
/* Index: PRODUCTODROGUERIA_FK                                  */
/*==============================================================*/
create index PRODUCTODROGUERIA_FK on PRODUCTODROGUERIA (
ID_DROGUERIA ASC
)
go

/*==============================================================*/
/* Table: PRODUCTO_FABRICANTE                                   */
/*==============================================================*/
create table PRODUCTO_FABRICANTE (
   ID_PRODUCTO          bigint                         not null,
   ID_FABRICANTE        int                            not null,
   constraint PK_PRODUCTO_FABRICANTE primary key (ID_PRODUCTO, ID_FABRICANTE)
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
/* Index: PRODUCTO_FABRICANTE2_FK                               */
/*==============================================================*/
create index PRODUCTO_FABRICANTE2_FK on PRODUCTO_FABRICANTE (
ID_FABRICANTE ASC
)
go

/*==============================================================*/
/* Table: PRODUCTO_FACTURA                                      */
/*==============================================================*/
create table PRODUCTO_FACTURA (
   ID_PRODUCTO          bigint                         not null,
   ID_FACTURA           int                            not null,
   constraint PK_PRODUCTO_FACTURA primary key (ID_PRODUCTO, ID_FACTURA)
)
go

/*==============================================================*/
/* Index: PRODUCTO_FACTURA_FK                                   */
/*==============================================================*/
create index PRODUCTO_FACTURA_FK on PRODUCTO_FACTURA (
ID_PRODUCTO ASC
)
go

/*==============================================================*/
/* Index: PRODUCTO_FACTURA2_FK                                  */
/*==============================================================*/
create index PRODUCTO_FACTURA2_FK on PRODUCTO_FACTURA (
ID_FACTURA ASC
)
go

/*==============================================================*/
/* Table: PRODUCTO_INVENTARIO                                   */
/*==============================================================*/
create table PRODUCTO_INVENTARIO (
   ID_PRODUCTO          bigint                         not null,
   ID_INVENTARIORPT     int                            not null,
   constraint PK_PRODUCTO_INVENTARIO primary key (ID_PRODUCTO, ID_INVENTARIORPT)
)
go

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO_FK                                */
/*==============================================================*/
create index PRODUCTO_INVENTARIO_FK on PRODUCTO_INVENTARIO (
ID_PRODUCTO ASC
)
go

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO2_FK                               */
/*==============================================================*/
create index PRODUCTO_INVENTARIO2_FK on PRODUCTO_INVENTARIO (
ID_INVENTARIORPT ASC
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
   ID_PROVEEDOR         int                            not null,
   ID_TIPO_PROVEEDOR    int                            not null,
   constraint PK_PROVEEDOR_TIPO_PROVEEDOR primary key (ID_PROVEEDOR, ID_TIPO_PROVEEDOR)
)
go

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR_FK                           */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR_FK on PROVEEDOR_TIPO_PROVEEDOR (
ID_PROVEEDOR ASC
)
go

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR2_FK                          */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR2_FK on PROVEEDOR_TIPO_PROVEEDOR (
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
/* View: VIEW_ADVICE                                            */
/*==============================================================*/
create view VIEW_ADVICE as
select * from ADVICE
go

/*==============================================================*/
/* View: VIEW_BITACORA                                          */
/*==============================================================*/
create view VIEW_BITACORA as
select
   *
go

/*==============================================================*/
/* View: VIEW_CARGO                                             */
/*==============================================================*/
create view VIEW_CARGO as
select
   *
go

/*==============================================================*/
/* View: VIEW_DROGUERIA                                         */
/*==============================================================*/
create view VIEW_DROGUERIA as
select
   *
go

/*==============================================================*/
/* View: VIEW_FABRICANTE                                        */
/*==============================================================*/
create view VIEW_FABRICANTE as
select
   *
go

/*==============================================================*/
/* View: VIEW_FACTURA                                           */
/*==============================================================*/
create view VIEW_FACTURA as
select
   *
go

/*==============================================================*/
/* View: VIEW_INVENTARIORPT                                     */
/*==============================================================*/
create view VIEW_INVENTARIORPT as
select
   *
go

/*==============================================================*/
/* View: VIEW_MEDICAMENTO                                       */
/*==============================================================*/
create view VIEW_MEDICAMENTO as
select
   *
go

/*==============================================================*/
/* View: VIEW_PEDIDO                                            */
/*==============================================================*/
create view VIEW_PEDIDO as
select
   *
go

/*==============================================================*/
/* View: VIEW_PEDIDO_PRODUCTO                                   */
/*==============================================================*/
create view VIEW_PEDIDO_PRODUCTO as
select
   *
go

/*==============================================================*/
/* View: VIEW_PERSONA                                           */
/*==============================================================*/
create view VIEW_PERSONA as
select
   *
go

/*==============================================================*/
/* View: VIEW_PRESENTACION                                      */
/*==============================================================*/
create view VIEW_PRESENTACION as
select
   *
go

/*==============================================================*/
/* View: VIEW_PRODUCTOS_DROGUERIA                               */
/*==============================================================*/
create view VIEW_PRODUCTOS_DROGUERIA as
select
   MEDICAMENTO.ID_PRODUCTO,
   MEDICAMENTO.ID_USO_MEDICAMENTO,
   MEDICAMENTO.ID_TIPO_PRODUCTO,
   MEDICAMENTO.ID_PRESENTACION,
   MEDICAMENTO.ID_PROVEEDOR,
   MEDICAMENTO.NOMBRE_PRODUCTO,
   MEDICAMENTO.PRECIO_PRODUCTO,
   MEDICAMENTO.CANTIDAD_PRODUCTO,
   MEDICAMENTO.POSOLOGIA_PRODUCTO,
   MEDICAMENTO.VENTA_LIBRE,
   DROGUERIA.ID_DROGUERIA,
   DROGUERIA.NOMBRE_DROGUERIA,
   DROGUERIA.TELEFONO_DROGUERIA,
   DROGUERIA.DIRECCION_DROGUERIA
from
   MEDICAMENTO,
   DROGUERIA
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_FABRICANTE                               */
/*==============================================================*/
create view VIEW_PRODUCTO_FABRICANTE as
select
   *
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_FACTURA                                  */
/*==============================================================*/
create view VIEW_PRODUCTO_FACTURA as
select
   *
go

/*==============================================================*/
/* View: VIEW_PRODUCTO_INVENTARIO                               */
/*==============================================================*/
create view VIEW_PRODUCTO_INVENTARIO as
select
   *
go

/*==============================================================*/
/* View: VIEW_PROVEEDOR                                         */
/*==============================================================*/
create view VIEW_PROVEEDOR as
select
   *
go

/*==============================================================*/
/* View: VIEW_PROVEEDOR_TIPO_PROV                               */
/*==============================================================*/
create view VIEW_PROVEEDOR_TIPO_PROV as
select
   *
go

/*==============================================================*/
/* View: VIEW_TIPO_PRODUCTO                                     */
/*==============================================================*/
create view VIEW_TIPO_PRODUCTO as
select
   *
go

/*==============================================================*/
/* View: VIEW_USO_MEDIC                                         */
/*==============================================================*/
create view VIEW_USO_MEDIC as
select
   *
go

alter table FACTURA
   add constraint FK_FACTURA_FACTURA_P_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
go

alter table INVETARIORPT
   add constraint FK_INVETARI_PERSONA_I_PERSONA foreign key (ID_PERSONA)
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
   add constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PEDIDO_PRODUCTO
   add constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO)
go

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_C_CARGO foreign key (ID_CARGO)
      references CARGO (ID_CARGO)
go

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_D_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
go

alter table PRODUCTODROGUERIA
   add constraint FK_PRODUCTO_PRODUCTOD_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
go

alter table PRODUCTODROGUERIA
   add constraint FK_PRODUCTO_PRODUCTOD_MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PRODUCTO_FABRICANTE
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PRODUCTO_FABRICANTE
   add constraint FK_PRODUCTO_PRODUCTO__FABRICAN foreign key (ID_FABRICANTE)
      references FABRICANTE (ID_FABRICANTE)
go

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM2 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__FACTURA foreign key (ID_FACTURA)
      references FACTURA (ID_FACTURA)
go

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM3 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__INVETARI foreign key (ID_INVENTARIORPT)
      references INVETARIORPT (ID_INVENTARIORPT)
go

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR)
go

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO foreign key (ID_TIPO_PROVEEDOR)
      references TIPO_PROVEEDOR (ID_TIPO_PROVEEDOR)
go


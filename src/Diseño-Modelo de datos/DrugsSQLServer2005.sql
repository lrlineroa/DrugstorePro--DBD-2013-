/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2005                    */
/* Created on:     4/17/2013 2:48:26 AM                         */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('FABRICANTE_TIPO_FABRICANTE') and o.name = 'FK_FABRICAN_FABRICANT_TIPO_FAB')
alter table FABRICANTE_TIPO_FABRICANTE
   drop constraint FK_FABRICAN_FABRICANT_TIPO_FAB
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('FABRICANTE_TIPO_FABRICANTE') and o.name = 'FK_FABRICAN_FABRICANT_FABRICAN')
alter table FABRICANTE_TIPO_FABRICANTE
   drop constraint FK_FABRICAN_FABRICANT_FABRICAN
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('FACTURA') and o.name = 'FK_FACTURA_FACTURA_P_PERSONA')
alter table FACTURA
   drop constraint FK_FACTURA_FACTURA_P_PERSONA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('INVETARIORPT') and o.name = 'FK_INVETARI_PERSONA_I_PERSONA')
alter table INVETARIORPT
   drop constraint FK_INVETARI_PERSONA_I_PERSONA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEDICAMENTO') and o.name = 'FK_MEDICAME_PRESENTAC_PRESENTA')
alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRESENTAC_PRESENTA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('MEDICAMENTO') and o.name = 'FK_MEDICAME_PRODUCTO__FABRICAN')
alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRODUCTO__FABRICAN
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
   where r.fkeyid = object_id('PRODUCTO_DROGUERIA') and o.name = 'FK_PRODUCTO_PRODUCTO__MEDICAME2')
alter table PRODUCTO_DROGUERIA
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAME2
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_FACTURA') and o.name = 'FK_PRODUCTO_PRODUCTO__FACTURA')
alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__FACTURA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_FACTURA') and o.name = 'FK_PRODUCTO_PRODUCTO__MEDICAME3')
alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAME3
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_INVENTARIO') and o.name = 'FK_PRODUCTO_PRODUCTO__INVETARI')
alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__INVETARI
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PRODUCTO_INVENTARIO') and o.name = 'FK_PRODUCTO_PRODUCTO__MEDICAME')
alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAME
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
           where  id    = object_id('FABRICANTE_TIPO_FABRICANTE')
            and   name  = 'FABRICANTE_TIPO_FABRICANTE_FK'
            and   indid > 0
            and   indid < 255)
   drop index FABRICANTE_TIPO_FABRICANTE.FABRICANTE_TIPO_FABRICANTE_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('FABRICANTE_TIPO_FABRICANTE')
            and   name  = 'FABRICANTE_TIPO_FABRICANTE2_FK'
            and   indid > 0
            and   indid < 255)
   drop index FABRICANTE_TIPO_FABRICANTE.FABRICANTE_TIPO_FABRICANTE2_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('FABRICANTE_TIPO_FABRICANTE')
            and   type = 'U')
   drop table FABRICANTE_TIPO_FABRICANTE
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
           where  id    = object_id('INVETARIORPT')
            and   name  = 'PERSONA_INVENTARIO_FK'
            and   indid > 0
            and   indid < 255)
   drop index INVETARIORPT.PERSONA_INVENTARIO_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('INVETARIORPT')
            and   type = 'U')
   drop table INVETARIORPT
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('MEDICAMENTO')
            and   name  = 'PRODUCTO_FABRICANTE_FK'
            and   indid > 0
            and   indid < 255)
   drop index MEDICAMENTO.PRODUCTO_FABRICANTE_FK
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
           where  id = object_id('TIPO_FABRICANTE')
            and   type = 'U')
   drop table TIPO_FABRICANTE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('TIPO_PRODUCTO')
            and   type = 'U')
   drop table TIPO_PRODUCTO
go

if exists (select 1
            from  sysobjects
           where  id = object_id('USO_MEDICAMENTO')
            and   type = 'U')
   drop table USO_MEDICAMENTO
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
   NOMBRE_FABRICANTE    varchar(20)          not null,
   TELEFONO_FABRICANTE  varchar(12)          not null,
   DIRECCION_FABRICANTE varchar(25)          not null,
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
   'La tabla FABRICANTE hace referencia a la entidad que fabrica los productos vendidos en la farmacia. Cada PRODUCTO tendra asociado un registro de la tabla FABRICANTE', 
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
   'Identificador de la entidad fabricante',
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
   'Razon social de la empresa que comercializa dicho producto',
   'user', @CurrentUser, 'table', 'FABRICANTE', 'column', 'NOMBRE_FABRICANTE'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'TELEFONO_FABRICANTE')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'FABRICANTE', 'column', 'TELEFONO_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Telefono de contacto del fabricante del producto',
   'user', @CurrentUser, 'table', 'FABRICANTE', 'column', 'TELEFONO_FABRICANTE'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'DIRECCION_FABRICANTE')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'FABRICANTE', 'column', 'DIRECCION_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Direccion de la empresa u oficina de la empresa que comercializa el producto.',
   'user', @CurrentUser, 'table', 'FABRICANTE', 'column', 'DIRECCION_FABRICANTE'
go

/*==============================================================*/
/* Table: FABRICANTE_TIPO_FABRICANTE                            */
/*==============================================================*/
create table FABRICANTE_TIPO_FABRICANTE (
   ID_TIPO_FABRICANTE   int                  not null,
   ID_FABRICANTE        int                  not null,
   constraint PK_FABRICANTE_TIPO_FABRICANTE primary key nonclustered (ID_TIPO_FABRICANTE, ID_FABRICANTE)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('FABRICANTE_TIPO_FABRICANTE') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'FABRICANTE_TIPO_FABRICANTE' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'relaciona las entidades FABRICANTE y Tipo_Fabricante', 
   'user', @CurrentUser, 'table', 'FABRICANTE_TIPO_FABRICANTE'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('FABRICANTE_TIPO_FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_TIPO_FABRICANTE')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'FABRICANTE_TIPO_FABRICANTE', 'column', 'ID_TIPO_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador de Tipo Fabricante',
   'user', @CurrentUser, 'table', 'FABRICANTE_TIPO_FABRICANTE', 'column', 'ID_TIPO_FABRICANTE'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('FABRICANTE_TIPO_FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_FABRICANTE')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'FABRICANTE_TIPO_FABRICANTE', 'column', 'ID_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador del fabricante',
   'user', @CurrentUser, 'table', 'FABRICANTE_TIPO_FABRICANTE', 'column', 'ID_FABRICANTE'
go

/*==============================================================*/
/* Index: FABRICANTE_TIPO_FABRICANTE2_FK                        */
/*==============================================================*/
create index FABRICANTE_TIPO_FABRICANTE2_FK on FABRICANTE_TIPO_FABRICANTE (
ID_FABRICANTE ASC
)
go

/*==============================================================*/
/* Index: FABRICANTE_TIPO_FABRICANTE_FK                         */
/*==============================================================*/
create index FABRICANTE_TIPO_FABRICANTE_FK on FABRICANTE_TIPO_FABRICANTE (
ID_TIPO_FABRICANTE ASC
)
go

/*==============================================================*/
/* Table: FACTURA                                               */
/*==============================================================*/
create table FACTURA (
   ID_FACTURA           int                  not null,
   ID_PERSONA           bigint               not null,
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
/* Table: INVETARIORPT                                          */
/*==============================================================*/
create table INVETARIORPT (
   ID_INVENTARIORPT     int                  not null,
   ID_PERSONA           bigint               not null,
   FECHA_INV            datetime             not null,
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
   ID_PRODUCTO          bigint               not null,
   ID_PRESENTACION      int                  not null,
   ID_USO_MEDICAMENTO   int                  null,
   NOMBRE_PRODUCTO      varchar(25)          null,
   PRECIO_PRODUCTO      float(7)             null,
   CANTIDAD_PRODUCTO    int                  null,
   POSOLOGIA_PRODUCTO   int                  null,
   ID_TIPO_PRODUCTO     int                  not null,
   ID_FABRICANTE        int                  not null,
   VENTA_LIBRE          bit                  not null,
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
/* Index: PRODUCTO_FABRICANTE_FK                                */
/*==============================================================*/
create index PRODUCTO_FABRICANTE_FK on MEDICAMENTO (
ID_FABRICANTE ASC
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
   SOLICITUD_EN_CURSO   bit                  not null,
   SOLICITUD_FINALIZADA bit                  not null,
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
   ID_PRODUCTO          bigint               not null,
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
   ID_PERSONA           bigint               not null,
   ID_CARGO             int                  not null,
   ID_DROGUERIA         int                  not null,
   NOMBRE_PERSONA       varchar(15)          not null,
   APELLIDO_PERSONA     varchar(15)          not null,
   TELEFONO_PERSONA     int                  not null
      constraint CKC_TELEFONO_PERSONA_PERSONA check (TELEFONO_PERSONA between 999999999 and 000000000),
   DIRECCION_PERSONA    varchar(25)          not null,
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
   'esta entidad recojera la informacion de cada una de las distintas presentaciones, formas, envases o maneras de comercializar los productos. eje: gel, pildora, jarabe, etc', 
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
   ID_PRODUCTO          bigint               not null
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
/* Table: PRODUCTO_FACTURA                                      */
/*==============================================================*/
create table PRODUCTO_FACTURA (
   ID_FACTURA           int                  not null,
   ID_PRODUCTO          bigint               not null
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
   ID_PRODUCTO          bigint               not null
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
/* Table: TIPO_FABRICANTE                                       */
/*==============================================================*/
create table TIPO_FABRICANTE (
   ID_TIPO_FABRICANTE   int                  not null,
   TIPO_FABRICANTE      varchar(25)          not null,
   constraint PK_TIPO_FABRICANTE primary key nonclustered (ID_TIPO_FABRICANTE)
)
go

if exists (select 1 from  sys.extended_properties
           where major_id = object_id('TIPO_FABRICANTE') and minor_id = 0)
begin 
   declare @CurrentUser sysname 
select @CurrentUser = user_name() 
execute sp_dropextendedproperty 'MS_Description',  
   'user', @CurrentUser, 'table', 'TIPO_FABRICANTE' 
 
end 


select @CurrentUser = user_name() 
execute sp_addextendedproperty 'MS_Description',  
   'Entidad que registra los diferentes tipos de fabricante segun su actividad.', 
   'user', @CurrentUser, 'table', 'TIPO_FABRICANTE'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('TIPO_FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'ID_TIPO_FABRICANTE')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'TIPO_FABRICANTE', 'column', 'ID_TIPO_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'Identificador de la entidad Tipo_Fabricante',
   'user', @CurrentUser, 'table', 'TIPO_FABRICANTE', 'column', 'ID_TIPO_FABRICANTE'
go

if exists(select 1 from sys.extended_properties p where
      p.major_id = object_id('TIPO_FABRICANTE')
  and p.minor_id = (select c.column_id from sys.columns c where c.object_id = p.major_id and c.name = 'TIPO_FABRICANTE')
)
begin
   declare @CurrentUser sysname
select @CurrentUser = user_name()
execute sp_dropextendedproperty 'MS_Description', 
   'user', @CurrentUser, 'table', 'TIPO_FABRICANTE', 'column', 'TIPO_FABRICANTE'

end


select @CurrentUser = user_name()
execute sp_addextendedproperty 'MS_Description', 
   'nombre del tipo de fabricante.',
   'user', @CurrentUser, 'table', 'TIPO_FABRICANTE', 'column', 'TIPO_FABRICANTE'
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

alter table FABRICANTE_TIPO_FABRICANTE
   add constraint FK_FABRICAN_FABRICANT_TIPO_FAB foreign key (ID_TIPO_FABRICANTE)
      references TIPO_FABRICANTE (ID_TIPO_FABRICANTE)
go

alter table FABRICANTE_TIPO_FABRICANTE
   add constraint FK_FABRICAN_FABRICANT_FABRICAN foreign key (ID_FABRICANTE)
      references FABRICANTE (ID_FABRICANTE)
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
   add constraint FK_MEDICAME_PRODUCTO__FABRICAN foreign key (ID_FABRICANTE)
      references FABRICANTE (ID_FABRICANTE)
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
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAME2 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__FACTURA foreign key (ID_FACTURA)
      references FACTURA (ID_FACTURA)
go

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAME3 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__INVETARI foreign key (ID_INVENTARIORPT)
      references INVETARIORPT (ID_INVENTARIORPT)
go

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
go


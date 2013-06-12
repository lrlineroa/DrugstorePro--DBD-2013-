/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     6/11/2013 10:26:49 PM                        */
/*==============================================================*/



-- Type package declaration
create or replace package PDTypes  
as
    TYPE ref_cursor IS REF CURSOR;
end;

-- Integrity package declaration
create or replace package IntegrityPackage AS
 procedure InitNestLevel;
 function GetNestLevel return number;
 procedure NextNestLevel;
 procedure PreviousNestLevel;
 end IntegrityPackage;
/

-- Integrity package definition
create or replace package body IntegrityPackage AS
 NestLevel number;

-- Procedure to initialize the trigger nest level
 procedure InitNestLevel is
 begin
 NestLevel := 0;
 end;


-- Function to return the trigger nest level
 function GetNestLevel return number is
 begin
 if NestLevel is null then
     NestLevel := 0;
 end if;
 return(NestLevel);
 end;

-- Procedure to increase the trigger nest level
 procedure NextNestLevel is
 begin
 if NestLevel is null then
     NestLevel := 0;
 end if;
 NestLevel := NestLevel + 1;
 end;

-- Procedure to decrease the trigger nest level
 procedure PreviousNestLevel is
 begin
 NestLevel := NestLevel - 1;
 end;

 end IntegrityPackage;
/


drop trigger TRG_DEL_DROG
/

drop trigger TRG_INS_DROG
/

drop trigger TRG_UPD_DROG
/

drop trigger TIB_BITACORA
/

alter table FACTURA
   drop constraint FK_FACTURA_FACTURA_P_PERSONA
/

alter table INVETARIORPT
   drop constraint FK_INVETARI_PERSONA_I_PERSONA
/

alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRESENTAC_PRESENTA
/

alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRODUCTO__PROVEEDO
/

alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRODUCTO__TIPO_PRO
/

alter table MEDICAMENTO
   drop constraint FK_MEDICAME_USO_MEDIC_USO_MEDI
/

alter table PEDIDO
   drop constraint FK_PEDIDO_PEDIDO_DR_DROGUERI
/

alter table PEDIDO_PRODUCTO
   drop constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME
/

alter table PEDIDO_PRODUCTO
   drop constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO
/

alter table PERSONA
   drop constraint FK_PERSONA_PERSONA_C_CARGO
/

alter table PERSONA
   drop constraint FK_PERSONA_PERSONA_D_DROGUERI
/

alter table PRODUCTODROGUERIA
   drop constraint FK_PRODUCTO_PRODUCTOD_DROGUERI
/

alter table PRODUCTODROGUERIA
   drop constraint FK_PRODUCTO_PRODUCTOD_MEDICAME
/

alter table PRODUCTO_FABRICANTE
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAME
/

alter table PRODUCTO_FABRICANTE
   drop constraint FK_PRODUCTO_PRODUCTO__FABRICAN
/

alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM2
/

alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__FACTURA
/

alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM3
/

alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__INVETARI
/

alter table PROVEEDOR_TIPO_PROVEEDOR
   drop constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO
/

alter table PROVEEDOR_TIPO_PROVEEDOR
   drop constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO
/

drop view VIEW_ADVICE
/

drop view VIEW_BITACORA
/

drop view VIEW_CARGO
/

drop view VIEW_DROGUERIA
/

drop view VIEW_FABRICANTE
/

drop view VIEW_FACTURA
/

drop view VIEW_INVENTARIORPT
/

drop view VIEW_MEDICAMENTO
/

drop view VIEW_PEDIDO
/

drop view VIEW_PEDIDO_PRODUCTO
/

drop view VIEW_PERSONA
/

drop view VIEW_PRESENTACION
/

drop view VIEW_PRODUCTOS_DROGUERIA
/

drop view VIEW_PRODUCTO_FABRICANTE
/

drop view VIEW_PRODUCTO_FACTURA
/

drop view VIEW_PRODUCTO_INVENTARIO
/

drop view VIEW_PROVEEDOR
/

drop view VIEW_PROVEEDOR_TIPO_PROV
/

drop view VIEW_TIPO_PRODUCTO
/

drop view VIEW_USO_MEDIC
/

drop table ADVICE cascade constraints
/

drop table BITACORA cascade constraints
/

drop table CARGO cascade constraints
/

drop table DROGUERIA cascade constraints
/

drop table FABRICANTE cascade constraints
/

drop index FACTURA_PERSONA_FK
/

drop table FACTURA cascade constraints
/

drop index PERSONA_INVENTARIO_FK
/

drop table INVETARIORPT cascade constraints
/

drop index PRODUCTO_PROVEEDOR_FK
/

drop index PRODUCTO_TIPO_PRODUCTO_FK
/

drop index PRESENTACION_PRODUCTO_FK
/

drop index USO_MEDICAMENTO_PRODUCTO_FK
/

drop table MEDICAMENTO cascade constraints
/

drop index PEDIDO_DROGUERIA_FK
/

drop table PEDIDO cascade constraints
/

drop index PEDIDO_PRODUCTO2_FK
/

drop index PEDIDO_PRODUCTO_FK
/

drop table PEDIDO_PRODUCTO cascade constraints
/

drop index PERSONA_DROGUERIA_FK
/

drop index PERSONA_CARGO_FK
/

drop table PERSONA cascade constraints
/

drop table PRESENTACION cascade constraints
/

drop index PRODUCTODROGUERIA_FK
/

drop index PRODUCTODROGUERIA2_FK
/

drop table PRODUCTODROGUERIA cascade constraints
/

drop index PRODUCTO_FABRICANTE2_FK
/

drop index PRODUCTO_FABRICANTE_FK
/

drop table PRODUCTO_FABRICANTE cascade constraints
/

drop index PRODUCTO_FACTURA2_FK
/

drop index PRODUCTO_FACTURA_FK
/

drop table PRODUCTO_FACTURA cascade constraints
/

drop index PRODUCTO_INVENTARIO2_FK
/

drop index PRODUCTO_INVENTARIO_FK
/

drop table PRODUCTO_INVENTARIO cascade constraints
/

drop table PROVEEDOR cascade constraints
/

drop index PROVEEDOR_TIPO_PROVEEDOR2_FK
/

drop index PROVEEDOR_TIPO_PROVEEDOR_FK
/

drop table PROVEEDOR_TIPO_PROVEEDOR cascade constraints
/

drop table TIPO_PRODUCTO cascade constraints
/

drop table TIPO_PROVEEDOR cascade constraints
/

drop table USO_MEDICAMENTO cascade constraints
/

drop sequence SEQUENCE
/

create sequence SEQUENCE
increment by 1
start with 1
/

/*==============================================================*/
/* Table: ADVICE                                                */
/*==============================================================*/
create table ADVICE  (
   ID_ADVICE            INTEGER                         not null,
   ID_PROD_RELACIONADO  INTEGER                         not null,
   TIPO_O_NOTA          CLOB,
   CANT_REGISTRADA      INTEGER                         not null,
   constraint PK_ADVICE primary key (ID_ADVICE)
)
/

comment on table ADVICE is
'ESTA TABLA CONTENDRÁ EL REGISTRO DE CUANDO UN MEDICAMENTO LLEGA A ESTADO CRÍTICO (MENOS DE 5 UNIDADES EN EL INVENTARIO)'
/

/*==============================================================*/
/* Table: BITACORA                                              */
/*==============================================================*/
create table BITACORA  (
   ID_BITACORA          INTEGER                         not null,
   FECHA                DATE                            not null,
   TIPO_ACCION          CHAR(20)                        not null,
   TABLA                CHAR(50),
   USUARIO              CHAR(25),
   constraint PK_BITACORA primary key (ID_BITACORA)
)
/

comment on table BITACORA is
'Tabla que guarda la información de las actividades que realizan los usuarios del sistema.'
/

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table CARGO  (
   ID_CARGO             INTEGER                         not null,
   TIPO_CARGO           VARCHAR2(15)                    not null,
   constraint PK_CARGO primary key (ID_CARGO)
)
/

comment on table CARGO is
'Esta entidad va a tener los distinitos cargos en la droguería vendedor, administrador etc...'
/

comment on column CARGO.ID_CARGO is
'Este es el identificador de los cargos puede ser un autonumérico'
/

comment on column CARGO.TIPO_CARGO is
'Este atributo va a guardar los tipos de cargos que hay en la droguería (administrador vendedor etc...'
/

/*==============================================================*/
/* Table: DROGUERIA                                             */
/*==============================================================*/
create table DROGUERIA  (
   ID_DROGUERIA         INTEGER                         not null,
   NOMBRE_DROGUERIA     VARCHAR2(25)                    not null,
   TELEFONO_DROGUERIA   VARCHAR2(15)                    not null,
   DIRECCION_DROGUERIA  VARCHAR2(35)                    not null,
   constraint PK_DROGUERIA primary key (ID_DROGUERIA)
)
/

comment on table DROGUERIA is
'Esta entidad guardara informacion sobre cada una de las distintas sedes de la drogueria.'
/

comment on column DROGUERIA.ID_DROGUERIA is
'identificador primario de esta entidad. '
/

comment on column DROGUERIA.NOMBRE_DROGUERIA is
'este atributo indica el nombre de la drogueria o sede de la drogueria'
/

comment on column DROGUERIA.TELEFONO_DROGUERIA is
'el telefono principal de contacto de la sede o drogueria'
/

comment on column DROGUERIA.DIRECCION_DROGUERIA is
'la direccion de la ubicacion fisica de la sede o drogueria'
/

/*==============================================================*/
/* Table: FABRICANTE                                            */
/*==============================================================*/
create table FABRICANTE  (
   ID_FABRICANTE        INTEGER                         not null,
   NOMBRE_FABRICANTE    VARCHAR2(20),
   constraint PK_FABRICANTE primary key (ID_FABRICANTE)
)
/

comment on table FABRICANTE is
'Esta Entidad va a guardar los diferentes fabricantes de los productos.'
/

comment on column FABRICANTE.ID_FABRICANTE is
'Es el identificador de el fabricante'
/

comment on column FABRICANTE.NOMBRE_FABRICANTE is
'Este atributo va a guardar el nombre del fabricante
'
/

/*==============================================================*/
/* Table: FACTURA                                               */
/*==============================================================*/
create table FACTURA  (
   ID_FACTURA           INTEGER                         not null,
   ID_PERSONA           INTEGER                         not null,
   FECHA_FACTURA        TIMESTAMP                       not null,
   TOTAL                FLOAT(10),
   constraint PK_FACTURA primary key (ID_FACTURA)
)
/

comment on column FACTURA.ID_PERSONA is
'Este es el número de identificación de la persona'
/

/*==============================================================*/
/* Index: FACTURA_PERSONA_FK                                    */
/*==============================================================*/
create index FACTURA_PERSONA_FK on FACTURA (
   ID_PERSONA ASC
)
/

/*==============================================================*/
/* Table: INVETARIORPT                                          */
/*==============================================================*/
create table INVETARIORPT  (
   ID_INVENTARIORPT     INTEGER                         not null,
   ID_PERSONA           INTEGER                         not null,
   FECHA_INV            DATE                            not null,
   constraint PK_INVETARIORPT primary key (ID_INVENTARIORPT)
)
/

comment on column INVETARIORPT.ID_PERSONA is
'Este es el número de identificación de la persona'
/

/*==============================================================*/
/* Index: PERSONA_INVENTARIO_FK                                 */
/*==============================================================*/
create index PERSONA_INVENTARIO_FK on INVETARIORPT (
   ID_PERSONA ASC
)
/

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO  (
   ID_PRODUCTO          INTEGER                         not null,
   ID_USO_MEDICAMENTO   INTEGER,
   ID_TIPO_PRODUCTO     INTEGER                         not null,
   ID_PRESENTACION      INTEGER                         not null,
   ID_PROVEEDOR         INTEGER                         not null,
   NOMBRE_PRODUCTO      VARCHAR2(25)                    not null,
   PRECIO_PRODUCTO      FLOAT(7)                        not null,
   CANTIDAD_PRODUCTO    INTEGER                         not null,
   POSOLOGIA_PRODUCTO   VARCHAR2(12)                    not null,
   VENTA_LIBRE          SMALLINT                        not null,
   constraint PK_MEDICAMENTO primary key (ID_PRODUCTO)
)
/

comment on column MEDICAMENTO.ID_PRODUCTO is
'Numero que identifica de forma unica el producto'
/

comment on column MEDICAMENTO.ID_PRESENTACION is
'identificador primario para esta entidad. '
/

comment on column MEDICAMENTO.ID_PROVEEDOR is
'Identificador de la entidad fabricante'
/

comment on column MEDICAMENTO.NOMBRE_PRODUCTO is
'Atributo que contiene el nombre del producto'
/

comment on column MEDICAMENTO.PRECIO_PRODUCTO is
'Atributo en el cual se especifica el precio del producto. Es de tipo Float porque puede contener decimales.'
/

comment on column MEDICAMENTO.CANTIDAD_PRODUCTO is
'Atributo en el que se especifica la cantidad del producto'
/

comment on column MEDICAMENTO.POSOLOGIA_PRODUCTO is
'Atributo en el cual se especifica la dosis recomendada del producto'
/

/*==============================================================*/
/* Index: USO_MEDICAMENTO_PRODUCTO_FK                           */
/*==============================================================*/
create index USO_MEDICAMENTO_PRODUCTO_FK on MEDICAMENTO (
   ID_USO_MEDICAMENTO ASC
)
/

/*==============================================================*/
/* Index: PRESENTACION_PRODUCTO_FK                              */
/*==============================================================*/
create index PRESENTACION_PRODUCTO_FK on MEDICAMENTO (
   ID_PRESENTACION ASC
)
/

/*==============================================================*/
/* Index: PRODUCTO_TIPO_PRODUCTO_FK                             */
/*==============================================================*/
create index PRODUCTO_TIPO_PRODUCTO_FK on MEDICAMENTO (
   ID_TIPO_PRODUCTO ASC
)
/

/*==============================================================*/
/* Index: PRODUCTO_PROVEEDOR_FK                                 */
/*==============================================================*/
create index PRODUCTO_PROVEEDOR_FK on MEDICAMENTO (
   ID_PROVEEDOR ASC
)
/

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO  (
   ID_PEDIDO            INTEGER                         not null,
   ID_DROGUERIA         INTEGER                         not null,
   FECHA_PEDIDO         DATE                            not null,
   HORA_PEDIDO          DATE                            not null,
   NOMBRE_CLIENTE_PED   VARCHAR2(35)                    not null,
   DIRECCION_CLIEN_PEDIDO VARCHAR2(50)                    not null,
   TELEFONO_CLIENTE_PED VARCHAR2(12)                    not null,
   SOLICITUD_EN_CURSO   SMALLINT                        not null,
   SOLICITUD_FINALIZADA SMALLINT                        not null,
   constraint PK_PEDIDO primary key (ID_PEDIDO)
)
/

comment on table PEDIDO is
'En esta clase se va a poner todo lo que tenga que ver con los pedidos que se hagan a un proveedor.'
/

comment on column PEDIDO.ID_PEDIDO is
'Este atributo identificara a la entidad con un codigo numerico irrepetible, es tipo integer debido a que solo nos interesa el numero como identificador para lo cual no es necesario exactitud decimal.'
/

comment on column PEDIDO.ID_DROGUERIA is
'identificador primario de esta entidad. '
/

comment on column PEDIDO.FECHA_PEDIDO is
'Este atributo guarda la fecha en la que se realizo el pedido.'
/

comment on column PEDIDO.HORA_PEDIDO is
'Este atributo guarda la hora en la que se realizo el pedido.'
/

comment on column PEDIDO.NOMBRE_CLIENTE_PED is
'En este atributo se guardara el nombre y apellido del cliente. Se definio un tamaño de 35 caracteres los cuales consideramos suficientes para guardar un nombre y los apellidos. Es de tipo varchar el cual maneja mejor el espacio cuando el tamaño de las entradas varia mucho.'
/

comment on column PEDIDO.DIRECCION_CLIEN_PEDIDO is
'En este atributo se guardara la direccion de entrega del pedido.'
/

comment on column PEDIDO.TELEFONO_CLIENTE_PED is
'Se guardara un numero telefonico fijo o celular para contactar al cliente.  Es de tipo integer debido a que los numeros telefonicos no requieren parte decimal.'
/

comment on column PEDIDO.SOLICITUD_EN_CURSO is
'Este atributo sera verdadero solo si la solicitud esta actualmente en curso. Siempre tendra valor opuesto al atributo Solicitud_finalizada.'
/

comment on column PEDIDO.SOLICITUD_FINALIZADA is
'Este atributo sera verdadero solo si el pedido a sido finalizado, ya sea por que el producto se entrego o porque el pedido se cancelo. Siempre tendra valor opuesto al atributo Solicitud_en_curso.'
/

/*==============================================================*/
/* Index: PEDIDO_DROGUERIA_FK                                   */
/*==============================================================*/
create index PEDIDO_DROGUERIA_FK on PEDIDO (
   ID_DROGUERIA ASC
)
/

/*==============================================================*/
/* Table: PEDIDO_PRODUCTO                                       */
/*==============================================================*/
create table PEDIDO_PRODUCTO  (
   ID_PRODUCTO          INTEGER                         not null,
   ID_PEDIDO            INTEGER                         not null,
   constraint PK_PEDIDO_PRODUCTO primary key (ID_PRODUCTO, ID_PEDIDO)
)
/

comment on table PEDIDO_PRODUCTO is
'Esta entidad nacio de la relacion n-m entre PEDIDO y PRODUCTO, y guardara información en donde se relacionaran los pedidos con los productos, es decir que producto fue pedido.'
/

comment on column PEDIDO_PRODUCTO.ID_PRODUCTO is
'Numero que identifica de forma unica el producto'
/

comment on column PEDIDO_PRODUCTO.ID_PEDIDO is
'Este atributo identificara a la entidad con un codigo numerico irrepetible, es tipo integer debido a que solo nos interesa el numero como identificador para lo cual no es necesario exactitud decimal.'
/

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO_FK                                    */
/*==============================================================*/
create index PEDIDO_PRODUCTO_FK on PEDIDO_PRODUCTO (
   ID_PRODUCTO ASC
)
/

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO2_FK                                   */
/*==============================================================*/
create index PEDIDO_PRODUCTO2_FK on PEDIDO_PRODUCTO (
   ID_PEDIDO ASC
)
/

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA  (
   ID_PERSONA           INTEGER                         not null,
   ID_CARGO             INTEGER                         not null,
   ID_DROGUERIA         INTEGER                         not null,
   NOMBRE_PERSONA       VARCHAR2(15)                    not null,
   APELLIDO_PERSONA     VARCHAR2(15)                    not null,
   TELEFONO_PERSONA     INTEGER                         not null
      constraint CKC_TELEFONO_PERSONA_PERSONA check (TELEFONO_PERSONA between 000000000 and 999999999),
   DIRECCION_PERSONA    VARCHAR2(25)                    not null,
   PASSWORD             CLOB                            not null,
   NOMBRE_DE_USUARIO    VARCHAR2(10)                    not null,
   constraint PK_PERSONA primary key (ID_PERSONA)
)
/

comment on table PERSONA is
'Esta entidad va a guardar la información de la persona que tiene alguna vinculación con la droguería, como administradores y vendedores.'
/

comment on column PERSONA.ID_PERSONA is
'Este es el número de identificación de la persona'
/

comment on column PERSONA.ID_CARGO is
'Este es el identificador de los cargos puede ser un autonumérico'
/

comment on column PERSONA.ID_DROGUERIA is
'identificador primario de esta entidad. '
/

comment on column PERSONA.NOMBRE_PERSONA is
'Este campo significa el nombre de la persona. (Luis, Carlos, Hernando etc...)'
/

comment on column PERSONA.APELLIDO_PERSONA is
'Este atributo es el apellido de la persona, (Martinez, Ortega, etc..)'
/

comment on column PERSONA.TELEFONO_PERSONA is
'Este atributo va a contener el teléfono de la persona que corresponda.'
/

comment on column PERSONA.DIRECCION_PERSONA is
'Este atributo va a contener la dirección de vivienda de la persona.'
/

comment on column PERSONA.PASSWORD is
'Atributo que va a guardar la contrase;a de el usuario para entrar al sistema'
/

/*==============================================================*/
/* Index: PERSONA_CARGO_FK                                      */
/*==============================================================*/
create index PERSONA_CARGO_FK on PERSONA (
   ID_CARGO ASC
)
/

/*==============================================================*/
/* Index: PERSONA_DROGUERIA_FK                                  */
/*==============================================================*/
create index PERSONA_DROGUERIA_FK on PERSONA (
   ID_DROGUERIA ASC
)
/

/*==============================================================*/
/* Table: PRESENTACION                                          */
/*==============================================================*/
create table PRESENTACION  (
   ID_PRESENTACION      INTEGER                         not null,
   TIPO_PRESENTACION    VARCHAR2(25)                    not null,
   constraint PK_PRESENTACION primary key (ID_PRESENTACION)
)
/

comment on table PRESENTACION is
'esta entidad recojera la informacion de cada una de las distintas presentaciones, formas, envases o maneras de comercializar los productos. eje: gel, pildora, jarabe, etc'
/

comment on column PRESENTACION.ID_PRESENTACION is
'identificador primario para esta entidad. '
/

comment on column PRESENTACION.TIPO_PRESENTACION is
'atributo que almacenará las distintas presentaciones en las que son vendidos los productos'
/

/*==============================================================*/
/* Table: PRODUCTODROGUERIA                                     */
/*==============================================================*/
create table PRODUCTODROGUERIA  (
   ID_PRODUCTO          INTEGER                         not null,
   ID_DROGUERIA         INTEGER                         not null,
   constraint PK_PRODUCTODROGUERIA primary key (ID_PRODUCTO, ID_DROGUERIA)
)
/

comment on column PRODUCTODROGUERIA.ID_PRODUCTO is
'Numero que identifica de forma unica el producto'
/

comment on column PRODUCTODROGUERIA.ID_DROGUERIA is
'identificador primario de esta entidad. '
/

/*==============================================================*/
/* Index: PRODUCTODROGUERIA2_FK                                 */
/*==============================================================*/
create index PRODUCTODROGUERIA2_FK on PRODUCTODROGUERIA (
   ID_PRODUCTO ASC
)
/

/*==============================================================*/
/* Index: PRODUCTODROGUERIA_FK                                  */
/*==============================================================*/
create index PRODUCTODROGUERIA_FK on PRODUCTODROGUERIA (
   ID_DROGUERIA ASC
)
/

/*==============================================================*/
/* Table: PRODUCTO_FABRICANTE                                   */
/*==============================================================*/
create table PRODUCTO_FABRICANTE  (
   ID_PRODUCTO          INTEGER                         not null,
   ID_FABRICANTE        INTEGER                         not null,
   constraint PK_PRODUCTO_FABRICANTE primary key (ID_PRODUCTO, ID_FABRICANTE)
)
/

comment on column PRODUCTO_FABRICANTE.ID_PRODUCTO is
'Numero que identifica de forma unica el producto'
/

comment on column PRODUCTO_FABRICANTE.ID_FABRICANTE is
'Es el identificador de el fabricante'
/

/*==============================================================*/
/* Index: PRODUCTO_FABRICANTE_FK                                */
/*==============================================================*/
create index PRODUCTO_FABRICANTE_FK on PRODUCTO_FABRICANTE (
   ID_PRODUCTO ASC
)
/

/*==============================================================*/
/* Index: PRODUCTO_FABRICANTE2_FK                               */
/*==============================================================*/
create index PRODUCTO_FABRICANTE2_FK on PRODUCTO_FABRICANTE (
   ID_FABRICANTE ASC
)
/

/*==============================================================*/
/* Table: PRODUCTO_FACTURA                                      */
/*==============================================================*/
create table PRODUCTO_FACTURA  (
   ID_PRODUCTO          INTEGER                         not null,
   ID_FACTURA           INTEGER                         not null,
   CANTIDAD_VENDIDA     INTEGER,
   constraint PK_PRODUCTO_FACTURA primary key (ID_PRODUCTO, ID_FACTURA)
)
/

comment on column PRODUCTO_FACTURA.ID_PRODUCTO is
'Numero que identifica de forma unica el producto'
/

/*==============================================================*/
/* Index: PRODUCTO_FACTURA_FK                                   */
/*==============================================================*/
create index PRODUCTO_FACTURA_FK on PRODUCTO_FACTURA (
   ID_PRODUCTO ASC
)
/

/*==============================================================*/
/* Index: PRODUCTO_FACTURA2_FK                                  */
/*==============================================================*/
create index PRODUCTO_FACTURA2_FK on PRODUCTO_FACTURA (
   ID_FACTURA ASC
)
/

/*==============================================================*/
/* Table: PRODUCTO_INVENTARIO                                   */
/*==============================================================*/
create table PRODUCTO_INVENTARIO  (
   ID_PRODUCTO          INTEGER                         not null,
   ID_INVENTARIORPT     INTEGER                         not null,
   constraint PK_PRODUCTO_INVENTARIO primary key (ID_PRODUCTO, ID_INVENTARIORPT)
)
/

comment on column PRODUCTO_INVENTARIO.ID_PRODUCTO is
'Numero que identifica de forma unica el producto'
/

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO_FK                                */
/*==============================================================*/
create index PRODUCTO_INVENTARIO_FK on PRODUCTO_INVENTARIO (
   ID_PRODUCTO ASC
)
/

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO2_FK                               */
/*==============================================================*/
create index PRODUCTO_INVENTARIO2_FK on PRODUCTO_INVENTARIO (
   ID_INVENTARIORPT ASC
)
/

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR  (
   ID_PROVEEDOR         INTEGER                         not null,
   NOMBRE_PROVEEDOR     VARCHAR2(20)                    not null,
   TELEFONO_PROVEEDOR   VARCHAR2(12)                    not null,
   DIRECCION_PROVEEDOR  VARCHAR2(25)                    not null,
   constraint PK_PROVEEDOR primary key (ID_PROVEEDOR)
)
/

comment on table PROVEEDOR is
'La tablap PROVEEDOR hace referencia a la entidad que surte de productos a la farmacia. Cada PRODUCTO tendra asociado un registro de la tabla PROVEEDOR'
/

comment on column PROVEEDOR.ID_PROVEEDOR is
'Identificador de la entidad fabricante'
/

comment on column PROVEEDOR.NOMBRE_PROVEEDOR is
'Razon social de la empresa que comercializa dicho producto'
/

comment on column PROVEEDOR.TELEFONO_PROVEEDOR is
'Telefono de contacto del proveedor del producto'
/

comment on column PROVEEDOR.DIRECCION_PROVEEDOR is
'Direccion de la empresa u oficina de la empresa que comercializa el producto.'
/

/*==============================================================*/
/* Table: PROVEEDOR_TIPO_PROVEEDOR                              */
/*==============================================================*/
create table PROVEEDOR_TIPO_PROVEEDOR  (
   ID_PROVEEDOR         INTEGER                         not null,
   ID_TIPO_PROVEEDOR    INTEGER                         not null,
   constraint PK_PROVEEDOR_TIPO_PROVEEDOR primary key (ID_PROVEEDOR, ID_TIPO_PROVEEDOR)
)
/

comment on table PROVEEDOR_TIPO_PROVEEDOR is
'relaciona las entidades PROVEEDOR y TIPO-PROVEEDOR'
/

comment on column PROVEEDOR_TIPO_PROVEEDOR.ID_PROVEEDOR is
'Identificador de la entidad fabricante'
/

comment on column PROVEEDOR_TIPO_PROVEEDOR.ID_TIPO_PROVEEDOR is
'Identificador de la entidad Tipo_Proveedor
'
/

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR_FK                           */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR_FK on PROVEEDOR_TIPO_PROVEEDOR (
   ID_PROVEEDOR ASC
)
/

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR2_FK                          */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR2_FK on PROVEEDOR_TIPO_PROVEEDOR (
   ID_TIPO_PROVEEDOR ASC
)
/

/*==============================================================*/
/* Table: TIPO_PRODUCTO                                         */
/*==============================================================*/
create table TIPO_PRODUCTO  (
   ID_TIPO_PRODUCTO     INTEGER                         not null,
   TIPO                 VARCHAR2(20)                    not null,
   constraint PK_TIPO_PRODUCTO primary key (ID_TIPO_PRODUCTO)
)
/

/*==============================================================*/
/* Table: TIPO_PROVEEDOR                                        */
/*==============================================================*/
create table TIPO_PROVEEDOR  (
   ID_TIPO_PROVEEDOR    INTEGER                         not null,
   TIPO_PROVEEDOR       VARCHAR2(25)                    not null,
   constraint PK_TIPO_PROVEEDOR primary key (ID_TIPO_PROVEEDOR)
)
/

comment on table TIPO_PROVEEDOR is
'Entidad que registra los diferentes tipos de proveedor según su actividad.'
/

comment on column TIPO_PROVEEDOR.ID_TIPO_PROVEEDOR is
'Identificador de la entidad Tipo_Proveedor
'
/

comment on column TIPO_PROVEEDOR.TIPO_PROVEEDOR is
'nombre del tipo de proveedor.'
/

/*==============================================================*/
/* Table: USO_MEDICAMENTO                                       */
/*==============================================================*/
create table USO_MEDICAMENTO  (
   ID_USO_MEDICAMENTO   INTEGER                         not null,
   TIPO_USO_PRODUCTO    VARCHAR2(25)                    not null,
   constraint PK_USO_MEDICAMENTO primary key (ID_USO_MEDICAMENTO)
)
/

comment on table USO_MEDICAMENTO is
'Solo va a tener relacion con producto cuando este sea un medicamento'
/

/*==============================================================*/
/* View: VIEW_ADVICE                                            */
/*==============================================================*/
create or replace view VIEW_ADVICE as
select * from ADVICE
with read only
/

/*==============================================================*/
/* View: VIEW_BITACORA                                          */
/*==============================================================*/
create or replace view VIEW_BITACORA as
select
   *
/

 comment on table VIEW_BITACORA is
'Esta vista muestra informacion acerca de los Logs del sistema'
/

/*==============================================================*/
/* View: VIEW_CARGO                                             */
/*==============================================================*/
create or replace view VIEW_CARGO as
select
   *
/

 comment on table VIEW_CARGO is
'Esta vista muestra la información acerca de los cargos ocupables en la drogueria'
/

/*==============================================================*/
/* View: VIEW_DROGUERIA                                         */
/*==============================================================*/
create or replace view VIEW_DROGUERIA as
select
   *
/

 comment on table VIEW_DROGUERIA is
'Esta vista muestra informacion acerca de las droguerias'
/

/*==============================================================*/
/* View: VIEW_FABRICANTE                                        */
/*==============================================================*/
create or replace view VIEW_FABRICANTE as
select
   *
/

 comment on table VIEW_FABRICANTE is
'Esta vista muestra informacion acerca del Fabricante de medicamentos'
/

/*==============================================================*/
/* View: VIEW_FACTURA                                           */
/*==============================================================*/
create or replace view VIEW_FACTURA as
select
   *
/

 comment on table VIEW_FACTURA is
'Esta vista muestra informacion acerca de las facturas'
/

/*==============================================================*/
/* View: VIEW_INVENTARIORPT                                     */
/*==============================================================*/
create or replace view VIEW_INVENTARIORPT as
select
   *
/

 comment on table VIEW_INVENTARIORPT is
'Esta vista muestra informacion acerca de los inventarios'
/

/*==============================================================*/
/* View: VIEW_MEDICAMENTO                                       */
/*==============================================================*/
create or replace view VIEW_MEDICAMENTO as
select
   *
/

 comment on table VIEW_MEDICAMENTO is
'Esta vista muestra infromación acerca de los mediacamentos que se ofertan en la Drogueria'
/

/*==============================================================*/
/* View: VIEW_PEDIDO                                            */
/*==============================================================*/
create or replace view VIEW_PEDIDO as
select
   *
/

 comment on table VIEW_PEDIDO is
'Esta vista muestra informacion acerca de los pedidos'
/

/*==============================================================*/
/* View: VIEW_PEDIDO_PRODUCTO                                   */
/*==============================================================*/
create or replace view VIEW_PEDIDO_PRODUCTO as
select
   *
/

 comment on table VIEW_PEDIDO_PRODUCTO is
'Esta vista muestra informacion acerca de los pedidos de productos'
/

/*==============================================================*/
/* View: VIEW_PERSONA                                           */
/*==============================================================*/
create or replace view VIEW_PERSONA as
select
   *
/

 comment on table VIEW_PERSONA is
'Esta vista muestra las caracteristicas mas importantes relacionadas con la tabla Persona'
/

/*==============================================================*/
/* View: VIEW_PRESENTACION                                      */
/*==============================================================*/
create or replace view VIEW_PRESENTACION as
select
   *
/

 comment on table VIEW_PRESENTACION is
'Esta vista muestra informacion acerca de la presentacion de los productos'
/

/*==============================================================*/
/* View: VIEW_PRODUCTOS_DROGUERIA                               */
/*==============================================================*/
create or replace view VIEW_PRODUCTOS_DROGUERIA as
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
with read only
/

comment on column VIEW_PRODUCTOS_DROGUERIA.ID_PRODUCTO is
'Numero que identifica de forma unica el producto'
/

comment on column VIEW_PRODUCTOS_DROGUERIA.ID_PRESENTACION is
'identificador primario para esta entidad. '
/

comment on column VIEW_PRODUCTOS_DROGUERIA.ID_PROVEEDOR is
'Identificador de la entidad fabricante'
/

comment on column VIEW_PRODUCTOS_DROGUERIA.NOMBRE_PRODUCTO is
'Atributo que contiene el nombre del producto'
/

comment on column VIEW_PRODUCTOS_DROGUERIA.PRECIO_PRODUCTO is
'Atributo en el cual se especifica el precio del producto. Es de tipo Float porque puede contener decimales.'
/

comment on column VIEW_PRODUCTOS_DROGUERIA.CANTIDAD_PRODUCTO is
'Atributo en el que se especifica la cantidad del producto'
/

comment on column VIEW_PRODUCTOS_DROGUERIA.POSOLOGIA_PRODUCTO is
'Atributo en el cual se especifica la dosis recomendada del producto'
/

comment on column VIEW_PRODUCTOS_DROGUERIA.ID_DROGUERIA is
'identificador primario de esta entidad. '
/

comment on column VIEW_PRODUCTOS_DROGUERIA.NOMBRE_DROGUERIA is
'este atributo indica el nombre de la drogueria o sede de la drogueria'
/

comment on column VIEW_PRODUCTOS_DROGUERIA.TELEFONO_DROGUERIA is
'el telefono principal de contacto de la sede o drogueria'
/

comment on column VIEW_PRODUCTOS_DROGUERIA.DIRECCION_DROGUERIA is
'la direccion de la ubicacion fisica de la sede o drogueria'
/

/*==============================================================*/
/* View: VIEW_PRODUCTO_FABRICANTE                               */
/*==============================================================*/
create or replace view VIEW_PRODUCTO_FABRICANTE as
select
   *
/

 comment on table VIEW_PRODUCTO_FABRICANTE is
'Esta vista muestra informacion acerca de Fabrcinate y los productos que fabrica'
/

/*==============================================================*/
/* View: VIEW_PRODUCTO_FACTURA                                  */
/*==============================================================*/
create or replace view VIEW_PRODUCTO_FACTURA as
select
   *
/

 comment on table VIEW_PRODUCTO_FACTURA is
'Esta vista muestra informacion acerca de la factura de compra de un producto'
/

/*==============================================================*/
/* View: VIEW_PRODUCTO_INVENTARIO                               */
/*==============================================================*/
create or replace view VIEW_PRODUCTO_INVENTARIO as
select
   *
/

 comment on table VIEW_PRODUCTO_INVENTARIO is
'Esta vista muestra informacion acerca de los productos que estan en inventario'
/

/*==============================================================*/
/* View: VIEW_PROVEEDOR                                         */
/*==============================================================*/
create or replace view VIEW_PROVEEDOR as
select
   *
/

 comment on table VIEW_PROVEEDOR is
'Esta vista muestra infromación de los proveedores de productos de la empresa'
/

/*==============================================================*/
/* View: VIEW_PROVEEDOR_TIPO_PROV                               */
/*==============================================================*/
create or replace view VIEW_PROVEEDOR_TIPO_PROV as
select
   *
/

 comment on table VIEW_PROVEEDOR_TIPO_PROV is
'Esta vista muestra informacion acerca del proveedor y su tipo de distribucion'
/

/*==============================================================*/
/* View: VIEW_TIPO_PRODUCTO                                     */
/*==============================================================*/
create or replace view VIEW_TIPO_PRODUCTO as
select
   *
/

 comment on table VIEW_TIPO_PRODUCTO is
'Esta vista muestra informacion acerca de los tipos de productos'
/

/*==============================================================*/
/* View: VIEW_USO_MEDIC                                         */
/*==============================================================*/
create or replace view VIEW_USO_MEDIC as
select
   *
/

 comment on table VIEW_USO_MEDIC is
'Esta vista muestra informacion acerca del uso que tienen los diferntes medicamentos'
/

alter table FACTURA
   add constraint FK_FACTURA_FACTURA_P_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
/

alter table INVETARIORPT
   add constraint FK_INVETARI_PERSONA_I_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
/

alter table MEDICAMENTO
   add constraint FK_MEDICAME_PRESENTAC_PRESENTA foreign key (ID_PRESENTACION)
      references PRESENTACION (ID_PRESENTACION)
/

alter table MEDICAMENTO
   add constraint FK_MEDICAME_PRODUCTO__PROVEEDO foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR)
/

alter table MEDICAMENTO
   add constraint FK_MEDICAME_PRODUCTO__TIPO_PRO foreign key (ID_TIPO_PRODUCTO)
      references TIPO_PRODUCTO (ID_TIPO_PRODUCTO)
/

alter table MEDICAMENTO
   add constraint FK_MEDICAME_USO_MEDIC_USO_MEDI foreign key (ID_USO_MEDICAMENTO)
      references USO_MEDICAMENTO (ID_USO_MEDICAMENTO)
/

alter table PEDIDO
   add constraint FK_PEDIDO_PEDIDO_DR_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
/

alter table PEDIDO_PRODUCTO
   add constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PEDIDO_PRODUCTO
   add constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO)
/

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_C_CARGO foreign key (ID_CARGO)
      references CARGO (ID_CARGO)
/

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_D_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
/

alter table PRODUCTODROGUERIA
   add constraint FK_PRODUCTO_PRODUCTOD_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
/

alter table PRODUCTODROGUERIA
   add constraint FK_PRODUCTO_PRODUCTOD_MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PRODUCTO_FABRICANTE
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PRODUCTO_FABRICANTE
   add constraint FK_PRODUCTO_PRODUCTO__FABRICAN foreign key (ID_FABRICANTE)
      references FABRICANTE (ID_FABRICANTE)
/

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM2 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__FACTURA foreign key (ID_FACTURA)
      references FACTURA (ID_FACTURA)
/

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM3 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__INVETARI foreign key (ID_INVENTARIORPT)
      references INVETARIORPT (ID_INVENTARIORPT)
/

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR)
/

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO foreign key (ID_TIPO_PROVEEDOR)
      references TIPO_PROVEEDOR (ID_TIPO_PROVEEDOR)
/


create trigger TIB_BITACORA before insert
on BITACORA for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "ID_BITACORA" uses sequence SEQUENCE
    select SEQUENCE.NEXTVAL INTO :new.ID_BITACORA from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger trg_del_drog AFTER DELETE ON dbd_3.View_Drogueria
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"DELETE","DROGUERIA",USER)
/


create trigger trg_ins_drog AFTER INSERT ON dbd_3.View_Drogueria
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"INSERT","DROGUERIA",USER)
/


create trigger trg_upd_drog AFTER UPDATE ON dbd_3.View_Drogueria
begin
as
    insert into dbd_3.BITACORA(fecha,tipo__accion,tabla,usuario) values(GETDATE(),"UPDATE","DROGUERIA",USER)
/


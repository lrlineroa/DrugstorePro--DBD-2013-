/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     22/06/2013 3:51:08 p. m.                     */
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

drop trigger TRG_DEL_CARG
/

drop trigger TRG_INS_CARG
/

drop trigger TRG_UPD_CARG
/

drop trigger TRG_DEL_DROG
/

drop trigger TRG_INS_DROG
/

drop trigger TRG_UPD_DROG
/

drop trigger TRG_DEL_FAB
/

drop trigger TRG_INS_FAB
/

drop trigger TRG_UPD_FAB
/

drop trigger TRG_DEL_FACTU
/

drop trigger TRG_INS_FACTU
/

drop trigger TRG_UPD_FACTU
/

drop trigger TRG_DEL_INVENT
/

drop trigger TRG_INS_INVENT
/

drop trigger TRG_UPD_INVENT
/

drop trigger TRG_DEL_MEDIC
/

drop trigger TRG_INS_MEDIC
/

drop trigger TRG_UPD_MEDIC
/

drop trigger TRG_DEL_PED
/

drop trigger TRG_INS_PED
/

drop trigger TRG_UPD_PED
/

drop trigger TRG_DEL_PERS
/

drop trigger TRG_INS_PERS
/

drop trigger TRG_UPD_PERS
/

drop trigger TRG_DEL_PORDFAB
/

drop trigger TRG_INS_PORDFAB
/

drop trigger TRG_UPD_PORDFAB
/

drop trigger TRG_DEL_PRODFAC
/

drop trigger TRG_INS_PRODFAC
/

drop trigger TRG_UPD_PRODFAC
/

drop trigger TRG_DEL_PRODINV
/

drop trigger TRG_INS_PRODINV
/

drop trigger TRG_UPD_PRODINV
/

drop trigger TRG_DEL_PROVE
/

drop trigger TRG_INS_PROVE
/

drop trigger TRG_UPD_PROVE
/

drop trigger TRG_DEL_TIPOPROD
/

drop trigger TRG_INS_TIPOPROD
/

drop trigger TRG_UPD_TIPOPROD
/

drop trigger TRG_DEL_USOMEDIC
/

drop trigger TRG_INS_USOMEDIC
/

drop trigger TRG_UPD_USOMEDIC
/

alter table FACTURA
   drop constraint FK_FACTURA_FACTURA_P_PERSONA
/

alter table INVENTARIO_RPT
   drop constraint FK_INVENTAR_PERSONA_I_PERSONA
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
   drop constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO
/

alter table PEDIDO_PRODUCTO
   drop constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME
/

alter table PERSONA
   drop constraint FK_PERSONA_PERSONA_C_CARGO
/

alter table PERSONA
   drop constraint FK_PERSONA_PERSONA_D_DROGUERI
/

alter table PRODUCTO_DROGUERIA
   drop constraint FK_PRODUCTO_PRODUCTO__DROGUERI
/

alter table PRODUCTO_DROGUERIA
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM2
/

alter table PRODUCTO_FABRICANTE
   drop constraint FK_PRODUCTO_FABRICANT_FABRICAN
/

alter table PRODUCTO_FABRICANTE
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAME
/

alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__FACTURA
/

alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM3
/

alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__INVENTAR
/

alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM4
/

alter table PROVEEDOR_TIPO_PROVEEDOR
   drop constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO
/

alter table PROVEEDOR_TIPO_PROVEEDOR
   drop constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO
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

drop view VIEW_PRODUCTOS_VENDIDOS
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

drop table INVENTARIO_RPT cascade constraints
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

drop index PRODUCTO_DROGUERIA2_FK
/

drop index PRODUCTO_DROGUERIA_FK
/

drop table PRODUCTO_DROGUERIA cascade constraints
/

drop index PRODUCTO_FABRICANTE_FK
/

drop index FABRICANTE_PRODUCTO_FK
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

drop index PROVEEDOR_TIPO_PROVEEDOR_FK
/

drop index PROVEEDOR_TIPO_PROVEEDOR2_FK
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
   USUARIO              VARCHAR2(25),
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
   TOTAL                FLOAT(10)                       not null,
   FECHA_FACTURA        TIMESTAMP                       not null,
   constraint PK_FACTURA primary key (ID_FACTURA)
)
/

/*==============================================================*/
/* Index: FACTURA_PERSONA_FK                                    */
/*==============================================================*/
create index FACTURA_PERSONA_FK on FACTURA (
   ID_PERSONA ASC
)
/

/*==============================================================*/
/* Table: INVENTARIO_RPT                                        */
/*==============================================================*/
create table INVENTARIO_RPT  (
   ID_INVENTARIORPT     INTEGER                         not null,
   ID_PERSONA           INTEGER                         not null,
   FECHA_INV            DATE                            not null,
   constraint PK_INVENTARIO_RPT primary key (ID_INVENTARIORPT)
)
/

/*==============================================================*/
/* Index: PERSONA_INVENTARIO_FK                                 */
/*==============================================================*/
create index PERSONA_INVENTARIO_FK on INVENTARIO_RPT (
   ID_PERSONA ASC
)
/

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO  (
   ID_PRODUCTO          INTEGER                         not null,
   ID_PRESENTACION      INTEGER                         not null,
   ID_USO_MEDICAMENTO   INTEGER,
   NOMBRE_PRODUCTO      VARCHAR2(25),
   PRECIO_PRODUCTO      FLOAT(7),
   CANTIDAD_PRODUCTO    INTEGER,
   POSOLOGIA_PRODUCTO   VARCHAR2(25),
   ID_TIPO_PRODUCTO     INTEGER                         not null,
   ID_PROVEEDOR         INTEGER                         not null,
   VENTA_LIBRE          SMALLINT                        not null,
   constraint PK_MEDICAMENTO primary key (ID_PRODUCTO)
)
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
'Este atributo relacionara a la entidad PEDIDO con la entidad DROGUERIA, y señalara cual sede es la que esta realizando el pedido. Es de tipo integer porque el identificador Id_Drogueria en la entidad DROGUERIA es de este tipo.'
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
   ID_PEDIDO            INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null,
   constraint PK_PEDIDO_PRODUCTO primary key (ID_PEDIDO, ID_PRODUCTO)
)
/

comment on table PEDIDO_PRODUCTO is
'Esta entidad nacio de la relacion n-m entre PEDIDO y PRODUCTO, y guardara información en donde se relacionaran los pedidos con los productos, es decir que producto fue pedido.'
/

comment on column PEDIDO_PRODUCTO.ID_PEDIDO is
'Este atributo referenciara un pedido realizado para relacionarlo con un producto. Conserva el mismo tipo de dato del atributo Id_Pedido de la entidad PEDIDO'
/

comment on column PEDIDO_PRODUCTO.ID_PRODUCTO is
'Este atributo referenciara un producto para relacionarlo con un pedido realizado. Conserva el mismo tipo de dato del atributo Id_Producto de la entidad PRODUCTO'
/

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO_FK                                    */
/*==============================================================*/
create index PEDIDO_PRODUCTO_FK on PEDIDO_PRODUCTO (
   ID_PEDIDO ASC
)
/

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO2_FK                                   */
/*==============================================================*/
create index PEDIDO_PRODUCTO2_FK on PEDIDO_PRODUCTO (
   ID_PRODUCTO ASC
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
   NOMBRE_DE_USUARIO    VARCHAR2(15),
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
'este atributo va a guardar el número del cargo de la persona '
/

comment on column PERSONA.ID_DROGUERIA is
'Este atributo va a guardar el número de la sede en el cual tiene vinculación la persona'
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
'Esta entidad recogera la informacion de cada una de las distintas presentaciones, formas, envases o maneras de comercializar los productos. eje: gel, pildora, jarabe, etc'
/

comment on column PRESENTACION.ID_PRESENTACION is
'identificador primario para esta entidad. '
/

comment on column PRESENTACION.TIPO_PRESENTACION is
'atributo que almacenará las distintas presentaciones en las que son vendidos los productos'
/

/*==============================================================*/
/* Table: PRODUCTO_DROGUERIA                                    */
/*==============================================================*/
create table PRODUCTO_DROGUERIA  (
   ID_DROGUERIA         INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null,
   constraint PK_PRODUCTO_DROGUERIA primary key (ID_DROGUERIA, ID_PRODUCTO)
)
/

comment on table PRODUCTO_DROGUERIA is
'entidad debil resultante de la relacion n-n. '
/

comment on column PRODUCTO_DROGUERIA.ID_DROGUERIA is
'identificador heredado de la entidad DROGUERIA'
/

comment on column PRODUCTO_DROGUERIA.ID_PRODUCTO is
'identificador heredado de la entidad PRODUCTO'
/

/*==============================================================*/
/* Index: PRODUCTO_DROGUERIA_FK                                 */
/*==============================================================*/
create index PRODUCTO_DROGUERIA_FK on PRODUCTO_DROGUERIA (
   ID_DROGUERIA ASC
)
/

/*==============================================================*/
/* Index: PRODUCTO_DROGUERIA2_FK                                */
/*==============================================================*/
create index PRODUCTO_DROGUERIA2_FK on PRODUCTO_DROGUERIA (
   ID_PRODUCTO ASC
)
/

/*==============================================================*/
/* Table: PRODUCTO_FABRICANTE                                   */
/*==============================================================*/
create table PRODUCTO_FABRICANTE  (
   ID_FABRICANTE        INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null,
   constraint PK_PRODUCTO_FABRICANTE primary key (ID_FABRICANTE, ID_PRODUCTO)
)
/

comment on column PRODUCTO_FABRICANTE.ID_FABRICANTE is
'Es el identificador de el fabricante'
/

comment on column PRODUCTO_FABRICANTE.ID_PRODUCTO is
'Numero que identifica de forma unica el producto'
/

/*==============================================================*/
/* Index: FABRICANTE_PRODUCTO_FK                                */
/*==============================================================*/
create index FABRICANTE_PRODUCTO_FK on PRODUCTO_FABRICANTE (
   ID_FABRICANTE ASC
)
/

/*==============================================================*/
/* Index: PRODUCTO_FABRICANTE_FK                                */
/*==============================================================*/
create index PRODUCTO_FABRICANTE_FK on PRODUCTO_FABRICANTE (
   ID_PRODUCTO ASC
)
/

/*==============================================================*/
/* Table: PRODUCTO_FACTURA                                      */
/*==============================================================*/
create table PRODUCTO_FACTURA  (
   ID_FACTURA           INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null,
   CANTIDAD_VENDIDA     INTEGER,
   constraint PK_PRODUCTO_FACTURA primary key (ID_FACTURA, ID_PRODUCTO)
)
/

/*==============================================================*/
/* Index: PRODUCTO_FACTURA_FK                                   */
/*==============================================================*/
create index PRODUCTO_FACTURA_FK on PRODUCTO_FACTURA (
   ID_FACTURA ASC
)
/

/*==============================================================*/
/* Index: PRODUCTO_FACTURA2_FK                                  */
/*==============================================================*/
create index PRODUCTO_FACTURA2_FK on PRODUCTO_FACTURA (
   ID_PRODUCTO ASC
)
/

/*==============================================================*/
/* Table: PRODUCTO_INVENTARIO                                   */
/*==============================================================*/
create table PRODUCTO_INVENTARIO  (
   ID_INVENTARIORPT     INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null,
   constraint PK_PRODUCTO_INVENTARIO primary key (ID_INVENTARIORPT, ID_PRODUCTO)
)
/

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO_FK                                */
/*==============================================================*/
create index PRODUCTO_INVENTARIO_FK on PRODUCTO_INVENTARIO (
   ID_INVENTARIORPT ASC
)
/

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO2_FK                               */
/*==============================================================*/
create index PRODUCTO_INVENTARIO2_FK on PRODUCTO_INVENTARIO (
   ID_PRODUCTO ASC
)
/

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR  (
   ID_PROVEEDOR         INTEGER                         not null,
   NOMBRE_PROVEEDOR     VARCHAR2(20)                    not null,
   TELEFONO_PROVEEDOR   VARCHAR2(12)                    not null,
   DIRECCION_PROVEEDOR  VARCHAR2(25)                    not null
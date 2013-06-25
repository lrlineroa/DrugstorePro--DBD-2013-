F/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     22/06/2013 10:50:28 p. m.                    */
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

drop view VIEW_FACTURA_TOTAL
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

alter table ADVICE
   drop primary key cascade
/

drop table ADVICE cascade constraints
/

alter table BITACORA
   drop primary key cascade
/

drop table BITACORA cascade constraints
/

alter table CARGO
   drop primary key cascade
/

drop table CARGO cascade constraints
/

alter table DROGUERIA
   drop primary key cascade
/

drop table DROGUERIA cascade constraints
/

alter table FABRICANTE
   drop primary key cascade
/

drop table FABRICANTE cascade constraints
/

drop index FACTURA_PERSONA_FK
/

alter table FACTURA
   drop primary key cascade
/

drop table FACTURA cascade constraints
/

drop index PERSONA_INVENTARIO_FK
/

alter table INVENTARIO_RPT
   drop primary key cascade
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

alter table MEDICAMENTO
   drop primary key cascade
/

drop table MEDICAMENTO cascade constraints
/

drop index PEDIDO_DROGUERIA_FK
/

alter table PEDIDO
   drop primary key cascade
/

drop table PEDIDO cascade constraints
/

drop index PEDIDO_PRODUCTO2_FK
/

drop index PEDIDO_PRODUCTO_FK
/

alter table PEDIDO_PRODUCTO
   drop primary key cascade
/

drop table PEDIDO_PRODUCTO cascade constraints
/

drop index PERSONA_DROGUERIA_FK
/

drop index PERSONA_CARGO_FK
/

alter table PERSONA
   drop primary key cascade
/

drop table PERSONA cascade constraints
/

alter table PRESENTACION
   drop primary key cascade
/

drop table PRESENTACION cascade constraints
/

drop index PRODUCTO_DROGUERIA2_FK
/

drop index PRODUCTO_DROGUERIA_FK
/

alter table PRODUCTO_DROGUERIA
   drop primary key cascade
/

drop table PRODUCTO_DROGUERIA cascade constraints
/

drop index PRODUCTO_FABRICANTE_FK
/

drop index FABRICANTE_PRODUCTO_FK
/

alter table PRODUCTO_FABRICANTE
   drop primary key cascade
/

drop table PRODUCTO_FABRICANTE cascade constraints
/

drop index PRODUCTO_FACTURA2_FK
/

drop index PRODUCTO_FACTURA_FK
/

alter table PRODUCTO_FACTURA
   drop primary key cascade
/

drop table PRODUCTO_FACTURA cascade constraints
/

drop index PRODUCTO_INVENTARIO2_FK
/

drop index PRODUCTO_INVENTARIO_FK
/

alter table PRODUCTO_INVENTARIO
   drop primary key cascade
/

drop table PRODUCTO_INVENTARIO cascade constraints
/

alter table PROVEEDOR
   drop primary key cascade
/

drop table PROVEEDOR cascade constraints
/

drop index PROVEEDOR_TIPO_PROVEEDOR_FK
/

drop index PROVEEDOR_TIPO_PROVEEDOR2_FK
/

alter table PROVEEDOR_TIPO_PROVEEDOR
   drop primary key cascade
/

drop table PROVEEDOR_TIPO_PROVEEDOR cascade constraints
/

alter table TIPO_PRODUCTO
   drop primary key cascade
/

drop table TIPO_PRODUCTO cascade constraints
/

alter table TIPO_PROVEEDOR
   drop primary key cascade
/

drop table TIPO_PROVEEDOR cascade constraints
/

alter table USO_MEDICAMENTO
   drop primary key cascade
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
   CANT_REGISTRADA      INTEGER                         not null
)
/

comment on table ADVICE is
'ESTA TABLA CONTENDR� EL REGISTRO DE CUANDO UN MEDICAMENTO LLEGA A ESTADO CR�TICO (MENOS DE 5 UNIDADES EN EL INVENTARIO)'
/

alter table ADVICE
   add constraint PK_ADVICE primary key (ID_ADVICE)
/

/*==============================================================*/
/* Table: BITACORA                                              */
/*==============================================================*/
create table BITACORA  (
   ID_BITACORA          INTEGER                         not null,
   FECHA                DATE                            not null,
   TIPO_ACCION          CHAR(20)                        not null,
   TABLA                CHAR(50),
   USUARIO              VARCHAR2(25)
)
/

comment on table BITACORA is
'Tabla que guarda la informaci�n de las actividades que realizan los usuarios del sistema.'
/

alter table BITACORA
   add constraint PK_BITACORA primary key (ID_BITACORA)
/

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table CARGO  (
   ID_CARGO             INTEGER                         not null,
   TIPO_CARGO           VARCHAR2(15)                    not null
)
/

comment on table CARGO is
'Esta entidad va a tener los distinitos cargos en la droguer�a vendedor, administrador etc...'
/

comment on column CARGO.ID_CARGO is
'Este es el identificador de los cargos puede ser un autonum�rico'
/

comment on column CARGO.TIPO_CARGO is
'Este atributo va a guardar los tipos de cargos que hay en la droguer�a (administrador vendedor etc...'
/

alter table CARGO
   add constraint PK_CARGO primary key (ID_CARGO)
/

/*==============================================================*/
/* Table: DROGUERIA                                             */
/*==============================================================*/
create table DROGUERIA  (
   ID_DROGUERIA         INTEGER                         not null,
   NOMBRE_DROGUERIA     VARCHAR2(25)                    not null,
   TELEFONO_DROGUERIA   VARCHAR2(15)                    not null,
   DIRECCION_DROGUERIA  VARCHAR2(35)                    not null
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

alter table DROGUERIA
   add constraint PK_DROGUERIA primary key (ID_DROGUERIA)
/

/*==============================================================*/
/* Table: FABRICANTE                                            */
/*==============================================================*/
create table FABRICANTE  (
   ID_FABRICANTE        INTEGER                         not null,
   NOMBRE_FABRICANTE    VARCHAR2(20)
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

alter table FABRICANTE
   add constraint PK_FABRICANTE primary key (ID_FABRICANTE)
/

/*==============================================================*/
/* Table: FACTURA                                               */
/*==============================================================*/
create table FACTURA  (
   ID_FACTURA           INTEGER                         not null,
   ID_PERSONA           INTEGER                         not null,
   TOTAL                FLOAT(10)                       not null,
   FECHA_FACTURA        TIMESTAMP                       not null
)
/

alter table FACTURA
   add constraint PK_FACTURA primary key (ID_FACTURA)
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
   FECHA_INV            DATE                            not null
)
/

alter table INVENTARIO_RPT
   add constraint PK_INVENTARIO_RPT primary key (ID_INVENTARIORPT)
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
   VENTA_LIBRE          SMALLINT                        not null
)
/

alter table MEDICAMENTO
   add constraint PK_MEDICAMENTO primary key (ID_PRODUCTO)
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
   SOLICITUD_FINALIZADA SMALLINT                        not null
)
/

comment on table PEDIDO is
'En esta clase se va a poner todo lo que tenga que ver con los pedidos que se hagan a un proveedor.'
/

comment on column PEDIDO.ID_PEDIDO is
'Este atributo identificara a la entidad con un codigo numerico irrepetible, es tipo integer debido a que solo nos interesa el numero como identificador para lo cual no es necesario exactitud decimal.'
/

comment on column PEDIDO.ID_DROGUERIA is
'Este atributo relacionara a la entidad PEDIDO con la entidad DROGUERIA, y se�alara cual sede es la que esta realizando el pedido. Es de tipo integer porque el identificador Id_Drogueria en la entidad DROGUERIA es de este tipo.'
/

comment on column PEDIDO.FECHA_PEDIDO is
'Este atributo guarda la fecha en la que se realizo el pedido.'
/

comment on column PEDIDO.HORA_PEDIDO is
'Este atributo guarda la hora en la que se realizo el pedido.'
/

comment on column PEDIDO.NOMBRE_CLIENTE_PED is
'En este atributo se guardara el nombre y apellido del cliente. Se definio un tama�o de 35 caracteres los cuales consideramos suficientes para guardar un nombre y los apellidos. Es de tipo varchar el cual maneja mejor el espacio cuando el tama�o de las entradas varia mucho.'
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

alter table PEDIDO
   add constraint PK_PEDIDO primary key (ID_PEDIDO)
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
   ID_PRODUCTO          INTEGER                         not null
)
/

comment on table PEDIDO_PRODUCTO is
'Esta entidad nacio de la relacion n-m entre PEDIDO y PRODUCTO, y guardara informaci�n en donde se relacionaran los pedidos con los productos, es decir que producto fue pedido.'
/

comment on column PEDIDO_PRODUCTO.ID_PEDIDO is
'Este atributo referenciara un pedido realizado para relacionarlo con un producto. Conserva el mismo tipo de dato del atributo Id_Pedido de la entidad PEDIDO'
/

comment on column PEDIDO_PRODUCTO.ID_PRODUCTO is
'Este atributo referenciara un producto para relacionarlo con un pedido realizado. Conserva el mismo tipo de dato del atributo Id_Producto de la entidad PRODUCTO'
/

alter table PEDIDO_PRODUCTO
   add constraint PK_PEDIDO_PRODUCTO primary key (ID_PEDIDO, ID_PRODUCTO)
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
   TELEFONO_PERSONA     INTEGER                         not null,
   DIRECCION_PERSONA    VARCHAR2(25)                    not null,
   PASSWORD             VARCHAR2(32)                    not null,
   NOMBRE_DE_USUARIO    VARCHAR2(15)
)
/

comment on table PERSONA is
'Esta entidad va a guardar la informaci�n de la persona que tiene alguna vinculaci�n con la droguer�a, como administradores y vendedores.'
/

comment on column PERSONA.ID_PERSONA is
'Este es el n�mero de identificaci�n de la persona'
/

comment on column PERSONA.ID_CARGO is
'este atributo va a guardar el n�mero del cargo de la persona '
/

comment on column PERSONA.ID_DROGUERIA is
'Este atributo va a guardar el n�mero de la sede en el cual tiene vinculaci�n la persona'
/

comment on column PERSONA.NOMBRE_PERSONA is
'Este campo significa el nombre de la persona. (Luis, Carlos, Hernando etc...)'
/

comment on column PERSONA.APELLIDO_PERSONA is
'Este atributo es el apellido de la persona, (Martinez, Ortega, etc..)'
/

comment on column PERSONA.TELEFONO_PERSONA is
'Este atributo va a contener el tel�fono de la persona que corresponda.'
/

comment on column PERSONA.DIRECCION_PERSONA is
'Este atributo va a contener la direcci�n de vivienda de la persona.'
/

comment on column PERSONA.PASSWORD is
'Atributo que va a guardar la contrase;a de el usuario para entrar al sistema'
/

alter table PERSONA
   add constraint CKC_TELEFONO_PERSONA_PERSONA check (TELEFONO_PERSONA between 000000000 and 999999999)
/

alter table PERSONA
   add constraint PK_PERSONA primary key (ID_PERSONA)
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
   TIPO_PRESENTACION    VARCHAR2(25)                    not null
)
/

comment on table PRESENTACION is
'Esta entidad recogera la informacion de cada una de las distintas presentaciones, formas, envases o maneras de comercializar los productos. eje: gel, pildora, jarabe, etc'
/

comment on column PRESENTACION.ID_PRESENTACION is
'identificador primario para esta entidad. '
/

comment on column PRESENTACION.TIPO_PRESENTACION is
'atributo que almacenar� las distintas presentaciones en las que son vendidos los productos'
/

alter table PRESENTACION
   add constraint PK_PRESENTACION primary key (ID_PRESENTACION)
/

/*==============================================================*/
/* Table: PRODUCTO_DROGUERIA                                    */
/*==============================================================*/
create table PRODUCTO_DROGUERIA  (
   ID_DROGUERIA         INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null
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

alter table PRODUCTO_DROGUERIA
   add constraint PK_PRODUCTO_DROGUERIA primary key (ID_DROGUERIA, ID_PRODUCTO)
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
   ID_PRODUCTO          INTEGER                         not null
)
/

comment on column PRODUCTO_FABRICANTE.ID_FABRICANTE is
'Es el identificador de el fabricante'
/

comment on column PRODUCTO_FABRICANTE.ID_PRODUCTO is
'Numero que identifica de forma unica el producto'
/

alter table PRODUCTO_FABRICANTE
   add constraint PK_PRODUCTO_FABRICANTE primary key (ID_FABRICANTE, ID_PRODUCTO)
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
   CANTIDAD_VENDIDA     INTEGER
)
/

alter table PRODUCTO_FACTURA
   add constraint PK_PRODUCTO_FACTURA primary key (ID_FACTURA, ID_PRODUCTO)
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
   ID_TIPO_PROVEEDOR    INTEGER                         not null,
   ID_PROVEEDOR         INTEGER                         not null,
   constraint PK_PROVEEDOR_TIPO_PROVEEDOR primary key (ID_TIPO_PROVEEDOR, ID_PROVEEDOR)
)
/

comment on table PROVEEDOR_TIPO_PROVEEDOR is
'relaciona las entidades PROVEEDOR y TIPO-PROVEEDOR'
/

comment on column PROVEEDOR_TIPO_PROVEEDOR.ID_TIPO_PROVEEDOR is
'Identificador de Tipo Proveedor'
/

comment on column PROVEEDOR_TIPO_PROVEEDOR.ID_PROVEEDOR is
'Identificador del proveedor'
/

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR2_FK                          */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR2_FK on PROVEEDOR_TIPO_PROVEEDOR (
   ID_PROVEEDOR ASC
)
/

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR_FK                           */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR_FK on PROVEEDOR_TIPO_PROVEEDOR (
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
'Entidad que registra los diferentes tipos de proveedor seg�n su actividad.'
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
select
   *
from
    ADVICE;
	

/*==============================================================*/
/* View: VIEW_BITACORA                                          */
/*==============================================================*/
create or replace view VIEW_BITACORA as
select * from BITACORA
/

 comment on table VIEW_BITACORA is
'Esta vista muestra informacion acerca de los Logs del sistema'
/

/*==============================================================*/
/* View: VIEW_CARGO                                             */
/*==============================================================*/
create or replace view VIEW_CARGO as
select * from CARGO
/

 comment on table VIEW_CARGO is
'Esta vista muestra la informaci�n acerca de los cargos ocupables en la drogueria'
/

/*==============================================================*/
/* View: VIEW_DROGUERIA                                         */
/*==============================================================*/
create or replace view VIEW_DROGUERIA as
select * from DROGUERIA
/

 comment on table VIEW_DROGUERIA is
'Esta vista muestra informacion acerca de las droguerias'
/

/*==============================================================*/
/* View: VIEW_FABRICANTE                                        */
/*==============================================================*/
create or replace view VIEW_FABRICANTE as
select * from FABRICANTE
/

 comment on table VIEW_FABRICANTE is
'Esta vista muestra informacion acerca del Fabricante de medicamentos'
/

/*==============================================================*/
/* View: VIEW_FACTURA                                           */
/*==============================================================*/
create or replace view VIEW_FACTURA as
select * from FACTURA
/

 comment on table VIEW_FACTURA is
'Esta vista muestra informacion acerca de las facturas'
/

/*==============================================================*/
/* View: VIEW_FACTURA_TOTAL                                     */
/*==============================================================*/
create or replace view VIEW_FACTURA_TOTAL as
SELECT F.ID_FACTURA, F.FECHA_FACTURA, P.ID_PRODUCTO, P.NOMBRE_PRODUCTO, P.PRECIO_PRODUCTO, PF.CANTIDAD_VENDIDA, P.PRECIO_PRODUCTO*pf.cantidad_vendida AS TOTAL_PRODUCTO , F.TOTAL AS TOTAL_FACTURA
FROM view_factura F, view_producto_factura PF, view_medicamento P
WHERE f.id_factura = pf.id_factura AND pf.id_producto = p.id_producto
/

 comment on table VIEW_FACTURA is
'Esta vista muestra la informacion completa acerca de las facturas, asi como todos los productos que incluye.'
/

/*==============================================================*/
/* View: VIEW_INVENTARIORPT                                     */
/*==============================================================*/
create or replace view VIEW_INVENTARIORPT as
select * from INVENTARIO_RPT
/

 comment on table VIEW_INVENTARIORPT is
'Esta vista muestra informacion acerca de los inventarios'
/

/*==============================================================*/
/* View: VIEW_MEDICAMENTO                                       */
/*==============================================================*/
create or replace view VIEW_MEDICAMENTO as
select * from MEDICAMENTO
/

 comment on table VIEW_MEDICAMENTO is
'Esta vista muestra infromaci�n acerca de los mediacamentos que se ofertan en la Drogueria'
/

/*==============================================================*/
/* View: VIEW_PEDIDO                                            */
/*==============================================================*/
create or replace view VIEW_PEDIDO as
select * from PEDIDO
/

 comment on table VIEW_PEDIDO is
'Esta vista muestra informacion acerca de los pedidos'
/

/*==============================================================*/
/* View: VIEW_PEDIDO_PRODUCTO                                   */
/*==============================================================*/
create or replace view VIEW_PEDIDO_PRODUCTO as
select * from PEDIDO_PRODUCTO
/

 comment on table VIEW_PEDIDO_PRODUCTO is
'Esta vista muestra informacion acerca de los pedidos de productos'
/

/*==============================================================*/
/* View: VIEW_PERSONA                                           */
/*==============================================================*/
create or replace view VIEW_PERSONA as
select * from PERSONA
/

 comment on table VIEW_PERSONA is
'Esta vista muestra las caracteristicas mas importantes relacionadas con la tabla Persona'
/

/*==============================================================*/
/* View: VIEW_PRESENTACION                                      */
/*==============================================================*/
create or replace view VIEW_PRESENTACION as
select * from PRESENTACION
/

 comment on table VIEW_PRESENTACION is
'Esta vista muestra informacion acerca de la presentacion de los productos'
/

/*==============================================================*/
/* View: VIEW_PRODUCTO_DROGUERIA                                */
/*==============================================================*/
create or replace view VIEW_PRODUCTO_DROGUERIA as
select * from PRODUCTO_DROGUERIA
/

 comment on table VIEW_PRODUCTO_DROGUERIA is
'Esta vista muestra informacion acerca de los productos que ofrece una drogueria'
/

/*==============================================================*/
/* View: VIEW_PRODUCTO_FABRICANTE                               */
/*==============================================================*/
create or replace view VIEW_PRODUCTO_FABRICANTE as
select * from PRODUCTO_FABRICANTE
/

 comment on table VIEW_PRODUCTO_FABRICANTE is
'Esta vista muestra informacion acerca de Fabrcinate y los productos que fabrica'
/

/*==============================================================*/
/* View: VIEW_PRODUCTO_FACTURA                                  */
/*==============================================================*/
create or replace view VIEW_PRODUCTO_FACTURA as
select * from PRODUCTO_FACTURA
/

 comment on table VIEW_PRODUCTO_FACTURA is
'Esta vista muestra informacion acerca de la factura de compra de un producto'
/

/*==============================================================*/
/* View: VIEW_PRODUCTO_INVENTARIO                               */
/*==============================================================*/
create or replace view VIEW_PRODUCTO_INVENTARIO as
select * from PRODUCTO_INVENTARIO
/

 comment on table VIEW_PRODUCTO_INVENTARIO is
'Esta vista muestra informacion acerca de los productos que estan en inventario'
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
/

/*==============================================================*/
/* View: VIEW_PRODUCTOS_VENDIDOS                                */
/*==============================================================*/
create or replace view VIEW_PRODUCTOS_VENDIDOS as
select
   ID_PRODUCTO,
   count(ID_PRODUCTO) as conteo
FROM
    PRODUCTO_FACTURA   
group by
   ID_PRODUCTO
/   

/*==============================================================*/
/* View: VIEW_PROVEEDOR                                         */
/*==============================================================*/
create or replace view VIEW_PROVEEDOR as
select * from PROVEEDOR
/

 comment on table VIEW_PROVEEDOR is
'Esta vista muestra infromaci�n de los proveedores de productos de la empresa'
/

/*==============================================================*/
/* View: VIEW_PROVEEDOR_TIPO_PROV                               */
/*==============================================================*/
create or replace view VIEW_PROVEEDOR_TIPO_PROV as
select * from PROVEEDOR_TIPO_PROVEEDOR
/

 comment on table VIEW_PROVEEDOR_TIPO_PROV is
'Esta vista muestra informacion acerca del proveedor y su tipo de distribucion'
/

/*==============================================================*/
/* View: VIEW_TIPO_PRODUCTO                                     */
/*==============================================================*/
create or replace view VIEW_TIPO_PRODUCTO as
select * from TIPO_PRODUCTO
/

 comment on table VIEW_TIPO_PRODUCTO is
'Esta vista muestra informacion acerca de los tipos de productos'
/

/*==============================================================*/
/* View: VIEW_USO_MEDIC                                         */
/*==============================================================*/
create or replace view VIEW_USO_MEDIC as
select * from USO_MEDICAMENTO
/

 comment on table VIEW_USO_MEDIC is
'Esta vista muestra informacion acerca del uso que tienen los diferntes medicamentos'
/

alter table FACTURA
   add constraint FK_FACTURA_FACTURA_P_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA)
/

alter table INVENTARIO_RPT
   add constraint FK_INVENTAR_PERSONA_I_PERSONA foreign key (ID_PERSONA)
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
   add constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO)
/

alter table PEDIDO_PRODUCTO
   add constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_C_CARGO foreign key (ID_CARGO)
      references CARGO (ID_CARGO)
/

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_D_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
/

alter table PRODUCTO_DROGUERIA
   add constraint FK_PRODUCTO_PRODUCTO__DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA)
/

alter table PRODUCTO_DROGUERIA
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM2 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PRODUCTO_FABRICANTE
   add constraint FK_PRODUCTO_FABRICANT_FABRICAN foreign key (ID_FABRICANTE)
      references FABRICANTE (ID_FABRICANTE)
/

alter table PRODUCTO_FABRICANTE
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__FACTURA foreign key (ID_FACTURA)
      references FACTURA (ID_FACTURA)
/

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM3 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__INVENTAR foreign key (ID_INVENTARIORPT)
      references INVENTARIO_RPT (ID_INVENTARIORPT)
/

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM4 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO)
/

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO foreign key (ID_TIPO_PROVEEDOR)
      references TIPO_PROVEEDOR (ID_TIPO_PROVEEDOR)
/

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR)
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


create trigger trg_del_carg AFTER DELETE ON CARGO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','CARGO',USER)
end;
/


create trigger trg_ins_carg AFTER INSERT ON CARGO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','CARGO',USER);
end;
/


create trigger trg_upd_carg AFTER UPDATE ON CARGO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','CARGO',USER);
end;
/


create trigger trg_del_drog AFTER DELETE ON DROGUERIA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','DROGUERIA',USER);
end;
/


create trigger trg_ins_drog AFTER INSERT ON DROGUERIA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','DROGUERIA',USER);
end;
/


create trigger trg_upd_drog AFTER UPDATE ON DROGUERIA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','DROGUERIA',USER);
end;
/


create trigger trg_del_fab AFTER DELETE ON FABRICANTE
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','FABRICANTE',USER);
end;
/


create trigger trg_ins_fab AFTER INSERT ON FABRICANTE
begin
insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','FABRICANTE',USER);
end;
/


create trigger trg_upd_fab AFTER UPDATE ON FABRICANTE
begin
   insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','FABRICANTE',USER);
end;
/


create trigger trg_del_factu AFTER DELETE ON FACTURA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','FACTURA',USER);
    end;
/


create trigger trg_ins_factu AFTER INSERT ON FACTURA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','FACTURA',USER);
    end;
/


create trigger trg_upd_factu AFTER UPDATE ON FACTURA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','FACTURA',USER);
    end;
/


create trigger trg_del_invent AFTER DELETE ON INVENTARIO_RPT
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','INVENTARIO_RPT',USER);
    end;
/


create trigger trg_ins_invent AFTER INSERT ON INVENTARIO_RPT
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','INVENTARIO_RPT',USER);
    end;
/


create trigger trg_upd_invent AFTER UPDATE ON INVENTARIO_RPT
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','INVENTARIO_RPT',USER);
    end;
/


create trigger trg_del_medic AFTER DELETE ON MEDICAMENTO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','MEDICAMENTO',USER);
    end;
/


create trigger trg_ins_medic AFTER INSERT ON MEDICAMENTO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','MEDICAMENTO',USER);
    end;
/


create trigger trg_upd_medic AFTER UPDATE ON MEDICAMENTO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','MEDICAMENTO',USER);
    end;
/


create trigger trg_del_ped AFTER DELETE ON PEDIDO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','PEDIDO',USER);
    end;
/


create trigger trg_ins_ped AFTER INSERT ON PEDIDO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','PEDIDO',USER);
    end;
/


create trigger trg_upd_ped AFTER UPDATE ON PEDIDO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','PEDIDO',USER);
    end;
/


create trigger trg_del_pers AFTER DELETE ON PERSONA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','PERSONA',USER);
    end;
/


create trigger trg_ins_pers AFTER INSERT ON PERSONA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','PERSONA',USER);
    end;
/


create trigger upd_del_pers AFTER UPDATE ON PERSONA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','PERSONA',USER);
    end;
/


create trigger trg_del_pordFab AFTER DELETE ON PRODUCTO_FABRICANTE
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','PRODUCTO_FABRICANTE',USER);
    end;
/


create trigger trg_ins_pordFab AFTER INSERT ON PRODUCTO_FABRICANTE
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','PRODUCTO_FABRICANTE',USER);
    end;
/


create trigger trg_upd_pordFab AFTER UPDATE ON PRODUCTO_FABRICANTE
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','PRODUCTO_FABRICANTE',USER);
    end;
/


create trigger trg_del_prodFac AFTER DELETE ON PRODUCTO_FACTURA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','PRODUCTO_FACTURA',USER);
    end;
/


create trigger trg_ins_prodFac AFTER INSERT ON PRODUCTO_FACTURA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','PRODUCTO_FACTURA',USER);
    end;
/


create trigger trg_upd_prodFac AFTER UPDATE ON PRODUCTO_FACTURA
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','PRODUCTO_FACTURA',USER);
    end;
/


create trigger trg_del_prodInv AFTER DELETE ON PRODUCTO_INVENTARIO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','PRODUCTO_INVENTARIO',USER);
    end;
/


create trigger trg_ins_prodInv AFTER INSERT ON PRODUCTO_INVENTARIO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','PRODUCTO_INVENTARIO',USER);
    end;
/


create trigger trg_upd_prodInv AFTER UPDATE ON PRODUCTO_INVENTARIO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','PRODUCTO_INVENTARIO',USER);
    end;
/


create trigger trg_del_prove AFTER DELETE ON PROVEEDOR
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','PROVEEDOR',USER);
    end;
/


create trigger trg_ins_prove AFTER INSERT ON PROVEEDOR
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','PROVEEDOR',USER);
    end;
/


create trigger trg_upd_prove AFTER UPDATE ON PROVEEDOR
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','PROVEEDOR',USER);
    end;
/


create trigger trg_del_tipoProd AFTER DELETE ON TIPO_PRODUCTO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','TIPO_PRODUCTO',USER);
    end;
/


create trigger trg_ins_tipoProd AFTER INSERT ON TIPO_PRODUCTO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','TIPO_PRODUCTO',USER);
    end;
/


create trigger trg_upd_tipoProd AFTER UPDATE ON TIPO_PRODUCTO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','TIPO_PRODUCTO',USER);
    end;
/


create trigger trg_del_usoMedic AFTER DELETE ON USO_MEDICAMENTO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'DELETE','USO_MEDICAMENTO',USER);
    end;
/


create trigger trg_ins_usoMedic AFTER INSERT ON USO_MEDICAMENTO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'INSERT','USO_MEDICAMENTO',USER);
    end;
/


create trigger trg_upd_usoMedic AFTER UPDATE ON USO_MEDICAMENTO
begin
    insert into BITACORA(FECHA,TIPO_ACCION,TABLA,USUARIO) values(SYSDATE,'UPDATE','USO_MEDICAMENTO',USER);
    end;
/

 
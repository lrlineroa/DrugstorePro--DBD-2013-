/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     5/8/2013 12:01:33 AM                         */
/*==============================================================*/


alter table FACTURA
   drop constraint FK_FACTURA_FACTURA_P_PERSONA;

alter table INVETARIORPT
   drop constraint FK_INVETARI_PERSONA_I_PERSONA;

alter table LOGS
   drop constraint FK_LOGS_PERSONA_L_PERSONA;

alter table MEDICAMENTO
   drop constraint FK_MEDICAME_FABRICANT_FABRICAN;

alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRESENTAC_PRESENTA;

alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRODUCTO__PROVEEDO;

alter table MEDICAMENTO
   drop constraint FK_MEDICAME_PRODUCTO__TIPO_PRO;

alter table MEDICAMENTO
   drop constraint FK_MEDICAME_USO_MEDIC_USO_MEDI;

alter table PEDIDO
   drop constraint FK_PEDIDO_PEDIDO_DR_DROGUERI;

alter table PEDIDO_PRODUCTO
   drop constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO;

alter table PEDIDO_PRODUCTO
   drop constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME;

alter table PERSONA
   drop constraint FK_PERSONA_PERSONA_C_CARGO;

alter table PERSONA
   drop constraint FK_PERSONA_PERSONA_D_DROGUERI;

alter table PRODUCTO_DROGUERIA
   drop constraint FK_PRODUCTO_PRODUCTO__DROGUERI;

alter table PRODUCTO_DROGUERIA
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM2;

alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__FACTURA;

alter table PRODUCTO_FACTURA
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAM3;

alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__INVETARI;

alter table PRODUCTO_INVENTARIO
   drop constraint FK_PRODUCTO_PRODUCTO__MEDICAME;

alter table PROVEEDOR_TIPO_PROVEEDOR
   drop constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO;

alter table PROVEEDOR_TIPO_PROVEEDOR
   drop constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO;

drop table CARGO cascade constraints;

drop table DROGUERIA cascade constraints;

drop table FABRICANTE cascade constraints;

drop index FACTURA_PERSONA_FK;

drop table FACTURA cascade constraints;

drop index PERSONA_INVENTARIO_FK;

drop table INVETARIORPT cascade constraints;

drop index PERSONA_LOG_FK;

drop table LOGS cascade constraints;

drop index PRODUCTO_PROVEEDOR_FK;

drop index PRODUCTO_TIPO_PRODUCTO_FK;

drop index FABRICANTE_PRODUCTO_FK;

drop index PRESENTACION_PRODUCTO_FK;

drop index USO_MEDICAMENTO_PRODUCTO_FK;

drop table MEDICAMENTO cascade constraints;

drop index PEDIDO_DROGUERIA_FK;

drop table PEDIDO cascade constraints;

drop index PEDIDO_PRODUCTO2_FK;

drop index PEDIDO_PRODUCTO_FK;

drop table PEDIDO_PRODUCTO cascade constraints;

drop index PERSONA_DROGUERIA_FK;

drop index PERSONA_CARGO_FK;

drop table PERSONA cascade constraints;

drop table PRESENTACION cascade constraints;

drop index PRODUCTO_DROGUERIA2_FK;

drop index PRODUCTO_DROGUERIA_FK;

drop table PRODUCTO_DROGUERIA cascade constraints;

drop index PRODUCTO_FACTURA2_FK;

drop index PRODUCTO_FACTURA_FK;

drop table PRODUCTO_FACTURA cascade constraints;

drop index PRODUCTO_INVENTARIO2_FK;

drop index PRODUCTO_INVENTARIO_FK;

drop table PRODUCTO_INVENTARIO cascade constraints;

drop table PROVEEDOR cascade constraints;

drop index PROVEEDOR_TIPO_PROVEEDOR_FK;

drop index PROVEEDOR_TIPO_PROVEEDOR2_FK;

drop table PROVEEDOR_TIPO_PROVEEDOR cascade constraints;

drop table TIPO_PRODUCTO cascade constraints;

drop table TIPO_PROVEEDOR cascade constraints;

drop table USO_MEDICAMENTO cascade constraints;

/*==============================================================*/
/* Table: CARGO                                                 */
/*==============================================================*/
create table CARGO  (
   ID_CARGO             INTEGER                         not null,
   TIPO_CARGO           VARCHAR2(15)                    not null,
   constraint PK_CARGO primary key (ID_CARGO)
);

comment on table CARGO is
'Esta entidad va a tener los distinitos cargos en la droguería vendedor, administrador etc...';

comment on column CARGO.ID_CARGO is
'Este es el identificador de los cargos puede ser un autonumérico';

comment on column CARGO.TIPO_CARGO is
'Este atributo va a guardar los tipos de cargos que hay en la droguería (administrador vendedor etc...';

/*==============================================================*/
/* Table: DROGUERIA                                             */
/*==============================================================*/
create table DROGUERIA  (
   ID_DROGUERIA         INTEGER                         not null,
   NOMBRE_DROGUERIA     VARCHAR2(25)                    not null,
   TELEFONO_DROGUERIA   VARCHAR2(15)                    not null,
   DIRECCION_DROGUERIA  VARCHAR2(35)                    not null,
   constraint PK_DROGUERIA primary key (ID_DROGUERIA)
);

comment on table DROGUERIA is
'Esta entidad guardara informacion sobre cada una de las distintas sedes de la drogueria.';

comment on column DROGUERIA.ID_DROGUERIA is
'identificador primario de esta entidad. ';

comment on column DROGUERIA.NOMBRE_DROGUERIA is
'este atributo indica el nombre de la drogueria o sede de la drogueria';

comment on column DROGUERIA.TELEFONO_DROGUERIA is
'el telefono principal de contacto de la sede o drogueria';

comment on column DROGUERIA.DIRECCION_DROGUERIA is
'la direccion de la ubicacion fisica de la sede o drogueria';

/*==============================================================*/
/* Table: FABRICANTE                                            */
/*==============================================================*/
create table FABRICANTE  (
   ID_FABRICANTE        INTEGER                         not null,
   NOMBRE_FABRICANTE    VARCHAR2(20),
   constraint PK_FABRICANTE primary key (ID_FABRICANTE)
);

comment on table FABRICANTE is
'Esta Entidad va a guardar los diferentes fabricantes de los productos.';

comment on column FABRICANTE.ID_FABRICANTE is
'Es el identificador de el fabricante';

comment on column FABRICANTE.NOMBRE_FABRICANTE is
'Este atributo va a guardar el nombre del fabricante
';

/*==============================================================*/
/* Table: FACTURA                                               */
/*==============================================================*/
create table FACTURA  (
   ID_FACTURA           INTEGER                         not null,
   ID_PERSONA           INTEGER                         not null,
   TOTAL                FLOAT(10)                       not null,
   constraint PK_FACTURA primary key (ID_FACTURA)
);

/*==============================================================*/
/* Index: FACTURA_PERSONA_FK                                    */
/*==============================================================*/
create index FACTURA_PERSONA_FK on FACTURA (
   ID_PERSONA ASC
);

/*==============================================================*/
/* Table: INVETARIORPT                                          */
/*==============================================================*/
create table INVETARIORPT  (
   ID_INVENTARIORPT     INTEGER                         not null,
   ID_PERSONA           INTEGER                         not null,
   FECHA_INV            DATE                            not null,
   constraint PK_INVETARIORPT primary key (ID_INVENTARIORPT)
);

/*==============================================================*/
/* Index: PERSONA_INVENTARIO_FK                                 */
/*==============================================================*/
create index PERSONA_INVENTARIO_FK on INVETARIORPT (
   ID_PERSONA ASC
);

/*==============================================================*/
/* Table: LOGS                                                  */
/*==============================================================*/
create table LOGS  (
   ID_LOG               INTEGER                         not null,
   ID_PERSONA           INTEGER                         not null,
   FECHA                DATE                            not null,
   TIPO_ACCION          CHAR(20)                        not null,
   DESCRIPCION          CHAR(50),
   constraint PK_LOGS primary key (ID_LOG)
);

comment on table LOGS is
'Tabla que guarda la información de las actividades que realizan los usuarios del sistema.';

comment on column LOGS.ID_PERSONA is
'Este es el número de identificación de la persona';

/*==============================================================*/
/* Index: PERSONA_LOG_FK                                        */
/*==============================================================*/
create index PERSONA_LOG_FK on LOGS (
   ID_PERSONA ASC
);

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO  (
   ID_PRODUCTO          INTEGER                         not null,
   ID_PRESENTACION      INTEGER                         not null,
   FAB_ID_FABRICANTE    INTEGER,
   ID_USO_MEDICAMENTO   INTEGER,
   NOMBRE_PRODUCTO      VARCHAR2(25),
   PRECIO_PRODUCTO      FLOAT(7),
   CANTIDAD_PRODUCTO    INTEGER,
   POSOLOGIA_PRODUCTO   VARCHAR2(25),
   ID_TIPO_PRODUCTO     INTEGER                         not null,
   ID_PROVEEDOR         INTEGER                         not null,
   VENTA_LIBRE          SMALLINT                        not null,
   constraint PK_MEDICAMENTO primary key (ID_PRODUCTO)
);

/*==============================================================*/
/* Index: USO_MEDICAMENTO_PRODUCTO_FK                           */
/*==============================================================*/
create index USO_MEDICAMENTO_PRODUCTO_FK on MEDICAMENTO (
   ID_USO_MEDICAMENTO ASC
);

/*==============================================================*/
/* Index: PRESENTACION_PRODUCTO_FK                              */
/*==============================================================*/
create index PRESENTACION_PRODUCTO_FK on MEDICAMENTO (
   ID_PRESENTACION ASC
);

/*==============================================================*/
/* Index: FABRICANTE_PRODUCTO_FK                                */
/*==============================================================*/
create index FABRICANTE_PRODUCTO_FK on MEDICAMENTO (
   FAB_ID_FABRICANTE ASC
);

/*==============================================================*/
/* Index: PRODUCTO_TIPO_PRODUCTO_FK                             */
/*==============================================================*/
create index PRODUCTO_TIPO_PRODUCTO_FK on MEDICAMENTO (
   ID_TIPO_PRODUCTO ASC
);

/*==============================================================*/
/* Index: PRODUCTO_PROVEEDOR_FK                                 */
/*==============================================================*/
create index PRODUCTO_PROVEEDOR_FK on MEDICAMENTO (
   ID_PROVEEDOR ASC
);

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
);

comment on table PEDIDO is
'En esta clase se va a poner todo lo que tenga que ver con los pedidos que se hagan a un proveedor.';

comment on column PEDIDO.ID_PEDIDO is
'Este atributo identificara a la entidad con un codigo numerico irrepetible, es tipo integer debido a que solo nos interesa el numero como identificador para lo cual no es necesario exactitud decimal.';

comment on column PEDIDO.ID_DROGUERIA is
'Este atributo relacionara a la entidad PEDIDO con la entidad DROGUERIA, y señalara cual sede es la que esta realizando el pedido. Es de tipo integer porque el identificador Id_Drogueria en la entidad DROGUERIA es de este tipo.';

comment on column PEDIDO.FECHA_PEDIDO is
'Este atributo guarda la fecha en la que se realizo el pedido.';

comment on column PEDIDO.HORA_PEDIDO is
'Este atributo guarda la hora en la que se realizo el pedido.';

comment on column PEDIDO.NOMBRE_CLIENTE_PED is
'En este atributo se guardara el nombre y apellido del cliente. Se definio un tamaño de 35 caracteres los cuales consideramos suficientes para guardar un nombre y los apellidos. Es de tipo varchar el cual maneja mejor el espacio cuando el tamaño de las entradas varia mucho.';

comment on column PEDIDO.DIRECCION_CLIEN_PEDIDO is
'En este atributo se guardara la direccion de entrega del pedido.';

comment on column PEDIDO.TELEFONO_CLIENTE_PED is
'Se guardara un numero telefonico fijo o celular para contactar al cliente.  Es de tipo integer debido a que los numeros telefonicos no requieren parte decimal.';

comment on column PEDIDO.SOLICITUD_EN_CURSO is
'Este atributo sera verdadero solo si la solicitud esta actualmente en curso. Siempre tendra valor opuesto al atributo Solicitud_finalizada.';

comment on column PEDIDO.SOLICITUD_FINALIZADA is
'Este atributo sera verdadero solo si el pedido a sido finalizado, ya sea por que el producto se entrego o porque el pedido se cancelo. Siempre tendra valor opuesto al atributo Solicitud_en_curso.';

/*==============================================================*/
/* Index: PEDIDO_DROGUERIA_FK                                   */
/*==============================================================*/
create index PEDIDO_DROGUERIA_FK on PEDIDO (
   ID_DROGUERIA ASC
);

/*==============================================================*/
/* Table: PEDIDO_PRODUCTO                                       */
/*==============================================================*/
create table PEDIDO_PRODUCTO  (
   ID_PEDIDO            INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null,
   constraint PK_PEDIDO_PRODUCTO primary key (ID_PEDIDO, ID_PRODUCTO)
);

comment on table PEDIDO_PRODUCTO is
'Esta entidad nacio de la relacion n-m entre PEDIDO y PRODUCTO, y guardara información en donde se relacionaran los pedidos con los productos, es decir que producto fue pedido.';

comment on column PEDIDO_PRODUCTO.ID_PEDIDO is
'Este atributo referenciara un pedido realizado para relacionarlo con un producto. Conserva el mismo tipo de dato del atributo Id_Pedido de la entidad PEDIDO';

comment on column PEDIDO_PRODUCTO.ID_PRODUCTO is
'Este atributo referenciara un producto para relacionarlo con un pedido realizado. Conserva el mismo tipo de dato del atributo Id_Producto de la entidad PRODUCTO';

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO_FK                                    */
/*==============================================================*/
create index PEDIDO_PRODUCTO_FK on PEDIDO_PRODUCTO (
   ID_PEDIDO ASC
);

/*==============================================================*/
/* Index: PEDIDO_PRODUCTO2_FK                                   */
/*==============================================================*/
create index PEDIDO_PRODUCTO2_FK on PEDIDO_PRODUCTO (
   ID_PRODUCTO ASC
);

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
      constraint CKC_TELEFONO_PERSONA_PERSONA check (TELEFONO_PERSONA between 999999999 and 000000000),
   DIRECCION_PERSONA    VARCHAR2(25)                    not null,
   PASSWORD             CLOB                            not null,
   constraint PK_PERSONA primary key (ID_PERSONA)
);

comment on table PERSONA is
'Esta entidad va a guardar la información de la persona que tiene alguna vinculación con la droguería, como administradores y vendedores.';

comment on column PERSONA.ID_PERSONA is
'Este es el número de identificación de la persona';

comment on column PERSONA.ID_CARGO is
'este atributo va a guardar el número del cargo de la persona ';

comment on column PERSONA.ID_DROGUERIA is
'Este atributo va a guardar el número de la sede en el cual tiene vinculación la persona';

comment on column PERSONA.NOMBRE_PERSONA is
'Este campo significa el nombre de la persona. (Luis, Carlos, Hernando etc...)';

comment on column PERSONA.APELLIDO_PERSONA is
'Este atributo es el apellido de la persona, (Martinez, Ortega, etc..)';

comment on column PERSONA.TELEFONO_PERSONA is
'Este atributo va a contener el teléfono de la persona que corresponda.';

comment on column PERSONA.DIRECCION_PERSONA is
'Este atributo va a contener la dirección de vivienda de la persona.';

comment on column PERSONA.PASSWORD is
'Atributo que va a guardar la contrase;a de el usuario para entrar al sistema';

/*==============================================================*/
/* Index: PERSONA_CARGO_FK                                      */
/*==============================================================*/
create index PERSONA_CARGO_FK on PERSONA (
   ID_CARGO ASC
);

/*==============================================================*/
/* Index: PERSONA_DROGUERIA_FK                                  */
/*==============================================================*/
create index PERSONA_DROGUERIA_FK on PERSONA (
   ID_DROGUERIA ASC
);

/*==============================================================*/
/* Table: PRESENTACION                                          */
/*==============================================================*/
create table PRESENTACION  (
   ID_PRESENTACION      INTEGER                         not null,
   TIPO_PRESENTACION    VARCHAR2(25)                    not null,
   constraint PK_PRESENTACION primary key (ID_PRESENTACION)
);

comment on table PRESENTACION is
'esta entidad recojera la informacion de cada una de las distintas presentaciones, formas, envases o maneras de comercializar los productos. eje: gel, pildora, jarabe, etc';

comment on column PRESENTACION.ID_PRESENTACION is
'identificador primario para esta entidad. ';

comment on column PRESENTACION.TIPO_PRESENTACION is
'atributo que almacenará las distintas presentaciones en las que son vendidos los productos';

/*==============================================================*/
/* Table: PRODUCTO_DROGUERIA                                    */
/*==============================================================*/
create table PRODUCTO_DROGUERIA  (
   ID_DROGUERIA         INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null
);

comment on table PRODUCTO_DROGUERIA is
'entidad debil resultante de la relacion n-n. ';

comment on column PRODUCTO_DROGUERIA.ID_DROGUERIA is
'identificador heredado de la entidad DROGUERIA';

comment on column PRODUCTO_DROGUERIA.ID_PRODUCTO is
'identificador heredado de la entidad PRODUCTO';

/*==============================================================*/
/* Index: PRODUCTO_DROGUERIA_FK                                 */
/*==============================================================*/
create index PRODUCTO_DROGUERIA_FK on PRODUCTO_DROGUERIA (
   ID_DROGUERIA ASC
);

/*==============================================================*/
/* Index: PRODUCTO_DROGUERIA2_FK                                */
/*==============================================================*/
create index PRODUCTO_DROGUERIA2_FK on PRODUCTO_DROGUERIA (
   ID_PRODUCTO ASC
);

/*==============================================================*/
/* Table: PRODUCTO_FACTURA                                      */
/*==============================================================*/
create table PRODUCTO_FACTURA  (
   ID_FACTURA           INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null
);

/*==============================================================*/
/* Index: PRODUCTO_FACTURA_FK                                   */
/*==============================================================*/
create index PRODUCTO_FACTURA_FK on PRODUCTO_FACTURA (
   ID_FACTURA ASC
);

/*==============================================================*/
/* Index: PRODUCTO_FACTURA2_FK                                  */
/*==============================================================*/
create index PRODUCTO_FACTURA2_FK on PRODUCTO_FACTURA (
   ID_PRODUCTO ASC
);

/*==============================================================*/
/* Table: PRODUCTO_INVENTARIO                                   */
/*==============================================================*/
create table PRODUCTO_INVENTARIO  (
   ID_INVENTARIORPT     INTEGER                         not null,
   ID_PRODUCTO          INTEGER                         not null
);

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO_FK                                */
/*==============================================================*/
create index PRODUCTO_INVENTARIO_FK on PRODUCTO_INVENTARIO (
   ID_INVENTARIORPT ASC
);

/*==============================================================*/
/* Index: PRODUCTO_INVENTARIO2_FK                               */
/*==============================================================*/
create index PRODUCTO_INVENTARIO2_FK on PRODUCTO_INVENTARIO (
   ID_PRODUCTO ASC
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR  (
   ID_PROVEEDOR         INTEGER                         not null,
   NOMBRE_PROVEEDOR     VARCHAR2(20)                    not null,
   TELEFONO_PROVEEDOR   VARCHAR2(12)                    not null,
   DIRECCION_PROVEEDOR  VARCHAR2(25)                    not null,
   constraint PK_PROVEEDOR primary key (ID_PROVEEDOR)
);

comment on table PROVEEDOR is
'La tablap PROVEEDOR hace referencia a la entidad que surte de productos a la farmacia. Cada PRODUCTO tendra asociado un registro de la tabla PROVEEDOR';

comment on column PROVEEDOR.ID_PROVEEDOR is
'Identificador de la entidad fabricante';

comment on column PROVEEDOR.NOMBRE_PROVEEDOR is
'Razon social de la empresa que comercializa dicho producto';

comment on column PROVEEDOR.TELEFONO_PROVEEDOR is
'Telefono de contacto del proveedor del producto';

comment on column PROVEEDOR.DIRECCION_PROVEEDOR is
'Direccion de la empresa u oficina de la empresa que comercializa el producto.';

/*==============================================================*/
/* Table: PROVEEDOR_TIPO_PROVEEDOR                              */
/*==============================================================*/
create table PROVEEDOR_TIPO_PROVEEDOR  (
   ID_TIPO_PROVEEDOR    INTEGER                         not null,
   ID_PROVEEDOR         INTEGER                         not null,
   constraint PK_PROVEEDOR_TIPO_PROVEEDOR primary key (ID_TIPO_PROVEEDOR, ID_PROVEEDOR)
);

comment on table PROVEEDOR_TIPO_PROVEEDOR is
'relaciona las entidades PROVEEDOR y TIPO-PROVEEDOR';

comment on column PROVEEDOR_TIPO_PROVEEDOR.ID_TIPO_PROVEEDOR is
'Identificador de Tipo Proveedor';

comment on column PROVEEDOR_TIPO_PROVEEDOR.ID_PROVEEDOR is
'Identificador del proveedor';

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR2_FK                          */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR2_FK on PROVEEDOR_TIPO_PROVEEDOR (
   ID_PROVEEDOR ASC
);

/*==============================================================*/
/* Index: PROVEEDOR_TIPO_PROVEEDOR_FK                           */
/*==============================================================*/
create index PROVEEDOR_TIPO_PROVEEDOR_FK on PROVEEDOR_TIPO_PROVEEDOR (
   ID_TIPO_PROVEEDOR ASC
);

/*==============================================================*/
/* Table: TIPO_PRODUCTO                                         */
/*==============================================================*/
create table TIPO_PRODUCTO  (
   ID_TIPO_PRODUCTO     INTEGER                         not null,
   TIPO                 VARCHAR2(20)                    not null,
   constraint PK_TIPO_PRODUCTO primary key (ID_TIPO_PRODUCTO)
);

/*==============================================================*/
/* Table: TIPO_PROVEEDOR                                        */
/*==============================================================*/
create table TIPO_PROVEEDOR  (
   ID_TIPO_PROVEEDOR    INTEGER                         not null,
   TIPO_PROVEEDOR       VARCHAR2(25)                    not null,
   constraint PK_TIPO_PROVEEDOR primary key (ID_TIPO_PROVEEDOR)
);

comment on table TIPO_PROVEEDOR is
'Entidad que registra los diferentes tipos de proveedor según su actividad.';

comment on column TIPO_PROVEEDOR.ID_TIPO_PROVEEDOR is
'Identificador de la entidad Tipo_Proveedor
';

comment on column TIPO_PROVEEDOR.TIPO_PROVEEDOR is
'nombre del tipo de proveedor.';

/*==============================================================*/
/* Table: USO_MEDICAMENTO                                       */
/*==============================================================*/
create table USO_MEDICAMENTO  (
   ID_USO_MEDICAMENTO   INTEGER                         not null,
   TIPO_USO_PRODUCTO    VARCHAR2(25)                    not null,
   constraint PK_USO_MEDICAMENTO primary key (ID_USO_MEDICAMENTO)
);

comment on table USO_MEDICAMENTO is
'Solo va a tener relacion con producto cuando este sea un medicamento';

alter table FACTURA
   add constraint FK_FACTURA_FACTURA_P_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA);

alter table INVETARIORPT
   add constraint FK_INVETARI_PERSONA_I_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA);

alter table LOGS
   add constraint FK_LOGS_PERSONA_L_PERSONA foreign key (ID_PERSONA)
      references PERSONA (ID_PERSONA);

alter table MEDICAMENTO
   add constraint FK_MEDICAME_FABRICANT_FABRICAN foreign key (FAB_ID_FABRICANTE)
      references FABRICANTE (ID_FABRICANTE);

alter table MEDICAMENTO
   add constraint FK_MEDICAME_PRESENTAC_PRESENTA foreign key (ID_PRESENTACION)
      references PRESENTACION (ID_PRESENTACION);

alter table MEDICAMENTO
   add constraint FK_MEDICAME_PRODUCTO__PROVEEDO foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR);

alter table MEDICAMENTO
   add constraint FK_MEDICAME_PRODUCTO__TIPO_PRO foreign key (ID_TIPO_PRODUCTO)
      references TIPO_PRODUCTO (ID_TIPO_PRODUCTO);

alter table MEDICAMENTO
   add constraint FK_MEDICAME_USO_MEDIC_USO_MEDI foreign key (ID_USO_MEDICAMENTO)
      references USO_MEDICAMENTO (ID_USO_MEDICAMENTO);

alter table PEDIDO
   add constraint FK_PEDIDO_PEDIDO_DR_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA);

alter table PEDIDO_PRODUCTO
   add constraint FK_PEDIDO_P_PEDIDO_PR_PEDIDO foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO);

alter table PEDIDO_PRODUCTO
   add constraint FK_PEDIDO_P_PEDIDO_PR_MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO);

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_C_CARGO foreign key (ID_CARGO)
      references CARGO (ID_CARGO);

alter table PERSONA
   add constraint FK_PERSONA_PERSONA_D_DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA);

alter table PRODUCTO_DROGUERIA
   add constraint FK_PRODUCTO_PRODUCTO__DROGUERI foreign key (ID_DROGUERIA)
      references DROGUERIA (ID_DROGUERIA);

alter table PRODUCTO_DROGUERIA
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM2 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO);

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__FACTURA foreign key (ID_FACTURA)
      references FACTURA (ID_FACTURA);

alter table PRODUCTO_FACTURA
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAM3 foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO);

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__INVETARI foreign key (ID_INVENTARIORPT)
      references INVETARIORPT (ID_INVENTARIORPT);

alter table PRODUCTO_INVENTARIO
   add constraint FK_PRODUCTO_PRODUCTO__MEDICAME foreign key (ID_PRODUCTO)
      references MEDICAMENTO (ID_PRODUCTO);

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_TIPO_PRO foreign key (ID_TIPO_PROVEEDOR)
      references TIPO_PROVEEDOR (ID_TIPO_PROVEEDOR);

alter table PROVEEDOR_TIPO_PROVEEDOR
   add constraint FK_PROVEEDO_PROVEEDOR_PROVEEDO foreign key (ID_PROVEEDOR)
      references PROVEEDOR (ID_PROVEEDOR);


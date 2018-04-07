--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table XXX_GLOBAL_ACCIONES
--------------------------------------------------------

  CREATE TABLE XXX_GLOBAL_ACCIONES 
   (  ID INT NOT NULL AUTO_INCREMENT,PRIMARY KEY (ID), 
  DESCRIPCION VARCHAR(200)
   ) ;
 
--------------------------------------------------------
--  DDL for Table XXX_HIST_USUARIOS
--------------------------------------------------------

  CREATE TABLE XXX_HIST_USUARIOS 
   (  ID INT NOT NULL AUTO_INCREMENT,PRIMARY KEY (ID), 
  ID_USUARIO INT, 
  FECHA_ACCION DATE, 
  NOMBRE_USUARIO_ACCION VARCHAR(500), 
  ID_GLOBAL_ACCION INT, 
  ID_USUARIO_ACCION INT, 
  NOMBRE_USUARIO VARCHAR(500)
   ) ;
 
--------------------------------------------------------
--  DDL for Table XXX_SEG_PERMISOS
--------------------------------------------------------

  CREATE TABLE XXX_SEG_PERMISOS 
   (  ID INT NOT NULL AUTO_INCREMENT,PRIMARY KEY (ID), 
  NOMBRE VARCHAR(100), 
  DESCRIPCION VARCHAR(300), 
  PERMISO_PADRE INT
   ) ;
 
--------------------------------------------------------
--  DDL for Table XXX_SEG_ROLES
--------------------------------------------------------

  CREATE TABLE XXX_SEG_ROLES 
   (  ID INT NOT NULL AUTO_INCREMENT,PRIMARY KEY (ID), 
  NOMBRE VARCHAR(100), 
  DESCRIPCION VARCHAR(200), 
  BORRADO INT, 
  TIPO iNT
   ) ;
 

--------------------------------------------------------
--  DDL for Table XXX_SEG_ROLES_PERMISOS
--------------------------------------------------------

  CREATE TABLE XXX_SEG_ROLES_PERMISOS 
   (  ID_ROL INT, 
  ID_PERMISO INT
   ) ;
 

--------------------------------------------------------
--  DDL for Table XXX_SEG_USUARIOS
--------------------------------------------------------

  CREATE TABLE XXX_SEG_USUARIOS 
   (  ID INT NOT NULL AUTO_INCREMENT,PRIMARY KEY (ID), 
  NOMBRE VARCHAR(120), 
  LOGIN VARCHAR(20), 
  PASSWORD VARCHAR(64), 
  BORRADO INT, 
  CODIDIOMA INT, 
  EMAIL VARCHAR(200), 
  ACTUALIZADO iNT, 
  OCULTO iNT
   ) ;

--------------------------------------------------------
--  DDL for Table XXX_SEG_USUARIOS_ROLES
--------------------------------------------------------

  CREATE TABLE XXX_SEG_USUARIOS_ROLES 
   (  ID_USUARIO INT, 
	  ID_ROL INT
   ) ;
 
 

Insert into XXX_GLOBAL_ACCIONES (ID,DESCRIPCION) values ('1','CREAR');
Insert into XXX_GLOBAL_ACCIONES (ID,DESCRIPCION) values ('2','ELIMINAR');
Insert into XXX_GLOBAL_ACCIONES (ID,DESCRIPCION) values ('3','MODIFICAR');

Insert into XXX_SEG_PERMISOS (ID,NOMBRE,DESCRIPCION,PERMISO_PADRE) values ('2','Adminsitración','Administración','1');
Insert into XXX_SEG_PERMISOS (ID,NOMBRE,DESCRIPCION,PERMISO_PADRE) values ('3','Administración Roles','Administración de Roles','2');
Insert into XXX_SEG_PERMISOS (ID,NOMBRE,DESCRIPCION,PERMISO_PADRE) values ('1','Superadministrador','Superadministrador',null);

Insert into XXX_SEG_ROLES (ID,NOMBRE,DESCRIPCION,BORRADO,TIPO) values ('1','ROL_ANONIMO','Rol que tendrán los usuarios por defecto','0','1');
Insert into XXX_SEG_ROLES (ID,NOMBRE,DESCRIPCION,BORRADO,TIPO) values ('3','ROL_INICIO','Da permiso a mostrar el Menu inicio','0','1');
Insert into XXX_SEG_ROLES (ID,NOMBRE,DESCRIPCION,BORRADO,TIPO) values ('2','ROL_SUPERADMIN','Superadministrador','0','1');

Insert into XXX_SEG_ROLES_PERMISOS (ID_ROL,ID_PERMISO) values ('2','1');

Insert into XXX_SEG_USUARIOS (ID,NOMBRE,LOGIN,PASSWORD,BORRADO,CODIDIOMA,EMAIL,ACTUALIZADO,OCULTO) values ('1','Administrador','admin','21232f297a57a5a743894a0e4a801fc3','0','1','admin@xxxx.xx','1','0');

Insert into XXX_SEG_USUARIOS_ROLES (ID_USUARIO,ID_ROL) values ('1','1');
Insert into XXX_SEG_USUARIOS_ROLES (ID_USUARIO,ID_ROL) values ('1','2');
Insert into XXX_SEG_USUARIOS_ROLES (ID_USUARIO,ID_ROL) values ('1','3');
commit;
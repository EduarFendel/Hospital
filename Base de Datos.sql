--
-- ER/Studio 8.0 SQL Code Generation
-- Company :      admin
-- Project :      hospital.dm1
-- Author :       Admin
--
-- Date Created : Sunday, May 31, 2015 00:51:03
-- Target DBMS : Oracle 11g
--

-- 
-- TABLE: ALERGIA 
--

CREATE TABLE ALERGIA(
    codigo_alergia    CHAR(10)    NOT NULL,
    nombre_alergia    CHAR(30),
    CONSTRAINT PK33 PRIMARY KEY (codigo_alergia)
)
;



-- 
-- TABLE: ALERGIA_PACIENTE 
--

CREATE TABLE ALERGIA_PACIENTE(
    codigo_alergia_paciente    CHAR(10)    NOT NULL,
    codigo_paciente            CHAR(10),
    codigo_alergia             CHAR(10),
    CONSTRAINT PK34 PRIMARY KEY (codigo_alergia_paciente)
)
;



-- 
-- TABLE: CITA 
--

CREATE TABLE CITA(
    codigo_cita        CHAR(10)        NOT NULL,
    dia                NUMBER(5, 0),
    mes                NUMBER(5, 0),
    ano                NUMBER(5, 0),
    codigo_paciente    CHAR(10),
    CONSTRAINT PK28 PRIMARY KEY (codigo_cita)
)
;



-- 
-- TABLE: CONSULTA 
--

CREATE TABLE CONSULTA(
    codigo_consulta    CHAR(10)     NOT NULL,
    descipcion         CHAR(140),
    codigo_paciente    CHAR(10)     NOT NULL,
    codigo_cita        CHAR(10),
    CONSTRAINT PK5 PRIMARY KEY (codigo_consulta)
)
;



-- 
-- TABLE: EMPLEADO 
--

CREATE TABLE EMPLEADO(
    codigo_empleado     CHAR(10)    NOT NULL,
    nombre_usuario      CHAR(25),
    password            CHAR(25),
    codigo_persona      CHAR(10)    NOT NULL,
    codigo_profesion    CHAR(10),
    CONSTRAINT PK2 PRIMARY KEY (codigo_empleado)
)
;



-- 
-- TABLE: HABITACION 
--

CREATE TABLE HABITACION(
    codigo_habitacion    CHAR(10)    NOT NULL,
    habitacion           CHAR(10),
    cama                 CHAR(10),
    esatdo               CHAR(10),
    CONSTRAINT PK11 PRIMARY KEY (codigo_habitacion)
)
;



-- 
-- TABLE: INFORMACION_ADICIONAL 
--

CREATE TABLE INFORMACION_ADICIONAL(
    codigo_referencia    CHAR(10)    NOT NULL,
    email                CHAR(25),
    telefono             CHAR(10),
    codigo_persona       CHAR(10),
    CONSTRAINT PK29 PRIMARY KEY (codigo_referencia)
)
;



-- 
-- TABLE: INFORME_PACIENTE 
--

CREATE TABLE INFORME_PACIENTE(
    codigo_informe       CHAR(10)        NOT NULL,
    dia                  NUMBER(5, 0),
    mes                  NUMBER(5, 0),
    ano                  NUMBER(5, 0),
    codigo_consulta      CHAR(10),
    codigo_habitacion    CHAR(10),
    codigo_paciente      CHAR(10),
    CONSTRAINT PK16 PRIMARY KEY (codigo_informe)
)
;



-- 
-- TABLE: INVENTARIO 
--

CREATE TABLE INVENTARIO(
    codigo_inventario       CHAR(10)         NOT NULL,
    nombre                  CHAR(50),
    cantidad                NUMBER(10, 0),
    dia                     NUMBER(5, 0),
    mes                     NUMBER(5, 0),
    ano                     NUMBER(5, 0),
    codigo_tipo_medicina    CHAR(10),
    codigo_presentacion     CHAR(10),
    CONSTRAINT PK8 PRIMARY KEY (codigo_inventario)
)
;



-- 
-- TABLE: PACIENTE 
--

CREATE TABLE PACIENTE(
    codigo_paciente    CHAR(10)     NOT NULL,
    altura             CHAR(10),
    peso               CHAR(10),
    ocupacion          CHAR(140),
    grupo_sanguineo    CHAR(25),
    codigo_persona     CHAR(10)     NOT NULL,
    CONSTRAINT PK4 PRIMARY KEY (codigo_paciente)
)
;



-- 
-- TABLE: PADECIMIENTO 
--

CREATE TABLE PADECIMIENTO(
    codigo_padecimiento    CHAR(10)    NOT NULL,
    nombre_padecimiento    CHAR(25),
    CONSTRAINT PK30 PRIMARY KEY (codigo_padecimiento)
)
;



-- 
-- TABLE: PADECIMIENTO_PACIENTE 
--

CREATE TABLE PADECIMIENTO_PACIENTE(
    codigo_paciente_padecimiento    CHAR(10)    NOT NULL,
    codigo_padecimiento             CHAR(10),
    codigo_paciente                 CHAR(10),
    CONSTRAINT PK31 PRIMARY KEY (codigo_paciente_padecimiento)
)
;



-- 
-- TABLE: PERSONA 
--

CREATE TABLE PERSONA(
    codigo_persona      CHAR(10)         NOT NULL,
    nombre              CHAR(30),
    segundo_nombre      CHAR(30),
    primer_apellido     CHAR(30),
    segundo_apellido    CHAR(30),
    sexo                CHAR(10),
    edad                NUMBER(10, 0),
    dpi                 CHAR(20),
    direccion           CHAR(50),
    CONSTRAINT PK1 PRIMARY KEY (codigo_persona)
)
;



-- 
-- TABLE: PRESENTACION 
--

CREATE TABLE PRESENTACION(
    codigo_presentacion    CHAR(10)    NOT NULL,
    nombre_presentacion    CHAR(30),
    CONSTRAINT PK36 PRIMARY KEY (codigo_presentacion)
)
;



-- 
-- TABLE: PROFESION 
--

CREATE TABLE PROFESION(
    codigo_profesion    CHAR(10)    NOT NULL,
    nombre              CHAR(50),
    CONSTRAINT PK3 PRIMARY KEY (codigo_profesion)
)
;



-- 
-- TABLE: REFERENCIA 
--

CREATE TABLE REFERENCIA(
    codigo_referencia    CHAR(50)    NOT NULL,
    primer_nombre        CHAR(50),
    segundo_nombre       CHAR(50),
    primer_apellido      CHAR(50),
    segundo_apellido     CHAR(50),
    sexo                 CHAR(50),
    edad                 CHAR(10),
    direccion            CHAR(50),
    dpi                  CHAR(50),
    telefono             CHAR(50),
    email                CHAR(50),
    codigo_paciente      CHAR(10),
    CONSTRAINT PK32 PRIMARY KEY (codigo_referencia)
)
;



-- 
-- TABLE: SERVICIO 
--

CREATE TABLE SERVICIO(
    codigo_servicio    CHAR(10)         NOT NULL,
    nombre             CHAR(40),
    precio             NUMBER(10, 2),
    CONSTRAINT PK6 PRIMARY KEY (codigo_servicio)
)
;



-- 
-- TABLE: SERVICIO_EMPLEADOS 
--

CREATE TABLE SERVICIO_EMPLEADOS(
    codigo_empleado_servicio    CHAR(10),
    codigo_informe              CHAR(10),
    codigo_empleado             CHAR(10)
)
;



-- 
-- TABLE: SERVICIO_PACIENTE 
--

CREATE TABLE SERVICIO_PACIENTE(
    correlativo_servicio      CHAR(10)        NOT NULL,
    codigo_master_servicio    CHAR(10),
    dia                       NUMBER(5, 0),
    mes                       NUMBER(5, 0),
    ano                       NUMBER(5, 0),
    codigo_servicio           CHAR(10)        NOT NULL,
    codigo_informe            CHAR(10)        NOT NULL,
    CONSTRAINT PK23 PRIMARY KEY (correlativo_servicio)
)
;



-- 
-- TABLE: SUPLEMENTOS_PACIENTE 
--

CREATE TABLE SUPLEMENTOS_PACIENTE(
    correlativo          CHAR(10)        NOT NULL,
    codigo_sup           CHAR(10),
    dia                  NUMBER(5, 0),
    mes                  NUMBER(5, 0),
    ano                  NUMBER(5, 0),
    codigo_informe       CHAR(10)        NOT NULL,
    codigo_inventario    CHAR(10)        NOT NULL,
    CONSTRAINT PK14 PRIMARY KEY (correlativo)
)
;



-- 
-- TABLE: TIPO_MEDICINA 
--

CREATE TABLE TIPO_MEDICINA(
    codigo_tipo_medicina    CHAR(10)    NOT NULL,
    tipo_medicina           CHAR(30),
    CONSTRAINT PK35 PRIMARY KEY (codigo_tipo_medicina)
)
;



-- 
-- TABLE: ALERGIA_PACIENTE 
--

ALTER TABLE ALERGIA_PACIENTE ADD CONSTRAINT RefPACIENTE47 
    FOREIGN KEY (codigo_paciente)
    REFERENCES PACIENTE(codigo_paciente)
;

ALTER TABLE ALERGIA_PACIENTE ADD CONSTRAINT RefALERGIA48 
    FOREIGN KEY (codigo_alergia)
    REFERENCES ALERGIA(codigo_alergia)
;


-- 
-- TABLE: CITA 
--

ALTER TABLE CITA ADD CONSTRAINT RefPACIENTE40 
    FOREIGN KEY (codigo_paciente)
    REFERENCES PACIENTE(codigo_paciente)
;


-- 
-- TABLE: CONSULTA 
--

ALTER TABLE CONSULTA ADD CONSTRAINT RefPACIENTE11 
    FOREIGN KEY (codigo_paciente)
    REFERENCES PACIENTE(codigo_paciente)
;

ALTER TABLE CONSULTA ADD CONSTRAINT RefCITA39 
    FOREIGN KEY (codigo_cita)
    REFERENCES CITA(codigo_cita)
;


-- 
-- TABLE: EMPLEADO 
--

ALTER TABLE EMPLEADO ADD CONSTRAINT RefPERSONA1 
    FOREIGN KEY (codigo_persona)
    REFERENCES PERSONA(codigo_persona)
;

ALTER TABLE EMPLEADO ADD CONSTRAINT RefPROFESION4 
    FOREIGN KEY (codigo_profesion)
    REFERENCES PROFESION(codigo_profesion)
;


-- 
-- TABLE: INFORMACION_ADICIONAL 
--

ALTER TABLE INFORMACION_ADICIONAL ADD CONSTRAINT RefPERSONA42 
    FOREIGN KEY (codigo_persona)
    REFERENCES PERSONA(codigo_persona)
;


-- 
-- TABLE: INFORME_PACIENTE 
--

ALTER TABLE INFORME_PACIENTE ADD CONSTRAINT RefPACIENTE49 
    FOREIGN KEY (codigo_paciente)
    REFERENCES PACIENTE(codigo_paciente)
;

ALTER TABLE INFORME_PACIENTE ADD CONSTRAINT RefCONSULTA12 
    FOREIGN KEY (codigo_consulta)
    REFERENCES CONSULTA(codigo_consulta)
;

ALTER TABLE INFORME_PACIENTE ADD CONSTRAINT RefHABITACION38 
    FOREIGN KEY (codigo_habitacion)
    REFERENCES HABITACION(codigo_habitacion)
;


-- 
-- TABLE: INVENTARIO 
--

ALTER TABLE INVENTARIO ADD CONSTRAINT RefTIPO_MEDICINA50 
    FOREIGN KEY (codigo_tipo_medicina)
    REFERENCES TIPO_MEDICINA(codigo_tipo_medicina)
;

ALTER TABLE INVENTARIO ADD CONSTRAINT RefPRESENTACION51 
    FOREIGN KEY (codigo_presentacion)
    REFERENCES PRESENTACION(codigo_presentacion)
;


-- 
-- TABLE: PACIENTE 
--

ALTER TABLE PACIENTE ADD CONSTRAINT RefPERSONA2 
    FOREIGN KEY (codigo_persona)
    REFERENCES PERSONA(codigo_persona)
;


-- 
-- TABLE: PADECIMIENTO_PACIENTE 
--

ALTER TABLE PADECIMIENTO_PACIENTE ADD CONSTRAINT RefPADECIMIENTO43 
    FOREIGN KEY (codigo_padecimiento)
    REFERENCES PADECIMIENTO(codigo_padecimiento)
;

ALTER TABLE PADECIMIENTO_PACIENTE ADD CONSTRAINT RefPACIENTE44 
    FOREIGN KEY (codigo_paciente)
    REFERENCES PACIENTE(codigo_paciente)
;


-- 
-- TABLE: REFERENCIA 
--

ALTER TABLE REFERENCIA ADD CONSTRAINT RefPACIENTE46 
    FOREIGN KEY (codigo_paciente)
    REFERENCES PACIENTE(codigo_paciente)
;


-- 
-- TABLE: SERVICIO_EMPLEADOS 
--

ALTER TABLE SERVICIO_EMPLEADOS ADD CONSTRAINT RefINFORME_PACIENTE54 
    FOREIGN KEY (codigo_informe)
    REFERENCES INFORME_PACIENTE(codigo_informe)
;

ALTER TABLE SERVICIO_EMPLEADOS ADD CONSTRAINT RefEMPLEADO55 
    FOREIGN KEY (codigo_empleado)
    REFERENCES EMPLEADO(codigo_empleado)
;


-- 
-- TABLE: SERVICIO_PACIENTE 
--

ALTER TABLE SERVICIO_PACIENTE ADD CONSTRAINT RefSERVICIO18 
    FOREIGN KEY (codigo_servicio)
    REFERENCES SERVICIO(codigo_servicio)
;

ALTER TABLE SERVICIO_PACIENTE ADD CONSTRAINT RefINFORME_PACIENTE20 
    FOREIGN KEY (codigo_informe)
    REFERENCES INFORME_PACIENTE(codigo_informe)
;


-- 
-- TABLE: SUPLEMENTOS_PACIENTE 
--

ALTER TABLE SUPLEMENTOS_PACIENTE ADD CONSTRAINT RefINFORME_PACIENTE23 
    FOREIGN KEY (codigo_informe)
    REFERENCES INFORME_PACIENTE(codigo_informe)
;

ALTER TABLE SUPLEMENTOS_PACIENTE ADD CONSTRAINT RefINVENTARIO24 
    FOREIGN KEY (codigo_inventario)
    REFERENCES INVENTARIO(codigo_inventario)
;



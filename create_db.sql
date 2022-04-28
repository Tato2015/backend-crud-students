--
-- PostgreSQL database dump
--
CREATE DATABASE "studentsdb" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Peru.1252';

--
-- TABLES
--

CREATE TABLE "public"."catalogs" (
    "code" integer NOT NULL,
    "origin_code" integer,
    "parent_code" integer,
    "description" character varying(500),
    "short_description" character varying(500)
);

CREATE TABLE "public"."students" (
    "student_id" integer NOT NULL,
    "name" character varying(100) NOT NULL,
    "last_name" character varying(100) NOT NULL,
    "birthday" "date" NOT NULL,
    "id_number" integer NOT NULL,
    "email" character varying(100) NOT NULL,
    "gender" smallint NOT NULL,
    "phone_1" integer,
    "phone_2" integer,
    "phone_reference" integer,
    "marital_status" smallint,
    "address" character varying(100) NOT NULL,
    "country" smallint NOT NULL,
    "city" smallint NOT NULL,
    "postal_code" character varying(100),
    "other" character varying(100)
);


--
-- SEQUENCE
--

CREATE SEQUENCE "public"."students_student_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- INSERTS
--

INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (3, 1, NULL, 'PERU', 'PER');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (4, 1, NULL, 'ARGENTINA', 'ARG');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (5, 1, NULL, 'BRASIL', 'BRA');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (6, 1, NULL, 'ECUADOR', 'ECU');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (7, 1, NULL, 'COLOMBIA', 'COL');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (8, 2, 3, 'LIMA', 'LIM');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (9, 2, 3, 'ICA', 'ICA');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (10, 2, 3, 'AREQUIPA', 'ARE');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (1, NULL, NULL, 'COUNTRY', 'PAIS');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (2, NULL, NULL, 'CITY', 'CIUDAD');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (11, NULL, NULL, 'MARITAL STATUS', 'MARISTAT');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (12, 11, NULL, 'MARRIED', 'MARR');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (13, 11, NULL, 'WIDOWED', 'WIDO');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (14, 11, NULL, 'SEPARATED', 'SEPA');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (15, 11, NULL, 'DIVORCED', 'DIVO');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (16, 11, NULL, 'SINGLE', 'SINGLE');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (17, NULL, NULL, 'GENDER', 'GEND');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (18, 17, NULL, 'MALE', 'MALE');
INSERT INTO "public"."catalogs" ("code", "origin_code", "parent_code", "description", "short_description") VALUES (19, 17, NULL, 'FEMALE', 'FEMA');


INSERT INTO "public"."students" ("student_id", "name", "last_name", "birthday", "id_number", "email", "gender", "phone_1", "phone_2", "phone_reference", "marital_status", "address", "country", "city", "postal_code", "other") VALUES (1, 'Geraldo', 'Achuy Molina', '1992-08-06', 70817849, 'geraldo602012@gmail.com', 18, 987654321, 0, 0, 16, 'JR ZORRITOS', 3, 8, 'XXX', '-');
INSERT INTO "public"."students" ("student_id", "name", "last_name", "birthday", "id_number", "email", "gender", "phone_1", "phone_2", "phone_reference", "marital_status", "address", "country", "city", "postal_code", "other") VALUES (2, 'Edson', 'Achuy Molina', '1995-05-15', 70817850, 'edsonachuy@gmail.com', 18, 917344214, 0, 0, 16, 'JR ZORRITOS', 3, 9, 'XXX', '-');


--
-- SET VAL SEQUENCE
--

SELECT pg_catalog.setval('"public"."students_student_id_seq"', 1, false);


--
-- PRIMARY KEY
--

ALTER TABLE ONLY "public"."catalogs"
    ADD CONSTRAINT "catalogs_pkey" PRIMARY KEY ("code");

ALTER TABLE ONLY "public"."students"
    ADD CONSTRAINT "students_pkey" PRIMARY KEY ("student_id");


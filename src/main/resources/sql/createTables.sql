DROP TABLE DEPARTMENTS_LECTORS;
DROP TABLE DEPARTMENT;
DROP TABLE LECTOR;

create table if not exists DEPARTMENT (
    id integer UNIQUE GENERATED ALWAYS AS IDENTITY,
    department_name varchar(150) NOT NULL,
    head_of_department varchar(150) NOT NULL
);

create table if not exists LECTOR (
    id integer UNIQUE GENERATED ALWAYS AS IDENTITY ,
    first_name varchar(100) NOT NULL ,
    second_name varchar(100) NOT NULL ,
    father_name varchar(100),
    lector_degree varchar(50) NOT NULL ,
    salary integer NOT NULL
);

create table if not exists DEPARTMENTS_LECTORS (
    id integer UNIQUE GENERATED ALWAYS AS IDENTITY ,
    department_id integer NOT NULL ,
    lector_id integer NOT NULL ,
    CONSTRAINT fk_departments
        FOREIGN KEY(department_id)
            REFERENCES DEPARTMENT(id)
            ON DELETE CASCADE ,
    CONSTRAINT fk_lectors
        FOREIGN KEY(lector_id)
            REFERENCES LECTOR(id)
            ON DELETE CASCADE
);
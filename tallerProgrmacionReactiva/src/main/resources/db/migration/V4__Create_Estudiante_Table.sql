create table estudiante(
    id SERIAL,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo VARCHAR(100),
    constraint estudiante_pk primary key (id)
);
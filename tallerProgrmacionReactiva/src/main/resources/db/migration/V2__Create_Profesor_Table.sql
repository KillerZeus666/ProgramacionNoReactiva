create table profesor(
    id SERIAL,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    correo VARCHAR(100),
    constraint profesor_pk primary key (id)
);
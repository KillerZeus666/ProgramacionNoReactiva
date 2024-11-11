CREATE TABLE curso (
    codigo VARCHAR(50),
    materiaId INTEGER,
    profesorId INTEGER,
    fechaInicio DATE,
    fechaFin DATE,
    CONSTRAINT curso_pk PRIMARY KEY (codigo),
    CONSTRAINT fk_materia FOREIGN KEY (materiaId) REFERENCES materia(id),
    CONSTRAINT fk_profesor FOREIGN KEY (profesorId) REFERENCES profesor(id)
);

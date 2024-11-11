create table nota(
    id SERIAL,
    materiaId INTEGER,
    profesorId INTEGER,
    cursoCodigo VARCHAR(50),
    estudianteId INTEGER,
    observacion VARCHAR(50),
    valor NUMERIC(3,2),
    porcentaje NUMERIC(4,2),
    constraint nota_pk primary key (id),
    CONSTRAINT fk_materia FOREIGN KEY (materiaId) REFERENCES materia(id),
    CONSTRAINT fk_profesor FOREIGN KEY (profesorId) REFERENCES profesor(id),
    CONSTRAINT fk_curso FOREIGN KEY (cursoCodigo) REFERENCES curso(codigo),
    CONSTRAINT fk_estudiante FOREIGN KEY (estudianteId) REFERENCES estudiante(id)
);

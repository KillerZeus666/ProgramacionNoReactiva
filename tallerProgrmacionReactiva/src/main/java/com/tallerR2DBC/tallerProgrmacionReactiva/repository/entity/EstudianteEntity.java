package com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("estudiante")
public class EstudianteEntity {
    @Id
    Integer id;

    String nombre;

    String apellido;

    String correo;
}

package com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("materia")
public class MateriaEntity {

    @Id
    Integer id;

    String nombre;

    Integer creditos;
}

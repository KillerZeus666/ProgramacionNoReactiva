package com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@Table("curso")
public class CursoEntity {

    @Id
    String codigo;

    Integer materiaid;

    Integer profesorid;

    LocalDate fechainicio;

    LocalDate fechafin;
}

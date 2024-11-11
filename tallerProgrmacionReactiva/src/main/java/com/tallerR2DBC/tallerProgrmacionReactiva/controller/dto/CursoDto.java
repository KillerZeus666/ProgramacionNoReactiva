package com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto;
import java.time.LocalDate;

public record CursoDto(Integer materiaid, Integer profesorid, String codigo, LocalDate fechainicio, LocalDate fechafin) {
}

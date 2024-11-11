package com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto;

public record NotaDto(Integer id, Integer materiaid, Integer profesorid, String cursocodigo, Integer estudianteid, String observacion, Double valor, Double porcentaje) {
}

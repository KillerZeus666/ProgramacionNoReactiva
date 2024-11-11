package com.tallerR2DBC.tallerProgrmacionReactiva.service;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.EstudianteDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.ProfesorDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EstudianteService {
    Mono<EstudianteDto> getEstudiante(Integer estudianteId);
    Mono<EstudianteDto> createEstudiante(EstudianteDto estudianteDto);
    Mono<EstudianteDto> updateEstudiante(Integer estudianteId, EstudianteDto estudianteDto);
    Mono<Void> deleteEstudiante(Integer estudianteId);
    Flux<EstudianteDto> getAllEstudiantes();
}

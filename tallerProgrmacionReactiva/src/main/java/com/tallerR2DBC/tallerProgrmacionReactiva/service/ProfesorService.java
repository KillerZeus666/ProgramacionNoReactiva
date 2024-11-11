package com.tallerR2DBC.tallerProgrmacionReactiva.service;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.ProfesorDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProfesorService {
    Mono<ProfesorDto> getProfesor(Integer profesorId);
    Mono<ProfesorDto> createProfesor(ProfesorDto profesorDto);
    Mono<ProfesorDto> updateProfesor(Integer profesorId, ProfesorDto profesorDto);
    Mono<Void> deleteProfesor(Integer profesorId);
    Flux<ProfesorDto> getAllProfesor();
}

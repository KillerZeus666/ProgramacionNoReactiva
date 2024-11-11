package com.tallerR2DBC.tallerProgrmacionReactiva.service;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.CursoDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CursoService {
    Mono<CursoDto> getCurso(String codigo);
    Mono<CursoDto> createCurso(CursoDto cursoDto);
    Mono<CursoDto> updateCurso(String codigo, CursoDto cursoDto);
    Mono<Void> deleteCurso(String codigo);
    Flux<CursoDto> getAllCursos();
}

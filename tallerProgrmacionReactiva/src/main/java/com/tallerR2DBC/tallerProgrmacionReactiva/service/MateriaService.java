package com.tallerR2DBC.tallerProgrmacionReactiva.service;

import  com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.MateriaDto;
import reactor.core.publisher.Flux;
import  reactor.core.publisher.Mono;
public interface MateriaService {
    Mono<MateriaDto> getMateria(Integer materiaId);
    Mono<MateriaDto> createMateria(MateriaDto materiaDto);
    Mono<MateriaDto> updateMateria(Integer materiaId, MateriaDto materiaDto);
    Mono<Void> deleteMateria(Integer materiaId);
    Flux<MateriaDto> getAllMaterias();

}

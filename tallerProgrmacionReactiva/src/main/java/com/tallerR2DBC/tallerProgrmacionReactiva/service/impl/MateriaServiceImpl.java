package com.tallerR2DBC.tallerProgrmacionReactiva.service.impl;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.MateriaDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.MateriaRepository;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.MateriaEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.MateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;
    @Override
    public Mono<MateriaDto> getMateria(Integer materiaId) {
        return materiaRepository.findById(materiaId)
                .map(materiaEntity -> new MateriaDto(materiaEntity.getId(), materiaEntity.getNombre(), materiaEntity.getCreditos()));
    }

    @Override
    public Mono<MateriaDto> createMateria(MateriaDto materiaDto) {
        return materiaRepository.save(MateriaEntity.builder()
                        .nombre(materiaDto.nombre())
                        .creditos(materiaDto.creditos())
                        .build())
                        .map(materiaEntity -> new MateriaDto(materiaEntity.getId(), materiaEntity.getNombre(), materiaEntity.getCreditos()));
    }

    @Override
    public Mono<MateriaDto> updateMateria(Integer materiaId, MateriaDto materiaDto) {
        return materiaRepository.save(MateriaEntity.builder()
                        .id(materiaId)
                        .nombre(materiaDto.nombre())
                        .creditos(materiaDto.creditos())
                        .build())
                        .map(materiaEntity -> new MateriaDto(materiaEntity.getId(), materiaEntity.getNombre(), materiaEntity.getCreditos()));
    }

    @Override
    public Mono<Void> deleteMateria(Integer materiaId) {
        return materiaRepository.deleteById(materiaId);
    }

    @Override
    public Flux<MateriaDto> getAllMaterias() {
        return materiaRepository.findAll()
                .map(materiaEntity -> new MateriaDto(materiaEntity.getId(), materiaEntity.getNombre(), materiaEntity.getCreditos()));
    }
}

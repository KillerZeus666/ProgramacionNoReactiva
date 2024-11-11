package com.tallerR2DBC.tallerProgrmacionReactiva.service.impl;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.NotaDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.NotaRepository;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.NotaEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;
    @Override
    public Mono<NotaDto> getNota(Integer notaId) {
        return notaRepository.findById(notaId)
                .map(notaEntity -> new NotaDto(
                        notaEntity.getId(),
                        notaEntity.getMateriaid(),
                        notaEntity.getProfesorid(),
                        notaEntity.getCursocodigo(),
                        notaEntity.getEstudianteid(),
                        notaEntity.getObservacion(),
                        notaEntity.getValor(),
                        notaEntity.getPorcentaje()
                ));
    }

    @Override
    public Mono<NotaDto> createNota(NotaDto notaDto) {
        return notaRepository.save(NotaEntity.builder()
                        .materiaid(notaDto.materiaid())
                        .profesorid(notaDto.profesorid())
                        .cursocodigo(notaDto.cursocodigo())
                        .estudianteid(notaDto.estudianteid())
                        .observacion(notaDto.observacion())
                        .valor(notaDto.valor())
                        .porcentaje(notaDto.porcentaje())
                        .build())
                .map(notaEntity -> new NotaDto(
                        notaEntity.getId(),
                        notaEntity.getMateriaid(),
                        notaEntity.getProfesorid(),
                        notaEntity.getCursocodigo(),
                        notaEntity.getEstudianteid(),
                        notaEntity.getObservacion(),
                        notaEntity.getValor(),
                        notaEntity.getPorcentaje()
                ));
    }

    @Override
    public Mono<NotaDto> updateNota(Integer notaId, NotaDto notaDto) {
        return notaRepository.save(NotaEntity.builder()
                        .id(notaId)
                        .materiaid(notaDto.materiaid())
                        .profesorid(notaDto.profesorid())
                        .cursocodigo(notaDto.cursocodigo())
                        .estudianteid(notaDto.estudianteid())
                        .observacion(notaDto.observacion())
                        .valor(notaDto.valor())
                        .porcentaje(notaDto.porcentaje())
                        .build())
                .map(notaEntity -> new NotaDto(
                        notaEntity.getId(),
                        notaEntity.getMateriaid(),
                        notaEntity.getProfesorid(),
                        notaEntity.getCursocodigo(),
                        notaEntity.getEstudianteid(),
                        notaEntity.getObservacion(),
                        notaEntity.getValor(),
                        notaEntity.getPorcentaje()
                ));
    }

    @Override
    public Mono<Void> deleteNota(Integer notaId) {
        return notaRepository.deleteById(notaId);
    }

    @Override
    public Flux<NotaDto> getAllNotas() {
        return notaRepository.findAll()
                .map(notaEntity -> new NotaDto(
                        notaEntity.getId(),
                        notaEntity.getMateriaid(),
                        notaEntity.getProfesorid(),
                        notaEntity.getCursocodigo(),
                        notaEntity.getEstudianteid(),
                        notaEntity.getObservacion(),
                        notaEntity.getValor(),
                        notaEntity.getPorcentaje()
                ));
    }
}

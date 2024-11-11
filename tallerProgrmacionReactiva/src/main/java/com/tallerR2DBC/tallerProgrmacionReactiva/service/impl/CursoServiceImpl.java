package com.tallerR2DBC.tallerProgrmacionReactiva.service.impl;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.CursoDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.MateriaDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.CursoRepository;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.MateriaRepository;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.CursoEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.MateriaEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.CursoService;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.MateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    @Override
    public Mono<CursoDto> getCurso(String codigo) {
        return cursoRepository.findById(codigo)
                .map(cursoEntity -> new CursoDto(cursoEntity.getMateriaid(), cursoEntity.getProfesorid(), cursoEntity.getCodigo(), cursoEntity.getFechainicio(), cursoEntity.getFechainicio()));
    }

    @Override
    public Mono<CursoDto> createCurso(CursoDto cursoDto) {
        return cursoRepository.save(CursoEntity.builder()
                        .materiaid(cursoDto.materiaid())
                        .profesorid(cursoDto.profesorid())
                        .fechainicio(cursoDto.fechainicio())
                        .fechafin(cursoDto.fechafin())
                        .build())
                        .map(cursoEntity -> new CursoDto(cursoEntity.getMateriaid(), cursoEntity.getProfesorid(), cursoEntity.getCodigo(), cursoEntity.getFechainicio(), cursoEntity.getFechainicio()));
    }

    @Override
    public Mono<CursoDto> updateCurso(String codigo, CursoDto cursoDto) {
        return cursoRepository.findById(codigo)
                .flatMap(existingCurso -> {
                    // Aquí puedes actualizar los campos de la entidad existente
                    existingCurso.setMateriaid(cursoDto.materiaid());
                    existingCurso.setProfesorid(cursoDto.profesorid());
                    existingCurso.setFechainicio(cursoDto.fechainicio());
                    existingCurso.setFechafin(cursoDto.fechafin());
                    return cursoRepository.save(existingCurso); // Guarda la entidad actualizada
                })
                .map(cursoEntity -> new CursoDto(cursoEntity.getMateriaid(), cursoEntity.getProfesorid(), cursoEntity.getCodigo(), cursoEntity.getFechainicio(), cursoEntity.getFechainicio()));
    }
    @Override
    public Mono<Void> deleteCurso(String codigo) {
        return cursoRepository.deleteById(codigo);
    }

    @Override
    public Flux<CursoDto> getAllCursos() {
        return cursoRepository.findAll()
                .map(cursoEntity -> new CursoDto(cursoEntity.getMateriaid(), cursoEntity.getProfesorid(), cursoEntity.getCodigo(), cursoEntity.getFechainicio(), cursoEntity.getFechainicio()));
    }
}

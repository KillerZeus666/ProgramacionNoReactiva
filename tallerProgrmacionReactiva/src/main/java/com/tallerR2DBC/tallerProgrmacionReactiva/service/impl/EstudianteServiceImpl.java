package com.tallerR2DBC.tallerProgrmacionReactiva.service.impl;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.EstudianteDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.ProfesorDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.EstudianteRepository;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.EstudianteEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.MateriaEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.ProfesorEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.CursoService;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;

    CursoService cursoService;
    @Override
    public Mono<EstudianteDto> getEstudiante(Integer estudianteId) {
        return estudianteRepository.findById(estudianteId)
                .map(estudianteEntity -> new EstudianteDto(estudianteEntity.getId(), estudianteEntity.getNombre(), estudianteEntity.getNombre(), estudianteEntity.getCorreo()));
    }
    public Mono<String> getEstudianteNameById(Integer materiaId) {
        return estudianteRepository.findById(materiaId)
                .map(EstudianteEntity::getNombre);
    }

    public Mono<String> getEstudianteApellidoById(Integer materiaId) {
        return estudianteRepository.findById(materiaId)
                .map(EstudianteEntity::getApellido);
    }

    public Mono<String> getEstudianteCorreoById(Integer materiaId) {
        return estudianteRepository.findById(materiaId)
                .map(EstudianteEntity::getCorreo);
    }

    @Override
    public Mono<EstudianteDto> createEstudiante(EstudianteDto estudianteDto) {
        return estudianteRepository.save(EstudianteEntity.builder()
                        .nombre(estudianteDto.nombre())
                        .apellido(estudianteDto.apellido())
                        .correo(estudianteDto.correo())
                        .build())
                .map(estudianteEntity -> new EstudianteDto(estudianteEntity.getId(), estudianteEntity.getNombre(), estudianteEntity.getNombre(), estudianteEntity.getCorreo()));
    }


    @Override
    public Mono<EstudianteDto> updateEstudiante(Integer estudianteId, EstudianteDto estudianteDto) {
        return estudianteRepository.save(EstudianteEntity.builder()
                        .id(estudianteId)
                        .nombre(estudianteDto.nombre())
                        .apellido(estudianteDto.apellido())
                        .correo(estudianteDto.correo())
                        .build())
                .map(estudianteEntity -> new EstudianteDto(estudianteEntity.getId(), estudianteEntity.getNombre(), estudianteEntity.getNombre(), estudianteEntity.getCorreo()));
    }

    @Override
    public Mono<Void> deleteEstudiante(Integer estudianteId) {
        return estudianteRepository.deleteById(estudianteId);
    }

    @Override
    public Flux<EstudianteDto> getAllEstudiantes() {
        return estudianteRepository.findAll()
                .map(estudianteEntity -> new EstudianteDto(estudianteEntity.getId(), estudianteEntity.getNombre(), estudianteEntity.getNombre(), estudianteEntity.getCorreo()));
    }
}

package com.tallerR2DBC.tallerProgrmacionReactiva.service.impl;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.ProfesorDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.ProfesorRepository;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.MateriaEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.ProfesorEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;

    @Override
    public Mono<ProfesorDto> getProfesor(Integer profesorId) {
        return profesorRepository.findById(profesorId)
                .map(profesorEntity -> new ProfesorDto(profesorEntity.getId(), profesorEntity.getNombre(), profesorEntity.getApellido(), profesorEntity.getCorreo()));
    }

    public Mono<String> getProfesorNameById(Integer materiaId) {
        return profesorRepository.findById(materiaId)
                .map(ProfesorEntity::getNombre);
    }

    @Override
    public Mono<ProfesorDto> createProfesor(ProfesorDto profesorDto) {
        return profesorRepository.save(ProfesorEntity.builder()
                        .nombre(profesorDto.nombre())
                        .apellido(profesorDto.apellido())
                        .correo(profesorDto.correo())
                        .build())
                        .map(profesorEntity -> new ProfesorDto(profesorEntity.getId(), profesorEntity.getNombre(), profesorEntity.getApellido(), profesorEntity.getCorreo()));
    }

    @Override
    public Mono<ProfesorDto> updateProfesor(Integer profesorId, ProfesorDto profesorDto) {
        return profesorRepository.save(ProfesorEntity.builder()
                        .id(profesorId)
                        .nombre(profesorDto.nombre())
                        .apellido(profesorDto.apellido())
                        .correo(profesorDto.correo())
                        .build())
                        .map(profesorEntity -> new ProfesorDto(profesorEntity.getId(), profesorEntity.getNombre(), profesorEntity.getApellido(), profesorEntity.getCorreo()));
    }

    @Override
    public Mono<Void> deleteProfesor(Integer profesorId) {
        return profesorRepository.deleteById(profesorId);
    }

    @Override
    public Flux<ProfesorDto> getAllProfesor() {
        return profesorRepository.findAll()
                .map(profesorEntity -> new ProfesorDto(profesorEntity.getId(), profesorEntity.getNombre(), profesorEntity.getApellido(), profesorEntity.getCorreo()));
    }
}

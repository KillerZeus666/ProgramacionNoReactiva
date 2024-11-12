package com.tallerR2DBC.tallerProgrmacionReactiva.service.impl;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.CursoDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.EstudianteDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.MateriaDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.*;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.CursoEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.MateriaEntity;
import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.ProfesorEntity;
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
    private final MateriaRepository materiaRepository;
    private final ProfesorRepository profesorRepository;
    private final EstudianteRepository estudianteRepository;
    private final NotaRepository notaRepository;

    @Override
    public Mono<CursoDto> getCurso(String codigo) {
        return cursoRepository.findById(codigo)
                .map(cursoEntity -> new CursoDto(cursoEntity.getMateriaid(), cursoEntity.getProfesorid(), cursoEntity.getCodigo(), cursoEntity.getFechainicio(), cursoEntity.getFechainicio()));
    }

    public Flux<String> getAllCursosInfo() {
        return cursoRepository.findAll()
                .flatMap(cursoEntity -> {
                    // Obtener el nombre de la materia
                    Mono<String> materiaName = materiaRepository.findById(cursoEntity.getMateriaid())
                            .map(MateriaEntity::getNombre)
                            .defaultIfEmpty("Materia no encontrada");

                    // Obtener el nombre del profesor
                    Mono<String> profesorName = profesorRepository.findById(cursoEntity.getProfesorid())
                            .map(ProfesorEntity::getNombre)
                            .defaultIfEmpty("Profesor no encontrado");

                    // Combinar la información de la materia, profesor y código del curso
                    return Mono.zip(materiaName, profesorName, Mono.just(cursoEntity.getCodigo()))
                            .map(tuple -> "Materia: " + tuple.getT1() + ", Profesor: " + tuple.getT2() + ", Código del curso: " + tuple.getT3());
                });
    }

    @Override
    public Flux<EstudianteDto> getEstudiantesByCursoCodigo(String cursoCodigo) {
        // Primero, obtenemos todas las notas asociadas al curso
        return notaRepository.findAll()
                .filter(nota -> nota.getCursocodigo().equals(cursoCodigo)) // Filtramos las notas del curso
                .flatMap(nota -> {
                    // Luego, obtenemos el estudiante por cada estudianteId en las notas
                    return estudianteRepository.findById(nota.getEstudianteid())
                            .map(estudianteEntity -> new EstudianteDto(
                                    estudianteEntity.getId(),
                                    estudianteEntity.getNombre(),
                                    estudianteEntity.getApellido(),
                                    estudianteEntity.getCorreo()
                            ));
                })
                .distinct(); // Eliminamos duplicados en caso de que un estudiante tenga varias notas en el mismo curso
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

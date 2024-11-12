package com.tallerR2DBC.tallerProgrmacionReactiva.controller;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.CursoDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.EstudianteDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    @GetMapping("/{cursoId}")
    Mono<CursoDto> getCurso(@PathVariable("cursoId") String codigo){
        return cursoService.getCurso(codigo);
    }

    @PostMapping
    Mono<CursoDto> createCurso(@RequestBody CursoDto cursoDto){
        return cursoService.createCurso(cursoDto);
    }

    @PutMapping("/{cursoId}")
    Mono<CursoDto> updateCurso(@PathVariable("cursoId") String codigo, @RequestBody CursoDto cursoDto){
        return cursoService.updateCurso(codigo, cursoDto);
    }

    @DeleteMapping("/{cursoId}")
    Mono<Void> deleteCurso(@PathVariable("cursoId") String codigo){
        return cursoService.deleteCurso(codigo);
    }

    @GetMapping("/all")
    Flux<CursoDto> getAllCursos(){
        return cursoService.getAllCursos();
    }

    @GetMapping("/info")
    public Flux<String> getAllCursosInfo() {
        return cursoService.getAllCursosInfo();
    }

    // Endpoint para obtener todos los estudiantes de un curso por su código
    @GetMapping("/{cursoId}/estudiantes")
    public Flux<EstudianteDto> getEstudiantesByCursoCodigo(@PathVariable("cursoId") String codigo) {
        return cursoService.getEstudiantesByCursoCodigo(codigo);
    }

}

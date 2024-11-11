package com.tallerR2DBC.tallerProgrmacionReactiva.controller;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.EstudianteDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.ProfesorDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    private  final EstudianteService estudianteService;

    @GetMapping("/{estudianteId}")
    Mono<EstudianteDto> getEstudiante(@PathVariable("estudianteId") Integer estudianteId){
        return estudianteService.getEstudiante(estudianteId);
    }

    @PostMapping
    Mono<EstudianteDto> createEstudiante(@RequestBody EstudianteDto estudianteDto){
        return estudianteService.createEstudiante(estudianteDto);
    }

    @PutMapping("/{estudianteId}")
    Mono<EstudianteDto> updateEstudiante(@PathVariable("estudianteId") Integer estudianteId, @RequestBody EstudianteDto estudianteDto){
        return estudianteService.updateEstudiante(estudianteId, estudianteDto);
    }

    @DeleteMapping("/{estudianteId}")
    Mono<Void> deleteEstudiante(@PathVariable("estudianteId") Integer estudianteId){
        return estudianteService.deleteEstudiante(estudianteId);
    }

    @GetMapping("/all")
    Flux<EstudianteDto> getAllEstudiantes(){
        return estudianteService.getAllEstudiantes();
    }
}

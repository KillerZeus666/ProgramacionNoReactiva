package com.tallerR2DBC.tallerProgrmacionReactiva.controller;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.MateriaDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.MateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/materia")
public class MateriaController {

    private final MateriaService materiaService;

    @GetMapping("/{materiaId}")
    Mono<MateriaDto> getMateria(@PathVariable("materiaId") Integer materiaId){
        return materiaService.getMateria(materiaId);
    }

    @PostMapping
    Mono<MateriaDto> createMateria(@RequestBody MateriaDto materiaDto){
        return materiaService.createMateria(materiaDto);
    }

    @PutMapping("/{materiaId}")
    Mono<MateriaDto> updateMateria(@PathVariable("materiaId") Integer materiaId, @RequestBody MateriaDto materiaDto){
        return materiaService.updateMateria(materiaId, materiaDto);
    }

    @DeleteMapping("/{materiaId}")
    Mono<Void> deleteMateria(@PathVariable("materiaId") Integer materiaId){
        return materiaService.deleteMateria(materiaId);
    }

    @GetMapping("/all")
    Flux<MateriaDto> getAllMaterias(){
        return materiaService.getAllMaterias();
    }
}

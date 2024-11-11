package com.tallerR2DBC.tallerProgrmacionReactiva.controller;


import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.ProfesorDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    private final ProfesorService profesorService;
    @GetMapping("/{profesorId}")
    Mono<ProfesorDto> getProfesor(@PathVariable("profesorId") Integer profesorId){
        return profesorService.getProfesor(profesorId);
    }

    @PostMapping
    Mono<ProfesorDto> createProfesor(@RequestBody ProfesorDto profesorDto){
        return profesorService.createProfesor(profesorDto);
    }

    @PutMapping("/{profesorId}")
    Mono<ProfesorDto> updateProfesor(@PathVariable("profesorId") Integer profesorId, @RequestBody ProfesorDto profesorDto){
        return profesorService.updateProfesor(profesorId, profesorDto);
    }

    @DeleteMapping("/{profesorId}")
    Mono<Void> deleteProfesor(@PathVariable("profesorId") Integer profesorId){
        return profesorService.deleteProfesor(profesorId);
    }

    @GetMapping("/all")
    Flux<ProfesorDto> getAllProfesor(){
        return profesorService.getAllProfesor();
    }
}

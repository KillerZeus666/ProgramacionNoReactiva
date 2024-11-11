package com.tallerR2DBC.tallerProgrmacionReactiva.controller;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.NotaDto;
import com.tallerR2DBC.tallerProgrmacionReactiva.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/nota")
public class NotaController {

    private final NotaService notaService;

    @GetMapping("/{notaId}")
    Mono<NotaDto> getNota(@PathVariable("notaId") Integer notaId) {
        return notaService.getNota(notaId);
    }

    @PostMapping
    Mono<NotaDto> createNota(@RequestBody NotaDto notaDto) {
        return notaService.createNota(notaDto);
    }

    @PutMapping("/{notaId}")
    Mono<NotaDto> updateNota(@PathVariable("notaId") Integer notaId, @RequestBody NotaDto notaDto) {
        return notaService.updateNota(notaId, notaDto);
    }

    @DeleteMapping("/{notaId}")
    Mono<Void> deleteNota(@PathVariable("notaId") Integer notaId) {
        return notaService.deleteNota(notaId);
    }

    @GetMapping("/all")
    Flux<NotaDto> getAllNotas() {
        return notaService.getAllNotas();
    }
}


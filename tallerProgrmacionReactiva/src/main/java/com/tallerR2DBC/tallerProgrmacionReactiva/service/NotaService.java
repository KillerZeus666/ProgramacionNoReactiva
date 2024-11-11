package com.tallerR2DBC.tallerProgrmacionReactiva.service;

import com.tallerR2DBC.tallerProgrmacionReactiva.controller.dto.NotaDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NotaService {
    Mono<NotaDto> getNota(Integer notaId);

    Mono<NotaDto> createNota(NotaDto notaDto);

    Mono<NotaDto> updateNota(Integer notaId, NotaDto notaDto);

    Mono<Void> deleteNota(Integer notaId);

    Flux<NotaDto> getAllNotas();
}

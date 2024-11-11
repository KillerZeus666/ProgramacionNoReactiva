package com.tallerR2DBC.tallerProgrmacionReactiva.repository;

import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.NotaEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotaRepository extends R2dbcRepository<NotaEntity, Integer> {
}

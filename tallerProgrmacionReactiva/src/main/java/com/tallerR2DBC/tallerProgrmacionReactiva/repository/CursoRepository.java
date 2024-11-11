package com.tallerR2DBC.tallerProgrmacionReactiva.repository;

import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.CursoEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CursoRepository extends R2dbcRepository<CursoEntity, String> {
}

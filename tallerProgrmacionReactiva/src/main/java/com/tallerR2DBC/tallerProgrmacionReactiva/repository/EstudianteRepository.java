package com.tallerR2DBC.tallerProgrmacionReactiva.repository;

import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.EstudianteEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface EstudianteRepository extends R2dbcRepository<EstudianteEntity, Integer> {
}

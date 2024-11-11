package com.tallerR2DBC.tallerProgrmacionReactiva.repository;

import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.ProfesorEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ProfesorRepository extends R2dbcRepository<ProfesorEntity, Integer> {
}

package com.tallerR2DBC.tallerProgrmacionReactiva.repository;

import com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity.MateriaEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MateriaRepository extends R2dbcRepository<MateriaEntity, Integer> {
}

package com.tallerR2DBC.tallerProgrmacionReactiva.repository.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("nota")
public class NotaEntity {
    @Id
    Integer id;
    Integer materiaid;
    Integer profesorid;
    String cursocodigo;
    Integer estudianteid;
    String observacion;
    double valor;
    double porcentaje;
}

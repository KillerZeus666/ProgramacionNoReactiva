package edu.javeriana.tallerG3030.excepcion;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaError {
    public RespuestaError(String mensaje, List<String> detalles) {
        super();
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    private String mensaje;
    private List<String> detalles;
}

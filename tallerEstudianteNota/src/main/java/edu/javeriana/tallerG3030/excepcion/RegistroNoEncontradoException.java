package edu.javeriana.tallerG3030.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegistroNoEncontradoException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RegistroNoEncontradoException(String message) {
        super(message);
    }
}

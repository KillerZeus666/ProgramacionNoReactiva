package edu.javeriana.tallerG3030.excepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ControllerAdvice
public class AplicacionException extends ResponseEntityExceptionHandler {



    @ExceptionHandler(RegistroNoEncontradoException.class)
    public final ResponseEntity<RespuestaError> gestorSinDatosException
            (RegistroNoEncontradoException ex, WebRequest request)
    {
        List<String> detalles = new ArrayList<>();
        detalles.add(ex.getLocalizedMessage());
        RespuestaError error = new RespuestaError("Error de PETICIÓN", detalles);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
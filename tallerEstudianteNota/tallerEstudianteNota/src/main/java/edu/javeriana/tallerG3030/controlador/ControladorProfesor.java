package edu.javeriana.tallerG3030.controlador;

import edu.javeriana.tallerG3030.excepcion.RegistroNoEncontradoException;
import edu.javeriana.tallerG3030.modelo.Profesor;
import edu.javeriana.tallerG3030.repositorio.RepositorioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ControladorProfesor {
    @Autowired
    private RepositorioProfesor repositorioProfesor;

    // POST Create
    @PostMapping("/profesor")
    public ResponseEntity<Profesor> creaProfesor(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = repositorioProfesor.save(profesor);
        return new ResponseEntity<>(nuevoProfesor, HttpStatus.CREATED);
    }

    // GET Retrieve
    @GetMapping("/profesores")
    public List<Profesor> traeProfesores() {
        return repositorioProfesor.findAll();
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<Profesor> traeProfesor(@PathVariable Integer id) {
        Profesor profesor = repositorioProfesor.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No existe el profesor con id: " + id));
        return ResponseEntity.ok(profesor);
    }

    // PUT Update
    @PutMapping("/profesor/{id}")
    public ResponseEntity<Profesor> actualizaProfesor(@PathVariable Integer id, @RequestBody Profesor profesor) {
        Profesor profesorExistente = repositorioProfesor.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No existe el profesor con id: " + id));

        profesorExistente.setNombre(profesor.getNombre());
        // Agrega otros setters según sea necesario

        Profesor profesorActualizado = repositorioProfesor.save(profesorExistente);
        return ResponseEntity.ok(profesorActualizado);
    }

    // DELETE Delete
    @DeleteMapping("/profesor/{id}")
    public ResponseEntity<HttpStatus> borraProfesor(@PathVariable Integer id) {
        Profesor profesor = repositorioProfesor.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No existe el profesor con id: " + id));
        repositorioProfesor.delete(profesor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

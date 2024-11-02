package edu.javeriana.tallerG3030.controlador;

import edu.javeriana.tallerG3030.excepcion.RegistroNoEncontradoException;
import edu.javeriana.tallerG3030.modelo.Materia;
import edu.javeriana.tallerG3030.repositorio.RepositorioMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ControladorMateria {
    @Autowired
    private RepositorioMateria repositorioMateria;

    // POST Create
    @PostMapping("/materia")
    public ResponseEntity<Materia> creaMateria(@RequestBody Materia materia) {
        Materia nuevaMateria = repositorioMateria.save(materia);
        return new ResponseEntity<>(nuevaMateria, HttpStatus.CREATED);
    }

    // GET Retrieve
    @GetMapping("/materias")
    public List<Materia> traeMaterias() {
        return repositorioMateria.findAll();
    }

    @GetMapping("/materia/{id}")
    public ResponseEntity<Materia> traeMateria(@PathVariable Integer id) {
        Materia materia = repositorioMateria.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No existe la materia con id: " + id));
        return ResponseEntity.ok(materia);
    }

    // PUT Update
    @PutMapping("/materia/{id}")
    public ResponseEntity<Materia> actualizaMateria(@PathVariable Integer id, @RequestBody Materia materia) {
        Materia materiaExistente = repositorioMateria.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No existe la materia con id: " + id));

        materiaExistente.setNombre(materia.getNombre());
        // Agrega otros setters según sea necesario

        Materia materiaActualizada = repositorioMateria.save(materiaExistente);
        return ResponseEntity.ok(materiaActualizada);
    }

    // DELETE Delete
    @DeleteMapping("/materia/{id}")
    public ResponseEntity<HttpStatus> borraMateria(@PathVariable Integer id) {
        Materia materia = repositorioMateria.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No existe la materia con id: " + id));
        repositorioMateria.delete(materia);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

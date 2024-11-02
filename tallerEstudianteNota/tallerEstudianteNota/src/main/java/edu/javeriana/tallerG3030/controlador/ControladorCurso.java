package edu.javeriana.tallerG3030.controlador;

import edu.javeriana.tallerG3030.excepcion.RegistroNoEncontradoException;
import edu.javeriana.tallerG3030.modelo.Curso;
//import edu.javeriana.tallerG3030.modelo.Materia; 
import edu.javeriana.tallerG3030.repositorio.RepositorioCurso;
import edu.javeriana.tallerG3030.repositorio.RepositorioMateria; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ControladorCurso {
    @Autowired
    private RepositorioCurso repositorioCurso;

    @Autowired
    private RepositorioMateria repositorioMateria; 

    @GetMapping("/cursos")
    public List<Curso> traeCursos() {
        return repositorioCurso.findAll();
    }

    @PostMapping("/curso")
    public ResponseEntity<Curso> creaCurso(@RequestBody Curso curso) {
        return new ResponseEntity<>(repositorioCurso.save(curso), HttpStatus.CREATED);
    }

    @PutMapping("/curso/{id}")
    public ResponseEntity<Curso> actualizaCurso(@PathVariable Integer id, @RequestBody Curso curso) {
        Curso cursoExistente = repositorioCurso.findById(id)
                .orElseThrow(() -> new RegistroNoEncontradoException("No existe curso con id: " + id));

        // Comparar la materia del curso existente con la nueva materia
        if (curso.getMateria() != null && curso.getMateria().getId() != null) {
            
        }

        // Actualizar otros campos del curso existente

        // Actualiza la materia
        cursoExistente.setMateria(curso.getMateria()); 
        // Actualiza el código
        cursoExistente.setCodigo(curso.getCodigo()); 
        // Actualiza la fecha de inicio
        cursoExistente.setFechaInicio(curso.getFechaInicio()); 
        // Actualiza la fecha de fin
        cursoExistente.setFechaFin(curso.getFechaFin()); 
        
        return new ResponseEntity<>(repositorioCurso.save(cursoExistente), HttpStatus.OK);
    }
}

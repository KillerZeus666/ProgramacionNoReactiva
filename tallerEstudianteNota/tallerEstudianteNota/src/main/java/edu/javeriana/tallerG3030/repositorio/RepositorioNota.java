package edu.javeriana.tallerG3030.repositorio;

import edu.javeriana.tallerG3030.modelo.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioNota extends JpaRepository<Nota, Integer> {
    List<Nota> findByEstudianteId(Integer id);

}

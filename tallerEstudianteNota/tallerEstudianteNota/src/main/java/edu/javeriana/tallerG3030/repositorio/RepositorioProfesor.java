package edu.javeriana.tallerG3030.repositorio;

import edu.javeriana.tallerG3030.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProfesor extends JpaRepository<Profesor, Integer> {
}

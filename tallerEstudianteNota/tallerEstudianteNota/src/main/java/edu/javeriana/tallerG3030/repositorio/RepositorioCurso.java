package edu.javeriana.tallerG3030.repositorio;

import edu.javeriana.tallerG3030.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCurso extends JpaRepository<Curso, Integer> {
}

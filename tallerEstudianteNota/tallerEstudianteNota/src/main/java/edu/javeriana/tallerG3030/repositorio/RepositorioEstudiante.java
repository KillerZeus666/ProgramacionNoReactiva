package edu.javeriana.tallerG3030.repositorio;

import edu.javeriana.tallerG3030.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEstudiante extends JpaRepository<Estudiante, Integer> {
}
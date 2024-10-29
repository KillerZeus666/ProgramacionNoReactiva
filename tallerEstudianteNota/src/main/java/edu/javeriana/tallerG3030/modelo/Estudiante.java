package edu.javeriana.tallerG3030.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@Table
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;

    @OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)

    private Set<Nota> notas;


}

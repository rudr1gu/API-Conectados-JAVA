package com.conectados.conectados.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank    
    private String nome;
    
    @NotBlank
    private int modulo;
    
    @NotBlank
    private String periodo;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @ManyToMany
    @JoinTable(
        name = "cursos_materias",
        joinColumns =  @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<Materia> materias;

}
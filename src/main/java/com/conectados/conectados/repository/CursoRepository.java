package com.conectados.conectados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Custom query methods can be defined here if needed

}

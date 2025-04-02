package com.conectados.conectados.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.domain.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
    // Custom query methods can be defined here if needed

}

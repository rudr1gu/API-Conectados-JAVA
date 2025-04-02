package com.conectados.conectados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.model.Estrela;

public interface EstrelaRepository extends JpaRepository<Estrela, Long> {
    // Custom query methods can be defined here if needed

}

package com.conectados.conectados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    // Custom query methods can be defined here if needed
}

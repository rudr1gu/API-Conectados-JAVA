package com.conectados.conectados.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.domain.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    // Custom query methods can be defined here if needed
}

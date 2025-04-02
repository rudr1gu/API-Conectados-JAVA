package com.conectados.conectados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    // Custom query methods can be defined here if needed
}

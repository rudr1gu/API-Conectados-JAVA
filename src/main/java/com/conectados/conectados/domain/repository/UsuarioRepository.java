package com.conectados.conectados.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}

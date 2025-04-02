package com.conectados.conectados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}

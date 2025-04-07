package com.conectados.conectados.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conectados.conectados.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Optional<Usuario> findByUsuario(String usuario);
    public Optional<Usuario> findByEmail(String email);
}

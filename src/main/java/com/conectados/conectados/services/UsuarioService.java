package com.conectados.conectados.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.conectados.conectados.domain.model.Usuario;
import com.conectados.conectados.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
}

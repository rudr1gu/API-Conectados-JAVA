package com.conectados.conectados.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.conectados.conectados.domain.model.Usuario;
import com.conectados.conectados.domain.repository.UsuarioRepository;
import com.conectados.conectados.security.JwtService;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return Optional.empty();
        }
        usuario.setSenha(criptografarSenha(usuario.getSenha()));

        return Optional.of(usuarioRepository.save(usuario));
    }

    public Optional<Usuario> atualizarUsuario(Usuario usuario) {
        if(usuarioRepository.findById(usuario.getId()).isPresent()){
            Optional<Usuario> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());

            if((buscaUsuario.isPresent()) && (buscaUsuario.get().getId() != usuario.getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
            }
           
            usuario.setSenha(criptografarSenha(usuario.getSenha()));

            return Optional.of(usuarioRepository.save(usuario));
        }

        return Optional.empty();
    }    



    private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(senha);
	}

}

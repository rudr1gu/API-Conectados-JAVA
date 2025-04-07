package com.conectados.conectados.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLogin {

    private Long id;
	private String nome;
	private String email;
	private String senha;
	private String foto;
	private String tipo;
	private String token;
    
}

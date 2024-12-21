package com.conectados.conectados.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String senha;

    @NotBlank
    private String tipo;

    private String foto;

    @ManyToOne
    @JsonIgnoreProperties("usuario")
    private Curso curso;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Postagem> postagens;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Resposta> respostas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Estrela> estrelas;

}

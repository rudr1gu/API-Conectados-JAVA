package com.conectados.conectados.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String conteudo;

    private LocalDate dataCriacao;

    private LocalDate dataAtualizacao;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Postagem postagem;

    @OneToMany(mappedBy = "resposta", cascade = CascadeType.ALL)
    private List<Estrela> estrelas;
}

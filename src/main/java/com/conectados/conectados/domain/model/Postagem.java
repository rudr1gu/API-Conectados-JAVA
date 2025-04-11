package com.conectados.conectados.domain.model;

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
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Table(name = "tb_postagens")
public class Postagem {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min = 10, max = 150,message = "O título deve ter no mínimo 10 caracteres")
    private String titulo;
    
    @NotBlank
    @Size(min = 10, max = 5000,message = "O conteúdo deve ter no mínimo 10 caracteres")
    private String conteudo;


    private String imagemUrl;

    @ManyToOne 
    private Usuario usuario;
    
    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Materia materia;

    @CreationTimestamp
    private LocalDate dataCriacao;

    @UpdateTimestamp
    private LocalDate dataAtualizacao;

    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
    private List<Resposta> respostas;
}

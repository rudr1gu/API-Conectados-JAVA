package com.conectados.conectados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conectados.conectados.domain.model.Postagem;
import com.conectados.conectados.services.PostagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @GetMapping("/all")
    public ResponseEntity<List<Postagem>> getAllPostagens(){
        return ResponseEntity.ok(postagemService.buscarTodasPostagens().orElse(null));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Postagem> cadastrarPostagem(@RequestBody Postagem postagem) {
        return ResponseEntity.ok(postagemService.cadastrarPostagem(postagem));
    }
    
}

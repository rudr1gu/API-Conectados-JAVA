package com.conectados.conectados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.conectados.conectados.domain.model.Postagem;
import com.conectados.conectados.services.PostagemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable Long id) {
        return postagemService.buscarPostagemPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Postagem> cadastrarPostagem(@RequestBody Postagem postagem) {
        return ResponseEntity.ok(postagemService.cadastrarPostagem(postagem));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Postagem> atualizarPostagem(@PathVariable Long id, @RequestBody Postagem postagem) {
        postagem.setId(id);
        return ResponseEntity.ok(postagemService.atualizarPostagem(postagem));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletarPostagem(@PathVariable Long id) {
        if (postagemService.buscarPostagemPorId(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Postagem não encontrada");
        }
        postagemService.deletarPostagem(id);
    }

}

package com.conectados.conectados.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.conectados.conectados.domain.model.Resposta;
import com.conectados.conectados.services.RespostaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/respostas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @GetMapping("/all")
    public ResponseEntity<List<Resposta>> getAllRespostas() {
        return ResponseEntity.ok(respostaService.buscarTodasRespostas().orElse(null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resposta> getById(@PathVariable Long id) {
        return respostaService.buscarRespostaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Resposta> cadastrarResposta(@RequestBody Resposta resposta) {
        return ResponseEntity.ok(respostaService.cadastrarResposta(resposta));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Resposta> atualizarResposta(@PathVariable Long id, @RequestBody Resposta resposta) {
        resposta.setId(id);
        return ResponseEntity.ok(respostaService.atualizarResposta(resposta));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletarResposta(@PathVariable Long id) {
        if (respostaService.buscarRespostaPorId(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resposta não encontrada");
        }
        respostaService.deletarResposta(id);
    }

}

package com.conectados.conectados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conectados.conectados.domain.model.Resposta;
import com.conectados.conectados.domain.repository.RespostaRepository;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;


    public Optional<List<Resposta>> buscarTodasRespostas() {
        List<Resposta> respostas = respostaRepository.findAll();
        if (respostas.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(respostas);
    }

    public Optional<Resposta> buscarRespostaPorId(Long id) {
        return respostaRepository.findById(id);
    }

    public Resposta cadastrarResposta(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    public Resposta atualizarResposta(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    public void deletarResposta(Long id) {
        respostaRepository.deleteById(id);
    }
}

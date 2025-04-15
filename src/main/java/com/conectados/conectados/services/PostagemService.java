package com.conectados.conectados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conectados.conectados.domain.model.Postagem;
import com.conectados.conectados.domain.repository.PostagemRepository;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    public Optional<List<Postagem>> buscarTodasPostagens(){
        List<Postagem> postagens = postagemRepository.findAll();
        if (postagens.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(postagens);
    }

    public Optional<Postagem> buscarPostagemPorId(Long id) {
        return postagemRepository.findById(id);
    }

    public Postagem cadastrarPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public Postagem atualizarPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public void deletarPostagem(Long id) {
        postagemRepository.deleteById(id);
    }

}

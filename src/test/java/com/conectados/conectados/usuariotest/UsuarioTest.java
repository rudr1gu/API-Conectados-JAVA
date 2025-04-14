package com.conectados.conectados.usuariotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.conectados.conectados.domain.model.Usuario;

@SpringBootTest
public class UsuarioTest {

    @Test
    void testNome() {
        Usuario usuario = new Usuario();
        usuario.setNome("Rodrigo");
        assertEquals("Rodrigo", usuario.getNome());
    }
    
}

package com.taller.usuarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {

    private UsuarioService service;

    @BeforeEach
    void setUp() {
        service = new UsuarioService();
    }

    @Test
    void crearUsuario_deberiaAgregarNuevoUsuario() {
        Usuario u = new Usuario("1", "Anderson", "anderson@mail.com", "1234");
        assertTrue(service.crearUsuario(u));
        assertEquals(1, service.contarUsuarios());
    }

    @Test
    void crearUsuario_conIdDuplicado_noDebeAgregar() {
        Usuario u1 = new Usuario("1", "Anderson", "a@mail.com", "1234");
        Usuario u2 = new Usuario("1", "Sebas", "s@mail.com", "5678");
        assertTrue(service.crearUsuario(u1));
        assertFalse(service.crearUsuario(u2));
        assertEquals(1, service.contarUsuarios());
    }

}

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

    @Test
    void crearUsuario_conUsuarioNull_noDebeAgregar() {
        assertFalse(service.crearUsuario(null));
        assertEquals(0, service.contarUsuarios());
    }

    @Test
    void crearUsuario_conIdNull_noDebeAgregar() {
        Usuario u = new Usuario(null, "Name", "mail@mail.com", "pass");
        assertFalse(service.crearUsuario(u));
        assertEquals(0, service.contarUsuarios());
    }

    @Test
    void buscarUsuario_existente_deberiaRetornarUsuario() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");
        service.crearUsuario(u);
        Usuario encontrado = service.buscarUsuario("1");
        assertNotNull(encontrado);
        assertEquals("Anderson", encontrado.getNombre());
    }

    @Test
    void buscarUsuario_inexistente_deberiaRetornarNull() {
        assertNull(service.buscarUsuario("99"));
    }

    @Test
    void buscarUsuario_conIdNull_deberiaRetornarNull() {
        assertNull(service.buscarUsuario(null));
    }

    @Test
    void eliminarUsuario_existente_deberiaEliminarlo() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");
        service.crearUsuario(u);
        assertTrue(service.eliminarUsuario("1"));
        assertEquals(0, service.contarUsuarios());
    }

    @Test
    void eliminarUsuario_inexistente_deberiaRetornarFalse() {
        assertFalse(service.eliminarUsuario("100"));
    }

    @Test
    void eliminarUsuario_conIdNull_deberiaRetornarFalse() {
        assertFalse(service.eliminarUsuario(null));
    }

    @Test
    void actualizarEmail_existente_deberiaActualizarlo() {
        Usuario u = new Usuario("1", "Anderson", "old@mail.com", "1234");
        service.crearUsuario(u);
        assertTrue(service.actualizarEmail("1", "new@mail.com"));
        assertEquals("new@mail.com", service.buscarUsuario("1").getEmail());
    }

    @Test
    void actualizarEmail_usuarioNoExistente_deberiaRetornarFalse() {
        assertFalse(service.actualizarEmail("1", "new@mail.com"));
    }

    @Test
    void actualizarEmail_conIdNull_deberiaRetornarFalse() {
        assertFalse(service.actualizarEmail(null, "new@mail.com"));
    }

    @Test
    void actualizarEmail_conEmailNull_deberiaRetornarFalse() {
        Usuario u = new Usuario("1", "Anderson", "old@mail.com", "1234");
        service.crearUsuario(u);
        assertFalse(service.actualizarEmail("1", null));
    }

    @Test
    void contarUsuarios_deberiaRetornarCantidadCorrecta() {
        assertEquals(0, service.contarUsuarios());
        service.crearUsuario(new Usuario("1", "A", "a@mail.com", "123"));
        service.crearUsuario(new Usuario("2", "B", "b@mail.com", "456"));
        assertEquals(2, service.contarUsuarios());
    }

    @Test
    void existeUsuario_deberiaRetornarTrueSiExiste() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");
        service.crearUsuario(u);
        assertTrue(service.existeUsuario("1"));
    }

    @Test
    void existeUsuario_deberiaRetornarFalseSiNoExiste() {
        assertFalse(service.existeUsuario("99"));
    }

    @Test
    void constructorYGetters_funcionanCorrectamente() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");
        assertEquals("1", u.getId());
        assertEquals("Anderson", u.getNombre());
        assertEquals("mail@mail.com", u.getEmail());
        assertEquals("1234", u.getPassword());
    }

    @Test
    void setters_deberianActualizarValores() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");

        u.setNombre("NuevoNombre");
        u.setEmail("nuevo@mail.com");
        u.setPassword("nuevaClave");

        assertEquals("NuevoNombre", u.getNombre());
        assertEquals("nuevo@mail.com", u.getEmail());
        assertEquals("nuevaClave", u.getPassword());
    }

    @Test
    void equalsYHashCode_funcionanCorrectamente() {
        Usuario u1 = new Usuario("1", "Anderson", "a@mail.com", "1234");
        Usuario u2 = new Usuario("1", "Anderson", "a@mail.com", "1234");
        Usuario u3 = new Usuario("2", "Sebas", "s@mail.com", "5678");

        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
        assertNotEquals(u1, u3);
    }

    @Test
    void equals_conNullYDistintoTipo_devuelveFalse() {
        Usuario u = new Usuario("1", "Anderson", "a@mail.com", "1234");
        assertNotEquals(u, null);
        assertNotEquals(u, "un string");
    }

    @Test
    void toString_noEsNull() {
        Usuario u = new Usuario("1", "Anderson", "a@mail.com", "1234");
        assertTrue(u.toString().contains("Usuario"));
    }
}

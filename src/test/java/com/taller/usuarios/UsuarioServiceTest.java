package com.taller.usuarios;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Pruebas unitarias para {@link UsuarioService}.
 * <p>
 * Se validan los métodos de creación, búsqueda, eliminación,
 * actualización de email, conteo de usuarios, y la implementación
 * de equals, hashCode y toString de {@link Usuario}.
 * </p>
 */


class UsuarioServiceTest {

    /**
     * Servicio de usuarios que se inicializa antes de cada prueba.
     */
    private UsuarioService service;


    @BeforeEach
    void setUp() {
        service = new UsuarioService();
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

    @Test
    void crearUsuarioDeberiaAgregarNuevoUsuario() {
        Usuario u = new Usuario("1", "Anderson", "anderson@mail.com", "1234");
        assertTrue(service.crearUsuario(u));
        assertEquals(1, service.contarUsuarios());
    }

    @Test
    void crearUsuarioConIdDuplicadoNoDebeAgregar() {
        Usuario u1 = new Usuario("1", "Anderson", "a@mail.com", "1234");
        Usuario u2 = new Usuario("1", "Sebas", "s@mail.com", "5678");
        assertTrue(service.crearUsuario(u1));
        assertFalse(service.crearUsuario(u2));
        assertEquals(1, service.contarUsuarios());
    }

    @Test
    void crearUsuarioConUsuarioNullNoDebeAgregar() {
        assertFalse(service.crearUsuario(null));
        assertEquals(0, service.contarUsuarios());
    }

    @Test
    void crearUsuarioConIdNullNoDebeAgregar() {
        Usuario u = new Usuario(null, "Name", "mail@mail.com", "pass");
        assertFalse(service.crearUsuario(u));
        assertEquals(0, service.contarUsuarios());
    }

    @Test
    void buscarUsuarioExistenteDeberiaRetornarUsuario() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");
        service.crearUsuario(u);
        Usuario encontrado = service.buscarUsuario("1");
        assertNotNull(encontrado);
        assertEquals("Anderson", encontrado.getNombre());
    }

    @Test
    void buscarUsuarioInexistenteDeberiaRetornarNull() {
        assertNull(service.buscarUsuario("99"));
    }

    @Test
    void buscarUsuarioConIdNullDeberiaRetornarNull() {
        assertNull(service.buscarUsuario(null));
    }

    @Test
    void eliminarUsuarioExistenteDeberiaEliminarlo() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");
        service.crearUsuario(u);
        assertTrue(service.eliminarUsuario("1"));
        assertEquals(0, service.contarUsuarios());
    }

    @Test
    void eliminarUsuarioInexistenteDeberiaRetornarFalse() {
        assertFalse(service.eliminarUsuario("100"));
    }

    @Test
    void eliminarUsuarioConIdNullDeberiaRetornarFalse() {
        assertFalse(service.eliminarUsuario(null));
    }

    @Test
    void actualizarEmailExistenteDeberiaActualizarlo() {
        Usuario u = new Usuario("1", "Anderson", "old@mail.com", "1234");
        service.crearUsuario(u);
        assertTrue(service.actualizarEmail("1", "new@mail.com"));
        assertEquals("new@mail.com", service.buscarUsuario("1").getEmail());
    }

    @Test
    void actualizarEmailUsuarioNoExistenteDeberiaRetornarFalse() {
        assertFalse(service.actualizarEmail("1", "new@mail.com"));
    }

    @Test
    void actualizarEmailConIdNullDeberiaRetornarFalse() {
        assertFalse(service.actualizarEmail(null, "new@mail.com"));
    }

    @Test
    void actualizarEmailConEmailNullDeberiaRetornarFalse() {
        Usuario u = new Usuario("1", "Anderson", "old@mail.com", "1234");
        service.crearUsuario(u);
        assertFalse(service.actualizarEmail("1", null));
    }

    @Test
    void contarUsuariosDeberiaRetornarCantidadCorrecta() {
        assertEquals(0, service.contarUsuarios());
        service.crearUsuario(new Usuario("1", "A", "a@mail.com", "123"));
        service.crearUsuario(new Usuario("2", "B", "b@mail.com", "456"));
        assertEquals(2, service.contarUsuarios());
    }

    @Test
    void existeUsuarioDeberiaRetornarTrueSiExiste() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");
        service.crearUsuario(u);
        assertTrue(service.existeUsuario("1"));
    }

    @Test
    void existeUsuarioDeberiaRetornarFalseSiNoExiste() {
        assertFalse(service.existeUsuario("99"));
    }

    @Test
    void constructorYGettersFuncionanCorrectamente() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");
        assertEquals("1", u.getId());
        assertEquals("Anderson", u.getNombre());
        assertEquals("mail@mail.com", u.getEmail());
        assertEquals("1234", u.getPassword());
    }

    @Test
    void settersDeberianActualizarValores() {
        Usuario u = new Usuario("1", "Anderson", "mail@mail.com", "1234");

        u.setNombre("NuevoNombre");
        u.setEmail("nuevo@mail.com");
        u.setPassword("nuevaClave");

        assertEquals("NuevoNombre", u.getNombre());
        assertEquals("nuevo@mail.com", u.getEmail());
        assertEquals("nuevaClave", u.getPassword());
    }

    @Test
    void equalsYHashCodeFuncionanCorrectamente() {
        Usuario u1 = new Usuario("1", "Anderson", "a@mail.com", "1234");
        Usuario u2 = new Usuario("1", "Anderson", "a@mail.com", "1234");
        Usuario u3 = new Usuario("2", "Sebas", "s@mail.com", "5678");

        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
        assertNotEquals(u1, u3);
    }

    @Test
    void equalsConNullYDistintoTipoDevuelveFalse() {
        Usuario u = new Usuario("1", "Anderson", "a@mail.com", "1234");
        assertNotEquals(u, null);
        assertNotEquals(u, "un string");
    }

    @Test
    void toStringNoEsNull() {
        Usuario u = new Usuario("1", "Anderson", "a@mail.com", "1234");
        assertTrue(u.toString().contains("Usuario"));
    }
}

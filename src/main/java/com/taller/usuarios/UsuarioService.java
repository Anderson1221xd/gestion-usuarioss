package com.taller.usuarios;

import java.util.HashMap;
import java.util.Map;

public class UsuarioService {
    private final Map<String, Usuario> usuarios = new HashMap<>();

    public boolean crearUsuario(Usuario usuario) {
        if (usuario == null || usuario.getId() == null || usuarios.containsKey(usuario.getId())) {
            return false;
        }
        usuarios.put(usuario.getId(), usuario);
        return true;
    }

    public Usuario buscarUsuario(String id) {
        return usuarios.get(id);
    }

    public boolean eliminarUsuario(String id) {
        return usuarios.remove(id) != null;
    }

    public boolean actualizarEmail(String id, String nuevoEmail) {
        Usuario u = usuarios.get(id);
        if (u == null) return false;
        u.setEmail(nuevoEmail);
        return true;
    }

    public int contarUsuarios() {
        return usuarios.size();
    }
}

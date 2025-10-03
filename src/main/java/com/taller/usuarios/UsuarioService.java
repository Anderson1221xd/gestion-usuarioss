package com.taller.usuarios;

import java.util.HashMap;
import java.util.Map;

/** Servicio que gestiona usuarios en memoria. */
public class UsuarioService {
  /** Almacena los usuarios en memoria utilizando su id como clave. */
  private final Map<String, Usuario> usuarios = new HashMap<>();

  /**
   * Crea un nuevo usuario en el sistema.
   *
   * @param usuario usuario a crear
   * @return true si se creó correctamente, false si ya existe o es inválido
   */
  public boolean crearUsuario(final Usuario usuario) {
    if (usuario == null || usuario.getId() ==
            null || usuarios.containsKey(usuario.getId())) {
      return false;
    }
    usuarios.put(usuario.getId(), usuario);
    return true;
  }

  /**
   * Busca un usuario por su ID.
   *
   * @param id identificador único del usuario
   * @return usuario encontrado o null si no existe
   */
  public Usuario buscarUsuario(final String id) {
    if (id == null) {
      return null;
    }
    return usuarios.get(id);
  }

  /**
   * Elimina un usuario por su ID.
   *
   * @param id identificador único del usuario
   * @return true si fue eliminado, false si no existía
   */
  public boolean eliminarUsuario(final String id) {
    if (id == null) {
      return false;
    }
    return usuarios.remove(id) != null;
  }

  /**
   * Actualiza el email de un usuario.
   *
   * @param id identificador único del usuario
   * @param nuevoEmail nuevo email a asignar
   * @return true si se actualizó, false si el usuario no existe
   */
  public boolean actualizarEmail(final String id, final String nuevoEmail) {
    if (id == null || nuevoEmail == null) {
      return false;
    }
    Usuario usuario = usuarios.get(id);
    if (usuario == null) {
      return false;
    }
    usuario.setEmail(nuevoEmail);
    return true;
  }

  /**
   * Devuelve el número total de usuarios registrados.
   *
   * @return cantidad de usuarios
   */
  public int contarUsuarios() {
    return usuarios.size();
  }

  /**
   * Verifica si un usuario existe.
   *
   * @param id identificador único del usuario
   * @return true si existe, false en caso contrario
   */
  public boolean existeUsuario(final String id) {
    return usuarios.containsKey(id);
  }
}

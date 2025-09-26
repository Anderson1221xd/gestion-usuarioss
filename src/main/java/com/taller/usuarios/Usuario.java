package com.taller.usuarios;

import java.util.Objects;

/**
 * Clase que representa a un usuario dentro del sistema.
 */
public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String password;

    /**
     * Constructor para inicializar un usuario.
     *
     * @param id identificador único del usuario
     * @param nombre nombre del usuario
     * @param email correo electrónico del usuario
     * @param password contraseña del usuario
     */
    public Usuario(final String id, final String nombre,
                   final String email, final String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Compara si dos usuarios son iguales.
     *
     * @param obj objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) obj;
        return Objects.equals(id, usuario.id)
                && Objects.equals(nombre, usuario.nombre)
                && Objects.equals(email, usuario.email)
                && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, password);
    }

    @Override
    public String toString() {
        return "Usuario{"
                + "id='" + id + '\''
                + ", nombre='" + nombre + '\''
                + ", email='" + email + '\''
                + ", password='" + password + '\''
                + '}';
    }
}

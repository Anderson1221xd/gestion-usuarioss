package com.taller.usuarios;

import java.util.Objects;

/**
 * Representa a un usuario dentro del sistema.
 * Contiene la información básica como identificador,
 * nombre, correo electrónico y contraseña.
 */
public final class Usuario {

    /** Identificador único del usuario. */
    private String id;

    /** Nombre del usuario. */
    private String nombre;

    /** Correo electrónico del usuario. */
    private String email;

    /** Contraseña del usuario. */
    private String password;

    /**
     * Crea un nuevo usuario con los datos especificados.
     *
     * @param idUsuario identificador único del usuario
     * @param nombreUsuario nombre del usuario
     * @param emailUsuario correo electrónico del usuario
     * @param passwordUsuario contraseña del usuario
     */
    public Usuario(final String idUsuario, final String nombreUsuario,
                   final String emailUsuario, final String passwordUsuario) {
        this.id = idUsuario;
        this.nombre = nombreUsuario;
        this.email = emailUsuario;
        this.password = passwordUsuario;
    }

    /**
     * Obtiene el identificador único del usuario.
     *
     * @return id del usuario
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Actualiza el nombre del usuario.
     *
     * @param nuevoNombre nuevo nombre
     */
    public void setNombre(final String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    /**
     * Actualiza el correo electrónico del usuario.
     *
     * @param nuevoEmail nuevo correo
     */
    public void setEmail(final String nuevoEmail) {
        this.email = nuevoEmail;
    }

    /**
     * Actualiza la contraseña del usuario.
     *
     * @param nuevaPassword nueva contraseña
     */
    public void setPassword(final String nuevaPassword) {
        this.password = nuevaPassword;
    }

    /**
     * Compara si dos objetos son iguales basándose
     * en sus atributos.
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
        final Usuario usuario = (Usuario) obj;
        return Objects.equals(id, usuario.id)
                && Objects.equals(nombre, usuario.nombre)
                && Objects.equals(email, usuario.email)
                && Objects.equals(password, usuario.password);
    }

    /**
     * Calcula el hash del usuario en función
     * de sus atributos.
     *
     * @return código hash del usuario
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, password);
    }

    /**
     * Retorna una representación en cadena del usuario.
     *
     * @return representación en formato String
     */
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

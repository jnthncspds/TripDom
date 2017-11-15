package edu.itla.tripdom.Entity;

/**
 * Created by Jonathan on 13/11/2017.
 */

public class Usuario {
    private int id;
    private String nombre;
    private boolean tipoDeUsuario; //Si es verdadero es empresa, si es falso es un usuario corriente.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(boolean tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
}

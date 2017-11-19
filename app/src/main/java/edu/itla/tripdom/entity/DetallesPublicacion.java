package edu.itla.tripdom.entity;

/**
 * Created by Jonathan on 13/11/2017.
 */

public class DetallesPublicacion {
    private int id;
    private Publicacion publicacion;
    private String lugar;
    private String descripcion;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacionId) {
        this.publicacion = publicacionId;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

package edu.itla.tripdom.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonathan on 13/11/2017.
 */

public class Publicacion implements Serializable {
    private int id;
    private String fecha;
    private String descripcion;
    private double costo;
    private String estado;
    private int cupo;
    private Usuario user;
    private String Origen;
    private int userId; //Declaré una variable para almacenar el id de los usuarios, en caso de requerir interaccion entre tablas

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDetalle(List<DetallesPublicacion> detalle) {
        this.detalle = detalle;
    }

    List<DetallesPublicacion> detalle;

    public List<DetallesPublicacion> getDetalle() {
        return detalle;
    }


    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }


    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void addDetalle(DetallesPublicacion pd) {
        if (detalle== null){
            detalle = new ArrayList<>();
        }
        pd.setPublicacion(this);
        detalle.add(pd);
    }
}

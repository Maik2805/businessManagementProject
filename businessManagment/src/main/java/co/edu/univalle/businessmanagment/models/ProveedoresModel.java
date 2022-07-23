/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.businessmanagment.models;

import java.util.Date;

/**
 *
 * @author camilo
 */
public class ProveedoresModel {
    
    //Primary key
    private String identificacion;
    
    private String nombre;
    private Date fechaCreacion;
    private boolean isDeleted;

    //Constructores
    public ProveedoresModel() {
    }

    public ProveedoresModel(String identificacion) {
        this.identificacion = identificacion;
    }

    //Getter and Setter
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

   
    
    
}

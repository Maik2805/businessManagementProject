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
public class ClienteModel {
    
    //Primary key
    private String identificacion ;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Date fechaCreacion;
    private boolean isDeleted;

    //Contructores
    public ClienteModel() {
    }

    public ClienteModel(String identificacion) {
        this.identificacion = identificacion;
    }

    public ClienteModel(String intentificacion, String nombre) {
        this.identificacion = intentificacion;
        this.nombre = nombre;
    }

    //Getter and setter
    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String intentificacion) {
        this.identificacion = intentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "ClienteModel{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", fechaCreacion=" + fechaCreacion + ", isDeleted=" + isDeleted + '}';
    }

}

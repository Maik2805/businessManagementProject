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
public class ProductoModel {
    
    //Primary key
    private String idProducto;
    
    private String nombre;
    private double precioVentaBase;
    private String estado;
    private Date fechaCreacion;
    private boolean isDeleted;

    //Constructores 
    
    public ProductoModel() {
    }

    public ProductoModel(String idProducto) {
        this.idProducto = idProducto;
    }

    //Getter and Setter
    
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVentaBase() {
        return precioVentaBase;
    }

    public void setPrecioVentaBase(double precioVentaBase) {
        this.precioVentaBase = precioVentaBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
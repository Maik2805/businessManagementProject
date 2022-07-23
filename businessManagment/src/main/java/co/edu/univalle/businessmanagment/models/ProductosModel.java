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
public class ProductosModel {
    
    //Primary key
    private int idProducto;
    
    private String nombre;
    private double precioVentaBase;
    private String estado;
    private Date fechaCreacion;
    private boolean isDeleted;

    //Constructores 
    
    public ProductosModel() {
    }

    public ProductosModel(int idProducto) {
        this.idProducto = idProducto;
    }

    //Getter and Setter
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombre;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombre = nombreProducto;
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
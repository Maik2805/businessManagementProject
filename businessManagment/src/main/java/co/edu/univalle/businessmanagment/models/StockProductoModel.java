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
public class StockProductoModel {
    
    private String identificacion;
    
    private String identificacionLote;
    private String identificacionProducto;
    private int cantidadInicial;
    private int cantidadDisponible;
    private String estado;
    private Date fechaCreacion;
    private boolean isDeleted;

    //Constructores     
    public StockProductoModel() {
    }

    public StockProductoModel(String identificacion) {
        this.identificacion = identificacion;
    }
    
    //Getter and Setter
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacionLote() {
        return identificacionLote;
    }

    public void setIdentificacionLote(String identificacionLote) {
        this.identificacionLote = identificacionLote;
    }

    public String getIdentificacionProducto() {
        return identificacionProducto;
    }

    public void setIdentificacionProducto(String identificacionProducto) {
        this.identificacionProducto = identificacionProducto;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
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

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    
}

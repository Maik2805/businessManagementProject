/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.models;

import co.edu.univalle.businessmanagment.utils.UuidHelper;

/**
 *
 * @author miccarurb
 */
public class DetalleVentaModel {
    private String id_detalle;
    private VentaModel venta;
    private ProductoModel producto;
    private int cantidad;
    private double totalBruto;
    private double totalNeto;
    private double descuento;
    private boolean esMayorista;

    public DetalleVentaModel() {
        id_detalle = UuidHelper.generate();
    }

    public DetalleVentaModel(String id_detalle) {
        this.id_detalle = id_detalle;
    }

    public String getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(String id_detalle) {
        this.id_detalle = id_detalle;
    }

    public VentaModel getVenta() {
        return venta;
    }

    public void setVenta(VentaModel venta) {
        this.venta = venta;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(double totalBruto) {
        this.totalBruto = totalBruto;
    }

    public double getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public boolean isEsMayorista() {
        return esMayorista;
    }

    public void setEsMayorista(boolean esMayorista) {
        this.esMayorista = esMayorista;
    }
    
}

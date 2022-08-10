/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.models.virtuals;

/**
 *
 * @author miccarurb
 */
public class AvailableProductVModel {
    private int cantidadDisponible;
    private String idProducto;
    private String nombreProducto;
    private double precioVentaProducto;

    public AvailableProductVModel(int cantidadDisponible, String idProducto, String nombreProducto, Double precio) {
        this.cantidadDisponible = cantidadDisponible;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioVentaProducto = precio;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.models;

import java.util.Date;

/**
 *
 * @author miccarurb
 */
public class VentaModel {
    private String idVenta;
    private UsuarioModel usuario;
    private ClienteModel cliente;
    private double subtotal;
    private double totalIva;
    private double totalNeto;
    private double totalBruto;
    private double totalDescuento;
    private Date fechaCreacion;
    private boolean isDeleted;

    public VentaModel() {
    }

    public VentaModel(String id_venta, UsuarioModel usuario, ClienteModel cliente) {
        this.idVenta = id_venta;
        this.usuario = usuario;
        this.cliente = cliente;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String id_venta) {
        this.idVenta = id_venta;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(double totalIva) {
        this.totalIva = totalIva;
    }

    public double getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }

    public double getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(double totalBruto) {
        this.totalBruto = totalBruto;
    }

    public double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
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

    @Override
    public String toString() {
        return "VentaModel{" + "idVenta=" + idVenta + ", usuario=" + usuario + ", cliente=" + cliente + ", subtotal=" + subtotal + ", totalIva=" + totalIva + ", totalNeto=" + totalNeto + ", totalBruto=" + totalBruto + ", totalDescuento=" + totalDescuento + ", fechaCreacion=" + fechaCreacion + ", isDeleted=" + isDeleted + '}';
    }
    
    
    
}

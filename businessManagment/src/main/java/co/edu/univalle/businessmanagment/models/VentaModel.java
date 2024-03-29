/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.models;

import co.edu.univalle.businessmanagment.utils.UuidHelper;
import java.util.Date;
import java.util.List;

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
    private List<DetalleVentaModel> detalle;

    public VentaModel() {
        idVenta = UuidHelper.generate(6);
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

    public List<DetalleVentaModel> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleVentaModel> detalle) {
        this.detalle = detalle;
    }
    
    public void agregarDetalle(DetalleVentaModel detalle){
        this.detalle.add(detalle);
    }
    
    public void calcularTotales(){
        totalNeto = 0;
        totalBruto = 0;
        totalDescuento = 0;
        subtotal = 0;
        for (DetalleVentaModel detalleVenta : detalle) {
            subtotal += detalleVenta.getTotalBruto();
            totalBruto += detalleVenta.getTotalBruto() - detalleVenta.getDescuento() ;
            totalDescuento += detalleVenta.getDescuento();
            totalNeto += detalleVenta.getTotalNeto();
        }
        totalIva = subtotal * 0.19d;
        totalNeto += + totalIva;
    }

    @Override
    public String toString() {
        return "VentaModel{" + "idVenta=" + idVenta + ", usuario=" + usuario + ", cliente=" + cliente + ", subtotal=" + subtotal + ", totalIva=" + totalIva + ", totalNeto=" + totalNeto + ", totalBruto=" + totalBruto + ", totalDescuento=" + totalDescuento + ", fechaCreacion=" + fechaCreacion + ", isDeleted=" + isDeleted + '}';
    }
    
    
    
}

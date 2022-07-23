/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.businessmanagment.models;

/**
 *
 * @author camilo
 */
public class MateriaPrimaModel {
    
    //Primary key
    private String idMateriaPrima;
    
    private String idProveedor;
    private String nombre;
    private double cantidadDisponible;

    //Constructores

    public MateriaPrimaModel() {
    }

    public MateriaPrimaModel(String idMateriaPrima, String nombre) {
        this.idMateriaPrima = idMateriaPrima;
        this.nombre = nombre;
    }
    
    //Getter and Setter

    public String getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(String idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    
    
    
    
}

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
public class DetalleLoteModel {
    private String identificacion;
    
    private String identificacionLote;
    private String identificacionMateriaPrima;
    private int cantidadUtilizada;
    
    //Contructores
    public DetalleLoteModel() {
    }

    public DetalleLoteModel(String identificacion) {
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

    public String getIdentificacionMateriaPrima() {
        return identificacionMateriaPrima;
    }

    public void setIdentificacionMateriaPrima(String identificacionMateriaPrima) {
        this.identificacionMateriaPrima = identificacionMateriaPrima;
    }

    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(int cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }   
}

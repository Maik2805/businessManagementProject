/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.businessmanagment.views.tablemodels;

import co.edu.univalle.businessmanagment.models.ProveedorModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author camilo
 */
public class ProveedorTableModel extends AbstractTableModel {
    
    private String [] columnas;
    private List<ProveedorModel> proveedores;
    
    //Constructores

    public ProveedorTableModel () {
        super();
        proveedores = new ArrayList<>();
        columnas = new String [] {
            "Identificacion", "Nombre"
        };
    }

    public void setProveedorModel (List<ProveedorModel> proveedores) {
        this.proveedores = proveedores;
    }
    
    @Override
    public int getRowCount() {
        return proveedores.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        ProveedorModel proveedor = proveedores.get(row);
        switch (col) {
            case 0: return String.valueOf(proveedor.getIdentificacion());
            case 1: return String.valueOf(proveedor.getNombre());
            default: return null;
        }
    }
    
    public ProveedorModel getProveedorModelAt (int row) {
        return proveedores.get (row);
    }
    
    @Override
    public String getColumnName (int col) {
        return columnas [col];
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.views.tablemodels;

import co.edu.univalle.businessmanagment.models.DetalleVentaModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class DetalleVentaTableModel extends AbstractTableModel {

    private String[] columns;
    private List<DetalleVentaModel> detalles;

    public DetalleVentaTableModel() {
        super();
        detalles = new ArrayList<>();
        columns = new String[]{
            "Id Producto", "Nombre", "Cantidad", "Total Bruto", "Descuento", "Total"
        };
    }

    public void setDetalleVentaModels(List<DetalleVentaModel> detalles) {
        this.detalles = detalles;
    }

    @Override
    public int getRowCount() {
        return detalles.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        DetalleVentaModel detalle = detalles.get(row);
        switch (col) {
            case 0:
                return String.valueOf(detalle.getProducto().getIdProducto());
            case 1:
                return String.valueOf(detalle.getProducto().getNombre());
            case 2:
                return String.valueOf(detalle.getCantidad());
            case 3:
                return String.valueOf(detalle.getTotalBruto());
            case 4:
                return String.valueOf(detalle.getDescuento());
            case 5:
                return String.valueOf(detalle.getTotalNeto());
            default:
                return null;
        }
    }

    public DetalleVentaModel getDetalleVentaModelAt(int row) {
        return detalles.get(row);
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.views.tablemodels;

import co.edu.univalle.businessmanagment.models.ProductoModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ProductoTableModel extends AbstractTableModel {

    private String[] columns;
    private List<ProductoModel> productos;

    public ProductoTableModel() {
        super();
        productos = new ArrayList<>();
        columns = new String[]{
            "Identificador", "Nombre", "Precio Venta", "Estado"
        };
    }

    public void setProductoModels(List<ProductoModel> productos) {
        this.productos = productos;
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        ProductoModel producto = productos.get(row);
        switch (col) {
            case 0:
                return String.valueOf(producto.getIdProducto());
            case 1:
                return String.valueOf(producto.getNombre());
            case 2:
                return String.valueOf(producto.getPrecioVentaBase());
            case 3:
                return String.valueOf(producto.getEstado());
            default:
                return null;
        }
    }

    public ProductoModel getProductoModelAt(int row) {
        return productos.get(row);
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.views.tablemodels;

import co.edu.univalle.businessmanagment.models.ClienteModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miccarurb
 */
public class ClienteTableModel extends AbstractTableModel {

    private String[] columns;
    private List<ClienteModel> clientes;

    public ClienteTableModel() {
        super();
        clientes = new ArrayList<>();
        columns = new String[]{
            "Identificación", "Nombre", "Apellido", "Email", "Teléfono"
        };
    }

    public void setClienteModels(List<ClienteModel> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        ClienteModel cliente = clientes.get(row);
        switch (col) {
            case 0:
                return String.valueOf(cliente.getIdentificacion());
            case 1:
                return String.valueOf(cliente.getNombre());
            case 2:
                return String.valueOf(cliente.getApellido());
            case 3:
                return String.valueOf(cliente.getEmail());
            case 4:
                return String.valueOf(cliente.getTelefono());
            default:
                return null;
        }
    }

    public ClienteModel getClienteModelAt(int row) {
        return clientes.get(row);
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
}

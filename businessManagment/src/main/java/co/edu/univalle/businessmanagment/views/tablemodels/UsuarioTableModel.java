/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.views.tablemodels;

import co.edu.univalle.businessmanagment.models.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miccarurb
 */
public class UsuarioTableModel extends AbstractTableModel {

    private String[] columns;
    private List<UsuarioModel> usuarios;

    public UsuarioTableModel() {
        super();
        usuarios = new ArrayList<>();
        columns = new String[]{
            "Email", "Tipo Id.", "Identificación", "Nombre", "Apellido", "Teléfono"
        };
    }

    public void setUsuarioModels(List<UsuarioModel> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        UsuarioModel usuario = usuarios.get(row);
        switch (col) {
            case 0:
                return String.valueOf(usuario.getEmail());
            case 1:
                return String.valueOf(usuario.getTipoIdentificacion());
            case 2:
                return String.valueOf(usuario.getIdentificacion());
            case 3:
                return String.valueOf(usuario.getNombre());
            case 4:
                return String.valueOf(usuario.getApellido());
            case 5:
                return String.valueOf(usuario.getTelefono());
            default:
                return null;
        }
    }

    public UsuarioModel getUsuarioModelAt(int row) {
        return usuarios.get(row);
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
}

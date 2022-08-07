/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.UsuarioModel;
import co.edu.univalle.businessmanagment.services.UsuariosService;
import co.edu.univalle.businessmanagment.views.Dashboard;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author miccarurb
 */
public class UsuarioController {

    private static final Logger logger = LogManager.getLogger(UsuarioController.class);

    UsuariosService usuarioService;
    List<UsuarioModel> usuarios;
    UsuarioModel usuario;
    Dashboard vista;

    public UsuarioController(Dashboard view) {
        vista = view;
        usuarios = new ArrayList();
        usuarioService = new UsuariosService();
        nuevoUsuario();
        CargaUsuarios cargaUsuarios = new CargaUsuarios(null);
        cargaUsuarios.execute();
    }

//    public UsuarioController(UsuariosService usuarioService) {
//        this();
//        this.usuarioService = usuarioService;
//    }

    public void cargarUsuarios() {
        try {
            usuarios = usuarioService.getAllUsuarios();
            vista.setUsuariosTableData(usuarios);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }
    
    public void buscarUsuarios() {
        String filtro = ""; // Completar con el buscador de la vista
        try {
            usuarios = usuarioService.findUsuarioByEmailFilter(filtro);
            vista.setUsuariosTableData(usuarios);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public final UsuarioModel nuevoUsuario() {
        usuario = new UsuarioModel();
        return usuario;
    }
    
    public void guardarUsuario() {
        try {
            usuarioService.createOrUpdateUsuario(usuario);
        }catch (SQLException ex){
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "FATAL_ERROR :" + ex.getMessage());
        } 
        catch (Exception ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "ERROR :" + ex.getMessage());
        }
    }
    
    class CargaUsuarios extends SwingWorker<Boolean, Integer> {
        JLabel etiqueta;
        
        public CargaUsuarios(JLabel label){
            etiqueta = label;
        }
        @Override
        protected Boolean doInBackground() throws Exception {
                if(etiqueta != null) etiqueta.setText("Cargando");
                logger.info("CargaUsuarios en proceso;");
                cargarUsuarios();
            return true;
        }
        
        @Override
        protected void done() {
            if(etiqueta != null) etiqueta.setText("");
            logger.info("CargaUsuarios Finalizada;");
        }

    }

}

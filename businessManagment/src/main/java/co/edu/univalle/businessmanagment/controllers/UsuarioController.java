/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.UsuarioModel;
import co.edu.univalle.businessmanagment.services.UsuariosService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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


    public UsuarioController() {
        usuarios = new ArrayList();
        nuevoUsuario();
    }

    public UsuarioController(UsuariosService usuarioService) {
        this();
        this.usuarioService = usuarioService;
    }

    public void cargarUsuarios() {
        try {
            usuarios = usuarioService.getAllUsuarios();
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }
    
    public void buscarUsuarios() {
        String filtro = ""; // Completar con el buscador de la vista
        try {
            usuarios = usuarioService.findUsuarioByEmailFilter(filtro);
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

}

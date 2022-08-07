/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.UsuarioModel;
import co.edu.univalle.businessmanagment.services.UsuariosService;
import co.edu.univalle.businessmanagment.views.Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
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
        prepareListeners();
        new CargaUsuarios(null, "CARGA_USUARIOS").execute();
    }

//    public UsuarioController(UsuariosService usuarioService) {
//        this();
//        this.usuarioService = usuarioService;
//    }
    public void prepareListeners() {
        vista.addActionListenerBtnAddUsuario(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    CargaUsuarios carga = new CargaUsuarios(null, "CREAR_USUARIO");
                    carga.execute();
                    if (carga.get()) {
                        new CargaUsuarios(null, "CARGA_USUARIOS").execute();
                        nuevoUsuario();
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    logger.error(ex);
                }
            }
        });
        vista.addActionListenerBtnEditarUsuario(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (vista.getUsuarioSelectedOnUsuariosTable() != null) {
                        vista.setDatosUsuarioFromUsuario(vista.getUsuarioSelectedOnUsuariosTable());
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                }
            }
        });
        vista.addActionListenerBtnBorrarUsuario(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int confirmacionResult = JOptionPane.showConfirmDialog(vista, "Seguro que deseas borrar los usuarios selecionados?", "Warning", 0);
                    if (confirmacionResult == JOptionPane.YES_OPTION) {
                        if (vista.getUsuariosSelectedOnUsuariosTable().size() > 0) {
                            CargaUsuarios carga = new CargaUsuarios(null, "REMOVE_USUARIOS");
                            carga.execute();
                            if (carga.get()) {
                                new CargaUsuarios(null, "CARGA_USUARIOS").execute();
                            }
                        }
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                }
            }
        });
        vista.addActionListenerBtnBuscarUsuario(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (vista.getUsuariosFilterIdentificacion() != null && !vista.getUsuariosFilterIdentificacion().trim().isEmpty()) {
                        new CargaUsuarios(null, "BUSCAR_USUARIO").execute();
                    } else {
                        new CargaUsuarios(null, "CARGA_USUARIOS").execute();
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                }
            }
        });
    }

    public void cargarUsuarios() {
        try {
            usuarios = usuarioService.getAllUsuarios();
            vista.setUsuariosTableData(usuarios);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public void buscarUsuarios() {
        String filtro = vista.getUsuariosFilterIdentificacion();
        try {
            System.out.println("FILTRO: "+ filtro);
            usuarios = usuarioService.findUsuarioByFilter(filtro);
            System.out.println("RESULTADOS: "+ usuarios.size());
            vista.setUsuariosTableData(usuarios);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public final UsuarioModel nuevoUsuario() {
        usuario = new UsuarioModel();
        vista.setDatosUsuarioFromUsuario(usuario);
        return usuario;
    }

    public void leerUsuarioFromView() {
        usuario = vista.getUsuarioFromDatosUsuario();
    }

    public void guardarUsuario() {
        try {
            usuarioService.createOrUpdateUsuario(usuario);
        } catch (SQLException ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(vista, "FATAL_ERROR :" + ex.getMessage());
        } catch (Exception ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(vista, "ERROR :" + ex.getMessage());
        }
    }

    private void eliminarUsuariosSeleccionados() {
        try {
            for (UsuarioModel usuarioModel : vista.getUsuariosSelectedOnUsuariosTable()) {
                usuarioService.deleteUsuario(usuarioModel);
            }
            logger.info("Usuarios eliminados satisfactoriamente.");
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    class CargaUsuarios extends SwingWorker<Boolean, Integer> {

        JLabel etiqueta;
        String metodo = "";

        public CargaUsuarios(JLabel label, String method) {
            etiqueta = label;
            metodo = method;
        }

        @Override
        protected Boolean doInBackground() throws Exception {
            if (etiqueta != null) {
                etiqueta.setText("Cargando");
            }
            logger.info(String.format("CargaUsuarios[%s] en proceso", metodo));
            switch (metodo) {
                case "CARGA_USUARIOS":
                    cargarUsuarios();
                    break;
                case "CREAR_USUARIO":
                    leerUsuarioFromView();
                    guardarUsuario();
                    break;
                case "BUSCAR_USUARIO":
                    buscarUsuarios();
                    break;
                case "REMOVE_USUARIOS":
                    eliminarUsuariosSeleccionados();
                    break;
                default:
                    cargarUsuarios();

            }

            return true;
        }

        @Override
        protected void done() {
            if (etiqueta != null) {
                etiqueta.setText("");
            }
            logger.info(String.format("CargaUsuarios[%s] Finalizada", metodo));
        }

    }

}

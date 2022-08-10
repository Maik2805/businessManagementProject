/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.ProveedorModel;
import co.edu.univalle.businessmanagment.services.ProveedorService;
import co.edu.univalle.businessmanagment.views.Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author camilo
 */
public class ProveedorController {
    
    private static final Logger logger = LogManager.getLogger (ProveedorController.class);
    
    ProveedorService proveedorService;
    List<ProveedorModel> proveedores;
    ProveedorModel proveedor;
    Dashboard vista;
    
    //Constructores
    public ProveedorController (Dashboard view) {
        vista = view;
        proveedores = new ArrayList();
        proveedorService = new ProveedorService();
        nuevoProveedor();
        prepareListeners();
        new CargaProveedores(null, "CARGA_PROVEEDORES").execute();
    }

        
    //Métodos
    public void prepareListeners() {
        vista.addActionListenerBtnAddProveedor(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    CargaProveedores carga = new CargaProveedores(null, "CREAR_PROVEEDOR");
                    carga.execute();
                    if (carga.get()) {
                        new CargaProveedores(null, "CARGA_USUARIOS").execute();
                        nuevoProveedor();
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    logger.error(ex);
                }
            }
        });
        vista.addActionListenerBtnEditarProveedor(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (vista.getProveedorSelectedOnProveedoresTable() != null) {
                        vista.setDatosProveedorFromProveedor(vista.getProveedorSelectedOnProveedoresTable());
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                }
            }
        });
        vista.addActionListenerBtnBorrarProveedor(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int confirmacionResult = JOptionPane.showConfirmDialog(vista, "Seguro que deseas borrar los proveedores selecionados?", "Warning", 0);
                    if (confirmacionResult == JOptionPane.YES_OPTION) {
                        if (vista.getProveedoresSelectedOnProveedoresTable().size() > 0) {
                            CargaProveedores carga = new CargaProveedores(null, "REMOVE_PROVEEDORES");
                            carga.execute();
                            if (carga.get()) {
                                new CargaProveedores(null, "CARGA_PROVEEDORES").execute();
                            }
                        }
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                }
            }
        });
        vista.addActionListenerBtnBuscarProveedor(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (vista.getProveedoresFilterIdentificacion() != null && !vista.getProveedoresFilterIdentificacion().trim().isEmpty()) {
                        new CargaProveedores(null, "BUSCAR_PROVEEDORES").execute();
                    } else {
                        new CargaProveedores(null, "CARGA_PROVEEDORES").execute();
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                }
            }
        });
    }
    
    public void cargarProveedores () {
        try {
            proveedores = proveedorService.getAllProveedores();
            vista.setProveedoresTableData(proveedores);
        } catch (SQLException e) {
            logger.error(e);
        }
    }
    
    public void buscarProveedores() {
        String filtro = vista.getProveedoresFilterIdentificacion();
        try {
            System.out.println("FILTRO: "+ filtro);
            proveedores = proveedorService.findProveedorByFilter(filtro);
            System.out.println("RESULTADOS: "+ proveedores.size());
            vista.setProveedoresTableData(proveedores);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }
    
    public final ProveedorModel nuevoProveedor() {
        proveedor = new ProveedorModel();
        vista.setDatosProveedorFromProveedor(proveedor);
        return proveedor;
    }

    public void leerProveedorFromView() {
        proveedor = vista.getProveedorFromDatosUsuario();
    }

    public void guardarProveedor() {
        try {
            System.out.println("Se guarda el proveedor");
            proveedorService.createOrUpdateProveedor(proveedor);
        } catch (SQLException ex) {
            System.out.println("Error antes del logger.error del catch");
            logger.error(ex);
            CargaProveedores evento = new CargaProveedores(null, "SHOW_DIALOG");
            System.out.println("Error antes del fatal error");
            evento.setMessage("FATAL_ERROR :" + ex.getMessage());
            evento.execute();
        } catch (Exception ex) {
            logger.error(ex);
            CargaProveedores evento = new CargaProveedores(null, "SHOW_DIALOG");
            evento.setMessage("ERROR :" + ex.getMessage());
            evento.execute();
        }
    }

    private void eliminarProveedoresSeleccionados() {
        try {
            for (ProveedorModel proveedorModel : vista.getProveedoresSelectedOnProveedoresTable()) {
                proveedorService.deleteProveedor(proveedorModel);
            }
            logger.info("Proveedores eliminados satisfactoriamente.");
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    class CargaProveedores extends SwingWorker<Boolean, Integer> {

        JLabel etiqueta;
        String metodo = "";
        String message = "";

        public CargaProveedores (JLabel label, String method) {
            etiqueta = label;
            metodo = method;
        }

        public void setMessage(String message) {
            this.message = message;
        }
                
        @Override
        protected Boolean doInBackground() throws Exception {
            if (etiqueta != null) {
                etiqueta.setText("Cargando");
            }
            logger.info(String.format("CargaProveedores[%s] en proceso", metodo));
            switch (metodo) {
                case "CARGA_PROVEEDORES":
                    cargarProveedores();
                    break;
                case "CREAR_PROVEEDOR":
                    leerProveedorFromView();
                    guardarProveedor();
                    break;
                case "BUSCAR_PROVEEDOR":
                    buscarProveedores();
                    break;
                case "REMOVE_PROVEEDORES":
                    eliminarProveedoresSeleccionados();
                    break;
                case "SHOW_DIALOG":
                    JOptionPane.showMessageDialog(vista, message);
                    break;
                default:
                    cargarProveedores();

            }

            return true;
        }

        @Override
        protected void done() {
            if (etiqueta != null) {
                etiqueta.setText("");
            }
            logger.info(String.format("CargaProveedores[%s] Finalizada", metodo));
        }

    }
}

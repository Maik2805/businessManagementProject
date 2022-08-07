/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.ClienteModel;
import co.edu.univalle.businessmanagment.services.ClientesService;
import co.edu.univalle.businessmanagment.views.Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ClienteController {

    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    ClientesService clienteService;
    List<ClienteModel> clientes;
    ClienteModel cliente;
    Dashboard vista;

    public ClienteController(Dashboard view) {
        vista = view;
        clienteService = new ClientesService();
        clientes = new ArrayList();
        nuevoCliente();
        prepareListeners();
        CargaClientes cargaClientes = new CargaClientes(null, "CARGA_CLIENTES");
        cargaClientes.execute();
    }

//    public ClienteController(ClientesService clienteService) {
//        this();
//        this.clienteService = clienteService;
//    }
    public void prepareListeners() {
        vista.addActionListenerBtnAddCliente(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    CargaClientes carga = new CargaClientes(null, "CREAR_CLIENTE");
                    carga.execute();
                    if (carga.get()) {
                        new CargaClientes(null, "CARGA_CLIENTES").execute();
                        nuevoCliente();
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    logger.error(ex);
                }
            }
        });

        vista.addActionListenerBtnBuscarCliente(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (vista.getClienteFiltroIdentificacion() != null && !vista.getClienteFiltroIdentificacion().trim().isEmpty()) {
                    new CargaClientes(null, "BUSCAR_CLIENTE").execute();
                } else {
                    new CargaClientes(null, "CARGA_CLIENTES").execute();
                }

            }
        });
        
        vista.addActionListenerBtnEditarCliente(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (vista.getClienteSelectedOnClientesTable() != null) {
                        vista.setDatosClienteFromCliente(vista.getClienteSelectedOnClientesTable());
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                }

            }
        });
        
        vista.addActionListenerBtnBorrarCliente(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int confirmacionResult = JOptionPane.showConfirmDialog(vista, "Seguro que deseas borrar los clientes selecionados?", "Warning", 0);
                    if (confirmacionResult == JOptionPane.YES_OPTION) {
                        if (vista.getClientesSelectedOnClientesTable().size() > 0) {
                            CargaClientes carga = new CargaClientes(null, "REMOVE_CLIENTES");
                            carga.execute();
                            if (carga.get()) {
                                new CargaClientes(null, "CARGA_CLIENTES").execute();
                            }
                        }
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                }
            }
        });
    }

    public void cargarClientes() {
        try {
            clientes = clienteService.getAllClientes();
            vista.setClientesTableData(clientes);
        } catch (SQLException ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "FATAL_ERROR :" + ex.getMessage());
        } catch (Exception ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "ERROR :" + ex.getMessage());
        }
    }

    public void buscarClientes() {
        String filtro = vista.getClienteFiltroIdentificacion();
        try {
            clientes = clienteService.findClienteByIdentificationFilter(filtro);
            vista.setClientesTableData(clientes);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public void leerClienteFromView() {
        cliente = vista.getClienteFromDatosCliente();
    }

    public final ClienteModel nuevoCliente() {
        cliente = new ClienteModel();
        vista.setDatosClienteFromCliente(cliente);
        return cliente;
    }

    public void guardarCliente() {
        try {
            System.out.println(cliente);
            clienteService.createOrUpdateCliente(cliente);
        } catch (SQLException ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "FATAL_ERROR :" + ex.getMessage());
        } catch (Exception ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "ERROR :" + ex.getMessage());
        }
    }
    
    private void eliminarClientesSeleccionados(){
        try {
            for (ClienteModel clienteModel : vista.getClientesSelectedOnClientesTable()) {
                clienteService.deleteCliente(clienteModel);
            }
            logger.info("Clientes eliminados satisfactoriamente.");
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    class CargaClientes extends SwingWorker<Boolean, Integer> {

        JLabel etiqueta;
        String metodo = "";

        public CargaClientes(JLabel label, String method) {
            etiqueta = label;
            metodo = method;
        }

        @Override
        protected Boolean doInBackground() throws Exception {
            if (etiqueta != null) {
                etiqueta.setText("Cargando");
            }
            logger.info(String.format("CargaClientes[%s] en proceso", metodo));
            switch (metodo) {
                case "CARGA_CLIENTES":
                    cargarClientes();
                    break;
                case "CREAR_CLIENTE":
                    leerClienteFromView();
                    guardarCliente();
                    break;
                case "BUSCAR_CLIENTE":
                    buscarClientes();
                    break;
                case "REMOVE_CLIENTES":
                    eliminarClientesSeleccionados();
                    break;
                default:
                    cargarClientes();

            }
            return true;
        }

        @Override
        protected void done() {
            if (etiqueta != null) {
                etiqueta.setText("");
            }
            logger.info(String.format("CargaClientes[%s] Finalizada", metodo));
        }

    }

}

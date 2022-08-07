/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.ClienteModel;
import co.edu.univalle.businessmanagment.services.ClientesService;
import co.edu.univalle.businessmanagment.views.Dashboard;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        CargaClientes cargaClientes = new CargaClientes(null);
        cargaClientes.execute();
    }

//    public ClienteController(ClientesService clienteService) {
//        this();
//        this.clienteService = clienteService;
//    }

    public void cargarClientes() {
        try {
            clientes = clienteService.getAllClientes();
            vista.setClientesTableData(clientes);
        } catch (SQLException ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "FATAL_ERROR :" + ex.getMessage());
        } catch (Exception ex){
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "ERROR :" + ex.getMessage());
        }
    }
    
    public void buscarClientes() {
        String filtro = ""; // Completar con el buscador de la vista
        try {
            clientes = clienteService.findClienteByIdentificationFilter(filtro);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public final ClienteModel nuevoCliente() {
        cliente = new ClienteModel();
        return cliente;
    }
    
    public void guardarCliente() {
        try {
            clienteService.createOrUpdateCliente(cliente);
        }catch (SQLException ex){
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "FATAL_ERROR :" + ex.getMessage());
        } 
        catch (Exception ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "ERROR :" + ex.getMessage());
        }
    }
    
    class CargaClientes extends SwingWorker<Boolean, Integer> {
        JLabel etiqueta;
        
        public CargaClientes(JLabel label){
            etiqueta = label;
        }
        @Override
        protected Boolean doInBackground() throws Exception {
                if(etiqueta != null) etiqueta.setText("Cargando");
                logger.info("CargaClientes en proceso;");
                cargarClientes();
            return true;
        }
        
        @Override
        protected void done() {
            if(etiqueta != null) etiqueta.setText("");
            logger.info("CargaClientes Finalizada;");
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.ClienteModel;
import co.edu.univalle.businessmanagment.services.ClientesService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class ClienteController {

    private static final Logger logger = LogManager.getLogger(ClienteController.class);

    ClientesService clienteService;
    List<ClienteModel> clientes;
    ClienteModel cliente;


    public ClienteController() {
        clientes = new ArrayList();
        nuevoCliente();
    }

    public ClienteController(ClientesService clienteService) {
        this();
        this.clienteService = clienteService;
    }

    public void cargarClientes() {
        try {
            clientes = clienteService.getAllClientes();
        } catch (SQLException ex) {
            logger.error(ex);
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

}

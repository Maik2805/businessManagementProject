/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.ProveedorModel;
import co.edu.univalle.businessmanagment.services.ProveedorService;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    
    //Constructores
    public ProveedorController () {
        proveedores = new ArrayList();
        nuevoProveedor();
    }

    public ProveedorController(ProveedorService proveedorService) {
        this();
        this.proveedorService = proveedorService;
    }
        
    //Métodos
    public void cargarProveedores () {
        try {
            proveedores = proveedorService.getAllProveedores();
        } catch (SQLException e) {
            logger.error(e);
        }
    }
    
    public void buscarProveedores () {
        String filtro = ""; 
        try {
            proveedores = proveedorService.findProveedorByIdentificacionFilter(filtro);
        } catch (SQLException e) {
            logger.error(e);
        }
    }
    
    public ProveedorModel nuevoProveedor () {
        proveedor = new ProveedorModel();
        return proveedor;
    }
    
    public void guardarProveedor () {
        try {
            proveedorService.createOrUpdateProveedor(proveedor);
        } catch (SQLException e) {
            logger.error(e);
            JOptionPane.showMessageDialog(null, "FATAL_ERROR :" + e.getMessage());
        } catch (Exception e) {
            logger.error(e);
            JOptionPane.showMessageDialog(null, "FATAL_ERROR :" + e.getMessage());
        }
    }
}

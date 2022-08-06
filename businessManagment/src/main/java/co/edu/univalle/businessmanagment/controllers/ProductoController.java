/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.ProductoModel;
import co.edu.univalle.businessmanagment.services.ClientesService;
import co.edu.univalle.businessmanagment.services.ProductosService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class ProductoController {

    private static final Logger logger = LogManager.getLogger(ProductoController.class);

    ProductosService productoService;
    List<ProductoModel> productos;
    ProductoModel producto;


    public ProductoController() {
        productos = new ArrayList();
        nuevoCliente();
    }

    public ProductoController(ProductosService productoService) {
        this();
        this.productoService = productoService;
    }

    public void cargarClientes() {
        try {
            productos = productoService.getAllProductos();
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public final ProductoModel nuevoCliente() {
        producto = new ProductoModel();
        return producto;
    }
    
    public void guardarCliente() {
        try {
            productoService.createOrUpdateProducto(producto);
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

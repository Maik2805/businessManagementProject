/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.ClienteModel;
import co.edu.univalle.businessmanagment.models.DetalleVentaModel;
import co.edu.univalle.businessmanagment.models.ProductoModel;
import co.edu.univalle.businessmanagment.models.UsuarioModel;
import co.edu.univalle.businessmanagment.models.VentaModel;
import co.edu.univalle.businessmanagment.services.ClientesService;
import co.edu.univalle.businessmanagment.services.ProductosService;
import co.edu.univalle.businessmanagment.services.StockService;
import co.edu.univalle.businessmanagment.services.UsuariosService;
import co.edu.univalle.businessmanagment.services.VentasService;
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
public class VentaController {

    private static final Logger logger = LogManager.getLogger(VentaController.class);

    VentasService ventaService;
    UsuariosService usuarioService;
    ClientesService clienteService;
    ProductosService productosService;
    StockService stockService;
    VentaModel venta;
    List<UsuarioModel> usuarios;
    List<ProductoModel> productos;
    List<ClienteModel> clientes;

    public VentaController() {
        usuarios = new ArrayList();
        productos = new ArrayList();
        clientes = new ArrayList();
        iniciarVenta();
    }

    public VentaController(VentasService ventaService, UsuariosService usuarioService,
            ClientesService clienteService, ProductosService productosService, StockService stockService) {
        this();
        this.ventaService = ventaService;
        this.usuarioService = usuarioService;
        this.clienteService = clienteService;
        this.productosService = productosService;
        this.stockService = stockService;
    }

    public void cargarClientes() {
        try {
            clientes = clienteService.getAllClientes();
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public void cargarProductos() {
        try {
            productos = productosService.getAllProductos();
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public void cargarUsuarios() {
        try {
            usuarios = usuarioService.getAllUsuarios();
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public final VentaModel iniciarVenta() {
        venta = new VentaModel();
        venta.setDetalle(new ArrayList<>());
        return venta;
    }

    public void calcularTotales(){
        venta.calcularTotales();
    }
    
    public void agregarProducto(ProductoModel producto, int cantidad) {
        int cantidadDisponible;
        try {
            cantidadDisponible = stockService.cantidadProductosDisponibles(producto);

            if (cantidadDisponible <= cantidad) {
                DetalleVentaModel detalle = new DetalleVentaModel();
                detalle.setProducto(producto);
                detalle.setCantidad(cantidad);
                detalle.setTotalBruto(producto.getPrecioVentaBase() * cantidad);
                venta.agregarDetalle(detalle);
                venta.calcularTotales();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR: : Cantidad de " + producto.getNombre() + " insuficiente."
                        + "Hay " + cantidadDisponible + " Und.");
            }
        } catch (Exception ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "FATAL_ERROR: " + ex.getMessage());
        }
    }

    public void guardarVenta() {
        try {
            ventaService.createVenta(venta);
            for (DetalleVentaModel detalleVentaModel : venta.getDetalle()) {
                ventaService.createDetalleVenta(venta.getIdVenta(), detalleVentaModel);
            }
        } catch (Exception ex) {
            logger.error(ex);
            JOptionPane.showMessageDialog(null, "FATAL_ERROR :" + ex.getMessage());
        }
    }

}

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
import co.edu.univalle.businessmanagment.models.virtuals.AvailableProductVModel;
import co.edu.univalle.businessmanagment.services.ClientesService;
import co.edu.univalle.businessmanagment.services.ProductosService;
import co.edu.univalle.businessmanagment.services.StockService;
import co.edu.univalle.businessmanagment.services.UsuariosService;
import co.edu.univalle.businessmanagment.services.VentasService;
import co.edu.univalle.businessmanagment.views.Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    List<AvailableProductVModel> productosStock;
    Dashboard vista;

    public VentaController(Dashboard view) {
        usuarios = new ArrayList();
        productos = new ArrayList();
        clientes = new ArrayList();
        productosStock = new ArrayList();
        ventaService = new VentasService();
        usuarioService = new UsuariosService();
        clienteService = new ClientesService();
        productosService = new ProductosService();
        stockService = new StockService();
        
        vista = view;
        iniciarVenta();
        prepareListeners();
        new CargaVentas(null,"CARGAR_USUARIOS_VENTA").execute();
        new CargaVentas(null,"CARGAR_CLIENTES_VENTA").execute();
        new CargaVentas(null,"CARGA_PRODUCTOS_VENTA").execute();
    }

//    public VentaController(VentasService ventaService, UsuariosService usuarioService,
//            ClientesService clienteService, ProductosService productosService, StockService stockService) {
//        this();
//        this.ventaService = ventaService;
//        this.usuarioService = usuarioService;
//        this.clienteService = clienteService;
//        this.productosService = productosService;
//        this.stockService = stockService;
//    }
    
    public void prepareListeners(){
        vista.addActionListenerListProductoVenta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = vista.getListProductoVentaIndexSelected();
                if(index != -1){
                    String valorProducto = String.valueOf(productosStock.get(index).getPrecioVentaProducto());
                    vista.setValorProductoVenta(valorProducto);
                }
            }
        });
    }

    public void cargarClientes() {
        try {
            clientes = clienteService.getAllClientes();
            vista.setClientesVentasList(clientes);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public void cargarProductos() {
        try {
//            productos = productosService.getAllProductos();
            productosStock = stockService.obtenerStock();
            vista.setProductosVentasList(productosStock);
            if(productosStock.size() > 0){
                String valor = String.valueOf(productosStock.get(0).getPrecioVentaProducto());
                vista.setValorProductoVenta(valor);
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public void cargarUsuarios() {
        try {
            usuarios = usuarioService.getAllUsuarios();
            vista.setUsuariosVentasList(usuarios);
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
    
    class CargaVentas extends SwingWorker<Boolean, Integer> {

        JLabel etiqueta;
        String metodo = "";
        String message = "";

        public CargaVentas(JLabel label, String method) {
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
            logger.info(String.format("CargaProductos[%s] en proceso", metodo));
            switch (metodo) {
                case "CARGAR_USUARIOS_VENTA":
                    cargarUsuarios();
                    break;
                case "CARGAR_CLIENTES_VENTA":
                    cargarClientes();
                    break;
                case "CARGA_PRODUCTOS_VENTA":
                    cargarProductos();
                    break;
                case "CREAR_VENTA":
//                    leerProductoFromView();
//                    guardarProducto();
                    break;
                case "BUSCAR_VENTAS":
//                    buscarProductos();
                    break;
                case "REMOVE_VENTAS":
//                    eliminarProductosSeleccionados();
                    break;
                case "SHOW_DIALOG":
                    JOptionPane.showMessageDialog(vista, message);
                    break;
                default:
                    cargarProductos();

            }
            return true;
        }

        @Override
        protected void done() {
            if (etiqueta != null) {
                etiqueta.setText("");
            }
            logger.info(String.format("CargaProductos[%s] Finalizada", metodo));
        }

    }

}

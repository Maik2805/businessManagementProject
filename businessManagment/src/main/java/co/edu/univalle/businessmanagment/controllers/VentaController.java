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
    DetalleVentaModel detalleVenta;
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
        detalleVenta = new DetalleVentaModel();

        vista = view;
        iniciarVenta();
        newDetalleVenta();
        prepareListeners();
        new CargaVentas(null, "CARGAR_USUARIOS_VENTA").execute();
        new CargaVentas(null, "CARGAR_CLIENTES_VENTA").execute();
        new CargaVentas(null, "CARGA_PRODUCTOS_VENTA").execute();
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
    public void prepareListeners() {
        vista.addActionListenerListProductoVenta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = vista.getListProductoVentaIndexSelected();
                if (index != -1) {
                    String valorProducto = String.valueOf(productosStock.get(index).getPrecioVentaProducto());
                    vista.setValorProductoVenta(valorProducto);
                }
            }
        });
        
        vista.addActionListenerTxtCantidadDeseadaProducto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                calcularTotalesProductoVenta();
            }
        });
        vista.addActionListenerTxtTotalDescuento(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                calcularTotalesProductoVenta();
            }
        });
        vista.addActionListenerBtnAddVenta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CargaVentas(null,"AGREGAR_PRODUCTO") .execute();
            }
        });
        vista.addActionListenerBtnGuardarVenta(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CargaVentas(null,"GUARDAR_VENTA") .execute();
            }
        });
        
                
        vista.addActionListenerBtnRefrescarVentas(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CargaVentas carga = new CargaVentas(null, "REFRESH_ALL_VENTA");
                carga.execute();
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
            if (productosStock.size() > 0) {
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
    
    public ClienteModel getClienteSelected() throws Exception{
        int index =  vista.getClienteVentaIndex();
        if (index != -1) {
            return clientes.get(index);
        }else{
            if (clientes.size() > 0) {
               return  clientes.get(0);
            }
            throw new Exception("Cliente no seleccionado");
        }
    }
    
    public UsuarioModel getUsuarioSelected() throws Exception{
        int index =  vista.getUsuarioVentaIndex();
        if (index != -1) {
            return usuarios.get(index);
        }else{
            if (usuarios.size() > 0) {
               return  usuarios.get(0);
            }
            throw new Exception("Usuario no seleccionado");
        }
    }

    public AvailableProductVModel getProductoStockFromView() {
        int index = vista.getListProductoVentaIndexSelected();
        if (index != -1) {
            return productosStock.get(index);
        } else {
            CargaVentas carga = new CargaVentas(null, "SHOW_DIALOG");
            carga.setMessage("ERROR: Ningún Producto Seleccionado");
            carga.execute();
            return null;
        }
    }
    
    public void getDetalleVentaFromView() throws Exception{
        detalleVenta = new DetalleVentaModel();
        int index = vista.getListProductoVentaIndexSelected();
            if (index != -1) {
                AvailableProductVModel productoStock = productosStock.get(index);
                detalleVenta.setCantidad(vista.getCantidadProductoDeseado());
                detalleVenta.setTotalBruto(vista.getCantidadProductoDeseado() * productoStock.getPrecioVentaProducto());
                detalleVenta.setDescuento(vista.getTotalDescuentoProducto());
                detalleVenta.setTotalNeto(detalleVenta.getTotalBruto() - detalleVenta.getDescuento());
            }
    }
    
    public void setDetalleVentaInView(){
        vista.setTotalesProductoFromDetalle(detalleVenta);
    }
    
    public void setDetalleVentaTableData(){
        vista.setDetalleVentaTableData(venta.getDetalle());
    }

    public final VentaModel iniciarVenta() {
        venta = new VentaModel();
        venta.setDetalle(new ArrayList<>());
        vista.setTxtIdVenta(venta.getIdVenta());
        setDetalleVentaTableData();
        setDetalleVentaInView();
        vista.setTotalVenta(venta);
        return venta;
    }

    public void newDetalleVenta(){
        detalleVenta = new DetalleVentaModel();
        setDetalleVentaInView();
    }
    public void calcularTotales() {
        venta.calcularTotales();
        vista.setTotalVenta(venta);
    }

    public void calcularTotalesProductoVenta() {
        try {
            getDetalleVentaFromView();
            setDetalleVentaInView();
//            AvailableProductVModel productoStock = getProductoStockFromView
        } catch (Exception ex) {
            logger.info("No se pudo calcular el total");
            logger.error(ex);
        }
    }

    public void agregarProducto() {
        int cantidadDisponible;
        AvailableProductVModel productoStock = getProductoStockFromView();
        if (productoStock != null) {
            try {
                ProductoModel producto = new ProductoModel();
                producto.setIdProducto(productoStock.getIdProducto());
                producto.setNombre(productoStock.getNombreProducto());
                int cantidadDeseada = vista.getCantidadProductoDeseado();
                cantidadDisponible = stockService.cantidadProductosDisponibles(producto.getIdProducto());
                if (cantidadDisponible >= cantidadDeseada) {
                    calcularTotalesProductoVenta();
                    detalleVenta.setProducto(producto);
//                    detalleVenta.setCantidad(cantidadDeseada);
//                    detalleVenta.setTotalBruto(producto.getPrecioVentaBase() * cantidadDeseada);
                    venta.agregarDetalle(detalleVenta);
                    venta.calcularTotales();
                    newDetalleVenta();
                } else {
                    CargaVentas carga = new CargaVentas(null, "SHOW_DIALOG");
                    carga.setMessage("ERROR: : Cantidad de producto insuficiente."
                            + "Hay " + cantidadDisponible + " Und.");
                    carga.execute();
                }
            } catch (Exception ex) {
                logger.error(ex);
                CargaVentas carga = new CargaVentas(null, "SHOW_DIALOG");
                carga.setMessage("ERROR: " + ex.getMessage());
                carga.execute();
            }

        }
    }

    public void guardarVenta() {
        try {
            calcularTotales();
            venta.setCliente(getClienteSelected());
            venta.setUsuario(getUsuarioSelected());
            ventaService.createVenta(venta);
            for (DetalleVentaModel detalleVentaModel : venta.getDetalle()) {
                ventaService.createDetalleVenta(venta.getIdVenta(), detalleVentaModel);
            }
            iniciarVenta();
            CargaVentas carga = new CargaVentas(null, "SHOW_DIALOG");
            carga.setMessage("Venta Guardada Satisfactoriamente");
            carga.execute();
        } catch (Exception ex) {
            logger.info(ex);
            CargaVentas carga = new CargaVentas(null, "SHOW_DIALOG");
            carga.setMessage("FATAL_ERROR :" + ex.getMessage());
            carga.execute();
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
                case "GUARDAR_VENTA":
                    guardarVenta();
                    break;
                case "AGREGAR_PRODUCTO":
                    agregarProducto();
                    setDetalleVentaTableData();
                    calcularTotales();
                    break;
                case "REFRESH_ALL_VENTA":
                    cargarProductos();
                    cargarUsuarios();
                    cargarClientes();
                    calcularTotalesProductoVenta();
                    calcularTotales();
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

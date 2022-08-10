/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.ProductoModel;
import co.edu.univalle.businessmanagment.services.ProductosService;
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

public class ProductoController {

    private static final Logger logger = LogManager.getLogger(ProductoController.class);

    ProductosService productoService;
    List<ProductoModel> productos;
    ProductoModel producto;
    Dashboard vista;

    public ProductoController(Dashboard view) {
        vista = view;
        productos = new ArrayList();
        productoService = new ProductosService();
        nuevoProducto();
        prepareListeners();
        CargaProductos cargaProductos = new CargaProductos(null, "CARGA_PRODUCTOS");
        cargaProductos.execute();
    }

//    public ProductoController(ProductosService productoService) {
//        this();
//        this.productoService = productoService;
//    }
    public void prepareListeners() {
        vista.addActionListenerBtnAddProducto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    CargaProductos carga = new CargaProductos(null, "CREAR_PRODUCTO");
                    carga.execute();
                    if (carga.get()) {
                        new CargaProductos(null, "CARGA_PRODUCTOS").execute();
                        nuevoProducto();
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    logger.error(ex);
                }
            }
        });

        vista.addActionListenerBtnBuscarProducto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CargaProductos carga = new CargaProductos(null, "BUSCAR_PRODUCTOS");
                carga.execute();

            }
        });
        
        vista.addActionListenerBtnBorrarProducto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int confirmacionResult = JOptionPane.showConfirmDialog(vista, "Seguro que deseas borrar los Productos selecionados?", "Warning", 0);
                    if (confirmacionResult == JOptionPane.YES_OPTION) {
                        CargaProductos carga = new CargaProductos(null, "REMOVE_PRODUCTOS");
                        carga.execute();
                        if(carga.get()){
                            new CargaProductos(null, "BUSCAR_PRODUCTOS").execute();
                        }
                    }
                } catch (InterruptedException | ExecutionException ex) {
                    
                }

            }
        });
        
        vista.addActionListenerBtnEditarProducto(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (vista.getProductoSelectedOnProductosTable()!= null) {
                        vista.setDatosProductoFromProducto(vista.getProductoSelectedOnProductosTable());
                    }
                } catch (Exception ex) {
                    logger.error(ex);
                }

            }
        });
    }

    public void cargarProductos() {
        try {
            productos = productoService.getAllProductos();
            vista.setProductosTableData(productos);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            logger.error(ex);
        }
    }
    
    public void buscarProductos(){
        String filtro = vista.getProductosFilter();
        try {
            productos = productoService.getProductosByFiltro(filtro);
            vista.setProductosTableData(productos);
        } catch (SQLException ex) {
            logger.error(ex);
        }
    }

    public final ProductoModel nuevoProducto() {
        try {
            producto = new ProductoModel();
            vista.setDatosProductoFromProducto(producto);
        } catch (Exception ex) {
            CargaProductos evento = new CargaProductos(null, "SHOW_DIALOG");
            evento.setMessage("ERROR :" + ex.getMessage());
            evento.execute();
        }
        return producto;
    }

    public void leerProductoFromView() {
        try {
            producto = vista.getProductoFromDatosProducto();
            logger.info("Producto leido: " + producto.getIdProducto());
        } catch (Exception ex) {
            CargaProductos evento = new CargaProductos(null, "SHOW_DIALOG");
            evento.setMessage("ERROR :" + ex.getMessage());
            evento.execute();
        }
    }

    public void guardarProducto() {
        try {
            productoService.createOrUpdateProducto(producto);
        } catch (SQLException ex) {
            logger.info(ex);
            CargaProductos evento = new CargaProductos(null, "SHOW_DIALOG");
            evento.setMessage("FATAL_ERROR :" + ex.getMessage());
            evento.execute();
        } catch (Exception ex) {
            logger.info(ex);
            CargaProductos evento = new CargaProductos(null, "SHOW_DIALOG");
            evento.setMessage("ERROR :" + ex.getMessage());
            evento.execute();
        }
    }
    
    private void eliminarProductosSeleccionados(){
        try {
            for (ProductoModel productoModel : vista.getProductosSelectedOnProductosTable()) {
                productoService.deleteProducto(productoModel);
            }
            logger.info("Productos eliminados satisfactoriamente.");
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    class CargaProductos extends SwingWorker<Boolean, Integer> {

        JLabel etiqueta;
        String metodo = "";
        String message = "";

        public CargaProductos(JLabel label, String method) {
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
                case "CARGA_PRODUCTOS":
                    cargarProductos();
                    break;
                case "CREAR_PRODUCTO":
                    leerProductoFromView();
                    guardarProducto();
                    break;
                case "BUSCAR_PRODUCTOS":
                    buscarProductos();
                    break;
                case "REMOVE_PRODUCTOS":
                    eliminarProductosSeleccionados();
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

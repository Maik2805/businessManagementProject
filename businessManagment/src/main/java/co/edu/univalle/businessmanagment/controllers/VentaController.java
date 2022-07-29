/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.controllers;

import co.edu.univalle.businessmanagment.models.DetalleVentaModel;
import co.edu.univalle.businessmanagment.models.ProductoModel;
import co.edu.univalle.businessmanagment.models.VentaModel;
import co.edu.univalle.businessmanagment.services.ClientesService;
import co.edu.univalle.businessmanagment.services.ProductosService;
import co.edu.univalle.businessmanagment.services.UsuariosService;
import co.edu.univalle.businessmanagment.services.VentasService;
import java.util.ArrayList;

/**
 *
 * @author miccarurb
 */
public class VentaController {
    VentasService ventaService;
    UsuariosService usuarioService;
    ClientesService clienteService;
    ProductosService productosService;
    VentaModel venta;

    public VentaController() {
        iniciarVenta();
    }
    
    public VentaController(VentasService ventaService, UsuariosService usuarioService, ClientesService clienteService, ProductosService productosService) {
        this.ventaService = ventaService;
        this.usuarioService = usuarioService;
        this.clienteService = clienteService;
        this.productosService = productosService;
        iniciarVenta();
    }
    
    public final VentaModel iniciarVenta(){
        venta = new VentaModel();
        venta.setDetalle(new ArrayList<>());
        return venta;
    }
    
    public void agregarProducto(ProductoModel producto, int cantidad){
        if (productosService.cantidadProductosDisponibles(producto) <= cantidad) {
            DetalleVentaModel detalle = new DetalleVentaModel();
            detalle.setProducto(producto);
            detalle.setCantidad(cantidad);
            detalle.setTotalBruto(producto.getPrecioVentaBase() * cantidad);
            venta.agregarDetalle(detalle);
            venta.calcularTotales();
        }
 
    }
    
}

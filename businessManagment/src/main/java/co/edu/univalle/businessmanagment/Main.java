/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment;

import co.edu.univalle.businessmanagment.controllers.ClienteController;
import co.edu.univalle.businessmanagment.controllers.ProductoController;
import co.edu.univalle.businessmanagment.controllers.ProveedorController;
import co.edu.univalle.businessmanagment.controllers.UsuarioController;
import co.edu.univalle.businessmanagment.controllers.VentaController;
import co.edu.univalle.businessmanagment.views.Dashboard;
import co.edu.univalle.businessmanagment.views.SplashScreen;

/**
 *
 * @author miccarurb
 */
public class Main {
    
    public static void main(String[] args) {
        Dashboard home = new Dashboard();
        SplashScreen initialView = new SplashScreen(home);
        initialView.loadSplashScreen(home);
        ClienteController clienteController = new ClienteController(home);
        UsuarioController usuarioController = new UsuarioController(home);
        ProductoController productoController = new ProductoController(home);
        VentaController ventaController = new VentaController(home);
        ProveedorController proveedorController = new ProveedorController(home);
//        home.setTitle("Sistema de Gestión");
//        home.setVisible(true);
    }
    
}

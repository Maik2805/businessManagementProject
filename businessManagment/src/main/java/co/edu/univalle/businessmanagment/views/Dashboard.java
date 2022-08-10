/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.univalle.businessmanagment.views;

import co.edu.univalle.businessmanagment.models.ClienteModel;
import co.edu.univalle.businessmanagment.models.DetalleVentaModel;
import co.edu.univalle.businessmanagment.models.ProductoModel;
import co.edu.univalle.businessmanagment.models.UsuarioModel;
import co.edu.univalle.businessmanagment.models.VentaModel;
import co.edu.univalle.businessmanagment.models.virtuals.AvailableProductVModel;
import co.edu.univalle.businessmanagment.views.tablemodels.ClienteTableModel;
import co.edu.univalle.businessmanagment.views.tablemodels.DetalleVentaTableModel;
import co.edu.univalle.businessmanagment.views.tablemodels.ProductoTableModel;
import co.edu.univalle.businessmanagment.views.tablemodels.UsuarioTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Alejandra
 */
public class Dashboard extends javax.swing.JFrame {

    private static final Logger logger = LogManager.getLogger(Dashboard.class);
    ClienteTableModel clientesTableModel;
    UsuarioTableModel usuariosTableModel;
    ProductoTableModel productosTableModel;
    DetalleVentaTableModel detallesVentaTableModel;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        clientesTableModel = new ClienteTableModel();
        usuariosTableModel = new UsuarioTableModel();
        productosTableModel = new ProductoTableModel();
        detallesVentaTableModel = new DetalleVentaTableModel();
        initComponents();
    }

    public void setClientesTableData(List<ClienteModel> clientes) {
        clientesTableModel.setClienteModels(clientes);
        clientesTableModel.fireTableDataChanged();
    }

    public void setUsuariosTableData(List<UsuarioModel> usuarios) {
        usuariosTableModel.setUsuarioModels(usuarios);
        usuariosTableModel.fireTableDataChanged();
    }
    
    public void setProductosTableData(List<ProductoModel> productos){
        productosTableModel.setProductoModels(productos);
        productosTableModel.fireTableDataChanged();
    }
    
    public void setDetalleVentaTableData(List<DetalleVentaModel> detalles){
        detallesVentaTableModel.setDetalleVentaModels(detalles);
        detallesVentaTableModel.fireTableDataChanged();
    }

    /* =========== USUARIOS IMPL ===========  */
    public UsuarioModel getUsuarioFromDatosUsuario() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setEmail(txtEmailUsuario.getText());
        usuario.setNombre(txtNombreUsuario.getText());
        usuario.setApellido(txtApellidoUsuario.getText());
        usuario.setIdentificacion(txtIdentificacionUsuario.getText());
        usuario.setTipoIdentificacion((String) listTipoIdentificacionUsuario.getSelectedItem());
        usuario.setTelefono(txtTelefonoUsuario.getText());
        return usuario;
    }

    public void setDatosUsuarioFromUsuario(UsuarioModel usuario) {
        txtEmailUsuario.setText(usuario.getEmail());
        txtNombreUsuario.setText(usuario.getNombre());
        txtApellidoUsuario.setText(usuario.getApellido());
        txtIdentificacionUsuario.setText(usuario.getIdentificacion());
        txtTelefonoUsuario.setText(usuario.getTelefono());
    }

    public void addActionListenerBtnAddUsuario(ActionListener listener) {
        btnAddUsuario.addActionListener(listener);
    }

    public void addActionListenerBtnBuscarUsuario(ActionListener listener) {
        btnBuscarUsuario.addActionListener(listener);
    }

    public void addActionListenerBtnEditarUsuario(ActionListener listener) {
        btnEditarUsuario.addActionListener(listener);
    }

    public void addActionListenerBtnBorrarUsuario(ActionListener listener) {
        btnBorrarUsuario.addActionListener(listener);
    }

    public UsuarioModel getUsuarioSelectedOnUsuariosTable() {
        int index = tablaUsuarios.getSelectedRow();
        if (index != -1) {
            return usuariosTableModel.getUsuarioModelAt(index);
        } else {
            JOptionPane.showMessageDialog(this, "ERROR : Ningún usuario Seleccionado");
            return null;
        }
    }

    public List<UsuarioModel> getUsuariosSelectedOnUsuariosTable() {
        int[] index = tablaUsuarios.getSelectedRows();
        ArrayList<UsuarioModel> usuariosSelected = new ArrayList();
        for (int i : index) {
            usuariosSelected.add(usuariosTableModel.getUsuarioModelAt(i));
        }
        return usuariosSelected;
    }

    public String getUsuariosFilterIdentificacion() {
        return txtFiltroIdentificacionUsuario.getText();
    }

    /* =========== CLIENTES IMPL ===========  */
    public ClienteModel getClienteFromDatosCliente() {
        ClienteModel cliente = new ClienteModel();
        cliente.setEmail(txtEmailCliente.getText());
        cliente.setNombre(txtNombreCliente.getText());
        cliente.setApellido(txtApellidoCliente.getText());
        cliente.setIdentificacion(txtIdentificacionCliente.getText());
        cliente.setTelefono(txtTelefonoCliente.getText());
        return cliente;
    }

    public void setDatosClienteFromCliente(ClienteModel cliente) {
        txtEmailCliente.setText(cliente.getEmail());
        txtNombreCliente.setText(cliente.getNombre());
        txtApellidoCliente.setText(cliente.getApellido());
        txtIdentificacionCliente.setText(cliente.getIdentificacion());
        txtTelefonoCliente.setText(cliente.getTelefono());
    }

    public void addActionListenerBtnAddCliente(ActionListener listener) {
        btnAddCliente.addActionListener(listener);
    }

    public void addActionListenerBtnBuscarCliente(ActionListener listener) {
        btnBuscarCliente.addActionListener(listener);
    }

    public void addActionListenerBtnEditarCliente(ActionListener listener) {
        btnEditarCliente.addActionListener(listener);
    }

    public void addActionListenerBtnBorrarCliente(ActionListener listener) {
        btnBorrarCliente.addActionListener(listener);
    }

    public String getClienteFiltroIdentificacion() {
        return txtFiltroIdentificacionCliente.getText();
    }

    public ClienteModel getClienteSelectedOnClientesTable() {
        int index = tablaClientes.getSelectedRow();
        if (index != -1) {
            return clientesTableModel.getClienteModelAt(index);
        } else {
            JOptionPane.showMessageDialog(this, "ERROR : Ningún Cliente Seleccionado");
            return null;
        }
    }

    public List<ClienteModel> getClientesSelectedOnClientesTable() {
        int[] index = tablaClientes.getSelectedRows();
        ArrayList<ClienteModel> clientesSelected = new ArrayList();
        for (int i : index) {
            clientesSelected.add(clientesTableModel.getClienteModelAt(i));
        }
        return clientesSelected;
    }

    /* =========== PRODUCTOS IMPL ===========  */
    public ProductoModel getProductoFromDatosProducto() throws Exception {
        ProductoModel producto = new ProductoModel();
        producto.setIdProducto(txtIdProducto.getText());
        producto.setNombre(txtNombreProducto.getText());
        producto.setPrecioVentaBase(obtenerPrecioBaseProducto());
        producto.setEstado((String) listEstadoProducto.getSelectedItem());
        return producto;
    }
    
    public void setDatosProductoFromProducto(ProductoModel producto) throws Exception {
        txtIdProducto.setText(producto.getIdProducto());
        txtNombreProducto.setText(producto.getNombre());
        txtPrecioProducto.setText(String.valueOf(producto.getPrecioVentaBase()));
        listEstadoProducto.setSelectedItem(producto.getEstado());
    }
    
    public void addActionListenerBtnAddProducto(ActionListener listener){
        btnAddProducto.addActionListener(listener);
    }
    
    public void addActionListenerBtnBuscarProducto(ActionListener listener){
        btnBuscarProducto.addActionListener(listener);
    }
    
    public void addActionListenerBtnEditarProducto(ActionListener listener){
        btnEditarProducto.addActionListener(listener);
    }
    
    public void addActionListenerBtnBorrarProducto(ActionListener listener){
        btnBorrarProducto.addActionListener(listener);
    }

    public double obtenerPrecioBaseProducto() throws Exception {
        String valueString = txtPrecioProducto.getText();
        try {
            return Double.valueOf(valueString);
        } catch (Exception e) {
            logger.info("El campo Precio Venta debe ser numerico.");
            throw new Exception("El campo Precio Venta debe ser numerico.");
        }
    }

    public ProductoModel getProductoSelectedOnProductosTable() {
        int index = tablaProductos.getSelectedRow();
        if (index != -1) {
            return productosTableModel.getProductoModelAt(index);
        } else {
            JOptionPane.showMessageDialog(this, "ERROR : Ningún Producto Seleccionado");
            return null;
        }
    }

    public List<ProductoModel> getProductosSelectedOnProductosTable() {
        int[] index = tablaProductos.getSelectedRows();
        ArrayList<ProductoModel> productosSelected = new ArrayList();
        for (int i : index) {
            productosSelected.add(productosTableModel.getProductoModelAt(i));
        }
        return productosSelected;
    }
    
    public String getProductosFilter(){
        return txtFiltroProducto.getText();
    }
    
    /* =========== CREATE VENTA IMPL ===========  */
    public void addActionListenerListProductoVenta(ActionListener listener){
        listProducto.addActionListener(listener);
    }
    
    public void addActionListenerTxtCantidadDeseadaProducto(ActionListener listener){
        txtCantidadDeseadaProducto.addActionListener(listener);
    }
            
    public void addActionListenerTxtTotalDescuento(ActionListener listener){
        txtTotalDescuento.addActionListener(listener);
    }
    
    public void addActionListenerBtnAddVenta(ActionListener listener){
        btnAddVenta.addActionListener(listener);
    }
    
    public void addActionListenerBtnGuardarVenta(ActionListener listener){
        btnGuardarVenta.addActionListener(listener);
    }
    
    public void addActionListenerBtnRefrescarVentas(ActionListener listener){
        btnRefrescarVentas.addActionListener(listener);
    }
    
    public void setTxtIdVenta(String idVenta){
        txtIdVenta.setText(idVenta);
    }
    public void setUsuariosVentasList(List<UsuarioModel> usuarios){
        listIdUsuario.removeAllItems();
        for (UsuarioModel usuario : usuarios) {
            listIdUsuario.addItem(usuario.getNombre() + " " + usuario.getApellido());
        }
        if(usuarios.size() > 0) listIdUsuario.setSelectedIndex(0);
    }
    
    public int getUsuarioVentaIndex(){
        return listIdUsuario.getSelectedIndex();
    }
    public int getClienteVentaIndex(){
        return listIdCliente.getSelectedIndex();
    }
    
    public void setClientesVentasList(List<ClienteModel> clientes){
        listIdCliente.removeAllItems();
        for (ClienteModel cliente : clientes) {
            listIdCliente.addItem(cliente.getNombre() + " " + cliente.getApellido());
        }
        if(clientes.size() > 0) listIdCliente.setSelectedIndex(0);
    }
    
    public void setProductosVentasList(List<AvailableProductVModel> productos){
        listProducto.removeAllItems();
        for (AvailableProductVModel producto : productos) {
            listProducto.addItem(producto.getNombreProducto()+ " (#" + producto.getCantidadDisponible() + ")");
        }
        if(productos.size() > 0) listIdCliente.setSelectedIndex(0);
    }
    
    public int getListProductoVentaIndexSelected(){
        return listProducto.getSelectedIndex();
    }
    
    public void setValorProductoVenta(String valor){
        txtVlrProductoVenta.setText(valor);
    }
    
    public void setTotalesProductoFromDetalle(DetalleVentaModel detalleVenta){
        txtTotalBruto.setText(String.valueOf(detalleVenta.getTotalBruto()));
        txtTotalDescuento.setText(String.valueOf(detalleVenta.getDescuento()));
        txtTotalProductoVenta.setText(String.valueOf(detalleVenta.getTotalNeto()));
    }
    
    public double getTotalDescuentoProducto() throws Exception{
        try {
            return Double.valueOf(txtTotalDescuento.getText());
        } catch (Exception e) {
            throw new Exception("El valor del descuentp del producto debe ser un numero.");
        }
    }
    public int getCantidadProductoDeseado() throws Exception{
        try {
            return Integer.valueOf(txtCantidadDeseadaProducto.getText());
        } catch (Exception e) {
            throw new Exception("La cantidad del producto debe ser un numero.");
        }
    }
    
    public void setTotalVenta(VentaModel venta){
        txtSubTotalVenta.setText(String.valueOf(venta.getSubtotal()));
        txtTotalDescuentoVenta.setText(String.valueOf(venta.getTotalDescuento()));
        txtTotalIvaVenta.setText(String.valueOf(venta.getTotalIva()));
        txtTotalBrutoVenta.setText(String.valueOf(venta.getTotalBruto()));
        txtTotalNetoVenta.setText(String.valueOf(venta.getTotalNeto()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundDashboard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        listadoOpciones = new javax.swing.JTabbedPane();
        panelInicio = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        panelUsuario = new javax.swing.JPanel();
        datosUsuarios = new javax.swing.JPanel();
        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        txt4 = new javax.swing.JLabel();
        txt6 = new javax.swing.JLabel();
        listTipoIdentificacionUsuario = new javax.swing.JComboBox<>();
        txtNombreUsuario = new javax.swing.JTextField();
        txtApellidoUsuario = new javax.swing.JTextField();
        txtIdentificacionUsuario = new javax.swing.JTextField();
        txtTelefonoUsuario = new javax.swing.JTextField();
        btnAddUsuario = new javax.swing.JButton();
        txt10 = new javax.swing.JLabel();
        txtEmailUsuario = new javax.swing.JTextField();
        registroUsuarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtFiltroIdentificacionUsuario = new javax.swing.JTextField();
        btnBuscarUsuario = new javax.swing.JButton();
        btnEditarUsuario = new javax.swing.JButton();
        btnActualizarUsuario = new javax.swing.JButton();
        btnBorrarUsuario = new javax.swing.JButton();
        btnVolverUsuario = new javax.swing.JButton();
        panelCliente = new javax.swing.JPanel();
        datosClientes = new javax.swing.JPanel();
        txt5 = new javax.swing.JLabel();
        txt7 = new javax.swing.JLabel();
        txt8 = new javax.swing.JLabel();
        txt9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtApellidoCliente = new javax.swing.JTextField();
        txtIdentificacionCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtEmailCliente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnAddCliente = new javax.swing.JButton();
        registroClientes = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtFiltroIdentificacionCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnBorrarCliente = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnRefrescarClientes = new javax.swing.JButton();
        btnVolverCliente = new javax.swing.JButton();
        panelProveedores = new javax.swing.JPanel();
        datosProveedores = new javax.swing.JPanel();
        nombreProveedor = new javax.swing.JLabel();
        idProveedor = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        txtIdentificacionProveedor = new javax.swing.JTextField();
        btnAddProveedor = new javax.swing.JButton();
        registroProveedores = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        identificacion = new javax.swing.JLabel();
        txtFiltroIdentificacionProveedor = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        btnBorrarProveedor = new javax.swing.JButton();
        btnRefrescarProveedores = new javax.swing.JButton();
        btnVolverProveedores = new javax.swing.JButton();
        panelProductos = new javax.swing.JPanel();
        datosProductos = new javax.swing.JPanel();
        nombreProveedor1 = new javax.swing.JLabel();
        idProveedor1 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        txtPrecioProducto = new javax.swing.JTextField();
        btnAddProducto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        listEstadoProducto = new javax.swing.JComboBox<>();
        registroProductos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        idProducto = new javax.swing.JLabel();
        txtFiltroProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnBorrarProducto = new javax.swing.JButton();
        btnBorrarVenta3 = new javax.swing.JButton();
        btnVolverProductos = new javax.swing.JButton();
        panelVentas = new javax.swing.JPanel();
        datosVenta = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        listIdUsuario = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        listIdCliente = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtCantidadDeseadaProducto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtVlrProductoVenta = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTotalProductoVenta = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        listProducto = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtTotalBruto = new javax.swing.JTextField();
        txtTotalDescuento = new javax.swing.JTextField();
        btnAddVenta = new javax.swing.JButton();
        btnVolverVentas = new javax.swing.JButton();
        panelTotales = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtTotalNetoVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSubTotalVenta = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTotalIvaVenta = new javax.swing.JTextField();
        txtTotalDescuentoVenta = new javax.swing.JTextField();
        txtTotalBrutoVenta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductosVenta = new javax.swing.JTable();
        btnGuardarVenta = new javax.swing.JButton();
        btnRefrescarVentas = new javax.swing.JButton();
        panelListaVentas = new javax.swing.JPanel();
        registroVentas1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaListadoVentas = new javax.swing.JTable();
        idVenta1 = new javax.swing.JLabel();
        txtFiltroVenta1 = new javax.swing.JTextField();
        btnBuscarListadoVentas = new javax.swing.JButton();
        btnRefrescarListadoVentas = new javax.swing.JButton();
        btnVolverListadoVentas = new javax.swing.JButton();
        panelDerechoBotones = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnRegistroVentas = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        backgroundDashboard.setBackground(new java.awt.Color(255, 255, 255));
        backgroundDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        backgroundDashboard.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        listadoOpciones.setBackground(new java.awt.Color(255, 255, 255));
        listadoOpciones.setForeground(new java.awt.Color(102, 102, 102));
        listadoOpciones.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));
        panelInicio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel6.setText("Bienvenido al programa");

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel22.setText("Sistema de Gestión para la empresa \"Productos Saludables\". Aquí se gestionará toda la ");

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel23.setText("información de los usuarios, clientes, proveedores, productos (distintas producciones),");

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel24.setText("y ventas realizadas.");

        jLabel25.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel25.setText("Este programa facilitará la gestión de cada proceso realizado por la empresa ya que ");

        jLabel26.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel26.setText("permite llevar un control completo y detallado.");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inicio.png"))); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 105, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(269, 269, 269))))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(27, 27, 27)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addGap(140, 140, 140)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        listadoOpciones.addTab("Inicio", panelInicio);

        panelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        panelUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        datosUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Datos Usuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        txt1.setBackground(new java.awt.Color(255, 255, 255));
        txt1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt1.setText("Nombre:");

        txt2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt2.setText("Apellido:");

        txt3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt3.setText("Tipo ID:");
        txt3.setToolTipText("");

        txt4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt4.setText("Número ID:");
        txt4.setToolTipText("");

        txt6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt6.setText("Teléfono:");

        listTipoIdentificacionUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listTipoIdentificacionUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C.C", "C.E", "NIT", "PEP" }));

        txtNombreUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtApellidoUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtIdentificacionUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtTelefonoUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        btnAddUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnAddUsuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnAddUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        btnAddUsuario.setText("Guardar");
        btnAddUsuario.setToolTipText("");
        btnAddUsuario.setBorder(null);
        btnAddUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsuarioActionPerformed(evt);
            }
        });

        txt10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt10.setText("Email:");

        txtEmailUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        javax.swing.GroupLayout datosUsuariosLayout = new javax.swing.GroupLayout(datosUsuarios);
        datosUsuarios.setLayout(datosUsuariosLayout);
        datosUsuariosLayout.setHorizontalGroup(
            datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosUsuariosLayout.createSequentialGroup()
                .addGroup(datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosUsuariosLayout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(btnAddUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosUsuariosLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(txt6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefonoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(datosUsuariosLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listTipoIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        datosUsuariosLayout.setVerticalGroup(
            datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosUsuariosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2)
                    .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3)
                    .addComponent(listTipoIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4)
                    .addComponent(txtIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6)
                    .addComponent(txtEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt10))
                .addGap(28, 28, 28)
                .addComponent(btnAddUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelUsuario.add(datosUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 740, -1));

        registroUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        registroUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Registro de Usuarios", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N
        registroUsuarios.setForeground(new java.awt.Color(102, 102, 102));

        tablaUsuarios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaUsuarios.setModel(usuariosTableModel);
        jScrollPane1.setViewportView(tablaUsuarios);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Identificación:");

        txtFiltroIdentificacionUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFiltroIdentificacionUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFiltroIdentificacionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroIdentificacionUsuarioActionPerformed(evt);
            }
        });

        btnBuscarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarUsuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.setBorder(null);
        btnBuscarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        btnEditarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarUsuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditarUsuario.setText("Editar");
        btnEditarUsuario.setBorder(null);
        btnEditarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnActualizarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizarUsuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnActualizarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        btnActualizarUsuario.setText("Actualizar");
        btnActualizarUsuario.setBorder(null);
        btnActualizarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuarioActionPerformed(evt);
            }
        });

        btnBorrarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrarUsuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBorrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnBorrarUsuario.setText("Borrar");
        btnBorrarUsuario.setBorder(null);
        btnBorrarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout registroUsuariosLayout = new javax.swing.GroupLayout(registroUsuarios);
        registroUsuarios.setLayout(registroUsuariosLayout);
        registroUsuariosLayout.setHorizontalGroup(
            registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registroUsuariosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroUsuariosLayout.createSequentialGroup()
                        .addGap(0, 166, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185))))
            .addGroup(registroUsuariosLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registroUsuariosLayout.setVerticalGroup(
            registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroUsuariosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFiltroIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelUsuario.add(registroUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 740, -1));

        btnVolverUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnVolverUsuario.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volver.png"))); // NOI18N
        btnVolverUsuario.setText("Volver");
        btnVolverUsuario.setBorder(null);
        btnVolverUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverUsuarioMouseClicked(evt);
            }
        });
        btnVolverUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverUsuarioActionPerformed(evt);
            }
        });
        panelUsuario.add(btnVolverUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 740, 90, 20));

        listadoOpciones.addTab("Usuario", panelUsuario);

        panelCliente.setBackground(new java.awt.Color(255, 255, 255));
        panelCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosClientes.setBackground(new java.awt.Color(255, 255, 255));
        datosClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Datos Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        txt5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt5.setText("Nombre:");

        txt7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt7.setText("Apellido:");

        txt8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt8.setText("Identificación:");
        txt8.setToolTipText("");

        txt9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt9.setText("Teléfono:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setText("E-mail:");

        txtNombreCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtApellidoCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtIdentificacionCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtTelefonoCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtEmailCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnAddCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnAddCliente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        btnAddCliente.setText("Guardar");
        btnAddCliente.setToolTipText("");
        btnAddCliente.setBorder(null);
        btnAddCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout datosClientesLayout = new javax.swing.GroupLayout(datosClientes);
        datosClientes.setLayout(datosClientesLayout);
        datosClientesLayout.setHorizontalGroup(
            datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosClientesLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt5)
                    .addComponent(txt7)
                    .addComponent(txt8)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(txtApellidoCliente)
                    .addComponent(txtIdentificacionCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosClientesLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(188, 188, 188))
                    .addGroup(datosClientesLayout.createSequentialGroup()
                        .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt9)
                                .addComponent(txtEmailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addComponent(txtTelefonoCliente))
                            .addGroup(datosClientesLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        datosClientesLayout.setVerticalGroup(
            datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(datosClientesLayout.createSequentialGroup()
                        .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosClientesLayout.createSequentialGroup()
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt7))
                            .addGroup(datosClientesLayout.createSequentialGroup()
                                .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosClientesLayout.createSequentialGroup()
                                .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCliente.add(datosClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        registroClientes.setBackground(new java.awt.Color(255, 255, 255));
        registroClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Registro de Clientes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Identificación: ");

        txtFiltroIdentificacionCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFiltroIdentificacionCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFiltroIdentificacionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroIdentificacionClienteActionPerformed(evt);
            }
        });

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.setBorder(null);
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarCliente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditarCliente.setText("Editar");
        btnEditarCliente.setBorder(null);
        btnEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnBorrarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrarCliente.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBorrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        btnBorrarCliente.setText("Borrar");
        btnBorrarCliente.setBorder(null);
        btnBorrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaClientes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaClientes.setModel(clientesTableModel);
        jScrollPane4.setViewportView(tablaClientes);

        btnRefrescarClientes.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrescarClientes.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnRefrescarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        btnRefrescarClientes.setText("Refrescar");
        btnRefrescarClientes.setBorder(null);
        btnRefrescarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout registroClientesLayout = new javax.swing.GroupLayout(registroClientes);
        registroClientes.setLayout(registroClientesLayout);
        registroClientesLayout.setHorizontalGroup(
            registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefrescarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroClientesLayout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        registroClientesLayout.setVerticalGroup(
            registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFiltroIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        panelCliente.add(registroClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 740, 380));

        btnVolverCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnVolverCliente.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volver.png"))); // NOI18N
        btnVolverCliente.setText("Volver");
        btnVolverCliente.setBorder(null);
        btnVolverCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverClienteMouseClicked(evt);
            }
        });
        btnVolverCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverClienteActionPerformed(evt);
            }
        });
        panelCliente.add(btnVolverCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 740, 90, 20));

        listadoOpciones.addTab("Clientes", panelCliente);

        panelProveedores.setBackground(new java.awt.Color(255, 255, 255));
        panelProveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosProveedores.setBackground(new java.awt.Color(255, 255, 255));
        datosProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Datos Proveedor", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        nombreProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombreProveedor.setText("Nombre:");

        idProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        idProveedor.setText("Identificación:");
        idProveedor.setToolTipText("");

        txtNombreProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtIdentificacionProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIdentificacionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionProveedorActionPerformed(evt);
            }
        });

        btnAddProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnAddProveedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnAddProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        btnAddProveedor.setText("Guardar");
        btnAddProveedor.setToolTipText("");
        btnAddProveedor.setBorder(null);
        btnAddProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout datosProveedoresLayout = new javax.swing.GroupLayout(datosProveedores);
        datosProveedores.setLayout(datosProveedoresLayout);
        datosProveedoresLayout.setHorizontalGroup(
            datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosProveedoresLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idProveedor)
                    .addComponent(nombreProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdentificacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        datosProveedoresLayout.setVerticalGroup(
            datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosProveedoresLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreProveedor))
                .addGap(18, 18, 18)
                .addGroup(datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdentificacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnAddProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        panelProveedores.add(datosProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        registroProveedores.setBackground(new java.awt.Color(255, 255, 255));
        registroProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Registro de Proveedores\n", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Identificación"
            }
        ));
        jScrollPane3.setViewportView(tablaProveedores);

        identificacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        identificacion.setText("Identificación:");

        txtFiltroIdentificacionProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFiltroIdentificacionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroIdentificacionProveedorActionPerformed(evt);
            }
        });

        btnBuscarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProveedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscarProveedor.setText("Buscar");
        btnBuscarProveedor.setBorder(null);
        btnBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        btnEditarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarProveedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnEditarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditarProveedor.setText("Editar");
        btnEditarProveedor.setBorder(null);
        btnEditarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });

        btnBorrarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrarProveedor.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBorrarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        btnBorrarProveedor.setText("Borrar");
        btnBorrarProveedor.setBorder(null);
        btnBorrarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnRefrescarProveedores.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrescarProveedores.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnRefrescarProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        btnRefrescarProveedores.setText("Refrescar");
        btnRefrescarProveedores.setBorder(null);
        btnRefrescarProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout registroProveedoresLayout = new javax.swing.GroupLayout(registroProveedores);
        registroProveedores.setLayout(registroProveedoresLayout);
        registroProveedoresLayout.setHorizontalGroup(
            registroProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroProveedoresLayout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(identificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroIdentificacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
            .addGroup(registroProveedoresLayout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefrescarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(registroProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        registroProveedoresLayout.setVerticalGroup(
            registroProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroProveedoresLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(registroProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificacion)
                    .addComponent(txtFiltroIdentificacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registroProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        panelProveedores.add(registroProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 740, -1));

        btnVolverProveedores.setBackground(new java.awt.Color(255, 255, 255));
        btnVolverProveedores.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volver.png"))); // NOI18N
        btnVolverProveedores.setText("Volver");
        btnVolverProveedores.setBorder(null);
        btnVolverProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverProveedoresMouseClicked(evt);
            }
        });
        btnVolverProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverProveedoresActionPerformed(evt);
            }
        });
        panelProveedores.add(btnVolverProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 740, 90, 20));

        listadoOpciones.addTab("Proveedores", panelProveedores);

        panelProductos.setBackground(new java.awt.Color(255, 255, 255));
        panelProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosProductos.setBackground(new java.awt.Color(255, 255, 255));
        datosProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Datos Producto\n\n", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        nombreProveedor1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombreProveedor1.setText("Nombre:");

        idProveedor1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        idProveedor1.setText("ID Producto:");
        idProveedor1.setToolTipText("");

        txtIdProducto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProductoActionPerformed(evt);
            }
        });

        txtNombreProducto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });

        txtPrecioProducto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtPrecioProducto.setText("0");
        txtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoActionPerformed(evt);
            }
        });

        btnAddProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnAddProducto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnAddProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        btnAddProducto.setText("Guardar");
        btnAddProducto.setToolTipText("");
        btnAddProducto.setBorder(null);
        btnAddProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Precio Venta:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Estado Producto:");

        listEstadoProducto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        listEstadoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Agotado" }));

        javax.swing.GroupLayout datosProductosLayout = new javax.swing.GroupLayout(datosProductos);
        datosProductos.setLayout(datosProductosLayout);
        datosProductosLayout.setHorizontalGroup(
            datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosProductosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(idProveedor1)
                    .addComponent(nombreProveedor1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPrecioProducto)
                        .addComponent(txtIdProducto)
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addComponent(listEstadoProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        datosProductosLayout.setVerticalGroup(
            datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idProveedor1)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreProveedor1)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listEstadoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnAddProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        panelProductos.add(datosProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        registroProductos.setBackground(new java.awt.Color(255, 255, 255));
        registroProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Registro de Productos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        tablaProductos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaProductos.setModel(productosTableModel);
        jScrollPane5.setViewportView(tablaProductos);

        idProducto.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        idProducto.setText("ID Producto: ");

        txtFiltroProducto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFiltroProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroProductoActionPerformed(evt);
            }
        });

        btnBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setBorder(null);
        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarProducto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnEditarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditarProducto.setText("Editar");
        btnEditarProducto.setBorder(null);
        btnEditarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        btnBorrarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrarProducto.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBorrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        btnBorrarProducto.setText("Borrar");
        btnBorrarProducto.setBorder(null);
        btnBorrarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBorrarVenta3.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrarVenta3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBorrarVenta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        btnBorrarVenta3.setText("Refrescar");
        btnBorrarVenta3.setBorder(null);
        btnBorrarVenta3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout registroProductosLayout = new javax.swing.GroupLayout(registroProductos);
        registroProductos.setLayout(registroProductosLayout);
        registroProductosLayout.setHorizontalGroup(
            registroProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroProductosLayout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(idProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(registroProductosLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarVenta3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(registroProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        registroProductosLayout.setVerticalGroup(
            registroProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroProductosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(registroProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idProducto)
                    .addComponent(txtFiltroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registroProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarVenta3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelProductos.add(registroProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 740, -1));

        btnVolverProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnVolverProductos.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volver.png"))); // NOI18N
        btnVolverProductos.setText("Volver");
        btnVolverProductos.setBorder(null);
        btnVolverProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverProductosMouseClicked(evt);
            }
        });
        btnVolverProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverProductosActionPerformed(evt);
            }
        });
        panelProductos.add(btnVolverProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 740, 90, 20));

        listadoOpciones.addTab("Productos", panelProductos);

        panelVentas.setBackground(new java.awt.Color(255, 255, 255));
        panelVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosVenta.setBackground(new java.awt.Color(255, 255, 255));
        datosVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Datos Venta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("ID Venta: ");

        txtIdVenta.setEditable(false);
        txtIdVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setText("ID Usuario: ");

        listIdUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setText("ID Cliente: ");

        listIdCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel16.setText("Cant.:");

        txtCantidadDeseadaProducto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCantidadDeseadaProducto.setText("0");

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel17.setText("Vlr Producto:");

        txtVlrProductoVenta.setEditable(false);
        txtVlrProductoVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtVlrProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVlrProductoVentaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel18.setText("Total: ");

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel19.setText("Descuento:");

        txtTotalProductoVenta.setEditable(false);
        txtTotalProductoVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel20.setText("Producto:");

        listProducto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel21.setText("Total Bruto: ");

        txtTotalBruto.setEditable(false);
        txtTotalBruto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        txtTotalDescuento.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTotalDescuento.setText("0");

        btnAddVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnAddVenta.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnAddVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Agregar.png"))); // NOI18N
        btnAddVenta.setText("Agregar");
        btnAddVenta.setBorder(null);
        btnAddVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datosVentaLayout = new javax.swing.GroupLayout(datosVenta);
        datosVenta.setLayout(datosVentaLayout);
        datosVentaLayout.setHorizontalGroup(
            datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosVentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(288, 288, 288))
            .addGroup(datosVentaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosVentaLayout.createSequentialGroup()
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosVentaLayout.createSequentialGroup()
                                .addComponent(listProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17))
                            .addGroup(datosVentaLayout.createSequentialGroup()
                                .addComponent(listIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(datosVentaLayout.createSequentialGroup()
                                .addComponent(listIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVlrProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadDeseadaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55))
                    .addGroup(datosVentaLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        datosVentaLayout.setVerticalGroup(
            datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosVentaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(listIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtCantidadDeseadaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(listProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtVlrProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTotalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtTotalProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelVentas.add(datosVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 700, 270));

        btnVolverVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnVolverVentas.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volver.png"))); // NOI18N
        btnVolverVentas.setText("Volver");
        btnVolverVentas.setBorder(null);
        btnVolverVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverVentasMouseClicked(evt);
            }
        });
        btnVolverVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverVentasActionPerformed(evt);
            }
        });
        panelVentas.add(btnVolverVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 740, 90, 20));

        panelTotales.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel13.setText("Total Neto:");

        txtTotalNetoVenta.setEditable(false);
        txtTotalNetoVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTotalNetoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalNetoVentaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setText("Subtotal:");

        txtSubTotalVenta.setEditable(false);
        txtSubTotalVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtSubTotalVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalVentaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Total Bruto:");

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setText("Total IVA:");

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Total Descuento:");

        txtTotalIvaVenta.setEditable(false);
        txtTotalIvaVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTotalIvaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalIvaVentaActionPerformed(evt);
            }
        });

        txtTotalDescuentoVenta.setEditable(false);
        txtTotalDescuentoVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTotalDescuentoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalDescuentoVentaActionPerformed(evt);
            }
        });

        txtTotalBrutoVenta.setEditable(false);
        txtTotalBrutoVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTotalBrutoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalBrutoVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTotalesLayout = new javax.swing.GroupLayout(panelTotales);
        panelTotales.setLayout(panelTotalesLayout);
        panelTotalesLayout.setHorizontalGroup(
            panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalesLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTotalesLayout.createSequentialGroup()
                        .addComponent(txtTotalDescuentoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalBrutoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTotalesLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalNetoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTotalesLayout.createSequentialGroup()
                        .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelTotalesLayout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalIvaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        panelTotalesLayout.setVerticalGroup(
            panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTotalesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSubTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtTotalIvaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalDescuentoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(txtTotalBrutoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panelTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTotalNetoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelVentas.add(panelTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 700, 170));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        tablaProductosVenta.setModel(detallesVentaTableModel);
        jScrollPane2.setViewportView(tablaProductosVenta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelVentas.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 700, 240));

        btnGuardarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarVenta.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnGuardarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar.png"))); // NOI18N
        btnGuardarVenta.setText("Guardar");
        btnGuardarVenta.setBorder(null);
        btnGuardarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVentaActionPerformed(evt);
            }
        });
        panelVentas.add(btnGuardarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 730, 89, 31));

        btnRefrescarVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrescarVentas.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnRefrescarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        btnRefrescarVentas.setText("Refrescar");
        btnRefrescarVentas.setBorder(null);
        btnRefrescarVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelVentas.add(btnRefrescarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 730, 89, 31));

        listadoOpciones.addTab("Ventas", panelVentas);

        panelListaVentas.setBackground(new java.awt.Color(255, 255, 255));

        registroVentas1.setBackground(new java.awt.Color(255, 255, 255));
        registroVentas1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Registro de Ventas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        tablaListadoVentas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaListadoVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Usuario", "ID Venta", "ID Cliente", "Subtotal", "Total Iva", "Total Bruto", "Total Neto", "Total Descuento"
            }
        ));
        jScrollPane7.setViewportView(tablaListadoVentas);

        idVenta1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        idVenta1.setText("ID Venta: ");

        txtFiltroVenta1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFiltroVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroVenta1ActionPerformed(evt);
            }
        });

        btnBuscarListadoVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarListadoVentas.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBuscarListadoVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnBuscarListadoVentas.setText("Buscar");
        btnBuscarListadoVentas.setBorder(null);
        btnBuscarListadoVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarListadoVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarListadoVentasActionPerformed(evt);
            }
        });

        btnRefrescarListadoVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrescarListadoVentas.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnRefrescarListadoVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Actualizar.png"))); // NOI18N
        btnRefrescarListadoVentas.setText("Refrescar");
        btnRefrescarListadoVentas.setBorder(null);
        btnRefrescarListadoVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout registroVentas1Layout = new javax.swing.GroupLayout(registroVentas1);
        registroVentas1.setLayout(registroVentas1Layout);
        registroVentas1Layout.setHorizontalGroup(
            registroVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroVentas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registroVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registroVentas1Layout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroVentas1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(idVenta1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroVenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarListadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))))
            .addGroup(registroVentas1Layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(btnRefrescarListadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        registroVentas1Layout.setVerticalGroup(
            registroVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroVentas1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(registroVentas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idVenta1)
                    .addComponent(txtFiltroVenta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarListadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefrescarListadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnVolverListadoVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnVolverListadoVentas.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverListadoVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volver.png"))); // NOI18N
        btnVolverListadoVentas.setText("Volver");
        btnVolverListadoVentas.setBorder(null);
        btnVolverListadoVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverListadoVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverListadoVentasMouseClicked(evt);
            }
        });
        btnVolverListadoVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverListadoVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelListaVentasLayout = new javax.swing.GroupLayout(panelListaVentas);
        panelListaVentas.setLayout(panelListaVentasLayout);
        panelListaVentasLayout.setHorizontalGroup(
            panelListaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaVentasLayout.createSequentialGroup()
                .addContainerGap(669, Short.MAX_VALUE)
                .addComponent(btnVolverListadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(panelListaVentasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(registroVentas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        panelListaVentasLayout.setVerticalGroup(
            panelListaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaVentasLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(registroVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(btnVolverListadoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        listadoOpciones.addTab("Listado Ventas", panelListaVentas);

        backgroundDashboard.add(listadoOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 810));

        panelDerechoBotones.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LOGO170.png"))); // NOI18N

        btnUsuario.setBackground(new java.awt.Color(153, 153, 153));
        btnUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        btnUsuario.setText("Usuarios");
        btnUsuario.setBorder(null);
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnUsuario.setIconTextGap(10);
        btnUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuarioMouseClicked(evt);
            }
        });
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(153, 153, 153));
        btnClientes.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setBorder(null);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnClientes.setIconTextGap(10);
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
        });
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProveedores.setBackground(new java.awt.Color(153, 153, 153));
        btnProveedores.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/provedores.png"))); // NOI18N
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorder(null);
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnProveedores.setIconTextGap(10);
        btnProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProveedoresMouseClicked(evt);
            }
        });
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnProductos.setBackground(new java.awt.Color(153, 153, 153));
        btnProductos.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/productos.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnProductos.setIconTextGap(10);
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMouseClicked(evt);
            }
        });
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnVentas.setBackground(new java.awt.Color(153, 153, 153));
        btnVentas.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ventas.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.setBorder(null);
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnVentas.setIconTextGap(10);
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentasMouseClicked(evt);
            }
        });
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnRegistroVentas.setBackground(new java.awt.Color(153, 153, 153));
        btnRegistroVentas.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnRegistroVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RegistroVentas.png"))); // NOI18N
        btnRegistroVentas.setText("Reg. Ventas");
        btnRegistroVentas.setBorder(null);
        btnRegistroVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistroVentas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnRegistroVentas.setIconTextGap(10);
        btnRegistroVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistroVentasMouseClicked(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelDerechoBotonesLayout = new javax.swing.GroupLayout(panelDerechoBotones);
        panelDerechoBotones.setLayout(panelDerechoBotonesLayout);
        panelDerechoBotonesLayout.setHorizontalGroup(
            panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechoBotonesLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechoBotonesLayout.createSequentialGroup()
                        .addGroup(panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(btnProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(btnRegistroVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechoBotonesLayout.createSequentialGroup()
                        .addGroup(panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18))))
        );
        panelDerechoBotonesLayout.setVerticalGroup(
            panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechoBotonesLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistroVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        backgroundDashboard.add(panelDerechoBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 230, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddUsuarioActionPerformed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void txtFiltroIdentificacionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroIdentificacionUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroIdentificacionUsuarioActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtFiltroIdentificacionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroIdentificacionClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroIdentificacionClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void txtIdentificacionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionProveedorActionPerformed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void txtFiltroIdentificacionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroIdentificacionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroIdentificacionProveedorActionPerformed

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMouseClicked
        listadoOpciones.setSelectedIndex(1);
    }//GEN-LAST:event_btnUsuarioMouseClicked

    private void btnProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseClicked
        listadoOpciones.setSelectedIndex(3);
    }//GEN-LAST:event_btnProveedoresMouseClicked

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        listadoOpciones.setSelectedIndex(2);
    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnVolverUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverUsuarioMouseClicked
        listadoOpciones.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverUsuarioMouseClicked

    private void btnVolverUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverUsuarioActionPerformed

    private void txtPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioProductoActionPerformed

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void txtIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProductoActionPerformed

    private void txtFiltroProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroProductoActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseClicked
        listadoOpciones.setSelectedIndex(5);
    }//GEN-LAST:event_btnVentasMouseClicked

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentasActionPerformed

    private void txtSubTotalVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalVentaActionPerformed

    private void txtTotalIvaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalIvaVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalIvaVentaActionPerformed

    private void txtTotalDescuentoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalDescuentoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalDescuentoVentaActionPerformed

    private void txtTotalNetoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalNetoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalNetoVentaActionPerformed

    private void txtTotalBrutoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalBrutoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalBrutoVentaActionPerformed

    private void btnAddVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddVentaActionPerformed

    private void btnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseClicked
        listadoOpciones.setSelectedIndex(4);
    }//GEN-LAST:event_btnProductosMouseClicked

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnVolverClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverClienteMouseClicked
        listadoOpciones.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverClienteMouseClicked

    private void btnVolverClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverClienteActionPerformed

    private void btnVolverProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverProveedoresMouseClicked
        listadoOpciones.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverProveedoresMouseClicked

    private void btnVolverProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverProveedoresActionPerformed

    private void btnVolverProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverProductosMouseClicked
        listadoOpciones.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverProductosMouseClicked

    private void btnVolverProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverProductosActionPerformed

    private void btnVolverVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverVentasMouseClicked
        listadoOpciones.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverVentasMouseClicked

    private void btnVolverVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverVentasActionPerformed

    private void btnActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarUsuarioActionPerformed

    private void txtFiltroVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroVenta1ActionPerformed

    private void btnBuscarListadoVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarListadoVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarListadoVentasActionPerformed

    private void txtVlrProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVlrProductoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVlrProductoVentaActionPerformed

    private void btnGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarVentaActionPerformed

    private void btnVolverListadoVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverListadoVentasMouseClicked
        listadoOpciones.setSelectedIndex(0);
    }//GEN-LAST:event_btnVolverListadoVentasMouseClicked

    private void btnVolverListadoVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverListadoVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverListadoVentasActionPerformed

    private void btnRegistroVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroVentasMouseClicked
        listadoOpciones.setSelectedIndex(6);
    }//GEN-LAST:event_btnRegistroVentasMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Dashboard().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundDashboard;
    private javax.swing.JButton btnActualizarUsuario;
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnAddProducto;
    private javax.swing.JButton btnAddProveedor;
    private javax.swing.JButton btnAddUsuario;
    private javax.swing.JButton btnAddVenta;
    private javax.swing.JButton btnBorrarCliente;
    private javax.swing.JButton btnBorrarProducto;
    private javax.swing.JButton btnBorrarProveedor;
    private javax.swing.JButton btnBorrarUsuario;
    private javax.swing.JButton btnBorrarVenta3;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarListadoVentas;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnGuardarVenta;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnRefrescarClientes;
    private javax.swing.JButton btnRefrescarListadoVentas;
    private javax.swing.JButton btnRefrescarProveedores;
    private javax.swing.JButton btnRefrescarVentas;
    private javax.swing.JButton btnRegistroVentas;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVolverCliente;
    private javax.swing.JButton btnVolverListadoVentas;
    private javax.swing.JButton btnVolverProductos;
    private javax.swing.JButton btnVolverProveedores;
    private javax.swing.JButton btnVolverUsuario;
    private javax.swing.JButton btnVolverVentas;
    private javax.swing.JPanel datosClientes;
    private javax.swing.JPanel datosProductos;
    private javax.swing.JPanel datosProveedores;
    private javax.swing.JPanel datosUsuarios;
    private javax.swing.JPanel datosVenta;
    private javax.swing.JLabel idProducto;
    private javax.swing.JLabel idProveedor;
    private javax.swing.JLabel idProveedor1;
    private javax.swing.JLabel idVenta1;
    private javax.swing.JLabel identificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> listEstadoProducto;
    private javax.swing.JComboBox<String> listIdCliente;
    private javax.swing.JComboBox<String> listIdUsuario;
    private javax.swing.JComboBox<String> listProducto;
    private javax.swing.JComboBox<String> listTipoIdentificacionUsuario;
    private javax.swing.JTabbedPane listadoOpciones;
    private javax.swing.JLabel nombreProveedor;
    private javax.swing.JLabel nombreProveedor1;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelDerechoBotones;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelListaVentas;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JPanel panelProveedores;
    private javax.swing.JPanel panelTotales;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JPanel panelVentas;
    private javax.swing.JPanel registroClientes;
    private javax.swing.JPanel registroProductos;
    private javax.swing.JPanel registroProveedores;
    private javax.swing.JPanel registroUsuarios;
    private javax.swing.JPanel registroVentas1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaListadoVentas;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaProductosVenta;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt10;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txt6;
    private javax.swing.JLabel txt7;
    private javax.swing.JLabel txt8;
    private javax.swing.JLabel txt9;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtApellidoUsuario;
    private javax.swing.JTextField txtCantidadDeseadaProducto;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtEmailUsuario;
    private javax.swing.JTextField txtFiltroIdentificacionCliente;
    private javax.swing.JTextField txtFiltroIdentificacionProveedor;
    private javax.swing.JTextField txtFiltroIdentificacionUsuario;
    private javax.swing.JTextField txtFiltroProducto;
    private javax.swing.JTextField txtFiltroVenta1;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtIdentificacionCliente;
    private javax.swing.JTextField txtIdentificacionProveedor;
    private javax.swing.JTextField txtIdentificacionUsuario;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtSubTotalVenta;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoUsuario;
    private javax.swing.JTextField txtTotalBruto;
    private javax.swing.JTextField txtTotalBrutoVenta;
    private javax.swing.JTextField txtTotalDescuento;
    private javax.swing.JTextField txtTotalDescuentoVenta;
    private javax.swing.JTextField txtTotalIvaVenta;
    private javax.swing.JTextField txtTotalNetoVenta;
    private javax.swing.JTextField txtTotalProductoVenta;
    private javax.swing.JTextField txtVlrProductoVenta;
    // End of variables declaration//GEN-END:variables
}

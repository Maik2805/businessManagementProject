/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.univalle.businessmanagment.views;

import co.edu.univalle.businessmanagment.models.ClienteModel;
import co.edu.univalle.businessmanagment.models.ProductoModel;
import co.edu.univalle.businessmanagment.models.UsuarioModel;
import co.edu.univalle.businessmanagment.views.tablemodels.ClienteTableModel;
import co.edu.univalle.businessmanagment.views.tablemodels.ProductoTableModel;
import co.edu.univalle.businessmanagment.views.tablemodels.UsuarioTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        clientesTableModel = new ClienteTableModel();
        usuariosTableModel = new UsuarioTableModel();
        productosTableModel = new ProductoTableModel();
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundDashboard = new javax.swing.JPanel();
        listadoOpciones = new javax.swing.JTabbedPane();
        panelInicio = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
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
        btnVolverProductos = new javax.swing.JButton();
        panelVentas = new javax.swing.JPanel();
        datosVenta = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtIdVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        listIdUsuario = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        listIdCliente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtSubTotalVenta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotalIvaVenta = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTotalBrutoVenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTotalNetoVenta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtTotalDescuentoVenta = new javax.swing.JTextField();
        btnAddVenta = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        registroVentas = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        idVenta = new javax.swing.JLabel();
        txtFiltroVenta = new javax.swing.JTextField();
        btnBuscarVenta = new javax.swing.JButton();
        btnEditarVenta = new javax.swing.JButton();
        btnBorrarVenta = new javax.swing.JButton();
        btnVolverVentas = new javax.swing.JButton();
        panelDerechoBotones = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        backgroundDashboard.setBackground(new java.awt.Color(255, 255, 255));
        backgroundDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel6.setText("¡Bienvenido al programa!");

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(267, 267, 267))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel6)
                .addContainerGap(652, Short.MAX_VALUE))
        );

        listadoOpciones.addTab("Incio", panelInicio);

        panelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        panelUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        datosUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Datos Usuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

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

        listTipoIdentificacionUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C.C", "C.E", "NIT", "PEP" }));

        btnAddUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnAddUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAddUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/añadir.png"))); // NOI18N
        btnAddUsuario.setText("Añadir");
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

        javax.swing.GroupLayout datosUsuariosLayout = new javax.swing.GroupLayout(datosUsuarios);
        datosUsuarios.setLayout(datosUsuariosLayout);
        datosUsuariosLayout.setHorizontalGroup(
            datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosUsuariosLayout.createSequentialGroup()
                .addGroup(datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosUsuariosLayout.createSequentialGroup()
                        .addGroup(datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(datosUsuariosLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(txt1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt3)
                                .addGap(7, 7, 7))
                            .addGroup(datosUsuariosLayout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addComponent(txt6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefonoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datosUsuariosLayout.createSequentialGroup()
                                .addComponent(listTipoIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(datosUsuariosLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btnAddUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6)
                    .addComponent(txtEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt10))
                .addGap(28, 28, 28)
                .addComponent(btnAddUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelUsuario.add(datosUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 740, -1));

        registroUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        registroUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Registro de Usuarios", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N
        registroUsuarios.setForeground(new java.awt.Color(102, 102, 102));

        tablaUsuarios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaUsuarios.setModel(usuariosTableModel);
        jScrollPane1.setViewportView(tablaUsuarios);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setText("Identificación:");

        txtFiltroIdentificacionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroIdentificacionUsuarioActionPerformed(evt);
            }
        });

        btnBuscarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
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
        btnEditarUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditarUsuario.setText("Editar");
        btnEditarUsuario.setBorder(null);
        btnEditarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnBorrarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrarUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroUsuariosLayout.createSequentialGroup()
                        .addGap(0, 169, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(registroUsuariosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(registroUsuariosLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        registroUsuariosLayout.setVerticalGroup(
            registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroUsuariosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFiltroIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelUsuario.add(registroUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 740, -1));

        btnVolverUsuario.setBackground(new java.awt.Color(153, 153, 153));
        btnVolverUsuario.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverUsuario.setForeground(new java.awt.Color(255, 255, 255));
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
        datosClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Datos Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

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

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnAddCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnAddCliente.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/añadir.png"))); // NOI18N
        btnAddCliente.setText("Añadir");
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
                    .addGroup(datosClientesLayout.createSequentialGroup()
                        .addComponent(btnAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosClientesLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(188, 188, 188))
                        .addGroup(datosClientesLayout.createSequentialGroup()
                            .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt9)
                                .addComponent(txtEmailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addComponent(txtTelefonoCliente))
                            .addContainerGap()))))
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
                                .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCliente.add(datosClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        registroClientes.setBackground(new java.awt.Color(255, 255, 255));
        registroClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Registro de Clientes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setText("Identificación: ");

        txtFiltroIdentificacionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroIdentificacionClienteActionPerformed(evt);
            }
        });

        btnBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
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
        btnEditarCliente.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
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
        btnBorrarCliente.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBorrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        btnBorrarCliente.setText("Borrar");
        btnBorrarCliente.setBorder(null);
        btnBorrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tablaClientes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaClientes.setModel(clientesTableModel);
        jScrollPane4.setViewportView(tablaClientes);

        javax.swing.GroupLayout registroClientesLayout = new javax.swing.GroupLayout(registroClientes);
        registroClientes.setLayout(registroClientesLayout);
        registroClientesLayout.setHorizontalGroup(
            registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        registroClientesLayout.setVerticalGroup(
            registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFiltroIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        panelCliente.add(registroClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 680, 380));

        btnVolverCliente.setBackground(new java.awt.Color(153, 153, 153));
        btnVolverCliente.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverCliente.setForeground(new java.awt.Color(255, 255, 255));
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

        listadoOpciones.addTab("Cliente", panelCliente);

        panelProveedores.setBackground(new java.awt.Color(255, 255, 255));
        panelProveedores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosProveedores.setBackground(new java.awt.Color(255, 255, 255));
        datosProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Datos Proveedores\n", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        nombreProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombreProveedor.setText("Nombre:");

        idProveedor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        idProveedor.setText("Identificación:");
        idProveedor.setToolTipText("");

        txtIdentificacionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionProveedorActionPerformed(evt);
            }
        });

        btnAddProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnAddProveedor.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAddProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnAddProveedor.setText("Añadir");
        btnAddProveedor.setToolTipText("");
        btnAddProveedor.setBorder(null);
        btnAddProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout datosProveedoresLayout = new javax.swing.GroupLayout(datosProveedores);
        datosProveedores.setLayout(datosProveedoresLayout);
        datosProveedoresLayout.setHorizontalGroup(
            datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosProveedoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(datosProveedoresLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idProveedor)
                    .addComponent(nombreProveedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdentificacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(btnAddProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        panelProveedores.add(datosProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 68, -1, -1));

        registroProveedores.setBackground(new java.awt.Color(255, 255, 255));
        registroProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Registro de Proveedores\n", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

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

        txtFiltroIdentificacionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroIdentificacionProveedorActionPerformed(evt);
            }
        });

        btnBuscarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProveedor.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/añadir.png"))); // NOI18N
        btnBuscarProveedor.setText("Buscar");
        btnBuscarProveedor.setBorder(null);
        btnBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        btnEditarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarProveedor.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
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
        btnBorrarProveedor.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBorrarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        btnBorrarProveedor.setText("Borrar");
        btnBorrarProveedor.setBorder(null);
        btnBorrarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout registroProveedoresLayout = new javax.swing.GroupLayout(registroProveedores);
        registroProveedores.setLayout(registroProveedoresLayout);
        registroProveedoresLayout.setHorizontalGroup(
            registroProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroProveedoresLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(identificacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroIdentificacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(registroProveedoresLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        registroProveedoresLayout.setVerticalGroup(
            registroProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroProveedoresLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(registroProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificacion)
                    .addComponent(txtFiltroIdentificacionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registroProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        panelProveedores.add(registroProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 314, -1, -1));

        btnVolverProveedores.setBackground(new java.awt.Color(153, 153, 153));
        btnVolverProveedores.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverProveedores.setForeground(new java.awt.Color(255, 255, 255));
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
        datosProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Datos Producto\n\n", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        nombreProveedor1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombreProveedor1.setText("Nombre:");

        idProveedor1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        idProveedor1.setText("ID Producto:");
        idProveedor1.setToolTipText("");

        txtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProductoActionPerformed(evt);
            }
        });

        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });

        txtPrecioProducto.setText("0");
        txtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoActionPerformed(evt);
            }
        });

        btnAddProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnAddProducto.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAddProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        btnAddProducto.setText("Añadir");
        btnAddProducto.setToolTipText("");
        btnAddProducto.setBorder(null);
        btnAddProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setText("Precio Venta:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setText("Estado Producto:");

        listEstadoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", "Agotado" }));

        javax.swing.GroupLayout datosProductosLayout = new javax.swing.GroupLayout(datosProductos);
        datosProductos.setLayout(datosProductosLayout);
        datosProductosLayout.setHorizontalGroup(
            datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosProductosLayout.createSequentialGroup()
                .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosProductosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(idProveedor1)
                            .addComponent(nombreProveedor1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecioProducto)
                            .addComponent(txtIdProducto)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(listEstadoProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(datosProductosLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnAddProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnAddProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        panelProductos.add(datosProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 33, -1, -1));

        registroProductos.setBackground(new java.awt.Color(255, 255, 255));
        registroProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Registro de Productos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        tablaProductos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaProductos.setModel(productosTableModel);
        tablaProductos.setRowHeight(20);
        jScrollPane5.setViewportView(tablaProductos);

        idProducto.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        idProducto.setText("ID Producto: ");

        txtFiltroProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroProductoActionPerformed(evt);
            }
        });

        btnBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarProducto.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/añadir.png"))); // NOI18N
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setBorder(null);
        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarProducto.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
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
        btnBorrarProducto.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBorrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        btnBorrarProducto.setText("Borrar");
        btnBorrarProducto.setBorder(null);
        btnBorrarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout registroProductosLayout = new javax.swing.GroupLayout(registroProductos);
        registroProductos.setLayout(registroProductosLayout);
        registroProductosLayout.setHorizontalGroup(
            registroProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(registroProductosLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(registroProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registroProductosLayout.setVerticalGroup(
            registroProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroProductosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(registroProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idProducto)
                    .addComponent(txtFiltroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registroProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        panelProductos.add(registroProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 320, -1, -1));

        btnVolverProductos.setBackground(new java.awt.Color(153, 153, 153));
        btnVolverProductos.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverProductos.setForeground(new java.awt.Color(255, 255, 255));
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
        datosVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Datos Venta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setText("ID Venta: ");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setText("ID Usuario: ");

        listIdUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setText("ID Cliente: ");

        listIdCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setText("Subtotal:");

        txtSubTotalVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalVentaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setText("Total IVA:");

        txtTotalIvaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalIvaVentaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Total Bruto:");

        txtTotalBrutoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalBrutoVentaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel13.setText("Total Neto:");

        txtTotalNetoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalNetoVentaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setText("Total Descuento:");

        txtTotalDescuentoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalDescuentoVentaActionPerformed(evt);
            }
        });

        btnAddVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnAddVenta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnAddVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/añadir.png"))); // NOI18N
        btnAddVenta.setText("Añadir");
        btnAddVenta.setBorder(null);
        btnAddVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddVenta.setMaximumSize(new java.awt.Dimension(62, 17));
        btnAddVenta.setMinimumSize(new java.awt.Dimension(62, 17));
        btnAddVenta.setPreferredSize(new java.awt.Dimension(62, 17));
        btnAddVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVentaActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout datosVentaLayout = new javax.swing.GroupLayout(datosVenta);
        datosVenta.setLayout(datosVentaLayout);
        datosVentaLayout.setHorizontalGroup(
            datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosVentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(listIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(listIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosVentaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalNetoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalBrutoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalDescuentoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosVentaLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalIvaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(datosVentaLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(btnAddVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datosVentaLayout.setVerticalGroup(
            datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosVentaLayout.createSequentialGroup()
                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosVentaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(listIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(listIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(datosVentaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(datosVentaLayout.createSequentialGroup()
                                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtSubTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotalIvaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotalBrutoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotalNetoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(datosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTotalDescuentoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelVentas.add(datosVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        registroVentas.setBackground(new java.awt.Color(255, 255, 255));
        registroVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2), "Registro de Ventas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        tablaVentas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tablaVentas);

        idVenta.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        idVenta.setText("ID Venta: ");

        txtFiltroVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroVentaActionPerformed(evt);
            }
        });

        btnBuscarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarVenta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBuscarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/añadir.png"))); // NOI18N
        btnBuscarVenta.setText("Buscar");
        btnBuscarVenta.setBorder(null);
        btnBuscarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentaActionPerformed(evt);
            }
        });

        btnEditarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarVenta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnEditarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditarVenta.setText("Editar");
        btnEditarVenta.setBorder(null);
        btnEditarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVentaActionPerformed(evt);
            }
        });

        btnBorrarVenta.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrarVenta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBorrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        btnBorrarVenta.setText("Borrar");
        btnBorrarVenta.setBorder(null);
        btnBorrarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout registroVentasLayout = new javax.swing.GroupLayout(registroVentas);
        registroVentas.setLayout(registroVentasLayout);
        registroVentasLayout.setHorizontalGroup(
            registroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroVentasLayout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(idVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(registroVentasLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(btnEditarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(registroVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        registroVentasLayout.setVerticalGroup(
            registroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroVentasLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(registroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idVenta)
                    .addComponent(txtFiltroVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registroVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        panelVentas.add(registroVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 740, -1));

        btnVolverVentas.setBackground(new java.awt.Color(153, 153, 153));
        btnVolverVentas.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnVolverVentas.setForeground(new java.awt.Color(255, 255, 255));
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

        listadoOpciones.addTab("Ventas", panelVentas);

        backgroundDashboard.add(listadoOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 810));

        panelDerechoBotones.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LOGO170.png"))); // NOI18N

        btnUsuario.setBackground(new java.awt.Color(153, 153, 153));
        btnUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setText("Usuarios");
        btnUsuario.setBorder(null);
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnClientes.setText("Clientes");
        btnClientes.setBorder(null);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorder(null);
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnProductos.setText("Productos");
        btnProductos.setBorder(null);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnVentas.setText("Ventas");
        btnVentas.setBorder(null);
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        javax.swing.GroupLayout panelDerechoBotonesLayout = new javax.swing.GroupLayout(panelDerechoBotones);
        panelDerechoBotones.setLayout(panelDerechoBotonesLayout);
        panelDerechoBotonesLayout.setHorizontalGroup(
            panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechoBotonesLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechoBotonesLayout.createSequentialGroup()
                        .addGroup(panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDerechoBotonesLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18))))
        );
        panelDerechoBotonesLayout.setVerticalGroup(
            panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechoBotonesLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );

        backgroundDashboard.add(panelDerechoBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 220, 810));

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

    private void txtTotalBrutoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalBrutoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalBrutoVentaActionPerformed

    private void txtTotalNetoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalNetoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalNetoVentaActionPerformed

    private void txtTotalDescuentoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalDescuentoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalDescuentoVentaActionPerformed

    private void btnAddVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddVentaActionPerformed

    private void txtFiltroVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroVentaActionPerformed

    private void btnBuscarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarVentaActionPerformed

    private void btnEditarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarVentaActionPerformed

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
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnAddProducto;
    private javax.swing.JButton btnAddProveedor;
    private javax.swing.JButton btnAddUsuario;
    private javax.swing.JButton btnAddVenta;
    private javax.swing.JButton btnBorrarCliente;
    private javax.swing.JButton btnBorrarProducto;
    private javax.swing.JButton btnBorrarProveedor;
    private javax.swing.JButton btnBorrarUsuario;
    private javax.swing.JButton btnBorrarVenta;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnBuscarVenta;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEditarVenta;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVolverCliente;
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
    private javax.swing.JLabel idVenta;
    private javax.swing.JLabel identificacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> listEstadoProducto;
    private javax.swing.JComboBox<String> listIdCliente;
    private javax.swing.JComboBox<String> listIdUsuario;
    private javax.swing.JComboBox<String> listTipoIdentificacionUsuario;
    private javax.swing.JTabbedPane listadoOpciones;
    private javax.swing.JLabel nombreProveedor;
    private javax.swing.JLabel nombreProveedor1;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelDerechoBotones;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JPanel panelProveedores;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JPanel panelVentas;
    private javax.swing.JPanel registroClientes;
    private javax.swing.JPanel registroProductos;
    private javax.swing.JPanel registroProveedores;
    private javax.swing.JPanel registroUsuarios;
    private javax.swing.JPanel registroVentas;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTable tablaVentas;
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
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtEmailUsuario;
    private javax.swing.JTextField txtFiltroIdentificacionCliente;
    private javax.swing.JTextField txtFiltroIdentificacionProveedor;
    private javax.swing.JTextField txtFiltroIdentificacionUsuario;
    private javax.swing.JTextField txtFiltroProducto;
    private javax.swing.JTextField txtFiltroVenta;
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
    private javax.swing.JTextField txtTotalBrutoVenta;
    private javax.swing.JTextField txtTotalDescuentoVenta;
    private javax.swing.JTextField txtTotalIvaVenta;
    private javax.swing.JTextField txtTotalNetoVenta;
    // End of variables declaration//GEN-END:variables
}

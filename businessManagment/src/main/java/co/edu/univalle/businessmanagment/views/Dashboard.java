/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.univalle.businessmanagment.views;

import co.edu.univalle.businessmanagment.models.ClienteModel;
import co.edu.univalle.businessmanagment.models.UsuarioModel;
import co.edu.univalle.businessmanagment.views.tablemodels.ClienteTableModel;
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

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        clientesTableModel = new ClienteTableModel();
        usuariosTableModel = new UsuarioTableModel();
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
    
    /* =========== USUARIOS IMPL ===========  */
    public UsuarioModel getUsuarioFromDatosUsuario(){
        UsuarioModel usuario = new UsuarioModel();
        usuario.setEmail(txtEmailUsuario.getText());
        usuario.setNombre(txtNombreUsuario.getText());
        usuario.setApellido(txtApellidoUsuario.getText());
        usuario.setIdentificacion(txtIdentificacionUsuario.getText());
        usuario.setTipoIdentificacion((String) listTipoIdentificacionUsuario.getSelectedItem());
        usuario.setTelefono(txtTelefonoUsuario.getText());
        return usuario;
    }
    
    public void setDatosUsuarioFromUsuario(UsuarioModel usuario){
        txtEmailUsuario.setText(usuario.getEmail());
        txtNombreUsuario.setText(usuario.getNombre());
        txtApellidoUsuario.setText(usuario.getApellido());
        txtIdentificacionUsuario.setText(usuario.getIdentificacion());
        txtTelefonoUsuario.setText(usuario.getTelefono());
    }
    
    public void addActionListenerBtnAddUsuario(ActionListener listener){
        btnAddUsuario.addActionListener(listener);
    }
    
    public void addActionListenerBtnBuscarUsuario(ActionListener listener){
        btnBuscarUsuario.addActionListener(listener);
    }
    
    public void addActionListenerBtnEditarUsuario(ActionListener listener){
        btnEditarUsuario.addActionListener(listener);
    }
    
    public void addActionListenerBtnBorrarUsuario(ActionListener listener){
        btnBorrarUsuario.addActionListener(listener);
    }
    
    public UsuarioModel getUsuarioSelectedOnUsuariosTable(){
        int index = tablaUsuarios.getSelectedRow();
        if (index != -1) {
            return usuariosTableModel.getUsuarioModelAt(index);
        }else{
            JOptionPane.showMessageDialog(this, "ERROR : Ningún usuario Seleccionado");
            return null;
        }
    }
    
    public List<UsuarioModel> getUsuariosSelectedOnUsuariosTable(){
        int[] index = tablaUsuarios.getSelectedRows();
        ArrayList<UsuarioModel> usuariosSelected = new ArrayList();
        for (int i : index) {
            usuariosSelected.add(usuariosTableModel.getUsuarioModelAt(i));
        }
        return usuariosSelected;
    }
    
    public String getUsuariosFilterIdentificacion(){
        return txtFiltroIdentificacionUsuario.getText();
    }
    
    /* =========== CLIENTES IMPL ===========  */
    public ClienteModel getClienteFromDatosCliente(){
        ClienteModel cliente = new ClienteModel();
        cliente.setEmail(txtEmailCliente.getText());
        cliente.setNombre(txtNombreCliente.getText());
        cliente.setApellido(txtApellidoCliente.getText());
        cliente.setIdentificacion(txtIdentificacionCliente.getText());
        cliente.setTelefono(txtTelefonoCliente.getText());
        return cliente;
    }
    
    public void setDatosClienteFromCliente(ClienteModel cliente){
        txtEmailCliente.setText(cliente.getEmail());
        txtNombreCliente.setText(cliente.getNombre());
        txtApellidoCliente.setText(cliente.getApellido());
        txtIdentificacionCliente.setText(cliente.getIdentificacion());
        txtTelefonoCliente.setText(cliente.getTelefono());
    }
    
    public void addActionListenerBtnAddCliente(ActionListener listener){
        btnAddCliente.addActionListener(listener);
    }
    
    public void addActionListenerBtnBuscarCliente(ActionListener listener){
        btnBuscarCliente.addActionListener(listener);
    }
    
    public void addActionListenerBtnEditarCliente(ActionListener listener){
        btnEditarCliente.addActionListener(listener);
    }
    
    public void addActionListenerBtnBorrarCliente(ActionListener listener){
        btnBorrarCliente.addActionListener(listener);
    }
    
    public String getClienteFiltroIdentificacion(){
        return txtFiltroIdentificacionCliente.getText();
    }
    
        public ClienteModel getClienteSelectedOnClientesTable(){
        int index = tablaClientes.getSelectedRow();
        if (index != -1) {
            return clientesTableModel.getClienteModelAt(index);
        }else{
            JOptionPane.showMessageDialog(this, "ERROR : Ningún Cliente Seleccionado");
            return null;
        }
    }
    
    public List<ClienteModel> getClientesSelectedOnClientesTable(){
        int[] index = tablaClientes.getSelectedRows();
        ArrayList<ClienteModel> clientesSelected = new ArrayList();
        for (int i : index) {
            clientesSelected.add(clientesTableModel.getClienteModelAt(i));
        }
        return clientesSelected;
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
        btnUsVolver = new javax.swing.JButton();
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
        jPanel1 = new javax.swing.JPanel();
        btnUsVolver1 = new javax.swing.JButton();
        panelProductos = new javax.swing.JPanel();
        panelProveedores = new javax.swing.JPanel();
        datosProveedores = new javax.swing.JPanel();
        nombreProveedor = new javax.swing.JLabel();
        idProveedor = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        txtIdentificacionProveedor = new javax.swing.JTextField();
        añadirProBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        registroProveedores = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        buscarProBtn = new javax.swing.JButton();
        identificacion = new javax.swing.JLabel();
        txtFiltroIdentificacionProveedor = new javax.swing.JTextField();
        editarProBtn = new javax.swing.JButton();
        borrarProBtn = new javax.swing.JButton();
        panelDerechoBotones = new javax.swing.JPanel();
        btnUsuario = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundDashboard.setBackground(new java.awt.Color(255, 255, 255));
        backgroundDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        panelUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        datosUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Usuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18))); // NOI18N

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
        btnAddUsuario.setText("Añadir");
        btnAddUsuario.setToolTipText("");
        btnAddUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUsuarioActionPerformed(evt);
            }
        });

        txt10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt10.setText("Email");

        javax.swing.GroupLayout datosUsuariosLayout = new javax.swing.GroupLayout(datosUsuarios);
        datosUsuarios.setLayout(datosUsuariosLayout);
        datosUsuariosLayout.setHorizontalGroup(
            datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(datosUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(datosUsuariosLayout.createSequentialGroup()
                        .addComponent(txt2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt3)
                        .addGap(18, 18, 18)
                        .addComponent(listTipoIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt4))
                    .addGroup(datosUsuariosLayout.createSequentialGroup()
                        .addComponent(txt6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefonoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosUsuariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
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

        panelUsuario.add(datosUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 56, 690, -1));

        registroUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        registroUsuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registro de Usuarios", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18))); // NOI18N

        tablaUsuarios.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tablaUsuarios.setModel(usuariosTableModel);
        tablaUsuarios.setRowHeight(20);
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
        btnBuscarUsuario.setText("Buscar");
        btnBuscarUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        btnEditarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnEditarUsuario.setText("Editar");
        btnEditarUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnBorrarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnBorrarUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBorrarUsuario.setText("Borrar");
        btnBorrarUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout registroUsuariosLayout = new javax.swing.GroupLayout(registroUsuarios);
        registroUsuarios.setLayout(registroUsuariosLayout);
        registroUsuariosLayout.setHorizontalGroup(
            registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroUsuariosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFiltroIdentificacionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(registroUsuariosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(registroUsuariosLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 186, Short.MAX_VALUE))
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
                .addGroup(registroUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelUsuario.add(registroUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        btnUsVolver.setBackground(new java.awt.Color(204, 204, 204));
        btnUsVolver.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnUsVolver.setText("Volver");
        btnUsVolver.setBorder(null);
        btnUsVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsVolverMouseClicked(evt);
            }
        });
        btnUsVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsVolverActionPerformed(evt);
            }
        });
        panelUsuario.add(btnUsVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 90, 20));

        listadoOpciones.addTab("Usuario", panelUsuario);

        panelCliente.setBackground(new java.awt.Color(255, 255, 255));
        panelCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        datosClientes.setBackground(new java.awt.Color(255, 255, 255));
        datosClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Cliente", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18))); // NOI18N

        txt5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt5.setText("Nombre:");

        txt7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt7.setText("Apellido:");

        txt8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt8.setText("Identificación");
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
                .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosClientesLayout.createSequentialGroup()
                        .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt5)
                            .addComponent(txt7)
                            .addComponent(txtApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(datosClientesLayout.createSequentialGroup()
                        .addComponent(txtIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datosClientesLayout.createSequentialGroup()
                        .addComponent(btnAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosClientesLayout.createSequentialGroup()
                            .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGap(118, 118, 118))
                        .addGroup(datosClientesLayout.createSequentialGroup()
                            .addGroup(datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt9)
                                .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))))
        );
        datosClientesLayout.setVerticalGroup(
            datosClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datosClientesLayout.createSequentialGroup()
                .addContainerGap()
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
                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(datosClientesLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelCliente.add(datosClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        registroClientes.setBackground(new java.awt.Color(255, 255, 255));
        registroClientes.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registro de Clientes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18))); // NOI18N

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
        tablaClientes.setRowHeight(20);
        jScrollPane4.setViewportView(tablaClientes);

        javax.swing.GroupLayout registroClientesLayout = new javax.swing.GroupLayout(registroClientes);
        registroClientes.setLayout(registroClientesLayout);
        registroClientesLayout.setHorizontalGroup(
            registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltroIdentificacionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBorrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(registroClientesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(registroClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        panelCliente.add(registroClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, 380));

        jPanel1.setBackground(new java.awt.Color(98, 82, 85));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        panelCliente.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 260, 780));

        btnUsVolver1.setBackground(new java.awt.Color(204, 204, 204));
        btnUsVolver1.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        btnUsVolver1.setText("Volver");
        btnUsVolver1.setBorder(null);
        btnUsVolver1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsVolver1MouseClicked(evt);
            }
        });
        btnUsVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsVolver1ActionPerformed(evt);
            }
        });
        panelCliente.add(btnUsVolver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 90, 20));

        listadoOpciones.addTab("Cliente", panelCliente);

        panelProductos.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
        panelProductos.setLayout(panelProductosLayout);
        panelProductosLayout.setHorizontalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        listadoOpciones.addTab("Productos", panelProductos);

        panelProveedores.setBackground(new java.awt.Color(255, 255, 255));

        datosProveedores.setBackground(new java.awt.Color(255, 255, 255));
        datosProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Proveedores\n", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18))); // NOI18N

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

        añadirProBtn.setBackground(new java.awt.Color(255, 255, 255));
        añadirProBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        añadirProBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        añadirProBtn.setText("Añadir");
        añadirProBtn.setToolTipText("");
        añadirProBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout datosProveedoresLayout = new javax.swing.GroupLayout(datosProveedores);
        datosProveedores.setLayout(datosProveedoresLayout);
        datosProveedoresLayout.setHorizontalGroup(
            datosProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datosProveedoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(añadirProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(añadirProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel3.setBackground(new java.awt.Color(98, 82, 85));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );

        registroProveedores.setBackground(new java.awt.Color(255, 255, 255));
        registroProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registro de Proveedores\n", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Roboto", 1, 18))); // NOI18N

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

        buscarProBtn.setBackground(new java.awt.Color(255, 255, 255));
        buscarProBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        buscarProBtn.setText("Buscar");
        buscarProBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscarProBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProBtnActionPerformed(evt);
            }
        });

        identificacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        identificacion.setText("Identificación:");

        txtFiltroIdentificacionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroIdentificacionProveedorActionPerformed(evt);
            }
        });

        editarProBtn.setBackground(new java.awt.Color(255, 255, 255));
        editarProBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        editarProBtn.setText("Editar");
        editarProBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        editarProBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarProBtnActionPerformed(evt);
            }
        });

        borrarProBtn.setBackground(new java.awt.Color(255, 255, 255));
        borrarProBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        borrarProBtn.setText("Borrar");
        borrarProBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addComponent(buscarProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(registroProveedoresLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(editarProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(borrarProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(buscarProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registroProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrarProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout panelProveedoresLayout = new javax.swing.GroupLayout(panelProveedores);
        panelProveedores.setLayout(panelProveedoresLayout);
        panelProveedoresLayout.setHorizontalGroup(
            panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedoresLayout.createSequentialGroup()
                .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(registroProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(datosProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        panelProveedoresLayout.setVerticalGroup(
            panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProveedoresLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelProveedoresLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(datosProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(registroProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        listadoOpciones.addTab("Proveedores", panelProveedores);

        backgroundDashboard.add(listadoOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 810));

        panelDerechoBotones.setBackground(new java.awt.Color(98, 82, 85));

        btnUsuario.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUsuario.setText("Usuarios");
        btnUsuario.setBorder(null);
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

        btnProveedores.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorder(null);
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

        btnClientes.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setBorder(null);
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

        javax.swing.GroupLayout panelDerechoBotonesLayout = new javax.swing.GroupLayout(panelDerechoBotones);
        panelDerechoBotones.setLayout(panelDerechoBotonesLayout);
        panelDerechoBotonesLayout.setHorizontalGroup(
            panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechoBotonesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelDerechoBotonesLayout.setVerticalGroup(
            panelDerechoBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDerechoBotonesLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(462, Short.MAX_VALUE))
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

    private void buscarProBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarProBtnActionPerformed

    private void txtFiltroIdentificacionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroIdentificacionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroIdentificacionProveedorActionPerformed

    private void editarProBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarProBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarProBtnActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMouseClicked
        listadoOpciones.setSelectedIndex(0);
    }//GEN-LAST:event_btnUsuarioMouseClicked

    private void btnProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedoresMouseClicked
        listadoOpciones.setSelectedIndex(2);
    }//GEN-LAST:event_btnProveedoresMouseClicked

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        listadoOpciones.setSelectedIndex(1);
    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnUsVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsVolverMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsVolverMouseClicked

    private void btnUsVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsVolverActionPerformed

    private void btnUsVolver1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsVolver1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsVolver1MouseClicked

    private void btnUsVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsVolver1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsVolver1ActionPerformed

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
    private javax.swing.JButton añadirProBtn;
    private javax.swing.JPanel backgroundDashboard;
    private javax.swing.JButton borrarProBtn;
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JButton btnAddUsuario;
    private javax.swing.JButton btnBorrarCliente;
    private javax.swing.JButton btnBorrarUsuario;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnUsVolver;
    private javax.swing.JButton btnUsVolver1;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton buscarProBtn;
    private javax.swing.JPanel datosClientes;
    private javax.swing.JPanel datosProveedores;
    private javax.swing.JPanel datosUsuarios;
    private javax.swing.JButton editarProBtn;
    private javax.swing.JLabel idProveedor;
    private javax.swing.JLabel identificacion;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> listTipoIdentificacionUsuario;
    private javax.swing.JTabbedPane listadoOpciones;
    private javax.swing.JLabel nombreProveedor;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelDerechoBotones;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JPanel panelProveedores;
    private javax.swing.JPanel panelUsuario;
    private javax.swing.JPanel registroClientes;
    private javax.swing.JPanel registroProveedores;
    private javax.swing.JPanel registroUsuarios;
    private javax.swing.JTable tablaClientes;
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
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtEmailUsuario;
    private javax.swing.JTextField txtFiltroIdentificacionCliente;
    private javax.swing.JTextField txtFiltroIdentificacionProveedor;
    private javax.swing.JTextField txtFiltroIdentificacionUsuario;
    private javax.swing.JTextField txtIdentificacionCliente;
    private javax.swing.JTextField txtIdentificacionProveedor;
    private javax.swing.JTextField txtIdentificacionUsuario;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoUsuario;
    // End of variables declaration//GEN-END:variables
}

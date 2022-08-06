/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.services;

import co.edu.univalle.businessmanagment.config.DbConnection;
import co.edu.univalle.businessmanagment.models.ClienteModel;
import co.edu.univalle.businessmanagment.models.DetalleVentaModel;
import co.edu.univalle.businessmanagment.models.UsuarioModel;
import co.edu.univalle.businessmanagment.models.VentaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author miccarurb
 */
public class VentasService {

    private static final Logger logger = LogManager.getLogger(VentasService.class);
    private UsuariosService usuariosService;
    private ClientesService clienteService;

    public VentasService() {
        this.usuariosService = new UsuariosService();
        this.clienteService = new ClientesService();
    }

    public VentaModel findVentaById(String id) throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.ventas where id_venta = ? and is_deleted is false";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            VentaModel venta = null;

            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                venta = resulsetToModel(resultSet);
                findVentaRelations(venta);
            }
            preparedStatement.close();
            resultSet.close();

            return venta;
        } catch (SQLException e) {
            throw e;
        }

    }

    public List<VentaModel> getAllVentas() throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.ventas WHERE is_deleted is false";
        List<VentaModel> ventas = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VentaModel venta = resulsetToModel(resultSet);
                findVentaRelations(venta);
                ventas.add(venta);
            }
            preparedStatement.close();
            resultSet.close();
            return ventas;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void findVentaRelations(VentaModel venta) throws SQLException {
        venta.setUsuario(usuariosService.findUsuarioByEmail(venta.getUsuario().getEmail()));
        venta.setCliente(clienteService.findClienteByIdentificacion(venta.getCliente().getIdentificacion()));
    }

    public int updateVentaValues(VentaModel venta) throws SQLException, Exception {
        if (venta.getIdVenta() == null || venta.getIdVenta().trim().isEmpty()) {
            throw new Exception("El campo 'id venta' no puede estar vacío");
        }
        int result = 0;
        String sql = "UPDATE business.ventas "
                + "SET subtotal = ?, total_iva = ?, total_bruto = ?, total_neto = ?, total_descuento = ? "
                + "WHERE id_venta = ?";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setDouble(1, venta.getSubtotal());
            preparedStatement.setDouble(2, venta.getTotalIva());
            preparedStatement.setDouble(3, venta.getTotalBruto());
            preparedStatement.setDouble(4, venta.getTotalNeto());
            preparedStatement.setDouble(5, venta.getTotalDescuento());
            preparedStatement.setString(6, venta.getIdVenta());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }

    public int createVenta(VentaModel venta) throws SQLException, Exception {
        if (venta.getIdVenta() == null || venta.getIdVenta().trim().isEmpty()) {
            throw new Exception("El campo 'id venta' no puede estar vacío");
        }
        int result = 0;
        String sql = "INSERT INTO business.ventas (id_venta, id_usuario, id_cliente, subtotal, total_iva, total_bruto, total_neto, total_descuento)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, venta.getIdVenta());
            preparedStatement.setString(2, venta.getUsuario().getIdentificacion());
            preparedStatement.setString(3, venta.getCliente().getEmail());
            preparedStatement.setDouble(4, venta.getSubtotal());
            preparedStatement.setDouble(5, venta.getTotalIva());
            preparedStatement.setDouble(6, venta.getTotalBruto());
            preparedStatement.setDouble(7, venta.getTotalNeto());
            preparedStatement.setDouble(8, venta.getTotalDescuento());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        return result;
    }

    public int deleteVenta(String idVenta) throws SQLException {
        int result = 0;
        String sql = "UPDATE business.ventas "
                + "SET is_deleted = true "
                + "WHERE id_venta = ? ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, idVenta);

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }

    public int deleteVenta(VentaModel venta) throws Exception {
        if (venta.getIdVenta() == null || venta.getIdVenta().trim().isEmpty()) {
            throw new Exception("El campo 'id venta' no puede estar vacío");
        }
        return deleteVenta(venta.getIdVenta());
    }

    public boolean checkVentaExist(String idVenta, boolean countDeletes) throws SQLException {
        String SQL_SELECT = "SELECT EXISTS (SELECT 1 FROM business.ventas WHERE id_venta = ?";
        SQL_SELECT += !countDeletes ? " AND is_deleted is false )" : " )";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet;
            preparedStatement.setString(1, idVenta);
            resultSet = preparedStatement.executeQuery();
            boolean resultado = false;
            while (resultSet.next()) {
                resultado = resultSet.getBoolean(1);
            }
            resultSet.close();
            preparedStatement.close();
            return resultado;
        } catch (SQLException e) {
            throw e;
        }
    }
//    
//    public int createOrUpdateUsuario(VentaModel usuario) throws Exception{
//        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
//            throw new Exception("El campo Email no puede estar vacío");
//        }
//        if(checkUsuarioExist(usuario.getEmail(), true)){
//            return updateUsuario(usuario);
//        } else {
//            return createUsuario(usuario);
//        }
//    }

    private static VentaModel resulsetToModel(ResultSet resultSet) throws SQLException {
        VentaModel venta = new VentaModel();
        venta.setIdVenta(resultSet.getString("id_venta"));
        venta.setUsuario(new UsuarioModel(resultSet.getString("id_usuario")));
        venta.setCliente(new ClienteModel(resultSet.getString("id_cliente")));
        venta.setSubtotal(resultSet.getDouble("subtotal"));
        venta.setTotalIva(resultSet.getDouble("total_iva"));
        venta.setTotalBruto(resultSet.getDouble("total_bruto"));
        venta.setTotalNeto(resultSet.getDouble("total_neto"));
        venta.setTotalDescuento(resultSet.getDouble("total_descuento"));
        venta.setFechaCreacion(resultSet.getDate("fecha_creacion"));
        venta.setIsDeleted(resultSet.getBoolean("is_deleted"));
        return venta;
    }

    public int createDetalleVenta(String idVenta,DetalleVentaModel detalle) throws SQLException, Exception {
        if (idVenta == null || idVenta.trim().isEmpty()) {
            throw new Exception("El campo 'id venta' no puede estar vacío");
        }
        if (detalle.getProducto().getIdProducto() == null || detalle.getProducto().getIdProducto().trim().isEmpty()) {
            throw new Exception("El campo 'Producto' no puede estar vacío");
        }
        int result = 0;
        String sql = "INSERT INTO business.detalle_ventas (id_detalle, id_venta, id_producto, cantidad,"
                + " total_bruto, total_neto, descuento, es_mayorista)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, detalle.getIdDetalle());
            preparedStatement.setString(2, idVenta);
            preparedStatement.setString(3, detalle.getProducto().getIdProducto());
            preparedStatement.setInt(4, detalle.getCantidad());
            preparedStatement.setDouble(5, detalle.getTotalBruto());
            preparedStatement.setDouble(6, detalle.getTotalNeto());
            preparedStatement.setDouble(7, detalle.getDescuento());
            preparedStatement.setBoolean(8, detalle.isEsMayorista());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        return result;
    }

}

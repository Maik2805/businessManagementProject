/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.services;

import co.edu.univalle.businessmanagment.config.DbConnection;
import co.edu.univalle.businessmanagment.models.ProductoModel;
import co.edu.univalle.businessmanagment.models.VentaModel;
import co.edu.univalle.businessmanagment.models.virtuals.AvailableProductVModel;
import co.edu.univalle.businessmanagment.utils.UuidHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author miccarurb
 */
public class StockService {

    private static final Logger logger = LogManager.getLogger(StockService.class);

    public int cantidadProductosDisponibles(ProductoModel producto) throws SQLException, Exception {
        if (producto.getIdProducto() == null || producto.getIdProducto().trim().isEmpty()) {
            throw new Exception("El campo Id Producto no puede estar vacío");
        }
        return cantidadProductosDisponibles(producto.getIdProducto());
    }

    public int cantidadProductosDisponibles(String productoId) throws SQLException, Exception {
        if (productoId == null || productoId.trim().isEmpty()) {
            throw new Exception("El campo Id Producto no puede estar vacío");
        }
        final String SQL_SELECT = "select SUM(sp.cantidad_disponible) from business.stock_productos sp "
                + "where sp.id_producto = ? and sp.is_deleted is false";
        int cantidadDisponible = 0;
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setString(1, productoId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cantidadDisponible = resultSet.getInt(1);
            }
            preparedStatement.close();
            resultSet.close();
            return cantidadDisponible;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<AvailableProductVModel> obtenerStock() throws SQLException {
        final String SQL_SELECT = "select SUM(sp.cantidad_disponible) as total, sp.id_producto,  p.nombre, p.precio_venta_base  from business.stock_productos sp "
                + "inner join business.productos p on sp.id_producto = p.id_producto where sp.is_deleted is false and p.is_deleted is false group by sp.id_producto,  p.nombre, p.precio_venta_base";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AvailableProductVModel> resultado = new ArrayList();
            while (resultSet.next()) {
                int cantidad = resultSet.getInt("total");
                String id_producto = resultSet.getString("id_producto");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio_venta_base");
                resultado.add(new AvailableProductVModel(cantidad, id_producto, nombre, precio));
            }
            preparedStatement.close();
            resultSet.close();
            return resultado;
        } catch (SQLException e) {
            throw e;
        }
    }

    public int insertDefaultStock(String producto_id) throws SQLException, Exception {
        if (producto_id == null || producto_id.trim().isEmpty()) {
            throw new Exception("El campo Id Producto no puede estar vacío");
        }
        int result = 0;
        String idAleatorio = UuidHelper.generate();
        String sql = "INSERT INTO business.stock_productos (id_stock, id_lote, id_producto, cantidad_inicial, cantidad_disponible, estado) "
                + " VALUES(?, NULL, ? , 9999, 9999, 'Activo')";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, idAleatorio);
            preparedStatement.setString(2, producto_id);

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }

}

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
        if (producto.getIdProducto()== null || producto.getIdProducto().trim().isEmpty()) {
            throw new Exception("El campo Id Producto no puede estar vacío");
        }
        final String SQL_SELECT = "select SUM(sp.cantidad_disponible) from business.stock_productos sp " +
                "where sp.id_producto = ? and sp.is_deleted is false";
        int cantidadDisponible = 0;
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setString(1, producto.getIdProducto());
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
    
    public List<AvailableProductVModel> obtenerStock() throws SQLException{
        final String SQL_SELECT = "select SUM(sp.cantidad_disponible) as total, sp.id_producto,  p.nombre  from business.stock_productos sp " +
        "inner join business.productos p on sp.id_producto = p.id_producto sp.is_deleted is false and p.id_deleted is false group by sp.id_producto,  p.nombre;";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AvailableProductVModel> resultado = new ArrayList();
            while (resultSet.next()) {
                int cantidad = resultSet.getInt("total");
                String id_producto = resultSet.getString("id_producto");
                String nombre = resultSet.getString("nombre");
                resultado.add(new AvailableProductVModel(cantidad, id_producto, nombre));
            }
            preparedStatement.close();
            resultSet.close();
            return resultado;
        } catch (SQLException e) {
            throw e;
        }
    }
    
}

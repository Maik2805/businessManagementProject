/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.services;

import co.edu.univalle.businessmanagment.config.DbConnection;
import co.edu.univalle.businessmanagment.models.ProductoModel;
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
public class ProductosService {

    private static final Logger logger = LogManager.getLogger(ProductosService.class);

    public ProductoModel findProductoById(String idProducto) throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.productos where id_producto = ? and is_deleted is false";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ProductoModel producto = null;
            ResultSet resultSet;
            preparedStatement.setString(1, idProducto);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                producto = resulsetToModel(resultSet);
            }
            preparedStatement.close();
            resultSet.close();

            return producto;
        } catch (SQLException e) {
            throw e;
        }

    }
    
    public List<ProductoModel> getProductosByNombre(String nombre) throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.productos WHERE nombre LIKE '%?%' AND is_deleted is false";
        List<ProductoModel> productos = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productos.add(resulsetToModel(resultSet));
            }
            preparedStatement.close();
            resultSet.close();
            return productos;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<ProductoModel> getAllProductos() throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.productos WHERE is_deleted is false";
        List<ProductoModel> productos = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productos.add(resulsetToModel(resultSet));
            }
            preparedStatement.close();
            resultSet.close();
            return productos;
        } catch (SQLException e) {
            throw e;
        }
    }

    public int updateProducto(ProductoModel producto) throws SQLException, Exception {
        if (producto.getIdProducto()== null || producto.getIdProducto().trim().isEmpty()) {
            throw new Exception("El campo Id no puede estar vacío");
        }
        int result = 0;
        String sql = "UPDATE business.productos "
                + "SET nombre = ?, precio_venta_base = ?, estado = ?   "
                + "WHERE id_producto = ? ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setDouble(2, producto.getPrecioVentaBase());
            preparedStatement.setString(3, producto.getEstado());
            preparedStatement.setString(4, producto.getIdProducto());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }
    
    public int createProducto(ProductoModel producto) throws SQLException, Exception {
        if (producto.getIdProducto()== null || producto.getIdProducto().trim().isEmpty()) {
            throw new Exception("El campo Id Producto no puede estar vacío");
        }
        int result = 0;
        String sql = "INSERT INTO business.productos (id_producto, nombre, precio_venta_base, estado)"
                + "VALUES (?, ?, ?, ? ) ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, producto.getIdProducto());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setDouble(3, producto.getPrecioVentaBase());
            preparedStatement.setString(4, producto.getEstado());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }
    
    public int deleteProducto(String idProducto) throws SQLException{
        int result = 0;
        String sql = "UPDATE business.productos "
                + "SET is_deleted = true "
                + "WHERE id_producto = ? ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, idProducto);

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }
    
    public int deleteProducto(ProductoModel producto) throws Exception{
        if (producto.getIdProducto()== null || producto.getIdProducto().trim().isEmpty()) {
            throw new Exception("El campo Id Producto no puede estar vacío");
        }
        return deleteProducto(producto.getIdProducto());
    }
    
    public boolean checkProductoExist(String idProducto, boolean countDeletes) throws SQLException{
        String SQL_SELECT = "SELECT EXISTS (SELECT 1 FROM business.productos WHERE id_producto = ?";
        SQL_SELECT += !countDeletes ? " AND is_deleted is false )" : " )";  
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet;
            preparedStatement.setString(1, idProducto);
            resultSet = preparedStatement.executeQuery();
            boolean resultado = false; 
            while (resultSet.next()) {
                resultado = resultSet.getBoolean(1);
            }
            resultSet.close();
            preparedStatement.close();
            return resultado;
        }
    }
    
    public int createOrUpdateProducto(ProductoModel producto) throws Exception{
        if (producto.getIdProducto()== null || producto.getIdProducto().trim().isEmpty()) {
            throw new Exception("El campo Id Producto no puede estar vacío");
        }
        if(checkProductoExist(producto.getIdProducto(), true)){
            return updateProducto(producto);
        } else {
            return createProducto(producto);
        }
    }

    private static ProductoModel resulsetToModel(ResultSet resultSet) throws SQLException {
        ProductoModel producto = new ProductoModel();
        producto.setIdProducto(resultSet.getString("id_producto"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecioVentaBase(resultSet.getDouble("precio_venta_base"));
        producto.setEstado(resultSet.getString("estado"));
        producto.setFechaCreacion(resultSet.getDate("fecha_creacion"));
        producto.setIsDeleted(resultSet.getBoolean("is_deleted"));
        return producto;
    }

}

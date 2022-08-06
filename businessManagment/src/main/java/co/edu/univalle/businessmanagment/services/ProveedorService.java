/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.univalle.businessmanagment.services;

import co.edu.univalle.businessmanagment.config.DbConnection;
import co.edu.univalle.businessmanagment.models.ProveedorModel;
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
 * @author camilo
 */
public class ProveedorService {
    
    private static final Logger logger = LogManager.getLogger(ProveedorService.class);
    
    public ProveedorModel findProveedorByIdentificacion (String id) throws SQLException {
        
        final String SQL_SELECT = "SELECT * FROM business.proveedores where identificaicon =? and is_deleted is false";
        
        try (Connection conn = DbConnection.getConnection(); 
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ProveedorModel proveedor = null;
            ResultSet resultSet;
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                proveedor = resultsetToModel(resultSet);
            }
            resultSet.close();
            return proveedor;
            } catch (SQLException e) {
                throw e;
            }
    }
    
    public List<ProveedorModel> getAllProveedores() throws SQLException {
        
        final String SQL_SELECT = "SELECT * FROM bussines.proveedores WHERE is_deleted is false";
        
        List<ProveedorModel> proveedor = new ArrayList<>();
        
        try (Connection conn = DbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet  = preparedStatement.executeQuery();
            while (resultSet.next()) {
                proveedor.add(resultsetToModel(resultSet));
            }
            return proveedor;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public int updateProveedor (ProveedorModel proveedor) throws SQLException, Exception {
        
        if (proveedor.getIdentificacion() == null || proveedor.getIdentificacion().trim().isEmpty()) {
            throw new Exception ("El proveedor debe tener una identificación");
        }
        
        int result = 0;
        String sql = "UPDATE bussiness.proveedores"
                     + "SET nombre = ?" + "WHERE identificacion = ?";
        
        try (Connection conn = DbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, proveedor.getNombre());
            
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        return result;
    }
    
    /**
     *
     * @param proveedor
     * @return
     * @throws SQLException
     */
    public int createProveedor(ProveedorModel proveedor) throws SQLException, Exception {
        if (proveedor.getIdentificacion() == null || proveedor.getIdentificacion().trim().isEmpty()) {
            throw new Exception ("El campo Identificación no puede estar vacío");
        }
        
        int result = 0;
        String sql = "INSERT INTO business.proveedores (nombre) "
                + "VALUES (?) ";
        try (Connection conn = DbConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
            preparedStatement.setString (1, proveedor.getNombre());
            
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        return result;
    }
    
    public int deleteProveedor (String username) throws SQLException {
        int result = 0;
        String sql = "UPDATE business.proveedores "
                + "SET is_deleted = true "
                + "WHERE identificacion = ? ";
        try (Connection conn = DbConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
            preparedStatement.setString(1, username);
            
            result = preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        return result;
    }
    
    public int deleteProveedor (ProveedorModel proveedor) throws Exception {
        if (proveedor.getIdentificacion() == null || proveedor.getIdentificacion().isEmpty()) {
            throw new Exception ("El campo Identificacion no puede estar vacío");
        }
        return deleteProveedor(proveedor.getIdentificacion());
    }
    
    public boolean checkProveedorExist (String username, boolean countDeletes) throws SQLException {
        String SQL_SELECT = "SLECT EXISTS ( SELECT 1 FROM business.proveedores WHERE identificacion = ?";
        SQL_SELECT += !countDeletes ? " AND is_deleted is flase )" : ")";
        try (Connection conn = DbConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet;
            preparedStatement.setString(1, username);
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
    
    public int createOrUpdateProveedor (ProveedorModel proveedor) throws Exception {
        if (proveedor.getIdentificacion() == null || proveedor.getIdentificacion().trim().isEmpty()) {
            throw new Exception ("El campo Identificacion no puede estar vacío");
        }
        if (checkProveedorExist(proveedor.getIdentificacion(), true)) {
            return updateProveedor (proveedor);
        } else {
            return createProveedor (proveedor);
        }
    }
    
    private static ProveedorModel resultsetToModel (ResultSet resultSet) throws SQLException {
        ProveedorModel proveedor = new ProveedorModel();
        proveedor.setIdentificacion(resultSet.getString("identificacion "));
        proveedor.setNombre(resultSet.getString("nombre "));
        proveedor.setFechaCreacion(resultSet.getDate("fecha_creacion "));
        proveedor.setIsDeleted(resultSet.getBoolean("is_deleted "));
        return proveedor;
    }
}

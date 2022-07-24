/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.services;

import co.edu.univalle.businessmanagment.config.DbConnection;
import co.edu.univalle.businessmanagment.models.ClienteModel;
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
public class ClientesService {

    private static final Logger logger = LogManager.getLogger(ClientesService.class);

    public ClienteModel findClienteByIdentificacion(String identificacion) throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.clientes where identificacion = ? and is_deleted is false";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ClienteModel cliente = null;
            ResultSet resultSet;
            preparedStatement.setString(1, identificacion);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cliente = resulsetToModel(resultSet);
            }
            preparedStatement.close();
            resultSet.close();

            return cliente;
        } catch (SQLException e) {
            throw e;
        }

    }

    public List<ClienteModel> getAllClientes() throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.clientes WHERE is_deleted is false";
        List<ClienteModel> clientes = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                clientes.add(resulsetToModel(resultSet));
            }
            preparedStatement.close();
            resultSet.close();
            return clientes;
        } catch (SQLException e) {
            throw e;
        }
    }

    public int updateCliente(ClienteModel cliente) throws SQLException, Exception {
        if (cliente.getIdentificacion()== null || cliente.getIdentificacion().trim().isEmpty()) {
            throw new Exception("El campo Identificacion no puede estar vacío");
        }
        int result = 0;
        String sql = "UPDATE business.clientes "
                + "SET nombre = ?, apellido = ?, email = ? ,telefono = ?  "
                + "WHERE identificacion = ? ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getIdentificacion());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }
    
    public int createCliente(ClienteModel cliente) throws SQLException, Exception {
        if (cliente.getIdentificacion()== null || cliente.getIdentificacion().trim().isEmpty()) {
            throw new Exception("El campo Identificacion no puede estar vacío");
        }
        int result = 0;
        String sql = "INSERT INTO business.clientes (identificacion, nombre, apellido, email, telefono )"
                + "VALUES (?, ?, ?, ?, ?) ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, cliente.getIdentificacion());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getApellido());
            preparedStatement.setString(4, cliente.getEmail());
            preparedStatement.setString(5, cliente.getTelefono());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }
    
    public int deleteCliente(String identificacion) throws SQLException{
        int result = 0;
        String sql = "UPDATE business.clientes "
                + "SET is_deleted = true "
                + "WHERE identificacion = ? ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, identificacion);

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }
    
    public int deleteCliente(ClienteModel cliente) throws Exception{
        if (cliente.getIdentificacion()== null || cliente.getIdentificacion().trim().isEmpty()) {
            throw new Exception("El campo Identificacion no puede estar vacío");
        }
        return deleteCliente(cliente.getIdentificacion());
    }
    
    public boolean checkClienteExist(String identificacion, boolean countDeletes) throws SQLException{
        String SQL_SELECT = "SELECT EXISTS (SELECT 1 FROM business.clientes WHERE identificacion = ?";
        SQL_SELECT += !countDeletes ? " AND is_deleted is false )" : " )";  
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet;
            preparedStatement.setString(1, identificacion);
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
    
    public int createOrUpdateCliente(ClienteModel cliente) throws Exception{
        if (cliente.getIdentificacion()== null || cliente.getIdentificacion().trim().isEmpty()) {
            throw new Exception("El campo Identificacion no puede estar vacío");
        }
        if(checkClienteExist(cliente.getIdentificacion(), true)){
            return updateCliente(cliente);
        } else {
            return updateCliente(cliente);
        }
    }

    private static ClienteModel resulsetToModel(ResultSet resultSet) throws SQLException {
        ClienteModel cliente = new ClienteModel();
        cliente.setIdentificacion(resultSet.getString("identificacion"));
        cliente.setNombre(resultSet.getString("nombre"));
        cliente.setApellido(resultSet.getString("apellido"));
        cliente.setEmail(resultSet.getString("email"));
        cliente.setTelefono(resultSet.getString("telefono"));
        cliente.setFechaCreacion(resultSet.getDate("fecha_creacion"));
        cliente.setIsDeleted(resultSet.getBoolean("is_deleted"));
        return cliente;
    }

}

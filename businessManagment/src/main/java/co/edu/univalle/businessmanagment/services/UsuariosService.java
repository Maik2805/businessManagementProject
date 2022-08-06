/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.services;

import co.edu.univalle.businessmanagment.config.DbConnection;
import co.edu.univalle.businessmanagment.models.UsuarioModel;
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
public class UsuariosService {

    private static final Logger logger = LogManager.getLogger(UsuariosService.class);

    public UsuarioModel findUsuarioByEmail(String email) throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.usuarios where email = ? and is_deleted is false";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            UsuarioModel usuario = null;
            ResultSet resultSet;
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario = resulsetToModel(resultSet);
            }

            resultSet.close();

            return usuario;
        } catch (SQLException e) {
            throw e;
        }

    }
    
    public List<UsuarioModel> findUsuarioByEmailFilter(String email) throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.usuarios WHERE email LIKE '?' and is_deleted is false";
        List<UsuarioModel> usuarios = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            preparedStatement.setString(1, "%"+email+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuarios.add(resulsetToModel(resultSet));
            }

            return usuarios;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<UsuarioModel> getAllUsuarios() throws SQLException {
        final String SQL_SELECT = "SELECT * FROM business.usuarios WHERE is_deleted is false";
        List<UsuarioModel> usuarios = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuarios.add(resulsetToModel(resultSet));
            }

            return usuarios;
        } catch (SQLException e) {
            throw e;
        }
    }

    public int updateUsuario(UsuarioModel usuario) throws SQLException, Exception {
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new Exception("El campo Email no puede estar vacío");
        }
        int result = 0;
        String sql = "UPDATE business.usuarios "
                + "SET tipo_identificacion = ?, identificacion = ?, nombre = ?, apellido = ?, telefono = ? "
                + "WHERE email=?";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, usuario.getTipoIdentificacion());
            preparedStatement.setString(2, usuario.getIdentificacion());
            preparedStatement.setString(3, usuario.getNombre());
            preparedStatement.setString(4, usuario.getApellido());
            preparedStatement.setString(5, usuario.getTelefono());
            preparedStatement.setString(6, usuario.getEmail());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }
    
    public int createUsuario(UsuarioModel usuario) throws SQLException, Exception {
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new Exception("El campo Email no puede estar vacío");
        }
        int result = 0;
        String sql = "INSERT INTO business.usuarios (tipo_identificacion, identificacion, nombre, apellido, telefono, email)"
                + "VALUES (?, ?, ?, ?, ?, ?) ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, usuario.getTipoIdentificacion());
            preparedStatement.setString(2, usuario.getIdentificacion());
            preparedStatement.setString(3, usuario.getNombre());
            preparedStatement.setString(4, usuario.getApellido());
            preparedStatement.setString(5, usuario.getTelefono());
            preparedStatement.setString(6, usuario.getEmail());

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }
    
    public int deleteUsuario(String username) throws SQLException{
        int result = 0;
        String sql = "UPDATE business.usuarios "
                + "SET is_deleted = true "
                + "WHERE email = ? ";
        try (Connection conn = DbConnection.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, username);

            result = preparedStatement.executeUpdate();
            preparedStatement.close();

        }
        return result;
    }
    
    public int deleteUsuario(UsuarioModel usuario) throws Exception{
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new Exception("El campo Email no puede estar vacío");
        }
        return deleteUsuario(usuario.getEmail());
    }
    
    public boolean checkUsuarioExist(String username, boolean countDeletes) throws SQLException{
        String SQL_SELECT = "SELECT EXISTS (SELECT 1 FROM business.usuarios WHERE email = ?";
        SQL_SELECT += !countDeletes ? " AND is_deleted is false )" : " )";  
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
    
    public int createOrUpdateUsuario(UsuarioModel usuario) throws SQLException, Exception{
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new Exception("El campo Email no puede estar vacío");
        }
        if(checkUsuarioExist(usuario.getEmail(), true)){
            return updateUsuario(usuario);
        } else {
            return createUsuario(usuario);
        }
    }

    private static UsuarioModel resulsetToModel(ResultSet resultSet) throws SQLException {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setEmail(resultSet.getString("email"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setApellido(resultSet.getString("apellido"));
        usuario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
        usuario.setIdentificacion(resultSet.getString("identificacion"));
        usuario.setTelefono(resultSet.getString("telefono"));
        usuario.setFechaCreacion(resultSet.getDate("fecha_creacion"));
        usuario.setIsDeleted(resultSet.getBoolean("is_deleted"));
        return usuario;

    }

}

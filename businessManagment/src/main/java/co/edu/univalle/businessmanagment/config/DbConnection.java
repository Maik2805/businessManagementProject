/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.businessmanagment.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author miccarurb
 */
public class DbConnection {
    private static final Logger logger = LogManager.getLogger(DbConnection.class);

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
        if (connection != null && !connection.isClosed()) {
            System.out.println("Connected to the database!");
            return connection;
        }
        return createConnection();
    }

    private static Connection createConnection() throws SQLException {
        try (InputStream input = DbConnection.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            final String URL = prop.getProperty("database.url", "jdbc:postgresql://localhost/postgres");
            final String USER = prop.getProperty("database.user", "root");
            final String PASSWORD = prop.getProperty("database.password", "admin");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException | IOException e) {
            logger.error("Error creando la conexión a la abse de datos",e);
            throw new SQLException(e);
        }
    }
    
    static class MiShDwnHook extends Thread {
        //Justo antes de finaliza el programa la JVM invocará
        //este método donde podemos cerra la conexión
        @Override
        public void run(){
            try{
                Connection con = DbConnection.getConnection();
                con.close();                     
            }
            catch (Exception ex){
                logger.error(ex);
            }
        }
    }
}

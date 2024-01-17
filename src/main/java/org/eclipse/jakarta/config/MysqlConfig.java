package org.eclipse.jakarta.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConfig {

    private Connection connection;

    public MysqlConfig() throws IOException {
        try {
            System.out.println("Entra en mysql config");

            // PROPERTIES
            InputStream inputStreamProperties = this.getClass().getClassLoader().getResourceAsStream("application.properties");
            Properties properties = new Properties();
            properties.load(inputStreamProperties);

            final String host = properties.getProperty("mysql.host");
            final String username = properties.getProperty("mysql.username");
            final String password = properties.getProperty("mysql.password");
            final String database = properties.getProperty("mysql.database");
            System.out.println(host+username+password+database);

            //CONEXIÓN
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username,password);

            if(connection == null){
                System.out.println("Conexion no establecida");
            }
            System.out.println("jdbc:mysql://\" + host + \"/\" + database, username,password");
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return connection;
    }
}

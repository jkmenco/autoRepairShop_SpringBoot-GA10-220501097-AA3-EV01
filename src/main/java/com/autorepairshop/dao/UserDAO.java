package com.autorepairshop.dao;

import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

@Repository
public class UserDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    private static final String VALIDATE_USER =
            "SELECT * FROM users WHERE username=? AND password=?";

    public UserDAO() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db_credentials.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("❌ No se encontró el archivo de credenciales");
                return;
            }
            prop.load(input);
            jdbcURL = prop.getProperty("jdbc.url");
            jdbcUsername = prop.getProperty("jdbc.username");
            jdbcPassword = prop.getProperty("jdbc.password");
            System.out.println("✅ Credenciales cargadas correctamente en UserDAO");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String username, String password) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement ps = connection.prepareStatement(VALIDATE_USER)) {
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

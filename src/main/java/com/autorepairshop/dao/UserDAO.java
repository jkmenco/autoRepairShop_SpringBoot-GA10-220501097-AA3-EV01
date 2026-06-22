package com.autorepairshop.dao;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDAO {
    private String jdbcURL = "jdbc:mysql://reseau.proxy.rlwy.net:48918/railway?useSSL=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "gmBaLbCZEGxGAzcsrKrMkWcsxavTcJqQ";

    private static final String VALIDATE_USER =
            "SELECT * FROM users WHERE username=? AND password=?";

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

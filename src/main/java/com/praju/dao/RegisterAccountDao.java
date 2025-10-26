package com.praju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterAccountDao {

    private static final String URL = "jdbc:mysql://localhost:3306/expensetracker";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public boolean registerUser(String username, String email, String password) {
        boolean success = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connecting to DB with root credentials...register dao");

            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                success = true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success;
    }
}

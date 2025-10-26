package com.praju.dao;

import java.sql.*;

public class LoginAcccountDao {

    private static final String URL = "jdbc:mysql://localhost:3306/expensetracker";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public int validateUser(String username, String email, String password) {
        int userId = -1;

        String query = "SELECT * FROM users WHERE username = ? AND email = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connecting to DB with root credentials...logindao");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	userId = rs.getInt("user_id");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userId;
    }
}

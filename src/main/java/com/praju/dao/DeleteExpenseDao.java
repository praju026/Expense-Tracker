package com.praju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteExpenseDao {
    private Connection connection;

    public DeleteExpenseDao() throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker", "root", "root");
        System.out.println("Connecting to DB with root credentials...delete dao");
    }

    public boolean deleteExpense(int expenseId, int userId) {
        String sql = "DELETE FROM expenses WHERE expense_id=? AND user_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, expenseId);
            ps.setInt(2, userId);
            int rows = ps.executeUpdate();
            System.out.println("Rows deleted: " + rows);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

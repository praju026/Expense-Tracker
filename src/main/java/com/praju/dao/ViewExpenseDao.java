package com.praju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.praju.model.*;

public class ViewExpenseDao {
	
	private Connection connection ;
	public  ViewExpenseDao() throws Exception {
		
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker","root","root");
	System.out.println("Connecting to DB with root credentials...view dao");

	}

	 public List<Expense> getAllExpenses(int userId) throws SQLException {
	        List<Expense> list = new ArrayList<>();
	PreparedStatement ps = connection.prepareStatement("SELECT * FROM EXPENSES WHERE user_id=?");
	ps.setInt(1, userId); 
	ResultSet rs =ps.executeQuery();
	
	 while (rs.next()) {
         Expense e = new Expense();
         e.setId(rs.getInt("expense_id"));
         e.setCategory(rs.getString("category"));
         e.setAmount(rs.getDouble("amount"));
         e.setDate(rs.getString("date"));
         e.setDescription(rs.getString("description"));
         list.add(e);
     }
     return list;
	
	}

	public Expense getExpenseById(int expenseId, int userId) throws SQLException {
    String sql = "SELECT * FROM expenses WHERE expense_id=? AND user_id=?";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker","root","root");
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, expenseId);
        ps.setInt(2, userId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Expense e = new Expense();
            e.setId(rs.getInt("expense_id"));
            e.setCategory(rs.getString("category"));
            e.setAmount(rs.getDouble("amount"));
            e.setDate(rs.getDate("date").toString());
            e.setDescription(rs.getString("description"));
            return e;
        }
    }
    return null;
}
}
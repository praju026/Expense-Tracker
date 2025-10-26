package com.praju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddExpenseDao {

	
	public boolean AddExpense(int userId, String category ,String amount ,String date ,String description) {
		
		try {
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker","root","root");
			System.out.println("Connecting to DB with root credentials.. adddao.");

			String query = "INSERT INTO expenses (user_id, category, amount, date, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setString(2, category);
            ps.setString(3, amount);
            ps.setString(4, date);
            ps.setString(5, description);
			int count = ps.executeUpdate();
			return count>0;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
		
	}
}

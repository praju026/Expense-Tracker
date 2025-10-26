package com.praju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExpenseDao {
	
	
	public boolean UpdateExpense(String category ,String amount ,String date ,String description,int userId,int expenseId) {
		
		try {
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker","root","root");
			System.out.println("Connecting to DB with root credentials...update dao");

			String query = "UPDATE expenses SET category=?, amount=?, date=?, description=? WHERE expense_id=? AND user_id=?";
            PreparedStatement ps = connection.prepareStatement(query);
           
            ps.setString(1, category);
            ps.setString(2, amount);
            ps.setString(3, date);
            ps.setString(4, description);
            ps.setInt(5, expenseId);
            ps.setInt(6, userId);
			int count = ps.executeUpdate();
			return count>0;
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
}
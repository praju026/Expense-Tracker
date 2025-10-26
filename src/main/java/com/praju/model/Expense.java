package com.praju.model;

import java.sql.Date;

public class Expense {
	    private int id;
	    private String category;
	    private double amount;
	    private String date;
	    private String description;
	    
	    
		public String getDescription() {
			return description;
		}
		public void setDescription(String discription) {
			this.description = discription;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}

	   

}

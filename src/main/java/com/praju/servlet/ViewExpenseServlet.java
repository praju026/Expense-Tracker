package com.praju.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.praju.dao.ViewExpenseDao;
import com.praju.model.*;

@WebServlet("/ViewExpenseServlet")
public class ViewExpenseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int userId = (int) session.getAttribute("UserId");
		
		try {
			ViewExpenseDao dao = new ViewExpenseDao();
			
			List<Expense> list = dao.getAllExpenses(userId);

			request.setAttribute("expenses", list);
			RequestDispatcher rd = request.getRequestDispatcher("ViewExpense.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

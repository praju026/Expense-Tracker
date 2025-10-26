package com.praju.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.praju.dao.UpdateExpenseDao;


@WebServlet("/UpdateExpenseServlet")
public class UpdateExpenseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String category = request.getParameter("category");
		String amount = request.getParameter("amount");
		String date = request.getParameter("date");
		String description = request.getParameter("description");

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("UserId");
		UpdateExpenseDao dao = new UpdateExpenseDao();
		
		int expenseId = Integer.parseInt(request.getParameter("id"));

	
		if (dao.UpdateExpense(category, amount, date, description, userId, expenseId)) {
		    response.sendRedirect("ViewExpenseServlet"); 
		} else {
		    request.setAttribute("error", "Failed to update expense");
		    request.getRequestDispatcher("/index.jsp").forward(request, response);
		}


	}
}

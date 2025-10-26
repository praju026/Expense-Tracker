package com.praju.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.praju.dao.AddExpenseDao;

@WebServlet("/AddExpense")
public class AddExpense extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category = request.getParameter("category");
		String amount = request.getParameter("amount");
		String date = request.getParameter("date");
		String description = request.getParameter("description");

		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("UserId");
		AddExpenseDao dao = new AddExpenseDao();
		if (dao.AddExpense(userId, category, amount, date, description)) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Login failed!");
			request.setAttribute("error", "Invalid data");
			RequestDispatcher rd = request.getRequestDispatcher("/AddExpense.jsp");
			rd.forward(request, response);
		}
	}

}

package com.praju.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.praju.dao.DeleteExpenseDao;

@WebServlet("/DeleteExpenseServlet")
public class DeleteExpenseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int expenseId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("UserId");

        try {
            DeleteExpenseDao dao = new DeleteExpenseDao();
            boolean success = dao.deleteExpense(expenseId, userId);
            if (success) {
                response.sendRedirect("ViewExpenseServlet");
            } else {
                response.getWriter().println("Failed to delete expense!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

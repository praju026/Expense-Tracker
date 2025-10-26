package com.praju.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.praju.dao.ViewExpenseDao;
import com.praju.model.Expense;

@WebServlet("/EditExpenseServlet")
public class EditExpenseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
          
            String idParam = request.getParameter("id");
            System.out.println("ID PARAM: " + idParam);
            int expenseId = Integer.parseInt(idParam);

          
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("UserId");

            ViewExpenseDao dao = new ViewExpenseDao();
            Expense expense = dao.getExpenseById(expenseId, userId); // create this method

            request.setAttribute("expense", expense);
            RequestDispatcher rd = request.getRequestDispatcher("/EditExpenseView.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}

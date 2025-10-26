package com.praju.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.praju.dao.LoginAcccountDao;

@WebServlet("/LoginAccount")
public class LoginAccountServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");

        HttpSession session = request.getSession();
        LoginAcccountDao dao = new LoginAcccountDao();
        int userId = dao.validateUser(username, email, password);

        if (userId>0) {
            System.out.println("Login success!");
            session.setAttribute("UserId", userId);
            session.setAttribute("UserName", username);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else {
            System.out.println("Login failed!");
            request.setAttribute("error", "Invalid username, email or password.");
            RequestDispatcher rd = request.getRequestDispatcher("/LoginAccountView.jsp");
            rd.forward(request, response);
        }
    }
}

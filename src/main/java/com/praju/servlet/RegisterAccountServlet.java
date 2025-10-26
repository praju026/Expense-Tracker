package com.praju.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.praju.dao.RegisterAccountDao;

@WebServlet("/RegisterAccountServlet")
public class RegisterAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");

        System.out.println("Register servlet triggered");
        System.out.println("username: " + username);
        System.out.println("email: " + email);
        System.out.println("password: " + password);

        RegisterAccountDao dao = new RegisterAccountDao();

        boolean result = dao.registerUser(username, email, password);

        if (result) {
            System.out.println("User registered successfully!");
            RequestDispatcher rd = request.getRequestDispatcher("/LoginAccountView.jsp");
            rd.forward(request, response);
        } else {
            System.out.println("Registration failed!");
            request.setAttribute("error", "Unable to register user. Try again.");
            RequestDispatcher rd = request.getRequestDispatcher("/RegisterAccountView.jsp");
            rd.forward(request, response);
        }
    }
}

package com.articleapplication.controller;

import com.articleapplication.dao.UserDaoImpl;
import com.articleapplication.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    private UserDaoImpl userDaoImp;
    @Override
    public void init() throws ServletException {
        userDaoImp = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");

        User user = userDaoImp.getUser(username, password);

        if (user != null) {
            request.getSession().setAttribute("name", user.getFirstName());
            request.getSession().setAttribute("username", user.getUsername());
            response.sendRedirect("user/article");
        } else {
            request.setAttribute("loginError", "Wrong Username or Password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
package com.articleapplication.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "/user/*", "/admin/*" })
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        boolean isLoginPage = requestURI.endsWith("/login.jsp");
        boolean isRegisterPage = requestURI.endsWith("/register.jsp");

        HttpSession session = httpRequest.getSession();
        String name = (String) session.getAttribute("name");
        String username = (String) session.getAttribute("username");

        if (isLoginPage || isRegisterPage || (name != null && username != null)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        }
    }
}

package com.articleapplication.servlets;


import com.articleapplication.dao.ArticleDaoImpl;
import com.articleapplication.model.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArticleServlet", value = "/user/article")
public class ArticleServlet extends HttpServlet {

    private ArticleDaoImpl articleDaoImp;

    @Override
    public void init() throws ServletException {
        articleDaoImp = new ArticleDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showUserArticles(request, response);
    }


    private void showUserArticles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");

        List<Article> articles = articleDaoImp.selectAllArticles(username);
        request.setAttribute("articles", articles);


        request.getRequestDispatcher("/article.jsp").forward(request, response);
    }





}
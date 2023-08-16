package com.articleapplication.controller;

import com.articleapplication.dao.ArticleDaoImpl;
import com.articleapplication.model.Article;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "ArticleController", value = "/user/article/actions")
public class ArticleController extends HttpServlet {

    private ArticleDaoImpl articleDaoImp;

    @Override
    public void init(){
        articleDaoImp = new ArticleDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            request.getRequestDispatcher("/article-form.jsp").forward(request, response);
        } else {

            try {


                switch (action) {
                    case "new":
                        request.getRequestDispatcher("/article-form.jsp").forward(request, response);
                        break;
                    case "viewMyArticles":
                        showMyArticles(request, response);
                        break;
                    case "viewAllArticles" :
                        showAllArticles(request, response);
                        break;
                    case "insert":
                        insertArticle(request, response);
                        break;
                    case "edit":
                        showEditArticle(request, response);
                        break;
                    case "update":
                        updateArticle(request, response);
                        break;
                    case "delete":
                        deleteArticle(request, response);
                        break;
                    default:
                        response.sendRedirect("login.jsp");
                        break;
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

    }




    private void insertArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = (String) request.getSession().getAttribute("username");

        String title = request.getParameter("title");
        String content = request.getParameter("article");

        Article article = new Article();
        article.setTitle(title);
        article.setArticle(content);
        article.setUsername(username);


        articleDaoImp.insertArticle(article);

        response.sendRedirect(request.getContextPath() + "/user/article");
    }




    private void updateArticle(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String title = request.getParameter("title");
        String content = request.getParameter("article");

        Article article = articleDaoImp.getArticle(id);
        article.setTitle(title);
        article.setArticle(content);

        articleDaoImp.updateArticle(article);
        response.sendRedirect(request.getContextPath() + "/user/article");
    }




    private void showEditArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Article article = articleDaoImp.getArticle(id);

        request.setAttribute("article", article);

        request.getRequestDispatcher("/article-form.jsp").forward(request, response);
    }


    private void showMyArticles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        List<Article> articlesByUsername = articleDaoImp.selectAllArticles(username);
        request.setAttribute("articleList", articlesByUsername);

        request.getRequestDispatcher("/my-article-form.jsp").forward(request, response);
    }

    private void showAllArticles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Article> articles = articleDaoImp.showAllArticles();

        request.setAttribute("allArticleList", articles);

        request.getRequestDispatcher("/all-article-form.jsp").forward(request, response);
    }
    private void deleteArticle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        articleDaoImp.deleteArticle(id);
        response.sendRedirect(request.getContextPath() + "/user/article");
    }







}
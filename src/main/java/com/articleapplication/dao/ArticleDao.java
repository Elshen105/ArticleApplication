package com.articleapplication.dao;

import com.articleapplication.model.Article;

import java.util.List;

public interface ArticleDao {
    void insertArticle(Article article);
    List<Article> selectAllArticles(String username);

    List<Article> showAllArticles();
    Article getArticle(int id);

    void updateArticle(Article article);

    void deleteArticle(int id);

}

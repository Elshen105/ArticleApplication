package com.articleapplication.dao;

import com.articleapplication.model.User;

public interface UserDao {
    void register(User user);
    User getUser(String username, String password);
}

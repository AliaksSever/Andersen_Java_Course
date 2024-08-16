package com.severin.dao;

public class UserDao {

    private final static UserDao INSTANCE = new UserDao();

    private UserDao(){}

    public static UserDao getInstance() {
        return INSTANCE;
    }
}

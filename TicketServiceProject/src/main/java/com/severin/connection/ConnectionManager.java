package com.severin.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.severin.util.PropertiesUtil;

public class ConnectionManager {
    private final static String URL_KEY = "db.url";
    private final static String USERNAME_KEY = "db.username";
    private final static String PASSWORD_KEY = "db.password";

    private ConnectionManager() {}

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USERNAME_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.severin.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private final static String URL = "jdbc:postgresql://localhost:5432/my_ticket_service_db";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "121212";

    private ConnectionManager() {}

    public static Connection open() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

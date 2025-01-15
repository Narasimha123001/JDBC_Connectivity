package com.JdbcConnections.SQL;

import java.sql.*;

public class mySQL {
    private static String DB_URL = "jdbc:mysql://localhost:3306/EMPLOYEE";
    private static String DB_user = "******";
    private static String DB_pass = "********";
    private Connection connection;

    public mySQL() {
        try {connection = DriverManager.getConnection(DB_URL, DB_user, DB_pass);
            System.out.println("Connected Success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

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

    public void addEmployee(int id, String name, double salary){
        String Query = "INSERT INTO EMPLOYEE(id,name,salary)VALUES(?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(Query)){
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setDouble(3,salary);
            preparedStatement.executeUpdate();
            System.out.println("Employee add successfully");
    }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

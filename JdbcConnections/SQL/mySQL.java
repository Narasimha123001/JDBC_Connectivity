package com.JdbcConnections.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    //Create
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

    //Read

    public List<String> getAllEmployee() {
        List<String> list = new ArrayList<>();
        String Query = "SELECT * FROM EMPLOYEE";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Query)){
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String  name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                list.add("ID: "+id+" Name: "+name+" Salary: "+salary);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    // update

    public void updateEmployeeDetails(int id, String newName){
        String Query = "UPDATE EMPLOYEE SET name= ? WHERE id = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(Query)){
            preparedStatement.setString(1,newName);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            System.out.println("Employee name update successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //delete employee

    public void deleteEmployee(int id){
        String Query = "DELETE FROM EMPLOYEE WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(Query)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Employee delete successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //close connection
    public void closeConnection() throws SQLException {
        if(connection != null  && !connection.isClosed()){
            connection.close();
        }
    }
}

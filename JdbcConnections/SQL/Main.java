package com.JdbcConnections.SQL;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mySQL repo = new mySQL();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee Name");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1-> {
                    System.out.println("Enter ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("enter the salary");
                    double salary = scanner.nextDouble();
                    repo.addEmployee(id,name,salary);
                }

                case 2-> {
                    List<String> employee = repo.getAllEmployee();
                    if(employee.isEmpty()){
                        System.out.println("No employee found");
                    } else {
                        employee.forEach(System.out::println);
                    }
                }

                case 3->{
                    System.out.println("Enter YOUR ID :");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the new Name: ");
                    String newName = scanner.nextLine();
                    repo.updateEmployeeDetails(id,newName);
                }

                case 4->{
                    System.out.println("Enter Your Employee id");
                    int id= scanner.nextInt();
                    repo.deleteEmployee(id);
                }

                case 5->{
                    System.out.println("Exiting applications");
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}

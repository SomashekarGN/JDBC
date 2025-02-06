package com.xworkz.jdbc.runner;

import java.sql.*;

public class ApplicationRunner {

    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/application","root","system");
            preparedStatement=connection.prepareStatement("select * from user_info");


            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next())
            {
                System.out.println(resultSet.getString("user_name"));
                System.out.println(resultSet.getString("user_email"));
                System.out.println(resultSet.getString("app_id"));


                System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            try {
                connection.close();
                preparedStatement.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

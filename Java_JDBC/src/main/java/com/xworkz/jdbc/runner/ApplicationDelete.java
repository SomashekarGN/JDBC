package com.xworkz.jdbc.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationDelete {
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
            preparedStatement=connection.prepareStatement("Delete from user_info where user_id=11");

            int result=preparedStatement.executeUpdate();
            if(result>=1)
            {
                System.out.println("Deleted...!");
            }
            else
            {
                System.out.println("Not Deleted...!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection!=null && preparedStatement!=null) {
                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

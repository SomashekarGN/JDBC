package com.xworkz.jdbc.runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationUpdate {
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
            preparedStatement=connection.prepareStatement("update user_info set user_name=? where user_id=?");
            preparedStatement.setString(1,"Somashekar GN");
            preparedStatement.setInt(2,10);

            int result=preparedStatement.executeUpdate();
            System.out.println(result);
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

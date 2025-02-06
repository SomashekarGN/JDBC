package com.xworkz.jdbc.runner;
import java.sql.*;//import packages

public class JdbcRunner {

    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/application";
        String userName="root";
        String password="system";
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        String query="insert into user_info(user_name,user_email,app_id) values (?,?,?)";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//load the drivers
            System.out.println("Loading the Driver Successful");

           connection= DriverManager.getConnection(url,userName,password);//Creating/Establish Connection
            System.out.println("JDBC Connection Successful");

            preparedStatement=connection.prepareStatement(query);

            preparedStatement.setString(1,"Somashekar GN");
            preparedStatement.setString(2,"X");
            preparedStatement.setInt(3,3);
            preparedStatement.executeQuery();



//            Statement st=connection.createStatement();
//            st.executeQuery("Select * from app_details");
//            st.executeUpdate();



        } catch (SQLException | ClassNotFoundException| NullPointerException e) {
            System.err.println("Expception encountered : "+e.getMessage());
        }


        finally {
            try {
                connection.close();
                preparedStatement.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Connection Successful...!");
    }
}

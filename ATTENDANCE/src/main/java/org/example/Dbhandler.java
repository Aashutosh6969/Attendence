package org.example;

import java.sql.*;

public class Dbhandler {

    public static Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:src/main/resources/database/AttendanceManagement.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection established");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public void insert_user(Connection connection, String username, String password) {
        String sql = "INSERT into Users(username,password) VALUES (?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);

            pstm.executeUpdate();
            System.out.println("Data is inserted");
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public void insert_class(Connection connection, String class_name) {
        String sql = "INSERT into Class(classname) VALUES (?)";
        PreparedStatement pstm = null;

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, class_name);


            pstm.executeUpdate();
            System.out.println("Data is inserted");
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void insert_attendence(Connection connection, int class_id, int user_id, int present) {
        String sql = "INSERT into Attendence(class_id,user_id,present) VALUES (?,?,?)";
        PreparedStatement pstm = null;

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, class_id);
            pstm.setInt(2, user_id);
            pstm.setInt(3, present);


            pstm.executeUpdate();
            System.out.println("Data is inserted");
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void select_users(Connection connection,int id){
        try {
            String sql = "SELECT username FROM Users Where id =" + " ' " + id + " ' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String username = resultSet.getString("username");

                System.out.println("Name : " + username);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void select_class(Connection connection,int id){
        try {
            String sql = "SELECT classname FROM Class Where id =" + " ' " + id + " ' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String classname = resultSet.getString("classname");

                System.out.println("Name : " + classname);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

package com.tw.todolist.Services;


import java.sql.*;
import java.sql.Statement;

public class JdbcService {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/scutcs";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    private Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void add(String value) throws SQLException, ClassNotFoundException {
        String sqlString = "INSERT INTO list(name,done) VALUE ('"+value+"','"+0+"')";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate(sqlString);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        java.sql.Statement statement = conn.createStatement();

        String sql = "select * from list";
        return statement.executeQuery(sql);

    }

    public void remove(Integer id) throws SQLException,ClassNotFoundException {
        System.out.println(id);
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        if(!conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        java.sql.Statement statement = conn.createStatement();
        String sqlString = "delete from list where id="+id;
        try {
            statement.execute(sqlString);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}

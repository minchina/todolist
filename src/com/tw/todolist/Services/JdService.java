package com.tw.todolist.Services;


import java.sql.*;
import java.sql.Statement;

public class JdService {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/scutcs";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    private Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(int data_id, String name, int status) throws SQLException {
        String sqlString = "UPDATE list SET done = " + status + ", name = '" + name + "' WHERE id = " + data_id;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlString);
        connection.close();
        statement.close();
    }

    public void add(String value) throws SQLException, ClassNotFoundException {
        String sqlString = "INSERT INTO list(name, done) VALUE ('" + value + "','" + 0 + "')";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlString);

        connection.close();
        statement.close();
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {

        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from list";
        return statement.executeQuery(sql);
    }

    public void remove(Integer id) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        String sqlString = "delete from list where id=" + id;
        statement.execute(sqlString);

        connection.close();
        statement.close();
    }
}

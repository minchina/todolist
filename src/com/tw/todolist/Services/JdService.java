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

    public void update(int data_id, int status) throws SQLException {
        String sqlString = "UPDATE list SET done = " + status + " WHERE id=" + data_id;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlString);

    }

    public void add(String value) throws SQLException, ClassNotFoundException {
        String sqlString = "INSERT INTO list(name, done) VALUE ('" + value + "','" + 0 + "')";
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        try {
            statement.executeUpdate(sqlString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();

        String sql = "select * from list";
        return statement.executeQuery(sql);
    }

    public void remove(Integer id) throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        java.sql.Statement statement = conn.createStatement();
        String sqlString = "delete from list where id=" + id;
        try {
            statement.execute(sqlString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void rename(String value, Integer integer) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        java.sql.Statement statement = conn.createStatement();

        String sql = "UPDATE list SET name='" + value + "' WHERE id=" + integer;
        statement.executeUpdate(sql);
    }
}

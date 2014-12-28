package com.tw.todolist.Services;


import java.sql.*;

public class JdService extends Jd{


    public JdService() throws SQLException {
    }

    public void update(int data_id, String name, int status) throws SQLException {
        String sqlString = "UPDATE list SET done = " + status + ", name = '" + name + "' WHERE id = " + data_id;
        statement.executeUpdate(sqlString);
        close();
    }

    public void add(String value) throws SQLException, ClassNotFoundException {
        String sqlString = "INSERT INTO list(name, done) VALUE ('" + value + "','" + 0 + "')";
        statement.executeUpdate(sqlString);
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from list";
        return statement.executeQuery(sql);
    }

    public void remove(Integer id) throws SQLException, ClassNotFoundException {
        String sqlString = "delete from list where id=" + id;
        statement.execute(sqlString);
        close();
    }
}

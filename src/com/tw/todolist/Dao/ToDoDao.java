package com.tw.todolist.Dao;


import java.sql.*;

public class ToDoDao extends Jd{


    public ToDoDao() throws SQLException {
    }

    public void update(int data_id, String name, int status) throws SQLException {
        String sqlString = "UPDATE list SET done = " + status + ", name = '" + name + "' WHERE id = " + data_id;
        statement.executeUpdate(sqlString);
        close();
    }

    public void add(String value) throws SQLException, ClassNotFoundException {
        String sqlString = "INSERT INTO list(name, done) VALUE ('" + value + "','" + 0 + "')";
        statement.executeUpdate(sqlString);
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            Long id = rs.getLong(1);
            System.out.println("数据主键：" + id);
        }
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

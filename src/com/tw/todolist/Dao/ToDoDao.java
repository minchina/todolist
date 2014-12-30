package com.tw.todolist.Dao;


import com.tw.todolist.Models.ToDo;

import java.sql.*;

public class ToDoDao extends Dao {


    public ToDoDao() throws SQLException {
    }

    public void update(int data_id, String name, int status) throws SQLException {
        String sqlString = "UPDATE list SET done = " + status + ", name = '" + name + "' WHERE id = " + data_id;
        statement.executeUpdate(sqlString);
        close();
    }

    public ToDo add(ToDo toDo) throws SQLException, ClassNotFoundException {
        String name = toDo.getName();
        int done = toDo.getDone();
        String sqlString = "INSERT INTO list(name, done) VALUE ('" + name + "','" + done + "')";
        statement.executeUpdate(sqlString);

        int id = 0;
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            id =rs.getInt(1);
        }
        toDo.setId(id);
        return toDo;
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

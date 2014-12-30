package com.tw.todolist.Dao;


import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoDao extends Dao {


    public ToDoDao() throws SQLException {
    }

    public void update(int data_id, String name, int status) throws SQLException {
        String sqlString = "UPDATE list SET done = " + status + ", name = '" + name + "' WHERE id = " + data_id;
        statement.executeUpdate(sqlString);
        close();
    }

    public ToDo add(ToDo toDo,User user) throws SQLException, ClassNotFoundException {
        String name = toDo.getName();
        int done = toDo.getDone();
        Integer userId = user.getId();
        String sqlString = "INSERT INTO list(name, done, userid) VALUE ('" + name + "'," + done + "," + userId +")";
        statement.executeUpdate(sqlString);

        int id = 0;
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
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

    public List<ToDo> getToDoListByUserId(int userId) throws SQLException {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        String sqlString = "select * from list where userid = " + userId;
        ResultSet resultSet = statement.executeQuery(sqlString);
        while (resultSet.next()){
            toDoList.add(new ToDo(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(4),resultSet.getInt(3)));
        }
        return toDoList;

    }
}

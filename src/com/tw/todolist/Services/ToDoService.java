package com.tw.todolist.Services;

import com.tw.todolist.Dao.JdDao;
import com.tw.todolist.Models.ToDo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ToDoService {
    private List<ToDo> toDoList = new ArrayList<ToDo>();
    JdDao jdDao;

    public ToDoService() throws SQLException {
        jdDao = new JdDao();
    }

    public void add(String name) throws SQLException, ClassNotFoundException {
        jdDao.add(name);
    }

    public List<ToDo> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = jdDao.getAll();
        while (resultSet.next()) {
            toDoList.add(new ToDo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
        }
        return toDoList;
    }

    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        jdDao.remove(id);
    }

    public void update(Integer id, String name, Integer status) throws SQLException {
        jdDao.update(id, name, status);
    }
}

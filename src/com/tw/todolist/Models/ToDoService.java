package com.tw.todolist.Models;

import com.tw.todolist.Services.JdService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ToDoService {
    private List<ToDo> toDoList = new ArrayList<ToDo>();
    JdService jdService;

    public ToDoService() throws SQLException {
        jdService = new JdService();
    }

    public void add(String name) throws SQLException, ClassNotFoundException {
        jdService.add(name);
    }

    public List<ToDo> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = jdService.getAll();
        while (resultSet.next()) {
            toDoList.add(new ToDo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
        }
        return toDoList;
    }

    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        jdService.remove(id);
    }

    public void update(Integer id, String name, Integer status) throws SQLException {
        jdService.update(id, name, status);
    }
}

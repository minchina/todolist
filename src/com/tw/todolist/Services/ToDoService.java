package com.tw.todolist.Services;

import com.tw.todolist.Dao.ToDoDao;
import com.tw.todolist.Models.ToDo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ToDoService {
    private List<ToDo> toDoList = new ArrayList<ToDo>();
    ToDoDao toDoDao;

    public ToDoService() throws SQLException {
        toDoDao = new ToDoDao();
    }

    public ToDo add(ToDo toDo) throws SQLException, ClassNotFoundException {
        return toDoDao.add(toDo);
    }

    public List<ToDo> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = toDoDao.getAll();
        while (resultSet.next()) {
            toDoList.add(new ToDo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
        }
        return toDoList;
    }

    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        toDoDao.remove(id);
    }

    public void update(Integer id, String name, Integer status) throws SQLException {
        toDoDao.update(id, name, status);
    }
}

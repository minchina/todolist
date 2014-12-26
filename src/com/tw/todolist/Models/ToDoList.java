package com.tw.todolist.Models;

import com.tw.todolist.Services.JdService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by minchina on 14-12-26.
 */
public class ToDoList {
    private List<ToDo> toDoList = new ArrayList<ToDo>();
    JdService jdService = new JdService();

    public void add(String name) throws SQLException, ClassNotFoundException {
        jdService.add(name);
    }

}

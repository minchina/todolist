package com.tw.todolist.Servlet;

import com.alibaba.fastjson.JSON;
import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Models.User;
import com.tw.todolist.Services.ToDoService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class AddToDoServlet extends HttpServlet {
    ToDoService toDoList;

    public AddToDoServlet() throws SQLException {
        toDoList = new ToDoService();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        ToDo toDo = new ToDo(0,name,0,0);

        try {
            toDo = toDoList.add(toDo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonToDo = JSON.toJSONString(toDo);
        out.print(jsonToDo);
    }
}

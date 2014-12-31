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
        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        Integer toDoId= 0;
        Integer done = 0;

        ToDo toDo = new ToDo(toDoId,name,userId,done);

        try {
            toDo = toDoList.add(toDo,userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonToDo = JSON.toJSONString(toDo);
        out.print(jsonToDo);
    }
}

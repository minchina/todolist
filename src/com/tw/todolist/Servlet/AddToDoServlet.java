package com.tw.todolist.Servlet;

import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Models.ToDoList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by minchina on 14-12-26.
 */
public class AddToDoServlet extends HttpServlet {
    ToDoList toDoList = new ToDoList();

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        try {
            toDoList.add(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.print(name);

    }
}

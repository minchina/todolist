package com.tw.todolist.Servlet;

import com.tw.todolist.Models.ToDoService;

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
        try {
            toDoList.add(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.print(name);

    }
}

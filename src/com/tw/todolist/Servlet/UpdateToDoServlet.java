package com.tw.todolist.Servlet;

import com.tw.todolist.Dao.ToDoDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


public class UpdateToDoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer status = Integer.valueOf(request.getParameter("status"));
        try {
            new ToDoDao().update(id, name, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

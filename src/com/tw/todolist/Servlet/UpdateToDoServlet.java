package com.tw.todolist.Servlet;

import com.tw.todolist.Dao.JdDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by minchina on 14-12-26.
 */
public class UpdateToDoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer status = Integer.valueOf(request.getParameter("status"));
        try {
            new JdDao().update(id, name, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

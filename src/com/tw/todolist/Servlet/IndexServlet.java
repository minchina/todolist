package com.tw.todolist.Servlet;

import com.tw.todolist.Services.JdbcService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by minchina on 14-12-25.
 */
public class IndexServlet extends HttpServlet{


    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        System.out.println("hhahaha");
        JdbcService jd = new JdbcService();
        ResultSet resultSet = null;
        try {
            resultSet = jd.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        request.setAttribute("result",resultSet);
        rd.forward(request,response);
    }
}

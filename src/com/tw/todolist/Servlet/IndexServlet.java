package com.tw.todolist.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by minchina on 14-12-25.
 */
public class IndexServlet extends HttpServlet{


    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hhahaha");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request,response);
    }
}

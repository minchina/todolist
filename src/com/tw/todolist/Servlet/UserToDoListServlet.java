package com.tw.todolist.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserToDoListServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        String name = url.substring(18);
        System.out.println(name);
        request.getRequestDispatcher("/usertodolist.jsp").forward(request,response);
    }
}

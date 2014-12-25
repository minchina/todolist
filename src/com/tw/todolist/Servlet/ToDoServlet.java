package com.tw.todolist.Servlet;

import com.tw.todolist.Services.JdbcService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;


//@WebServlet(urlPatterns = {"/"})
public class ToDoServlet extends HttpServlet{
    Connection conn = null;
    Statement stmt = null;

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
//        System.out.println("haha");
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

        PrintWriter out = response.getWriter();
        String value = request.getParameter("name");
        String type = request.getParameter("type");

        response.setCharacterEncoding("utf8");
        JdbcService jd = new JdbcService();
        try {
            if(type.equals("add")) {
                jd.add(value);
            }else if(type.equals("delete")){
                jd.remove(Integer.valueOf(value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.print(value);
    }
}

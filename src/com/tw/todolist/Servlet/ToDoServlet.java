package com.tw.todolist.Servlet;
import com.tw.todolist.Services.JdHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet(urlPatterns = {"/"})
public class ToDoServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

        PrintWriter out = response.getWriter();
        String value = request.getParameter("name");
        String type = request.getParameter("type");

        response.setCharacterEncoding("utf8");
        JdHelper jd = new JdHelper();
        try {
            if(type.equals("add")) {
                jd.add(value);
            }else if(type.equals("delete")){
                jd.remove(Integer.valueOf(value));
            }else if(type.equals("update")){
                String status = request.getParameter("status");
                jd.update(Integer.valueOf(value),Integer.valueOf(status));
            }else if(type.equals("rename")){
                String id = request.getParameter("id");
                jd.rename(value,Integer.valueOf(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.print(value);
    }
}

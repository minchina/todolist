package com.tw.todolist.Servlet;

import com.tw.todolist.Models.Item;
import com.tw.todolist.Services.JdHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndexServlet extends HttpServlet{
    private List<Item> toDoList = new ArrayList<Item>();


    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        toDoList.clear();
        System.out.println("succeed enter get index");
        JdHelper jd = new JdHelper();
        ResultSet resultSet = null;

        try {
            resultSet = jd.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert resultSet != null;
            while (resultSet.next()){
                toDoList.add(new Item(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        request.setAttribute("toDoList", toDoList);
        rd.forward(request,response);
    }
}

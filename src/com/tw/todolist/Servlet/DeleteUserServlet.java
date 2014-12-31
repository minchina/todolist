package com.tw.todolist.Servlet;

import com.tw.todolist.Models.User;
import com.tw.todolist.Services.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by minchina on 14-12-31.
 */
public class DeleteUserServlet extends HttpServlet{


    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        System.out.println("hh");
        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        String userName = request.getParameter("user_name");
        try {
            new UserService().delete(new User(userId,userName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

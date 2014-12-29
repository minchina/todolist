package com.tw.todolist.Servlet;

import com.tw.todolist.Models.User;
import com.tw.todolist.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class UserListServlet extends HttpServlet {
    private List<User> userList;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            userList = new UserService().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/userlist.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        Integer userId = 0;
        String userName = request.getParameter("user_name");
        try {
            UserService userService = new UserService();
            userId = userService.add(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("user_id", userId);
    }

}

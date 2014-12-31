package com.tw.todolist.Servlet;

import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Models.User;
import com.tw.todolist.Services.ToDoService;
import com.tw.todolist.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserToDoListServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;
        List<ToDo> userToDoList =new ArrayList<ToDo>();

        String url = request.getRequestURI();
        int indexOf = url.lastIndexOf("/");
        String name = url.substring(18, indexOf);

        try {
            user = new UserService().findUserByName(name);
            userToDoList = new ToDoService().getToDoListByUserId(user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert user != null;
        request.setAttribute("user_id",user.getId());
        request.setAttribute("usertodolist",userToDoList);
        //The pathname must begin with a "/" and is interpreted as relative to the current context root.
        request.getRequestDispatcher("/usertodolist.jsp").forward(request, response);
    }

}

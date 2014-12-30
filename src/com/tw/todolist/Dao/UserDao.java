package com.tw.todolist.Dao;


import com.tw.todolist.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends Dao {

    public UserDao() throws SQLException {
    }

    public User add(User user) throws SQLException, ClassNotFoundException {
        String userName = user.getName();
        Integer id = 0;
        String sqlString = "INSERT INTO user(name) VALUE ('" + userName + "')";
        statement.executeUpdate(sqlString);
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        user.setId(id);
        return user;
    }

    public List<User> getAll() throws SQLException, ClassNotFoundException {
        List<User> userList = new ArrayList<User>();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            userList.add(new User(resultSet.getInt(1), resultSet.getString(2)));
        }
        return userList;
    }


}

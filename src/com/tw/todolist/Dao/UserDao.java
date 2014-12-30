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
        String sqlString = "INSERT INTO user(name) VALUE ('" + userName + "')";
        statement.executeUpdate(sqlString);
        return getLastUser();
    }

    public List<User> getAll() throws SQLException, ClassNotFoundException {
        List<User> userList = new ArrayList<User>();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while (resultSet.next()) {
            userList.add(new User(resultSet.getInt(1), resultSet.getString(2)));
        }
        return userList;
    }

    public User getLastUser() throws SQLException {
        User user = null;
        String sqlString = "SELECT * from user where id = (SELECT max(id) FROM user)";
        ResultSet resultSet = statement.executeQuery(sqlString);
        while (resultSet.next()) {
            user = new User(resultSet.getInt(1), resultSet.getString(2));
        }
        return user;
    }

    public User findUserByName(String name) throws SQLException {
        User user = null;
        String sqlString = "SELECT * from user where name = '" + name + "'";
        ResultSet resultSet = statement.executeQuery(sqlString);
        while (resultSet.next()) {
            user = new User(resultSet.getInt(1), resultSet.getString(2));
        }
        return user;
    }


}

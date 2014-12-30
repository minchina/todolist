package com.tw.todolist.Services;

import com.tw.todolist.Dao.UserDao;
import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by minchina on 14-12-28.
 */
public class UserService {


    UserDao userDao;

    public UserService() throws SQLException {
        userDao = new UserDao();
    }

    public User add(User user) throws SQLException, ClassNotFoundException {
        return userDao.add(user);
    }

    public List<User> getAll() throws Exception {
        return userDao.getAll();
    }

    public User findUserByName(String name) throws SQLException {
        return userDao.findUserByName(name);
    }
}

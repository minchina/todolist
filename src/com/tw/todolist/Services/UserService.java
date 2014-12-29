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

    private List<User> userList = new ArrayList<User>();

    UserDao userDao;

    public UserService() throws SQLException {
        userDao = new UserDao();
    }

    public User add(User user) throws SQLException, ClassNotFoundException {
        return userDao.add(user);
    }

    public List<User> getAll() throws Exception {
        ResultSet resultSet = userDao.getAll();
        while (resultSet.next()) {
            userList.add(new User(resultSet.getInt(1),resultSet.getString(2)));
        }
        return userList;
    }
}

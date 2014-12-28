package com.tw.todolist.Dao;



import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by minchina on 14-12-28.
 */
public class UserDao extends Jd {

    public UserDao() throws SQLException {
    }

    public Integer add(String userName) throws SQLException, ClassNotFoundException {
        Integer id = 0;
        String sqlString = "INSERT INTO user(name) VALUE ('" + userName + "')";
        statement.executeUpdate(sqlString);
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        String sql = "select * from user";
        return statement.executeQuery(sql);
    }



}

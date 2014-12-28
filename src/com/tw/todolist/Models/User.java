package com.tw.todolist.Models;

/**
 * Created by minchina on 14-12-28.
 */
public class User {
    private String name;
    private Integer id;

    public User(int id, String name) {
        this.id=id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

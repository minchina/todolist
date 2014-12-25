package com.tw.todolist.Models;

/**
 * Created by minchina on 14-12-25.
 */
public class Item {
    private int id;
    private String name;
    private int done;
    public Item(int id, String name, int done){
        this.id = id;
        this.name = name;
        this.done = done;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

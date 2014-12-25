package com.tw.todolist.Models;

/**
 * Created by minchina on 14-12-25.
 */
public class Item {
    public int id;
    public String name;
    public int done;
    public Item(int id, String name, int done){
        this.id = id;
        this.name = name;
        this.done = done;
    }
}

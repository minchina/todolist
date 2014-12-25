package com.tw.todolist.Models;

import java.util.UUID;

/**
 * Created by minchina on 14-12-24.
 */
public class UuidGenerator {


    public String getOne(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }
}

package com.firstspringapp.dao;

import com.firstspringapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    List<User> userList = new ArrayList<>();

    public UserDao(){
        userList.add(new User("madhu","madhu@gmail.com"));
        userList.add(new User("vasu","vasu@yahoo.com"));
        userList.add(new User("suresh","suresh@gmail.com"));
    }

    public boolean addUser(User user){
        return userList.add(user);
    }
}

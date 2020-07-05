package com.firstspringapp.dao;

import com.firstspringapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    List<User> userList = new ArrayList<>();

    public UserDao(){
        userList.add(new User("100","madhu","madhu@gmail.com"));
        userList.add(new User("101","vasu","vasu@yahoo.com"));
        userList.add(new User("102","suresh","suresh@gmail.com"));
    }

    public boolean addUser(User user){
        return userList.add(user);
    }

    public List<User> getAllUsers(){
        return userList;
    }

    public User getUserById(String id) {
        for(User user:userList) {
            if (user.getId().equals(id))
                return user;
        }
        return null;
    }

    public boolean updateUserData(String id, User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        User userById = this.getUserById(id);
        if(userById != null) {
            userById.setFirstName(firstName);
            userById.setLastName(lastName);
            return true;
        }
        return false;
    }
}

package com.firstspringapp.Controller;

import com.firstspringapp.dao.UserDao;
import com.firstspringapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = {"", "/","/home"})
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable String id){
        User user = userDao.getUserById(id);
        if(user!=null)
            return "Hello "+user.getFirstName();
        return "user not found";
    }

    @PostMapping("/user")
    public String addUserData(@RequestBody User user){
        if(userDao.addUser(user))
            return "Hello "+ user.getFirstName() +" "+ user.getLastName();
        return "user not added";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable String id,@RequestBody User user ){
        if(userDao.updateUserData(id, user))
            return "User data updated"+id;
        return "id is not in the user list";
    }
}

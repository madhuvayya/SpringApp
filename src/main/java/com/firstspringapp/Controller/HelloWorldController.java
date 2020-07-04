package com.firstspringapp.Controller;

import com.firstspringapp.dao.UserDao;
import com.firstspringapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = {"", "/","/home"})
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name){
        return "Hello "+ name;
    }

    @PostMapping("/user")
    public String sayHelloParam(@RequestBody User user){
        if(userDao.addUser(user))
            return "Hello "+ user.getFirstName() +" "+ user.getLastName();
        return "user not add";
    }

    @PutMapping("/put/{firstName}")
    public String sayHello(@PathVariable String firstName,  @RequestParam(value = "lastName") String lastName ){
        return "Hello " + firstName +" "+ lastName;
    }
}

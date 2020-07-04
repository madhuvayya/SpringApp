package com.firstspringapp.config;

import com.firstspringapp.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public UserDao userDao(){
        return new UserDao();
    }
}

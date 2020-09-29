package com.firstspringapp.controller;

import com.firstspringapp.Controller.HelloWorldController;
import com.firstspringapp.dao.UserDao;
import com.firstspringapp.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private HelloWorldController helloWorldController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController)
                .build();
    }

    @Test
    public void givenHelloUrl_shouldReturnStatusOkAndString() throws Exception {
        mockMvc.perform( get("/hello") )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    public void givenUsersUrl_shouldReturn() throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User("100","madhu","madhu@gmail.com"));
        userList.add(new User("101","vasu","vasu@yahoo.com"));
        userList.add(new User("102","suresh","suresh@gmail.com"));

        when(userDao.getAllUsers()).thenReturn(userList);

         mockMvc.perform(get("/hello/users"))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$",hasSize(3)))
                 .andExpect(jsonPath("$[1].firstName",is(userList.get(1).getFirstName())));

         verify(userDao,times(1)).getAllUsers();
    }

    @Test
    public void givenUser_WithUserIdUrl_shouldReturnUserDetails() throws Exception {

        when(userDao.getUserById(any())).thenReturn(new User("102","suresh","suresh@gmail.com"));

        mockMvc.perform(get("/hello/user/102"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello suresh suresh@gmail.com")));

        verify(userDao,times(1)).getUserById(any());
    }

}

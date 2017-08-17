package com.tw.tradeaway.controller;

import com.google.gson.Gson;
import com.tw.tradeaway.dto.OrderItemDto;
import com.tw.tradeaway.dto.UserProfile;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class UserControllerTest {

    @Autowired
    WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void loginSuccessfully() throws Exception {

        String profileJson = "{\"email\": \"pavan@gmail.com\", \"password\": \"password\"}";

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(profileJson))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.firstName").value(Matchers.is("pavan")))
                .andExpect(jsonPath("$.lastName").value(Matchers.is("kumar")))
                .andExpect(jsonPath("$.email").value(Matchers.is("pavan@gmail.com")))
                .andExpect(jsonPath("$.role").value(Matchers.is("buyer")))
                .andExpect(jsonPath("$.token").value(Matchers.is(Base64.getEncoder().encodeToString("pavan@gmail.com".getBytes(StandardCharsets.UTF_8)))))
                .andExpect(jsonPath("$.id").value(Matchers.is(1)));
    }

    @Test
    public void loginWithWrongCred() throws Exception {

        String profileJson = "{\"email\": \"unknown\", \"password\": \"wrong\"}";


        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(profileJson))
                .andExpect(status().is4xxClientError());
    }

}
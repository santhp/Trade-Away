package com.tw.tradeaway.controller;

import com.google.gson.Gson;
import com.tw.tradeaway.dto.OrderItemDto;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@        WebAppConfiguration
@        SpringBootTest
public class OrderControllerTest {

    @Autowired
    WebApplicationContext context;
    private MockMvc mockMvc;
    @Test
    public void mustCheckOutAnItemToPlaceOrder() throws Exception {
        Gson gson = new Gson();

        OrderItemDto item = new OrderItemDto(1, 1, 1,1,"deliveryAddress");
        String orderJson = gson.toJson(item);

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        mockMvc.perform(
                post("/api/order")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().isCreated());
    }


   @Test
    public void mustFailPlacingOrderWhenInputIsNullOrBlank() throws Exception {
        Gson gson = new Gson();

        OrderItemDto item = new OrderItemDto();
        String orderJson = gson.toJson(item);

        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        mockMvc.perform(
                post("/order")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(orderJson))
                .andExpect(status().is4xxClientError());
    }
}
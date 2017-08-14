package com.tw.tradeaway.order;

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
public class CheckOutControllerTest {

    @Autowired
    WebApplicationContext context;
    private MockMvc mockMvc;
    @Test
    public void mustCheckOutAnItemToPlaceOrder() throws Exception {
        System.out.println(context);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        mockMvc.perform(post("/checkout/")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
    }
}
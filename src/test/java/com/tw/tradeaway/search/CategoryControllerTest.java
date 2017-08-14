package com.tw.tradeaway.search;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
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

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class CategoryControllerTest {

    @Autowired
    WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void beforeMethod() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getCategoryListTest1() throws Exception {
        mockMvc.perform(get("/category/list")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]", is("Cat1")))
                .andExpect(jsonPath("$[1]", is("Cat2")));
    }

    public void getCategoryListTest2() throws Exception {


        //TODO

        mockMvc.perform(get("/category/list")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]", is("Cat1")))
                .andExpect(jsonPath("$[1]", is("Cat2")));
    }

    public void getProductListTest1() throws Exception {

        Category category=new Category(1,"Electronics");
        Product iphone = new Product(1,"IPHONE", "Its an Iphone", 59999.00, null, category);

        //TODO


        mockMvc.perform(get("/category/list")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]", is("Cat1")))
                .andExpect(jsonPath("$[1]", is("Cat2")));
    }

    public void getProductListTest2() throws Exception {


        //TODO

        mockMvc.perform(get("/category/list")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]", is("Cat1")))
                .andExpect(jsonPath("$[1]", is("Cat2")));
    }

}
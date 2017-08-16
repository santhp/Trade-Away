package com.tw.tradeaway.controller;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.dto.SellerDto;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.ProductSellerQuantityMapping;
import com.tw.tradeaway.entities.Seller;
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

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        mockMvc.perform(get("/api/category/list")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]").value(new Category(1, "Electronics")))
                .andExpect(jsonPath("$[1]").value(new Category(2, "Books")));
    }

    @Test
    public void getProductListTest1() throws Exception {

        Seller seller = new Seller(1, "ABC");
        Product product = new Product( "IPhone", "Advanced phone", 10000, null, new Category(1, "Electronics"));
        ProductSellerQuantityMapping productSellerQuantityMapping = new ProductSellerQuantityMapping(1, product, seller, 10);

        ProductDto expectedProductDto = new ProductDto(product.getName(), product.getDescription(), product.getPrice(), product.getImage(), new ArrayList<>());
        expectedProductDto.getSellerDto().add(new SellerDto(seller.getId(), seller.getName(), 10));


        mockMvc.perform(get("/api/category?categoryId=1001")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]").value(expectedProductDto));
    }

    @Test
    public void getProductListGivenCategoryId() {


    }
}
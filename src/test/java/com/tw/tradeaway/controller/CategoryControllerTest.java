package com.tw.tradeaway.controller;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.dto.SellerDto;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.ProductSellerQuantityMapping;
import com.tw.tradeaway.entities.Seller;
import com.tw.tradeaway.service.EntityToDtoTransformer;
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
import java.util.Collection;
import java.util.Collections;

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
        // TODO Mock really!
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getCategoryListTest1() throws Exception {
        mockMvc.perform(get("/api/category/list")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]").value(new Category(1, "Electronics")));
    }

    @Test
    public void getProductListGivenCategoryId() throws Exception {

        Category cat=new Category(1, "Electronics");
        Product prod=new Product( "iPhone", "d1", 100d, null,cat);
        Seller seller=new Seller(1, "Deepak");
        ProductSellerQuantityMapping productSellerQuantityMapping=new ProductSellerQuantityMapping(prod,seller,10);
        Collection<ProductDto> expectedProductDto = EntityToDtoTransformer.transformProductMappingToDot(Collections.singletonList(productSellerQuantityMapping));


        mockMvc.perform(get("/api/category?categoryId=1")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]").value(expectedProductDto.iterator().next()));
    }

}

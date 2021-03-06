package com.tw.tradeaway.controller;

import com.tw.tradeaway.dto.ProductDto;
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

import java.util.Collection;
import java.util.Collections;

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
                .andExpect(jsonPath("$[0]").value(new Category(1, "Mobiles")));
    }

    @Test
    public void getProductListGivenCategoryId() throws Exception {

        Category cat=new Category("Mobiles");
        Product prod = new Product("iPhone 6", "8MP primary camera with auto focus and 1.2MP front facing camera\n" +
                "11.4 centimeters (4.7-inch) retina HD touchscreen with 1334 x 750 pixels resolution and 326 ppi pixel density\n", 26634d,
                "https://www.o2.co.uk/shop/homepage/images/shop15/brand/apple/iphone-6/apple-iphone-6-2016-ios-10-gallery-img-2-101016.jpg", cat);
        Seller seller=new Seller(1, "Deepak");
        ProductSellerQuantityMapping productSellerQuantityMapping=new ProductSellerQuantityMapping(prod,seller,10);
        Collection<ProductDto> expectedProductDto = EntityToDtoTransformer.transformProductMappingToDot(Collections.singletonList(productSellerQuantityMapping));


        mockMvc.perform(get("/api/category/1/items")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful()).andDo(print())
                .andExpect(jsonPath("$[0]").value(expectedProductDto.iterator().next()));
    }

}

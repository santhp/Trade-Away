package com.tw.tradeaway.controller;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    CategoriesService categoriesService;

    @RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Mobiles"));
        categoryList.add(new Category(2, "Laptops"));
        categoryList.add(new Category(3, "Television"));
        categoryList.add(new Category(4, "Grocery"));
        return categoryList;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDto> getProductList(@RequestParam int categoryId) {

        categoriesService.getListOfProducts(categoryId);
        return null;
    }


}

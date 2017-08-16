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

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    CategoriesService categoriesService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Category> getCategoryList() {


        return categoriesService.getListOfCategories();
    }


    @RequestMapping(method = RequestMethod.GET)
    public Collection<ProductDto> getProductList(@RequestParam int categoryId) {

        return categoriesService.getListOfProducts(categoryId);
    }


}

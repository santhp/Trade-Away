package com.tw.tradeaway.controller;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
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


    @RequestMapping(value="{categoryId}/items",method = RequestMethod.GET)
    public Collection<ProductDto> getProductList(@PathVariable("categoryId") int categoryId) {

        return categoriesService.getListOfProducts(categoryId);
    }


}

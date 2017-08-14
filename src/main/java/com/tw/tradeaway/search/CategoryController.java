package com.tw.tradeaway.search;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    CategoriesService categoriesService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<String> getCategoryList() {


        return Arrays.asList("Cat1", "Cat2");
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDto> getProductList(@RequestParam int categoryId) {

        categoriesService.getListOfProducts(categoryId);
        return null;
    }


}

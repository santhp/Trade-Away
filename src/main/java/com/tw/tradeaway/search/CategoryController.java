package com.tw.tradeaway.search;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<String> getCategoryList() {
        return Arrays.asList("Cat1", "Cat2");
    }

}

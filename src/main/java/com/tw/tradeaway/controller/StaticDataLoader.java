package com.tw.tradeaway.controller;

import com.tw.tradeaway.dao.CategoryDAO;
import com.tw.tradeaway.dao.ProductDAO;
import com.tw.tradeaway.dao.SellerDAO;
import com.tw.tradeaway.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StaticDataLoader implements ApplicationRunner {
    @Autowired
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private SellerDAO sellerDAO;

    public void run(ApplicationArguments args) {
        categoryDAO.save(new Category(1001, "Electronics"));
        categoryDAO.save(new Category(1002, "Books"));


    }
}
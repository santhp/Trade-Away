package com.tw.tradeaway.controller;

import com.tw.tradeaway.dao.CategoryDAO;
import com.tw.tradeaway.dao.ProductDAO;
import com.tw.tradeaway.dao.ProductSellerQuantityMappingDao;
import com.tw.tradeaway.dao.SellerDAO;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.ProductSellerQuantityMapping;
import com.tw.tradeaway.entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StaticDataLoader implements ApplicationRunner {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private SellerDAO sellerDAO;
    @Autowired
    private ProductSellerQuantityMappingDao productSellerQuantityMappingDao;

    public void run(ApplicationArguments args) {
        Category cat=new Category("Electronics");
        categoryDAO.save(cat);

        Product prod=new Product( "iPhone", "d1", 100d, "https://n4.sdlcdn.com/imgs/a/l/9/black-f1854.jpg",cat);
        productDAO.save(prod);

        Seller seller=new Seller("Deepak");
        sellerDAO.save(seller);

        ProductSellerQuantityMapping prodSelMapping=new ProductSellerQuantityMapping(prod,seller,10);
        productSellerQuantityMappingDao.save(prodSelMapping);

    }
}
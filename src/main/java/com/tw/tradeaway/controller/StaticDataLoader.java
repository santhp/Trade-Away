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
        Category Mobiles = new Category("Mobiles");
        categoryDAO.save(Mobiles);

        Category laptops = new Category("Laptops");
        categoryDAO.save(laptops);

        Seller deepak = new Seller("Deepak");
        sellerDAO.save(deepak);

        Seller raja = new Seller("Raja");
        sellerDAO.save(raja);


        Product prod = new Product("iPhone 6", "8MP primary camera with auto focus and 1.2MP front facing camera\n" +
                "11.4 centimeters (4.7-inch) retina HD touchscreen with 1334 x 750 pixels resolution and 326 ppi pixel density\n", 26634d,
                "https://www.o2.co.uk/shop/homepage/images/shop15/brand/apple/iphone-6/apple-iphone-6-2016-ios-10-gallery-img-1-101016.jpg", Mobiles);
        productDAO.save(prod);

        ProductSellerQuantityMapping prodSelMapping = new ProductSellerQuantityMapping(prod, deepak, 10);
        productSellerQuantityMappingDao.save(prodSelMapping);

        prod = new Product("Samsung s7", "2MP primary camera with dual pixel, auto focus, motion mode, panorama mode,\n f/1.7, hyper lapse, slow motion, pro-mode, live broadcast, video collage,", 43234d,
                "http://www.samsung.com/us/support/get-started/samsung-galaxy-s7/assets/images/homepage/hero/default-hero.png", Mobiles);
        productDAO.save(prod);
        prodSelMapping = new ProductSellerQuantityMapping(prod, raja, 20);
        productSellerQuantityMappingDao.save(prodSelMapping);


        prodSelMapping = new ProductSellerQuantityMapping(prod, deepak, 50);
        productSellerQuantityMappingDao.save(prodSelMapping);

        //Laptops
        prod = new Product("Dell 2345", "38.1cm (15) performance laptop with Intel® processors and the latest graphics for a new level of fun, games and videos", 26634d,
                "http://ecx.images-amazon.com/images/I/41dyWm-6vcL._AC_SS200_.jpg", laptops);
        productDAO.save(prod);

        prodSelMapping = new ProductSellerQuantityMapping(prod, raja, 1000);
        productSellerQuantityMappingDao.save(prodSelMapping);

        prod = new Product("Mac", "13.3-inch (diagonal) LED-backlit display with IPS technology; 2560x1600 native resolution at 227 pixels per inch with support for millions of colours", 204934d,
                "https://cdn.cultofmac.com/wp-content/uploads/2017/01/macbook-pro-touchbar.jpg", laptops);
        productDAO.save(prod);

        prodSelMapping = new ProductSellerQuantityMapping(prod, raja, 100);
        productSellerQuantityMappingDao.save(prodSelMapping);


    }
}
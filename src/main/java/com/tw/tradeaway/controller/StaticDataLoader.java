package com.tw.tradeaway.controller;

import com.tw.tradeaway.dao.*;
import com.tw.tradeaway.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StaticDataLoader implements ApplicationRunner {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private SellerDAO sellerDAO;
    @Autowired
    private ProductSellerQuantityMappingDao productSellerQuantityMappingDao;
    @Autowired
    private OrderDAO orderDAO;

    public void run(ApplicationArguments args) {
        User buyer1 = new User("pavan", "kumar","pavan@gmail.com","90001212","buyer","address", "password");
        userDAO.save(buyer1);
        User seller1 = new User("deepak", "v","deepak@gmail.com","90001212","seller","address", "password");
        userDAO.save(seller1);


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
                "https://www.o2.co.uk/shop/homepage/images/shop15/brand/apple/iphone-6/apple-iphone-6-2016-ios-10-gallery-img-2-101016.jpg", Mobiles);
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

        //Out of stock simulation.
        prod = new Product("iPhone 10S", "Features: Everything beyond your imagination", 1000000000000d,
                "http://www.ced.ltd.uk/img/Firebird/Firebird_Gneiss_Wet.png", Mobiles);
        productDAO.save(prod);
        prodSelMapping = new ProductSellerQuantityMapping(prod, raja, 0);
        productSellerQuantityMappingDao.save(prodSelMapping);


        //Laptops
        prod = new Product("Dell 2345", "38.1cm (15) performance laptop with Intel® processors and the latest graphics for a new level of fun, games and videos", 26634d,
                "http://ecx.images-amazon.com/images/I/41dyWm-6vcL._AC_SS200_.jpg", laptops);
        productDAO.save(prod);

        prodSelMapping = new ProductSellerQuantityMapping(prod, raja, 1000);
        productSellerQuantityMappingDao.save(prodSelMapping);

        prod = new Product("Mac", "13.3-inch (diagonal) LED-backlit display with IPS technology; 2560x1600 native resolution at 227 pixels per inch with support for millions of colours", 204934d,
                "http://cdn2.alphr.com/sites/alphr/files/apple-macbook-2015-front-zoomed-out.jpg", laptops);
        productDAO.save(prod);

        prodSelMapping = new ProductSellerQuantityMapping(prod, raja, 100);
        productSellerQuantityMappingDao.save(prodSelMapping);

        Order order = new Order(prod,1,2,1,"NEW INDIANA","Pending");
        orderDAO.save(order);
    }
}
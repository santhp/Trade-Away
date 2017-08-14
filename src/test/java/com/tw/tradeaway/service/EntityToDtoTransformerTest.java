package com.tw.tradeaway.service;

import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.Seller;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityToDtoTransformerTest {

    @Test
    public void getProductDto() throws Exception {
        Category category=new Category(1,"Electronics");
        Product iphone = new Product(1,"IPHONE", "Its an Iphone", 59999.00, null, category);

        //TODO
    }

    @Test
    public void getSellerDto() throws Exception {
        Seller seller = new Seller(1,"LLP");

    }

}
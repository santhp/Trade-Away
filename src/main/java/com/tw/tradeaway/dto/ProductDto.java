package com.tw.tradeaway.dto;

import java.util.List;

public class ProductDto {

    String name;
    String description;
    double price;
    byte[] image;
    List<SellerDto> sellerList;

    public ProductDto(String name, String description, double price, byte[] image, List<SellerDto> sellerList) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.sellerList = sellerList;
    }
}

package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.dto.SellerDto;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.Seller;

import java.util.List;

public class EntityToDtoTransformer {

    public static ProductDto getProductDto(Product product, List<Seller> sellerList) {

      //public ProductDto(String name, String description, double price, byte[] image, List<SellerDto> sellerList) {

        return null;
    }


    public static SellerDto getSellerDto(Seller seller) {
       return new SellerDto(seller.getSellerName(), seller.getSellerId()) ;
    }
}

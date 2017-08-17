package com.tw.tradeaway.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderItemDto {

    private int buyerId;
    private int sellerId;
    private int productId;
    private String productname;
    private int qty;
    private String deliveryAddress;
    private List<String> errorMsg=new ArrayList<>();
    private int orderId;
    private double price;

    public OrderItemDto() {
    }

    public OrderItemDto(int buyerId, int sellerId, int productId, int qty, String deliveryAddress) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.qty = qty;
        this.deliveryAddress = deliveryAddress;
    }
}



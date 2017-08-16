package com.tw.tradeaway.dto;

public class OrderItemDto {

    private int userId;
    private int productId;
    private int qty;
    private String deliveryAddress;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderItemDto(int userId, int productId, int qty, String deliveryAddress) {
        this.userId = userId;
        this.productId = productId;
        this.qty = qty;
        this.deliveryAddress = deliveryAddress;
    }

    public OrderItemDto() {
    }

}



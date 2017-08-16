package com.tw.tradeaway.dto;

public class OrderItemDto {

    public int userId;
    public int ProductId;
    public int Qty;
    public String DeliveryAddress;


    public OrderItemDto() {
    }

    public OrderItemDto(int userId, int productId, int qty, String deliveryAddress) {
        this.userId = userId;
        ProductId = productId;
        Qty = qty;
        DeliveryAddress = deliveryAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        DeliveryAddress = deliveryAddress;
    }
}



package com.tw.tradeaway.entities;

public class Seller {
    int sellerId;
    String sellerName;

    public Seller(int sellerId, String sellerName) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
    }

    public int getSellerId() {
        return sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }
}

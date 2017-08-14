package com.tw.tradeaway.entities;


public class Product {
    int productId;
    String name;
    String description;
    double price;
    byte[] image;
    Category category;

    public Product(int productId, String name, String description, double price, byte[] image, Category category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public byte[] getImage() {
        return image;
    }

    public Category getCategory() {
        return category;
    }
}
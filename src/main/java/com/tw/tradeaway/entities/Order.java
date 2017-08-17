package com.tw.tradeaway.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Order_Details")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;



    @OneToOne
    @JoinColumn(name = "Product_ID", referencedColumnName = "id")
    private Product product;
    @Column(name = "Buyer_ID", nullable = false)
    private int buyerID;
    @Column(name = "Seller_ID",nullable = false)
    private int sellerID;
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Column(name = "Delivery_Address", nullable = false)
    private String deliveryAddress;

    @Column(name = "Status", nullable = false)
    private String status;

    public Order(Product product,int buyerID, int sellerID, int quantity, String deliveryAddress, String status) {
        this.product=product;
        this.buyerID = buyerID;
        this.sellerID = sellerID;
        this.quantity = quantity;
        this.deliveryAddress = deliveryAddress;
        this.status = status;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getBuyerID() {
        return buyerID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getStatus() {
        return status;
    }


}

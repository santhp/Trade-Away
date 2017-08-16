package com.tw.tradeaway.entities;


import javax.persistence.*;

@Entity
@Table(name = "Order_Details")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Product_ID", nullable = false)
    private int productID;
    @Column(name = "User_ID", nullable = false)
    private int userID;
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Column(name = "Delivery_Address", nullable = false)
    private String deliveryAddress;

    public Order(int userID, int productID, int quantity, String deliveryAddress) {
        this.productID = productID;
        this.userID = userID;
        this.quantity = quantity;
        this.deliveryAddress = deliveryAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productID=" + productID +
                ", userID=" + userID +
                ", quantity=" + quantity +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                '}';
    }
}

package com.tw.tradeaway.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Product")
public class ProductSellerQuantityMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @OneToOne
    @JoinColumn(name = "productId",referencedColumnName = "id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "sellerId",referencedColumnName = "id")
    private Seller seller;

    @Column
    private int quantity;


    public ProductSellerQuantityMapping(Product product, Seller seller, int quantity) {
        this.product = product;
        this.seller = seller;
        this.quantity = quantity;
    }

    public ProductSellerQuantityMapping() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSellerQuantityMapping that = (ProductSellerQuantityMapping) o;

        if (quantity != that.quantity) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return seller != null ? seller.equals(that.seller) : that.seller == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (seller != null ? seller.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }
}

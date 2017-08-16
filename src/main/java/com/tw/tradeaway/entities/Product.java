package com.tw.tradeaway.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;


@Data
@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "price")
    double price;
    @Column(name = "image")
    byte[] image;
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    Category category;

    public Product( String name, String description, double price, byte[] image, Category category) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (!Arrays.equals(image, product.image)) return false;
        return category != null ? category.equals(product.category) : product.category == null;
    }

    @Override
    public int hashCode() {
        int result = 7;
        long temp;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
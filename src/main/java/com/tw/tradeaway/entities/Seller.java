package com.tw.tradeaway.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Seller")
public class Seller {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "name")
    String name;

    public Seller(String name) {
        this.name = name;
    }

    public Seller(int id, String name) {
        this.id = id;

        this.name = name;
    }

    public Seller() {
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seller seller = (Seller) o;

        if (id != seller.id) return false;
        return name != null ? name.equals(seller.name) : seller.name == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

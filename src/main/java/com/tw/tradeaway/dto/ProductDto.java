package com.tw.tradeaway.dto;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ProductDto {

    String name;
    String description;
    double price;
    String imageUrl;
    List<SellerDto> sellerDto;

    public ProductDto(String name, String description, double price, String imageUrl, List<SellerDto> sellerDto) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.sellerDto = sellerDto;
    }

    public ProductDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDto that = (ProductDto) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return sellerDto != null ? sellerDto.equals(that.sellerDto) : that.sellerDto == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (sellerDto != null ? sellerDto.hashCode() : 0);
        return result;
    }
}

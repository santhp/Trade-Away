package com.tw.tradeaway.dto;

import lombok.Data;

@Data
public class SellerDto {
    private int sellerId;
    private String sellerName;
    private int quantity;

    public SellerDto() {
    }

    public SellerDto(int sellerId, String sellerName, int quantity) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellerDto sellerDto = (SellerDto) o;

        if (sellerId != sellerDto.sellerId) return false;
        if (quantity != sellerDto.quantity) return false;
        return sellerName != null ? sellerName.equals(sellerDto.sellerName) : sellerDto.sellerName == null;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + sellerId;
        result = 31 * result + (sellerName != null ? sellerName.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }
}

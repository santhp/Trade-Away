package com.tw.tradeaway.entities;

import lombok.Data;

@Data
public class Category {
    int categoryId;
    String categoryName;

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

}

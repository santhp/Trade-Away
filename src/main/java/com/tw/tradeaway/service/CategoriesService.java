package com.tw.tradeaway.service;

import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;

import java.util.List;

public interface CategoriesService {

    public List<Category> getListOfCategories();

    public List<Product>  getListOfProducts(int categoryId);


}







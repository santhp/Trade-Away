package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.entities.Category;

import java.util.Collection;
import java.util.List;

public interface CategoriesService {

    public List<Category> getListOfCategories();

    public Collection<ProductDto> getListOfProducts(int categoryId);


}







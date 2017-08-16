package com.tw.tradeaway.service;

import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {


    @Override
    public List<Category> getListOfCategories() {
        return null;
    }

    @Override
    public List<Product> getListOfProducts(int categoryId) {
        return null;
    }
}

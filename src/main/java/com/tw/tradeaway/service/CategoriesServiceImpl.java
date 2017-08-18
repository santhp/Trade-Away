package com.tw.tradeaway.service;

import com.tw.tradeaway.dao.CategoryDAO;
import com.tw.tradeaway.dao.ProductDAO;
import com.tw.tradeaway.dao.ProductSellerQuantityMappingDao;
import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.ProductSellerQuantityMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProductSellerQuantityMappingDao productSellerQuantityMappingDao;

    @Override
    public List<Category> getListOfCategories() {
        List<Category> categories = new ArrayList<>();
        categoryDAO.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Collection<ProductDto> getListOfProducts(int categoryId) {

        List<ProductSellerQuantityMapping> map =productSellerQuantityMappingDao.getPSQMappingListForGivenCategory(categoryId);
        return EntityToDtoTransformer.transformProductMappingToDot(map);

    }
}

package com.tw.tradeaway.service;

import com.tw.tradeaway.dao.CategoryDAO;
import com.tw.tradeaway.dao.ProductDAO;
import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.ProductSellerQuantityMapping;
import com.tw.tradeaway.entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    ProductDAO productDAO;

    @Override
    public List<Category> getListOfCategories() {
        List<Category> categories = new ArrayList<>();
        categoryDAO.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Collection<ProductDto> getListOfProducts(int categoryId) {

        Seller seller = new Seller(1, "ABC");
        Product product = new Product( "IPhone", "Advanced phone", 10000, null, new Category(1, "Electronics"));
        ProductSellerQuantityMapping productSellerQuantityMapping = new ProductSellerQuantityMapping(1, product, seller, 10);
//
//        List<Product> productList = productDAO.getProductListForGivenCategory(categoryId);
//

        return EntityToDtoTransformer.transformProductMappingToDot(Arrays.asList(productSellerQuantityMapping));

    }
}

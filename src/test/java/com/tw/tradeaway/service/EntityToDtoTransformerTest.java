package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.dto.SellerDto;
import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.ProductSellerQuantityMapping;
import com.tw.tradeaway.entities.Seller;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class EntityToDtoTransformerTest {

    @Test
    public void getProductDto() throws Exception {
        Seller seller = new Seller(1, "ABC");
        Product product = new Product( 1, "IPhone", "Advanced phone", 10000d, null, new Category(1, "Electronics"));
        ProductSellerQuantityMapping productSellerQuantityMapping = new ProductSellerQuantityMapping(product, seller, 10);

        ProductDto expectedProductDto = new ProductDto(product.getId(),product.getName(), product.getDescription(), product.getPrice(), product.getImageUrl(), new ArrayList<>());
        expectedProductDto.getSellerDto().add(new SellerDto(seller.getId(), seller.getName(), 10));


        Collection<ProductDto> actualProductDtoList = EntityToDtoTransformer.transformProductMappingToDot(Collections.singletonList(productSellerQuantityMapping));
        Collection<ProductDto> expectedProductDtoList = Collections.singletonList(expectedProductDto);

        assertTrue(actualProductDtoList
                .containsAll(expectedProductDtoList));

    }
}
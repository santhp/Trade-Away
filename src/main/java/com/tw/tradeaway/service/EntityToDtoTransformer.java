package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.ProductDto;
import com.tw.tradeaway.dto.SellerDto;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.ProductSellerQuantityMapping;
import com.tw.tradeaway.entities.Seller;

import java.util.*;

public class EntityToDtoTransformer {

    public static Collection<ProductDto> transformProductMappingToDot(List<ProductSellerQuantityMapping> productSellerQuantityMappingList) {
        Map<Product, ProductDto> outputMap = new HashMap<>();

        for (ProductSellerQuantityMapping currentMapping : productSellerQuantityMappingList) {
            Product currentProduct = currentMapping.getProduct();
            Seller currentSeller = currentMapping.getSeller();
            int currentQuantity = currentMapping.getQuantity();


            if (outputMap.containsKey(currentProduct)) {
                outputMap.get(currentProduct).getSellerDto().add(new SellerDto(currentSeller.getId(), currentSeller.getName(), currentQuantity));
            } else {
                ProductDto newProductDto = new ProductDto(currentProduct.getName(), currentProduct.getDescription(), currentProduct.getPrice(), currentProduct.getImageUrl(), new ArrayList<>());
                newProductDto.getSellerDto().add(new SellerDto(currentSeller.getId(), currentSeller.getName(), currentQuantity));
                outputMap.put(currentProduct, newProductDto);
            }
        }

        return outputMap.values();
    }

}

package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.ProductSellerQuantityMapping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProductSellerQuantityMappingDao extends CrudRepository<ProductSellerQuantityMapping, Integer> {

    @Query("select p from ProductSellerQuantityMapping p where p.product.category.id=:categoryId")
     List<ProductSellerQuantityMapping> getPSQMappingListForGivenCategory(@Param("categoryId")int categoryId);

    @Query("select p.quantity from ProductSellerQuantityMapping p where p.product.id=:productId and p.seller.id=:sellerId")
    int getQuantityForGivenProductAndSeller(@Param("productId")int productId,@Param("sellerId")int sellerId);

    @Query("select p from ProductSellerQuantityMapping p where p.product.id=:productId and p.seller.id=:sellerId")
    ProductSellerQuantityMapping getProductSellerQuantityMappingGivenProductAndSeller(@Param("productId")int productId,@Param("sellerId")int sellerId);

}

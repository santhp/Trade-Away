package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProductDAO extends CrudRepository<Product, Integer> {
    @Query("select p from Product p where p.category.id=:id")
    List<Product> getProductListForGivenCategory(@Param("id")int id);
}

package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.Category;
import com.tw.tradeaway.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface SellerDAO extends CrudRepository<Category, Integer> {

}

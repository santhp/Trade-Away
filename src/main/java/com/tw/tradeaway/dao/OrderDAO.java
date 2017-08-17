package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface OrderDAO extends CrudRepository<Order, Integer> {

}
package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface OrderDAO extends CrudRepository<Order, Integer> {

    @Query("select o from Order o where o.sellerID=:id")
    List<Order> getOrdersForSeller(@Param("id")int id);
}
package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.Order;
import org.h2.engine.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQuery;
import java.util.List;
import java.util.List;

@Transactional
@Repository
public interface OrderDAO extends CrudRepository<Order, Integer> {

    @Query("select o from Order o where o.sellerID=:id")
    List<Order> getOrdersForSeller(@Param("id")int id);
}
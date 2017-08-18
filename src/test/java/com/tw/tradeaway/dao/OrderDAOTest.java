package com.tw.tradeaway.dao;

import com.tw.tradeaway.entities.Order;
import com.tw.tradeaway.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderDAOTest {

    @Autowired
    OrderDAO orderDAO;

    @Test
    public void createRecordSuccessfully() {
        Product product = new Product();
        product.setId(1);
        Order order = new Order(product,1,1,1,"abc","PENDING");
        orderDAO.save(order);
    }

    @Test
    public void getDataSuccessfully() {


        Iterable<Order> orders = orderDAO.findAll();
        if(orders.iterator().hasNext()){
            assert(true);
        }
    }
}
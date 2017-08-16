package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.OrderItemDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderPlacementServiceImplTest {

    @Autowired
    OrderPlacementService service;

    @Test
    public void createOrderSucessfully() throws Exception {


        OrderItemDto orderInfo = new OrderItemDto();
        orderInfo.setUserId(1001);
        orderInfo.setProductId(2001);
        orderInfo.setQty(1);
        orderInfo.setDeliveryAddress("Bangalore");
        int orderID = service.createOrder(orderInfo);
        System.out.println("Order ID ::: ::: :::   "+orderID);
        assertNotEquals(0, orderID);


        orderInfo.setUserId(1001);
        orderInfo.setProductId(2001);
        orderInfo.setQty(1);
        orderInfo.setDeliveryAddress("Bangalore");
        orderID = service.createOrder(orderInfo);
        assertEquals (2, orderID);



    }

}
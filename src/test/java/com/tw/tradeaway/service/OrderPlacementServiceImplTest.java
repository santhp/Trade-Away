package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.OrderItemDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderPlacementServiceImplTest {


    @Test
    public void createOrderSucessfully() throws Exception {

        OrderPlacementService service = new OrderPlacementServiceImpl();
        OrderItemDto orderInfo = new OrderItemDto();
        orderInfo.setUserId(1001);
        orderInfo.setProductId(2001);
        orderInfo.setQty(1);
        orderInfo.setDeliveryAddress("Bangalore");
        //int orderID  = service.createOrder(orderInfo);
        //assertNotEquals(0,orderID);

    }

}
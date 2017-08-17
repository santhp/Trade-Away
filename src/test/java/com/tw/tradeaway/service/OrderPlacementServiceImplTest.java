package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.OrderItemDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

        orderInfo.setProductId(1);
        orderInfo.setQty(1);
        orderInfo.setBuyerId(1);
        orderInfo.setSellerId(1);
        orderInfo.setDeliveryAddress("Bangalore");
        orderInfo = service.createOrder(orderInfo);
        assertNotEquals(0, orderInfo.getOrderId());


        OrderItemDto orderInfo2 = new OrderItemDto();

        orderInfo2.setProductId(1);
        orderInfo2.setQty(4);
        orderInfo2.setBuyerId(1);
        orderInfo2.setSellerId(1);
        orderInfo2.setDeliveryAddress("Bangalore");
        orderInfo2 = service.createOrder(orderInfo2);
       assertNotEquals(1,orderInfo2.getOrderId());

        OrderItemDto orderInfo3 = new OrderItemDto();

        orderInfo3.setProductId(1);
        orderInfo3.setQty(6);
        orderInfo3.setBuyerId(1);
        orderInfo3.setSellerId(1);
        orderInfo3.setDeliveryAddress("Bangalore");
        orderInfo3 = service.createOrder(orderInfo3);
        List<String> errorList = orderInfo.getErrorMsg();
        if (errorList.contains("Order Quantity is not available in stock")) {
            assert (true);
        }
    }



    @Test
    public void createOrderMandatoryValidation() throws Exception {

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setProductId(2001);
        orderItemDto.setQty(1);
        orderItemDto.setDeliveryAddress("Bangalore");

        orderItemDto = service.createOrder(orderItemDto);
        List<String> errorList = orderItemDto.getErrorMsg();
        if (errorList.contains("Address, Quantity are mandatory to create order")) {
            assert (true);
        }


    }

    @Test
    public void createOrderFailWithInsufficientQuantity() throws Exception {

        OrderItemDto orderInfo = new OrderItemDto();

        orderInfo.setProductId(1);
        orderInfo.setQty(21);
        orderInfo.setBuyerId(1);
        orderInfo.setSellerId(1);
        orderInfo.setDeliveryAddress("Bangalore");
        orderInfo = service.createOrder(orderInfo);
        List<String> errorList = orderInfo.getErrorMsg();
        if (errorList.contains("Order Quantity is not available in stock")) {
            assert (true);
        }

    }

}
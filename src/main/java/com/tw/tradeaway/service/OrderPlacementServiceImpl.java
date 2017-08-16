package com.tw.tradeaway.service;

import com.tw.tradeaway.common.exception.InvalidOrderInfoException;
import com.tw.tradeaway.dao.OrderRespository;
import com.tw.tradeaway.dto.OrderItemDto;
import com.tw.tradeaway.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPlacementServiceImpl  implements  OrderPlacementService{

    @Autowired
    OrderRespository orderRepo;
    /**
     * method to perform process order creation
     * @param orderDto
     * @return orderID
     */
    @Override
    public int createOrder(OrderItemDto orderDto) throws InvalidOrderInfoException {

        // perform validations
        performValidations(orderDto);
        Order newOrder=new Order(orderDto.getUserId(),orderDto.getProductId(),orderDto.getQty(),orderDto.getDeliveryAddress()) ;
        newOrder = orderRepo.save(newOrder);
        return newOrder.getId();
    }


    private void performValidations(OrderItemDto orderDto) throws InvalidOrderInfoException {

        // mandatory validations
        if(orderDto == null || orderDto.getUserId() == 0
                || orderDto.getProductId() == 0
                || orderDto.getQty() == 0
                || orderDto.getDeliveryAddress() == null
                || orderDto.getDeliveryAddress().isEmpty()){

            throw new InvalidOrderInfoException("Product Id, User ID, Address, Quantity are mandatory to create order");
        }
    }
}

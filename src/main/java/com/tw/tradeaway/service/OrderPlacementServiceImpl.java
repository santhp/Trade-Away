package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.OrderItemDto;

public class OrderPlacementServiceImpl  implements  OrderPlacementService{

    /**
     * method to perform process order creation
     * @param orderInfo
     * @return orderID
     */
    @Override
    public int createOrder(OrderItemDto orderInfo) {


        return 0;
    }


    private void performValidations(OrderItemDto orderInfo){

        // mandatory validations
        if(orderInfo == null || orderInfo.getUserId() == 0
                || orderInfo.getProductId() == 0
                || orderInfo.getQty() == 0
                || orderInfo.getDeliveryAddress() == null
                || orderInfo.getDeliveryAddress().isEmpty()){

        }
    }
}

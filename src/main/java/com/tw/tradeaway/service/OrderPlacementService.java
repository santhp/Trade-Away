package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.OrderItemDto;

public interface OrderPlacementService {


    OrderItemDto createOrder(OrderItemDto orderInfo) ;
}

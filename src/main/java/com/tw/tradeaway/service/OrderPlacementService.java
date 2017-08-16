package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.OrderItemDto;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

public interface OrderPlacementService {


    public int createOrder(OrderItemDto orderInfo);
}

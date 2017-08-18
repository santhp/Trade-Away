package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.OrderItemDto;

import java.util.Collection;

public interface SellerService {

    Collection<OrderItemDto> getOrders(int sellerId);
}

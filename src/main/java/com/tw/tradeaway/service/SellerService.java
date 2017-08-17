package com.tw.tradeaway.service;

import com.tw.tradeaway.dto.OrderItemDto;

import java.util.Collection;
import java.util.List;

public interface SellerService {

    public Collection<OrderItemDto> getOrders(int sellerId);
}

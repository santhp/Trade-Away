package com.tw.tradeaway.service;

import com.tw.tradeaway.dao.OrderDAO;
import com.tw.tradeaway.dto.OrderItemDto;
import com.tw.tradeaway.entities.Order;
import com.tw.tradeaway.entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    public Collection<OrderItemDto> getOrders(int sellerId) {

        //public OrderItemDto(int buyerId, int sellerId, int productId,
        // String productname, int qty, String deliveryAddress, int orderId, double price) {

        List<OrderItemDto> orderItemDtos = new ArrayList<>();

        for(Order order : orderDAO.getOrdersForSeller(sellerId)) {
            OrderItemDto orderDto = new OrderItemDto(
                    order.getBuyerID(),order.getSellerID(),order.getProduct().getId(),
                    order.getProduct().getName(), order.getQuantity(),order.getDeliveryAddress(),
                    order.getId(),order.getProduct().getPrice(),order.getStatus());

            orderItemDtos.add(orderDto);
        }

        return orderItemDtos;
    }
}

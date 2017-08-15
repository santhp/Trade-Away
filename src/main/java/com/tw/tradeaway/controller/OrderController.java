package com.tw.tradeaway.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import viewmodel.OrderItem;

import java.net.URI;

@RestController
@RequestMapping(value = "order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> checkoutToPlaceOrder(@RequestBody OrderItem orderItem) {

        // TODO:: Create order here

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(orderItem.getProductId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public OrderItem getOrder() {

        OrderItem item = new OrderItem("item001", 1, "deliveryAddress");
        return item;
    }
}
package com.tw.tradeaway.controller;

import com.tw.tradeaway.dto.OrderItemDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> checkoutToPlaceOrder(@RequestBody OrderItemDto orderItem) {

        if (orderItem == null || orderItem.ProductId == null) {
            throw new NullPointerException("Parameter Type cannot be null");
        }

        // TODO:: Create order here

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(orderItem.getProductId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public OrderItemDto getOrder() {

        OrderItemDto item = new OrderItemDto("item001", 1, "deliveryAddress");
        return item;
    }
}
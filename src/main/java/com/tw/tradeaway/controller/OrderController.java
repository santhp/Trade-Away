package com.tw.tradeaway.controller;

import com.tw.tradeaway.dto.OrderItemDto;
import com.tw.tradeaway.service.OrderPlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class OrderController {

    @Autowired
    OrderPlacementService service;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/api/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<OrderItemDto> checkoutToPlaceOrder(@RequestBody OrderItemDto orderItem) {

        orderItem = service.createOrder(orderItem);

        // success response
        if (orderItem.getErrorMsg().isEmpty()) {
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(orderItem.getOrderId()).toUri();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(location);
            return new ResponseEntity<OrderItemDto>(orderItem, headers, HttpStatus.CREATED);
        }

        //failure response
        return new ResponseEntity<OrderItemDto>(orderItem, HttpStatus.BAD_REQUEST);


    }

}
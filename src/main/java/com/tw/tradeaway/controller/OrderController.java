package com.tw.tradeaway.controller;

import com.tw.tradeaway.dto.OrderItemDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class OrderController {

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/order", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> checkoutToPlaceOrder(@RequestBody OrderItemDto orderItem) {

        //validation
        if(orderItem == null || orderItem.getProductId() == 0){
            throw new NullPointerException("Parameter Type [Order ID] cannot be null");
        }



        // response
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(orderItem.getProductId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
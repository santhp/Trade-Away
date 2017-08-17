package com.tw.tradeaway.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tw.tradeaway.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "api/seller", produces = MediaType.APPLICATION_JSON_VALUE)
public class SellerController {

    @RequestMapping(value = "{sellerId}/orders", method = RequestMethod.GET)
    public String getOrders(@PathVariable("sellerId") int sellerId) {
        JsonArray arr =new JsonArray();
        JsonObject json = new JsonObject();
        json.addProperty("orderId", 1001);
        json.addProperty("productId", 1);
        json.addProperty("name", "IPhone");
        json.addProperty("price", "67889");
        json.addProperty("address", "Pune");
        json.addProperty("status", "Pending");
        arr.add(json);

        json = new JsonObject();
        json.addProperty("orderId", 1002);
        json.addProperty("productId", 1);
        json.addProperty("name", "MacBook");
        json.addProperty("price", "99999");
        json.addProperty("address", "Hyderabad");
        json.addProperty("status", "Pending");
        arr.add(json);

        return arr.toString();

    }
}


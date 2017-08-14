package com.tw.tradeaway.order;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "checkout", produces = MediaType.APPLICATION_JSON_VALUE)
public class CheckOutController {
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String checkoutToPlaceOrder() {
        return "";
    }
}
package com.rdcecomm.rdcecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/place-order")
public class PlaceOrderController {
    /*@Autowired
    private PlaceOrderService placeOrderService;

    @PostMapping("/checkout")
    public List<PlaceOrder> placeOrder() {
        return placeOrderService.placeOrder();
    }

    @GetMapping("/transaction")
    public List<PlaceOrder> transactions() {
        return placeOrderService.transactions();
    }*/
}

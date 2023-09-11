package com.example.hw25.controllers;

import com.example.hw25.services.OrderService;
import com.example.hw25.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {

    private final OrderService orderService;
    private final ProductService productService;

    @Autowired
    public Controller(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/ping")
    public String getOk(){
        return "ping";
    }
}

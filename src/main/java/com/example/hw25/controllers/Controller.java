package com.example.hw25.controllers;

import com.example.hw25.models.Order;
import com.example.hw25.services.OrderService;
import com.example.hw25.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Controller
public class Controller {

    private final OrderService orderService;
    private final ProductService productService;
    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    public Controller(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/ping")
    public String getOk() {
        log.info("GET Ping controller started");
        return "ping";
    }

    @GetMapping("/orders")
    public String getOrders() {
        log.info("GET Orders controller started");
        return "orders";
    }

    @ResponseBody
    @PostMapping("/orders")
    public String postOrders(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        log.info("POST Orders controller started");
        String orderId = request.getParameter("orderId");
        Optional<Order> orderOptional = orderService.findById(Integer.parseInt(orderId));
        ObjectMapper objectMapper = new ObjectMapper();
        if (orderOptional.isPresent()) {
            return objectMapper.writeValueAsString(orderOptional.get());
        }
        return "Order Not Found";
    }

    @ResponseBody
    @GetMapping("/orders/all")
    public String getAllOrders() {
        log.info("GET OrdersAll controller started");
        List<Order> orderList = orderService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder stringBuilder = new StringBuilder();
        orderList.forEach(order -> {
            try {
                stringBuilder.append(objectMapper.writeValueAsString(order));
            } catch (JsonProcessingException e) {
                log.error("", new RuntimeException(e));
            }
        });
        return stringBuilder.toString();
    }
}

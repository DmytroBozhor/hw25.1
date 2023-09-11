package com.example.hw25.services;

import com.example.hw25.models.Order;
import com.example.hw25.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> findById(int id){
        return orderRepository.findById(id);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public void save(Order order){
        orderRepository.save(order);
    }
}

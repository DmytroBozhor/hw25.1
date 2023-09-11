package com.example.hw25.repositories;

import com.example.hw25.models.Order;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ListCrudRepository<Order, Integer> {
}

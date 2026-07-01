package com.joabdevelop.swiftcart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joabdevelop.swiftcart.entities.Order;
import com.joabdevelop.swiftcart.repositories.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}

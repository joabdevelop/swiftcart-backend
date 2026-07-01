package com.joabdevelop.swiftcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joabdevelop.swiftcart.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

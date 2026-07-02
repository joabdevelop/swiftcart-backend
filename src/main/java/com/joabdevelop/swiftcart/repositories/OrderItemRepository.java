package com.joabdevelop.swiftcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joabdevelop.swiftcart.entities.OrderItem;
import com.joabdevelop.swiftcart.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}

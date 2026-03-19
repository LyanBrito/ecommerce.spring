package org.example.ecommerce.repositories;

import org.example.ecommerce.entities.OrderItem;
import org.example.ecommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, OrderItemPK> {
}

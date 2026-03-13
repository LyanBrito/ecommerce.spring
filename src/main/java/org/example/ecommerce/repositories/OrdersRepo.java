package org.example.ecommerce.repositories;

import org.example.ecommerce.entitys.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersRepo extends JpaRepository<OrderEntity, UUID> {
}

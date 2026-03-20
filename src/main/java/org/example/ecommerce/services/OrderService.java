package org.example.ecommerce.services;

import org.example.ecommerce.dto.orders.OrdersRes;
import org.example.ecommerce.dto.users.UsersRes;
import org.example.ecommerce.entities.OrderEntity;
import org.example.ecommerce.entities.UserEntity;
import org.example.ecommerce.repositories.OrdersRepo;
import org.example.ecommerce.repositories.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrdersRepo ordersRepo;
    private final UsersRepo usersRepo;

    public OrderService(OrdersRepo ordersRepo, UsersRepo usersRepo) {
        this.ordersRepo = ordersRepo;
        this.usersRepo = usersRepo;
    }

    public OrdersRes create(UUID userId) {
        UserEntity user = usersRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        OrderEntity order = new OrderEntity();
        order.setClient(user);
        ordersRepo.save(order);
        return new OrdersRes(order);
    }

    public OrdersRes showById(UUID id) {
        OrderEntity order = ordersRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return new OrdersRes(order);
    }

    public List<OrdersRes> showAll() {
        List<OrderEntity> orders = ordersRepo.findAll();
        return orders.stream().map(OrdersRes::new).toList();
    }

}

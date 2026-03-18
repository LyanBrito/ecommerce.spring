package org.example.ecommerce.services;

import org.example.ecommerce.dto.orders.OrdersReq;
import org.example.ecommerce.dto.orders.OrdersRes;
import org.example.ecommerce.entities.OrderEntity;
import org.example.ecommerce.entities.PaymentEntity;
import org.example.ecommerce.entities.UserEntity;
import org.example.ecommerce.entities.enums.OrderStatus;
import org.example.ecommerce.repositories.OrdersRepo;
import org.example.ecommerce.repositories.UsersRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class OrderService {

    private final OrdersRepo ordersRepo;
    private final UsersRepo usersRepo;

    public OrderService(OrdersRepo ordersRepo, UsersRepo usersRepo) {
        this.ordersRepo = ordersRepo;
        this.usersRepo = usersRepo;
    }

    public OrdersRes create(OrdersReq req, UUID userId){
        UserEntity user = usersRepo.getReferenceById(userId);
        OrderEntity order = new OrderEntity();
        order.setMoment(LocalDate.now());
        order.setOrder_status(OrderStatus.WAITING_PAYMENT);
        order.setPaymentEntity(new PaymentEntity());
        order.setClient(user);

        return new OrdersRes(user);
    }
}

package org.example.ecommerce.dto.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommerce.entities.PaymentEntity;
import org.example.ecommerce.entities.UserEntity;
import org.example.ecommerce.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersRes {
    private UUID id;
    private LocalDate moment;
    private OrderStatus order_status;
    private UserEntity client;
    private PaymentEntity paymentEntity;

    public OrdersRes(UserEntity user) {
    }
}

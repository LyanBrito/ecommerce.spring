package org.example.ecommerce.dto.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommerce.dto.users.UsersRes;
import org.example.ecommerce.entities.OrderEntity;
import org.example.ecommerce.entities.PaymentEntity;
import org.example.ecommerce.entities.UserEntity;
import org.example.ecommerce.entities.enums.OrderStatus;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class OrdersRes {
    private LocalDate moment;
    private OrderStatus order_status;
    private UsersRes user;

    public OrdersRes(OrderEntity orderEntity, UsersRes usersRes) {
        this.moment = orderEntity.getMoment();
        this.order_status = orderEntity.getOrder_status();
        this.user = usersRes;
    }

    public OrdersRes(OrderEntity orderEntity) {
        this.moment = orderEntity.getMoment();
        this.order_status = orderEntity.getOrder_status();
    }
}

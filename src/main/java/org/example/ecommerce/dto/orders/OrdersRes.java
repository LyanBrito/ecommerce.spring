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
    private UUID id;
    private LocalDate moment;
    private OrderStatus order_status;
    private UUID user_id;

    public OrdersRes(OrderEntity orderEntity) {
        this.id = orderEntity.getId();
        this.moment = orderEntity.getMoment();
        this.order_status = orderEntity.getOrder_status();
        this.user_id = (orderEntity.getClient() != null) ? orderEntity.getClient().getId() : null;
    }
}

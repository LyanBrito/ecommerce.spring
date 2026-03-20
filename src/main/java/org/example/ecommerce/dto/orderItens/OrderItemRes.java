package org.example.ecommerce.dto.orderItens;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommerce.entities.OrderItem;
import org.example.ecommerce.entities.OrderItemPK;

import java.util.UUID;

@NoArgsConstructor
@Getter
public class OrderItemRes {
    private OrderItemPK id;
    private int quantity;
    private double price;

    public OrderItemRes(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }
}

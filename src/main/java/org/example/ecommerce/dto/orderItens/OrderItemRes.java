package org.example.ecommerce.dto.orderItens;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommerce.entities.OrderItem;

@NoArgsConstructor
@Getter
public class OrderItemRes {
    private int quantity;
    private double price;

    public OrderItemRes(OrderItem orderItem) {
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }
}

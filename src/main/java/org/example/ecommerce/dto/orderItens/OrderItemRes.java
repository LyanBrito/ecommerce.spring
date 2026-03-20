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
    private int quantity;
    private double price;
    private String clientName;
    private String productName;

    public OrderItemRes(OrderItem orderItem) {
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.clientName = orderItem.getId().getOrderEntity().getClient().getName();
        this.productName = orderItem.getId().getProduct().getName();
    }
}

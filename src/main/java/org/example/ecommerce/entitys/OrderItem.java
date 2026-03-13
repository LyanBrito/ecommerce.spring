package org.example.ecommerce.entitys;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private int quantity;
    private double price;

    public OrderItem(OrderEntity order, ProductEntity product ,OrderItemPK id, int quantity, double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderEntity getOrderEntity() {
        return id.getOrder();
    }

    public void setOrderEntity(OrderEntity order) {
        id.setOrder(order);
    }

    public ProductEntity getProductEntity() {
        return id.getProduct();
    }

    public void setProductEntity(ProductEntity product) {
        id.setProduct(product);
    }
}

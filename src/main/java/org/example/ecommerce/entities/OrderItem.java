package org.example.ecommerce.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
        id.setOrderEntity(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonBackReference
    public OrderEntity getOrderEntity() {
        return id.getOrderEntity();
    }

    public void setOrderEntity(OrderEntity order) {
        id.setOrderEntity(order);
    }

    public ProductEntity getProductEntity() {
        return id.getProduct();
    }

    public void setProductEntity(ProductEntity product) {
        id.setProduct(product);
    }
}

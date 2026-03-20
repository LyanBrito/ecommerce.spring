package org.example.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ecommerce.dto.orderItens.OrderItemReq;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private int quantity;
    private double price;

    public OrderItem(OrderEntity order, ProductEntity product , OrderItemReq req) {
        id.setOrderEntity(order);
        id.setProduct(product);
        this.quantity = req.getQuantity();
        this.price = product.getPrice() * req.getQuantity();
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

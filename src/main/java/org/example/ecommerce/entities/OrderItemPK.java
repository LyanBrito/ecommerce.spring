package org.example.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderItemPK {

    @ManyToOne
    @JoinColumn(name = "orderEntity_id")
    private OrderEntity orderEntity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

}
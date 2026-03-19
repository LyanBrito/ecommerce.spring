package org.example.ecommerce.dto.orderItens;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemReq {
    @Size(min = 1)
    private int quantity;
    private double price;
}

package org.example.ecommerce.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate moment;
    @OneToOne
    @MapsId
    @JsonBackReference
    private OrderEntity orderEntity;

    public PaymentEntity(OrderEntity orderEntity) {
        this.moment = LocalDate.now();
        this.orderEntity = orderEntity;
    }
}
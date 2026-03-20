package org.example.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.dto.orders.OrdersRes;
import org.example.ecommerce.entities.enums.OrderStatus;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate moment;
    private OrderStatus order_status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity client;
    @OneToOne(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private PaymentEntity paymentEntity;
    // o que acontecer com a classe pedido, acontece com a classe pagamento

    @OneToMany(mappedBy = "id.orderEntity")
    private Set<OrderItem> items =  new HashSet<>();

    public OrderEntity() {
        this.order_status = OrderStatus.WAITING_PAYMENT;
        this.moment = LocalDate.now();
    }

    public OrderEntity(LocalDate moment, OrderStatus order_status, UserEntity client, PaymentEntity paymentEntity, Set<OrderItem> items) {
        this.moment = moment;
        this.order_status = order_status;
        this.client = client;
        this.paymentEntity = paymentEntity;
        this.items = items;
    }
}

package org.example.ecommerce.entitys;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.entitys.enums.OrderStatus;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public OrderEntity(OrderStatus order_status, UserEntity client, LocalDate moment) {
        this.order_status = OrderStatus.WAITING_PAYMENT;
        this.client = client;
        this.moment = LocalDate.now();
    }
}

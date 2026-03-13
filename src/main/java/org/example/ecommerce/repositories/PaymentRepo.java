package org.example.ecommerce.repositories;

import org.example.ecommerce.entitys.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepo extends JpaRepository<PaymentEntity, UUID> {
}

package org.example.ecommerce.repositories;

import org.example.ecommerce.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductsRepo extends JpaRepository<ProductEntity, UUID> {
    UUID id(UUID id);
}

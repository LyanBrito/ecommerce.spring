package org.example.ecommerce.repositories;

import org.example.ecommerce.entitys.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriesRepo extends JpaRepository<CategoriesEntity, UUID> {
}

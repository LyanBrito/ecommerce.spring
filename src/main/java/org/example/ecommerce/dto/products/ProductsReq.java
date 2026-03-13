package org.example.ecommerce.dto.products;

import lombok.*;
import org.example.ecommerce.entitys.CategoriesEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsReq {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private String imgUrl;
    private Set<CategoriesEntity> categories = new HashSet<>();
}

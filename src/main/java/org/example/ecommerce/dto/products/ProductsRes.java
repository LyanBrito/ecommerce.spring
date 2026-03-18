package org.example.ecommerce.dto.products;

import lombok.*;
import org.example.ecommerce.entities.CategoriesEntity;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRes {
    private String name;
    private String description;
    private double price;
    private String imgUrl;
    private Set<CategoriesEntity> categories = new HashSet<>();
}

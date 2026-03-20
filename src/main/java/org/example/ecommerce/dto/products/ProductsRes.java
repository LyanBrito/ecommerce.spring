package org.example.ecommerce.dto.products;

import lombok.*;
import org.example.ecommerce.entities.CategoriesEntity;
import org.example.ecommerce.entities.ProductEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRes {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private String imgUrl;
//    private Set<CategoriesEntity> categories = new HashSet<>();

    public ProductsRes(ProductEntity product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgUrl = product.getImgUrl();
//        this.categories = product.getCategories();
    }
}

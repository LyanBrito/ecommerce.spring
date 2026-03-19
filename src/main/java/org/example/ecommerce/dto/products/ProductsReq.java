package org.example.ecommerce.dto.products;

import lombok.*;
import org.example.ecommerce.entities.CategoriesEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsReq {
    private String name;
    private String description;
    private double price;
    private String imgUrl;
    private Set<CategoriesEntity> categories = new HashSet<>();
//    certeza de que isso pode dar errado,
//    mas arrumo depois, ou não chamo categorias.
//    decido isso amanhã
}

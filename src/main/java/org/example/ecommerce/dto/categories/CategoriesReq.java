package org.example.ecommerce.dto.categories;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesReq {
    private UUID id;
    private String name;
}

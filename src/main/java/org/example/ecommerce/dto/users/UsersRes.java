package org.example.ecommerce.dto.users;

import lombok.*;
import org.example.ecommerce.entities.OrderEntity;
import org.example.ecommerce.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersRes {
    private String name;
    private String email;
    private String tell;
    private List<OrderEntity> orders = new ArrayList<>();

    public UsersRes(UserEntity userEntity) {
    }
}

package org.example.ecommerce.dto.users;

import lombok.*;
import org.example.ecommerce.entities.OrderEntity;
import org.example.ecommerce.entities.UserEntity;
import org.example.ecommerce.entities.enums.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersRes {
    private UUID id;
    private String name;
    private String email;
    private String tell;
    private List<OrderEntity> orders = new ArrayList<>();
    private Roles roles;

    public UsersRes(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.tell = user.getTell();
        this.orders = user.getOrders();
        this.roles = user.getRoles();
    }
}

package org.example.ecommerce.dto.users;

import lombok.*;
import org.example.ecommerce.entitys.enums.Roles;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersReq {
    private String name;
    private String email;
    private String tell;
    private String password;
    private Roles roles;
}

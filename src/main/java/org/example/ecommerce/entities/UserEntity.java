package org.example.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.dto.users.UsersReq;
import org.example.ecommerce.entities.enums.Roles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String email;
    private String tell;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany(mappedBy = "client")
    private List<OrderEntity> orders = new ArrayList<>();

    public UserEntity(UsersReq req) {
        this.name = req.getName();
        this.email = req.getEmail();
        this.tell = req.getTell();
        this.password = req.getPassword();
        this.roles = req.getRoles();
    }
}

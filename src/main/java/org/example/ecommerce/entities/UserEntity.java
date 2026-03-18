package org.example.ecommerce.entitys;

import jakarta.persistence.*;
import lombok.*;
import org.example.ecommerce.entitys.enums.Roles;

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

    public UserEntity(String name, String email, String password) {
    }
}

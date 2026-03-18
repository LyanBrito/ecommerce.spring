package org.example.ecommerce.services;

import org.example.ecommerce.dto.users.UsersReq;
import org.example.ecommerce.dto.users.UsersRes;
import org.example.ecommerce.entities.UserEntity;
import org.example.ecommerce.repositories.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public UsersRes showAll() {
        List<UserEntity> users = usersRepo.findAll();
        return (UsersRes) users.stream().map(UsersRes::new).toList();
    }

    public String newUser(UsersReq req) {
        UserEntity u = new UserEntity(req.getName(), req.getEmail(), req.getPassword());
        usersRepo.save(u);
        return "creado";
    }


}

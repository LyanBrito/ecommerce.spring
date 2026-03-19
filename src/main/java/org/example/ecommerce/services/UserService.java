package org.example.ecommerce.services;

import org.example.ecommerce.dto.users.UsersReq;
import org.example.ecommerce.dto.users.UsersRes;
import org.example.ecommerce.entities.UserEntity;
import org.example.ecommerce.repositories.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public String createNew(UsersReq req) {
        UserEntity u = new UserEntity(req.getName(), req.getEmail(), req.getPassword());
        usersRepo.save(u);
        return "creado";
    }

    public UsersRes showById(UUID id) {
        UserEntity user = usersRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UsersRes(user);
    }

    public String update(UUID id, UsersReq req) {
        UserEntity user = usersRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        usersRepo.save(user);
        return "Successfully Updated";
    }

    public String delete(UUID id){
        UserEntity user = usersRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        usersRepo.deleteById(id);
        return "Successfully Deleted";
    }
}

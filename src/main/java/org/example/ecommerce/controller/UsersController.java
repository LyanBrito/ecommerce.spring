package org.example.ecommerce.controller;

import jakarta.validation.Valid;
import org.example.ecommerce.dto.users.UsersReq;
import org.example.ecommerce.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/new")
    public ResponseEntity<?> createUser (@Valid @RequestBody UsersReq req) {
        return ResponseEntity.ok(userService.createNew(req));
    }
    @GetMapping("/show")
    public ResponseEntity<?> showAll() {
        return ResponseEntity.ok(userService.showAll());
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<?> showUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.showById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @Valid @RequestBody UsersReq req) {
        return ResponseEntity.ok(userService.update(id, req));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.delete(id));
    }

}

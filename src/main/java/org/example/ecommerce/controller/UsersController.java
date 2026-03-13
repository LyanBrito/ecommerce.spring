package org.example.ecommerce.controller;

import jakarta.validation.Valid;
import org.example.ecommerce.dto.users.UsersReq;
import org.example.ecommerce.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/new")
    public ResponseEntity<?> addUser (@Valid @RequestBody UsersReq req) {
        return ResponseEntity.ok(userService.newUser(req));
    }
}

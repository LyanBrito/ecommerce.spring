package org.example.ecommerce.controller;

import jakarta.validation.Valid;
import org.example.ecommerce.dto.orders.OrdersReq;
import org.example.ecommerce.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrdersReq req,@PathVariable UUID userId){
        return ResponseEntity.ok(orderService.create(req, userId));
    }
    @GetMapping("/show")
    public ResponseEntity<?> showAll() {
        return ResponseEntity.ok(orderService.showAll());
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<?> showById(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.showById(id));
    }
}

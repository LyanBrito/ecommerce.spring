package org.example.ecommerce.controller;

import jakarta.validation.Valid;
import org.example.ecommerce.dto.orders.OrdersReq;
import org.example.ecommerce.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrdersReq req,@PathVariable UUID userId){
        return ResponseEntity.ok(orderService.create(req, userId));
    }
}

package org.example.ecommerce.controller;

import jakarta.validation.Valid;
import org.example.ecommerce.dto.orderItens.OrderItemReq;
import org.example.ecommerce.services.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orderItens")
public class OrderItemController {
    public final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping("/create/{order_id, product_id}")
//    não sei se isso funciona não em
    public ResponseEntity<?> createOrderItem(@Valid @RequestBody OrderItemReq req, @PathVariable UUID order_id, @PathVariable UUID product_id) {
        return ResponseEntity.ok(orderItemService.create(req, product_id, order_id));
    }
    @GetMapping("/show/{order_id, product_id}")
    public ResponseEntity<?> showById(@PathVariable UUID order_id, @PathVariable UUID product_id){
        return ResponseEntity.ok(orderItemService.showById(product_id, order_id));
    }
}

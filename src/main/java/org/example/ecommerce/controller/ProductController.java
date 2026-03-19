package org.example.ecommerce.controller;

import jakarta.validation.Valid;
import org.example.ecommerce.dto.products.ProductsReq;
import org.example.ecommerce.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    public final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ProductsReq req){
        return ResponseEntity.ok(productService.create(req));
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<?> showById(@PathVariable UUID id){
        return ResponseEntity.ok(productService.showById(id));
    }
    @GetMapping("/show")
    public ResponseEntity<?> showALl(){
        return ResponseEntity.ok(productService.showAll());
    }
}

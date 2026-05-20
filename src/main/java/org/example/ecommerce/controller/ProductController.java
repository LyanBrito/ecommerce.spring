package org.example.ecommerce.controller;

import jakarta.validation.Valid;
import org.example.ecommerce.dto.products.ProductsReq;
import org.example.ecommerce.services.ProductImgsService;
import org.example.ecommerce.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    public final ProductService productService;
    public final ProductImgsService imageService;

    public ProductController(ProductService productService, ProductImgsService imageService) {
        this.productService = productService;
        this.imageService = imageService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ProductsReq req, @RequestParam MultipartFile imagePath) throws IOException {
        return ResponseEntity.ok(productService.create(req, imageService.savePhoto(imagePath)));
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

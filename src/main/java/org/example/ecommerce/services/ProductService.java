package org.example.ecommerce.services;

import org.example.ecommerce.dto.products.ProductsReq;
import org.example.ecommerce.dto.products.ProductsRes;
import org.example.ecommerce.entities.ProductEntity;
import org.example.ecommerce.repositories.ProductsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    public final ProductsRepo productsRepo;

    public ProductService(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    public String create(ProductsReq req) {
        ProductEntity product = new ProductEntity(req);
        productsRepo.save(product);

        return "New product created successfully!";
    }

    public ProductsRes showById(UUID id) {
        ProductEntity product = productsRepo.findById(id).orElseThrow(() -> new RuntimeException("deu ruim chefe"));
        // mudar essa logs depois em
        return new ProductsRes(product);
    }

    public List<ProductsRes> showAll() {
        List<ProductEntity> products = productsRepo.findAll();
        return products.stream().map(ProductsRes::new).toList();
    }
}

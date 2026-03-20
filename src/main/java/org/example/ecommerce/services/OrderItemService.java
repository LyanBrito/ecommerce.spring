package org.example.ecommerce.services;

import org.example.ecommerce.dto.orderItens.OrderItemReq;
import org.example.ecommerce.dto.orderItens.OrderItemRes;
import org.example.ecommerce.entities.OrderEntity;
import org.example.ecommerce.entities.OrderItem;
import org.example.ecommerce.entities.OrderItemPK;
import org.example.ecommerce.entities.ProductEntity;
import org.example.ecommerce.repositories.OrderItemRepo;
import org.example.ecommerce.repositories.OrdersRepo;
import org.example.ecommerce.repositories.ProductsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService {
    public final OrderItemRepo orderItemRepo;
    public final OrdersRepo ordersRepo;
    public final ProductsRepo productsRepo;

    public OrderItemService(OrderItemRepo orderItemRepo, OrdersRepo ordersRepo, ProductsRepo productsRepo) {
        this.orderItemRepo = orderItemRepo;
        this.ordersRepo = ordersRepo;
        this.productsRepo = productsRepo;
    }

    public OrderItemRes create(OrderItemReq req, UUID product_id, UUID order_id) {
        ProductEntity product = productsRepo.findById(product_id).orElseThrow(() -> new RuntimeException("Product not found"));
        OrderEntity order = ordersRepo.findById(order_id).orElseThrow(() -> new RuntimeException("Order not found"));
        OrderItem orderItem = new OrderItem(order, product, req);
        orderItemRepo.save(orderItem);
        return new OrderItemRes(orderItem);
    }

    public OrderItemRes showById(UUID product_id, UUID order_id) {
        OrderItemPK pk = new OrderItemPK();
        ProductEntity product = productsRepo.findById(product_id).orElseThrow(() -> new RuntimeException("Product not found"));
        OrderEntity order = ordersRepo.findById(order_id).orElseThrow(() -> new RuntimeException("Order not found"));
        pk.setOrderEntity(order);
        pk.setProduct(product);
        OrderItem orderItem = orderItemRepo.findById(pk).orElseThrow(() -> new RuntimeException("OrderItem not found"));

        return new OrderItemRes(orderItem);

    }

    public List<OrderItemRes> showAll() {
        List<OrderItem> orderItems = orderItemRepo.findAll();
        return orderItems.stream().map(OrderItemRes::new).toList();
    }
}

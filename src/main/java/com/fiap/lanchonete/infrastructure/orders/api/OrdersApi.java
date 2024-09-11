package com.fiap.lanchonete.infrastructure.orders.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderRequest;

@RequestMapping("/orders")
public interface OrdersApi {

    @GetMapping("")
    public List<Order> getAllOrders();

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable("id") UUID id);

    @PatchMapping("/{id}/state")
    public void updateOrderState(@PathVariable("id") UUID id, @RequestBody OrderState state);

    @PostMapping("/create")
    public void createOrder(@RequestBody OrderRequest order);
}

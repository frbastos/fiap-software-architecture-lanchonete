package com.fiap.lanchonete.infrastructure.adapters.orders.repository;

import com.fiap.lanchonete.infrastructure.adapters.orders.entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdersRepository extends JpaRepository<OrderEntity, UUID> {
}

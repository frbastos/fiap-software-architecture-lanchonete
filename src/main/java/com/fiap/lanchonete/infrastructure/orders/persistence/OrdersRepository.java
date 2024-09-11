package com.fiap.lanchonete.infrastructure.orders.persistence;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrderEntity, UUID> {
}

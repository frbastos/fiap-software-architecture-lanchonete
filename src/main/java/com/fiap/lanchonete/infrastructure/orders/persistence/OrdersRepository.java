package com.fiap.lanchonete.infrastructure.orders.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersRepository extends JpaRepository<OrderEntity, UUID> {

    @Query("SELECT o FROM OrderEntity o WHERE o.orderNumber = :orderNumber")
    Optional<OrderEntity> findByOrderNumber(@Param("orderNumber") Long orderNumber);
}

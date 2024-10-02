package com.fiap.lanchonete.infrastructure.orders.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrdersRepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT o FROM OrderEntity o WHERE o.orderNumber = :orderNumber")
    Optional<OrderEntity> findByOrderNumber(@Param("orderNumber") Long orderNumber);

    @Query(value = "SELECT * FROM ORDERS WHERE STATE <> 'FINISHED'", nativeQuery = true)
    List<OrderEntity> findAllOrderByDateCreation();
}

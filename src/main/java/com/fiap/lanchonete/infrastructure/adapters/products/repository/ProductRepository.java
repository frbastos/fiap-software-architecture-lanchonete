package com.fiap.lanchonete.infrastructure.adapters.products.repository;

import com.fiap.lanchonete.infrastructure.adapters.products.entidades.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
}

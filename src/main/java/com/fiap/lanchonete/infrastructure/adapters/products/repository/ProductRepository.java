package com.fiap.lanchonete.infrastructure.adapters.products.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.infrastructure.adapters.products.entidades.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    List<ProductEntity> findByCategory(Category category);
}

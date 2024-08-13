package com.fiap.lanchonete.infrastructure.adapters.products.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchonete.domain.products.models.Category;
import com.fiap.lanchonete.infrastructure.adapters.products.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    List<ProductEntity> findByCategory(Category category);
}

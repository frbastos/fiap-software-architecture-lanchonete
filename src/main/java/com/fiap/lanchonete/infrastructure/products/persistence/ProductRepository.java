package com.fiap.lanchonete.infrastructure.products.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchonete.domain.products.valueobjects.Category;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    List<ProductEntity> findByCategory(Category category);
}

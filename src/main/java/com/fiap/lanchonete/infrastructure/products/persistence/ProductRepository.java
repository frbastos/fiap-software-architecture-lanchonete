package com.fiap.lanchonete.infrastructure.products.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchonete.domain.products.valueobjects.Category;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByCategory(Category category);
}

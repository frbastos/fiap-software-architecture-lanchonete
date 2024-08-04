package com.fiap.lanchonete.domain.products.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductUpdate;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public interface ProductServicePort {

    Product save(ProductPersistence persistence);
    Product update(UUID id, ProductUpdate update);
    void remove(UUID id) throws NotFoundException;
    List<Product> getAll();
    Optional<Product> getById(UUID id);
    List<Product> getByCategory(Category category);
    List<Product> getAllByCategory(Category category);
}

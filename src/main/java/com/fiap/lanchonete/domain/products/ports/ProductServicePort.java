package com.fiap.lanchonete.domain.products.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductResponse;
import com.fiap.lanchonete.domain.products.dto.ProductUpdate;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public interface ProductServicePort {

    ProductResponse save(ProductPersistence persistence);
    ProductResponse update(UUID id, ProductUpdate update);
    void remove(UUID id) throws NotFoundException;
    List<ProductResponse> getAll();
    Optional<ProductResponse> getById(UUID id);
    List<ProductResponse> getByCategory(Category category);
    List<ProductResponse> getAllByCategory(Category category);
}

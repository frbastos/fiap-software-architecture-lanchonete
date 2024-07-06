package com.fiap.lanchonete.domain.products.ports;

import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductResponse;
import com.fiap.lanchonete.domain.products.dto.ProductUpdate;
import com.fiap.lanchonete.shared.exception.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductServicePort {

    void save(ProductPersistence persistence);
    void update(UUID id, ProductUpdate update);
    void remove(UUID id) throws NotFoundException;
    List<ProductResponse> getAll();
    Optional<Product> getById(UUID id);

}

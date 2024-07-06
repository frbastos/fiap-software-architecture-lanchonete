package com.fiap.lanchonete.domain.products.ports;

import com.fiap.lanchonete.domain.products.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {

        void save(Product product);
        void update(Product product);
        void remove(UUID id);
        List<Product> listAll();
        Optional<Product> getById(UUID id);
}

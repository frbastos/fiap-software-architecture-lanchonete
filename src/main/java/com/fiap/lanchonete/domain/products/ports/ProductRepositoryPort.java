package com.fiap.lanchonete.domain.products.ports;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;

public interface ProductRepositoryPort {

        Product save(Product product);
        void remove(UUID id);
        List<Product> listAll();
        Optional<Product> getById(UUID id);
        List<Product> getByCategory(Category category);
}

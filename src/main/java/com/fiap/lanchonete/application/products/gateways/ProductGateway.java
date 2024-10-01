package com.fiap.lanchonete.application.products.gateways;

import java.util.List;
import java.util.Optional;

import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.domain.products.valueobjects.Category;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public interface ProductGateway {

    List<Product> listAll();

    Optional<Product> getById(Long id) throws NotFoundException;

    List<Product> getByCategory(Category category);

    void remove(Long id);

    Product save(Product product);

}

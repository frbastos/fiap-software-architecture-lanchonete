package com.fiap.lanchonete.domain.products.services;

import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductResponse;
import com.fiap.lanchonete.domain.products.dto.ProductUpdate;
import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.domain.products.ports.ProductServicePort;
import com.fiap.lanchonete.shared.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductService implements ProductServicePort {

    private final ProductRepositoryPort productRepository;

    public ProductService(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductPersistence persistence) {
        Product product = new Product(persistence);
        this.productRepository.save(product);
    }

    @Override
    public void update(UUID id, ProductUpdate update) {
        Product product = this.getById(id).orElseThrow(NotFoundException::new);
        product.update(update);
        this.productRepository.save(product);
    }

    @Override
    public void remove(UUID id) throws NotFoundException {
        Product product = this.getById(id).orElseThrow(NotFoundException::new);
        this.productRepository.remove(product.getId());
    }

    @Override
    public List<ProductResponse> getAll() {
        return this.productRepository.listAll().stream().map(Product::toProdutcResponse).toList();
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return this.productRepository.getById(id);
    }
}

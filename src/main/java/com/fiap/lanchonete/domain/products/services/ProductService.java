package com.fiap.lanchonete.domain.products.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductUpdate;
import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.domain.products.ports.ProductServicePort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class ProductService implements ProductServicePort {

    private final ProductRepositoryPort productRepository;

    public ProductService(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(ProductPersistence persistence) {
        Product product = new Product(persistence);
        return this.productRepository.save(product);
    }

    @Override
    public Product update(UUID id, ProductUpdate update) {
        Product product = this.productRepository.getById(id).orElseThrow((NotFoundException::new));
        product.update(update);
       return this.productRepository.save(product);
    }

    @Override
    public void remove(UUID id) throws NotFoundException {
        Product product = this.productRepository.getById(id).orElseThrow((NotFoundException::new));
        this.productRepository.remove(product.getId());
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.listAll();
    }

    @Override
    public Optional<Product> getById(UUID id) throws NotFoundException{
        return Optional.of(this.productRepository.getById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return this.productRepository.getByCategory(category);
    }

    @Override
    public List<Product> getAllByCategory(Category category) {
        return this.productRepository.getByCategory(category);
    }
}

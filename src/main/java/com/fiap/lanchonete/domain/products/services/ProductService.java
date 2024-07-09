package com.fiap.lanchonete.domain.products.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.dto.ProductPersistence;
import com.fiap.lanchonete.domain.products.dto.ProductResponse;
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
    public ProductResponse save(ProductPersistence persistence) {
        Product product = new Product(persistence);
        product = this.productRepository.save(product);
        return product.toProdutcResponse();
    }

    @Override
    public ProductResponse update(UUID id, ProductUpdate update) {
        Product product = this.productRepository.getById(id).orElseThrow((NotFoundException::new));
        product.update(update);
        product = this.productRepository.save(product);
        return product.toProdutcResponse();
    }

    @Override
    public void remove(UUID id) throws NotFoundException {
        Product product = this.productRepository.getById(id).orElseThrow((NotFoundException::new));
        this.productRepository.remove(product.getId());
    }

    @Override
    public List<ProductResponse> getAll() {
        return this.productRepository.listAll().stream().map(Product::toProdutcResponse).toList();
    }

    @Override
    public Optional<ProductResponse> getById(UUID id) throws NotFoundException{
        return Optional.of(this.productRepository.getById(id).orElseThrow(NotFoundException::new).toProdutcResponse());
    }

    @Override
    public List<ProductResponse> getByCategory(Category category) {
        return this.productRepository.getByCategory(category).stream().map(Product::toProdutcResponse).toList();
    }

    @Override
    public List<ProductResponse> getAllByCategory(Category category) {
        return this.productRepository.getByCategory(category).stream().map(Product::toProdutcResponse).toList();
    }
}

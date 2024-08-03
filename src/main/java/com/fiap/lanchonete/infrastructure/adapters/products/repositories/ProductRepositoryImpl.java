package com.fiap.lanchonete.infrastructure.adapters.products.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.infrastructure.adapters.products.entities.ProductEntity;
import com.fiap.lanchonete.infrastructure.adapters.products.mappers.ProductMapper;

@Component
public class ProductRepositoryImpl implements ProductRepositoryPort {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductRepositoryImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = this.productMapper.toProductEntity(product);
        productEntity = this.productRepository.save(productEntity);
        return this.productMapper.toProduct(productEntity);
    }

    @Override
    public void remove(UUID id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> listAll() {
        return this.productMapper.toListProduct(this.productRepository.findAll());
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return this.productRepository.findById(id)
                .map(p -> this.productMapper.toProduct(p));
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return this.productMapper.toListProduct(this.productRepository.findByCategory(category));
    }

}

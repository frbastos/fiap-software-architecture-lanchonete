package com.fiap.lanchonete.infrastructure.adapters.products.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.products.Category;
import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.infrastructure.adapters.products.entidades.ProductEntity;

@Component
public class ProductRepositoryImpl implements ProductRepositoryPort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = new ProductEntity(product);
        productEntity =  this.productRepository.save(productEntity);
        return productEntity.toProduct();
    }

    @Override
    public void remove(UUID id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> listAll() {
        return this.productRepository.findAll().stream().map(ProductEntity::toProduct).toList();
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return this.productRepository.findById(id).map(ProductEntity::toProduct);
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return this.productRepository.findByCategory(category).stream().map(ProductEntity::toProduct).toList();
    }
}

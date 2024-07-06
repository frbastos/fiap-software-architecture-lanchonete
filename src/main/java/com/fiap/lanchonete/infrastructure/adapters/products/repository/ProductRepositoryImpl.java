package com.fiap.lanchonete.infrastructure.adapters.products.repository;

import com.fiap.lanchonete.domain.products.Product;
import com.fiap.lanchonete.domain.products.ports.ProductRepositoryPort;
import com.fiap.lanchonete.infrastructure.adapters.products.entidades.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductRepositoryImpl implements ProductRepositoryPort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product) {
        ProductEntity productEntity = new ProductEntity(product);
        this.productRepository.save(productEntity);
    }

    @Override
    public void update(Product product) {
        ProductEntity productEntity = new ProductEntity(product);
        this.productRepository.save(productEntity);
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
}

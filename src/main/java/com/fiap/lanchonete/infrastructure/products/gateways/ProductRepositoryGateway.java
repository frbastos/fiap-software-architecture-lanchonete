package com.fiap.lanchonete.infrastructure.products.gateways;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.domain.products.valueobjects.Category;
import com.fiap.lanchonete.infrastructure.products.persistence.ProductEntity;
import com.fiap.lanchonete.infrastructure.products.persistence.ProductRepository;

@Component
public class ProductRepositoryGateway implements ProductGateway {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    ProductRepositoryGateway(
            ProductRepository productRepository,
            ProductEntityMapper productEntityMapper) {

        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productEntityMapper.toProductEntity(product);
        productEntity = this.productRepository.save(productEntity);
        return productEntityMapper.toProduct(productEntity);
    }

    @Override
    public void remove(UUID id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> listAll() {
        List<ProductEntity> products = this.productRepository.findAll();
        return productEntityMapper.toListProduct(products);
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return this.productRepository.findById(id).map(entity -> productEntityMapper.toProduct(entity));
    }

    @Override
    public List<Product> getByCategory(Category category) {
        List<ProductEntity> byCategory = this.productRepository.findByCategory(category);
        return productEntityMapper.toListProduct(byCategory);
    }
}
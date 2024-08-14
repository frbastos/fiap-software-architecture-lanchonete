package com.fiap.lanchonete.infrastructure.adapters.products.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.products.models.Category;
import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.ports.out.GetAllProductsOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.GetProductByIdOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.GetProductsByCategoryOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.RemoveProductOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.SaveProductOutputPort;
import com.fiap.lanchonete.infrastructure.adapters.products.entity.ProductEntity;
import com.fiap.lanchonete.infrastructure.adapters.products.mappers.ProductMapper;

@Component
public class ProductRepositoryImpl implements GetAllProductsOutputPort, GetProductByIdOutputPort,
        GetProductsByCategoryOutputPort, RemoveProductOutputPort, SaveProductOutputPort {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        productEntity = this.productRepository.save(productEntity);
        return productMapper.toProduct(productEntity);
    }

    @Override
    public void remove(UUID id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> listAll() {
        List<ProductEntity> products = this.productRepository.findAll();
        return productMapper.toListProduct(products);
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return this.productRepository.findById(id).map(entity -> productMapper.toProduct(entity));
    }

    @Override
    public List<Product> getByCategory(Category category) {
        List<ProductEntity> byCategory = this.productRepository.findByCategory(category);
        return productMapper.toListProduct(byCategory);
    }
}

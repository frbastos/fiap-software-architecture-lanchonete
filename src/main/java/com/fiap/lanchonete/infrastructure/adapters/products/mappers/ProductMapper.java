package com.fiap.lanchonete.infrastructure.adapters.products.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.infrastructure.adapters.products.entity.ProductEntity;

@Component
public class ProductMapper {

    public ProductEntity toProductEntity(Product product) {
        return new ProductEntity(
                product.getId(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory());
    }

    public List<ProductEntity> toListProductEntity(List<Product> products) {
        return products
            .stream()
            .map(p -> this.toProductEntity(p))
            .toList();
    }

    public Product toProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getCategory());
    }

    public List<Product> toListProduct(List<ProductEntity> productsEntity) {
        return productsEntity
            .stream()
            .map(p -> this.toProduct(p))
            .toList();
    }

}

package com.fiap.lanchonete.infrastructure.products.api.dto;

import com.fiap.lanchonete.domain.products.entities.Product;

public class ProductDTOMapper {

    public Product toProduct(CreateProductRequest request){
        return new Product(null, request.description() , request.price(), request.category());
    }

    public ProductResponse toResponse(Product product){
        return new ProductResponse(product.getId(), product.getDescription(), product.getPrice(), product.getCategory());
    }
    
}

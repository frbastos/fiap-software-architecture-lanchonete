package com.fiap.lanchonete.application.products.usecases;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.domain.products.entities.Product;

public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductGateway productGateway;

    public CreateProductUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Product createProduct(Product product) {
        return this.productGateway.save(product);
    }

}

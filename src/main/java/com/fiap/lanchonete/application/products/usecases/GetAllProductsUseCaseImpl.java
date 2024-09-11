package com.fiap.lanchonete.application.products.usecases;

import java.util.List;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.domain.products.entities.Product;

public class GetAllProductsUseCaseImpl implements GetAllProductsUseCase  {

    private final ProductGateway productGateway;

    public GetAllProductsUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<Product> getAll() {
        return this.productGateway.listAll();
    }

}

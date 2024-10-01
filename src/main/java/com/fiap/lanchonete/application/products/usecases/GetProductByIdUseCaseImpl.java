package com.fiap.lanchonete.application.products.usecases;

import java.util.Optional;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class GetProductByIdUseCaseImpl implements GetProductByIdUseCase {

    private final ProductGateway productGateway;

    public GetProductByIdUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Optional<Product> getById(Long id) throws NotFoundException {
        return this.productGateway.getById(id);
    }

}

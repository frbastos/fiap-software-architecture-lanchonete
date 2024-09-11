package com.fiap.lanchonete.application.products.usecases;

import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class GetProductByIdUseCaseImpl implements GetProductByIdUseCase {

    private final ProductGateway productGateway;

    public GetProductByIdUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public Optional<Product> getById(UUID id) throws NotFoundException {
        return Optional.of(this.productGateway.getById(id).orElseThrow(NotFoundException::new));
    }

}

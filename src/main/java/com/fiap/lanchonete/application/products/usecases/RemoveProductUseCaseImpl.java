package com.fiap.lanchonete.application.products.usecases;

import java.util.UUID;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class RemoveProductUseCaseImpl implements RemoveProductUseCase {

    private final ProductGateway productGateway;

    public RemoveProductUseCaseImpl( ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public void remove(UUID id) {
        Product product = productGateway.getById(id).orElseThrow((NotFoundException::new));
        productGateway.remove(product.getId());
    }

}

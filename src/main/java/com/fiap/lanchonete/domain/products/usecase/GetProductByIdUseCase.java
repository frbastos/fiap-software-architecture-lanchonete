package com.fiap.lanchonete.domain.products.usecase;

import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.ports.in.GetProductByIdInputPort;
import com.fiap.lanchonete.domain.products.ports.out.GetProductByIdOutputPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class GetProductByIdUseCase implements GetProductByIdInputPort {

    private final GetProductByIdOutputPort getProductByIdOutputPort;

    public GetProductByIdUseCase(GetProductByIdOutputPort getProductByIdOutputPort) {
        this.getProductByIdOutputPort = getProductByIdOutputPort;
    }

    @Override
    public Optional<Product> getById(UUID id) throws NotFoundException {
        return Optional.of(this.getProductByIdOutputPort.getById(id).orElseThrow(NotFoundException::new));
    }

}

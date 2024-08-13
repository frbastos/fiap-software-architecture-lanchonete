package com.fiap.lanchonete.domain.products.ports.in;

import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public interface GetProductByIdInputPort {

    public Optional<Product> getById(UUID id) throws NotFoundException;

}

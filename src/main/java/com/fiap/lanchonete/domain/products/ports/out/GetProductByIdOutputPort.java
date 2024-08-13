package com.fiap.lanchonete.domain.products.ports.out;

import java.util.Optional;
import java.util.UUID;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public interface GetProductByIdOutputPort {

    public Optional<Product> getById(UUID id) throws NotFoundException;

}

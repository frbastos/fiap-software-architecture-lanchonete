package com.fiap.lanchonete.application.products.usecases;

import java.util.Optional;

import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public interface GetProductByIdUseCase {

    Optional<Product> getById(Long id) throws NotFoundException;

}

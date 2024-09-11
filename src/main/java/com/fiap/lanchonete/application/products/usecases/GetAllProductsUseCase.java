package com.fiap.lanchonete.application.products.usecases;

import java.util.List;

import com.fiap.lanchonete.domain.products.entities.Product;

public interface GetAllProductsUseCase {

    List<Product> getAll();

}

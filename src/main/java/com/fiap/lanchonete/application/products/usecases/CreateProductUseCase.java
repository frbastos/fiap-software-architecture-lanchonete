package com.fiap.lanchonete.application.products.usecases;

import com.fiap.lanchonete.domain.products.entities.Product;

public interface CreateProductUseCase {

    Product createProduct(Product persistence);

}

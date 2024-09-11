package com.fiap.lanchonete.application.products.usecases;

import com.fiap.lanchonete.application.products.usecases.commands.UpdateProductCommand;
import com.fiap.lanchonete.domain.products.entities.Product;

public interface UpdateProductUseCase {

    Product update(UpdateProductCommand update);

}

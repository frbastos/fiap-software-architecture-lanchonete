package com.fiap.lanchonete.application.products.usecases;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.application.products.usecases.commands.UpdateProductCommand;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase{

   private final ProductGateway productGateway;

    public UpdateProductUseCaseImpl(ProductGateway productGateway) {
       this.productGateway = productGateway;
    }

    @Override
    public Product update(UpdateProductCommand update) {
        Product product = this.productGateway.getById(update.id()).orElseThrow((NotFoundException::new));
        product.update(update);
        return this.productGateway.save(product);
    }

}

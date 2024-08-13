package com.fiap.lanchonete.domain.products.usecase;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.models.ProductPersistence;
import com.fiap.lanchonete.domain.products.ports.in.CreateProductInputPort;
import com.fiap.lanchonete.domain.products.ports.out.SaveProductOutputPort;

public class CreateProductUseCase implements CreateProductInputPort {

    private final SaveProductOutputPort saveProductOutputPort;

    public CreateProductUseCase(SaveProductOutputPort saveProductOutputPort) {
        this.saveProductOutputPort = saveProductOutputPort;
    }

    @Override
    public Product createProduct(ProductPersistence persistence) {
        Product product = new Product(persistence);
        return this.saveProductOutputPort.save(product);
    }

}

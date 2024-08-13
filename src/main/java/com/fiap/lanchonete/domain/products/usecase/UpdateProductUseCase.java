package com.fiap.lanchonete.domain.products.usecase;

import java.util.UUID;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.models.ProductUpdate;
import com.fiap.lanchonete.domain.products.ports.in.UpdateProductInputPort;
import com.fiap.lanchonete.domain.products.ports.out.GetProductByIdOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.SaveProductOutputPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class UpdateProductUseCase implements UpdateProductInputPort {

    private final GetProductByIdOutputPort getProductByIdOutputPort;
    private final SaveProductOutputPort saveProductOutputPort;

    public UpdateProductUseCase(GetProductByIdOutputPort getProductByIdOutputPort,
            SaveProductOutputPort saveProductOutputPort) {
        this.getProductByIdOutputPort = getProductByIdOutputPort;
        this.saveProductOutputPort = saveProductOutputPort;
    }

    @Override
    public Product update(UUID id, ProductUpdate update) {
        Product product = this.getProductByIdOutputPort.getById(id).orElseThrow((NotFoundException::new));
        product.update(update);
        return this.saveProductOutputPort.save(product);
    }

}

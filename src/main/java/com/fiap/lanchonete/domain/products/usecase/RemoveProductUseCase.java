package com.fiap.lanchonete.domain.products.usecase;

import java.util.UUID;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.ports.in.RemoveProductInputPort;
import com.fiap.lanchonete.domain.products.ports.out.GetProductByIdOutputPort;
import com.fiap.lanchonete.domain.products.ports.out.RemoveProductOutputPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

public class RemoveProductUseCase implements RemoveProductInputPort {

    private final RemoveProductOutputPort removeProductInputPort;
    private final GetProductByIdOutputPort getProductByIdOutputPort;

    public RemoveProductUseCase(RemoveProductOutputPort removeProductInputPort,
    GetProductByIdOutputPort getProductByIdOutputPort) {
        this.removeProductInputPort = removeProductInputPort;
        this.getProductByIdOutputPort = getProductByIdOutputPort;
    }

    @Override
    public void remove(UUID id) {
        Product product = this.getProductByIdOutputPort.getById(id).orElseThrow((NotFoundException::new));
        this.removeProductInputPort.remove(product.getId());
    }

}

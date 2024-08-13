package com.fiap.lanchonete.domain.products.usecase;

import java.util.List;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.ports.in.GetAllProductsInputPort;
import com.fiap.lanchonete.domain.products.ports.out.GetAllProductsOutputPort;

public class GetAllProductsUseCase implements GetAllProductsInputPort  {

    private final GetAllProductsOutputPort getAllProductsOutputPort;

    public GetAllProductsUseCase(GetAllProductsOutputPort getAllProductsOutputPort) {
        this.getAllProductsOutputPort = getAllProductsOutputPort;
    }

    @Override
    public List<Product> getAll() {
        return this.getAllProductsOutputPort.listAll();
    }

}

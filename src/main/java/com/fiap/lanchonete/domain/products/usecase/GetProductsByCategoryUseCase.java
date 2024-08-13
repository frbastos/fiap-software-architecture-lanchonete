package com.fiap.lanchonete.domain.products.usecase;

import java.util.List;

import com.fiap.lanchonete.domain.products.models.Category;
import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.ports.in.GetProductsByCategoryInputPort;
import com.fiap.lanchonete.domain.products.ports.out.GetProductsByCategoryOutputPort;

public class GetProductsByCategoryUseCase implements GetProductsByCategoryInputPort {

    private final GetProductsByCategoryOutputPort getProductsByCategoryOutputPort;

    public GetProductsByCategoryUseCase(GetProductsByCategoryOutputPort getProductsByCategoryOutputPort) {
        this.getProductsByCategoryOutputPort = getProductsByCategoryOutputPort;
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return this.getProductsByCategoryOutputPort.getByCategory(category);

    }

}

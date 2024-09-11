package com.fiap.lanchonete.application.products.usecases;

import java.util.List;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.domain.products.entities.Product;
import com.fiap.lanchonete.domain.products.valueobjects.Category;

public class GetProductsByCategoryUseCaseImpl implements GetProductsByCategoryUseCase {

    private final ProductGateway productGateway;

    public GetProductsByCategoryUseCaseImpl(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return this.productGateway.getByCategory(category);
    }

}

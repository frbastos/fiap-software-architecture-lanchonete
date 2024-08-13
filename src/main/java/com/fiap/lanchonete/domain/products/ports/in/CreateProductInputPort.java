package com.fiap.lanchonete.domain.products.ports.in;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.models.ProductPersistence;

public interface CreateProductInputPort {
    
    Product createProduct(ProductPersistence persistence);
}

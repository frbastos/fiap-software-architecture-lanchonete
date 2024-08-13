package com.fiap.lanchonete.domain.products.ports.in;

import java.util.List;

import com.fiap.lanchonete.domain.products.models.Product;

public interface GetAllProductsInputPort {

    List<Product> getAll();

}

package com.fiap.lanchonete.domain.products.ports.in;

import java.util.UUID;

import com.fiap.lanchonete.domain.products.models.Product;
import com.fiap.lanchonete.domain.products.models.ProductUpdate;

public interface UpdateProductInputPort {

    Product update(UUID id, ProductUpdate update);

}

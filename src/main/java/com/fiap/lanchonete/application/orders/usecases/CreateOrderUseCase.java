package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderRequest;

public interface CreateOrderUseCase {

    void createOrder(OrderRequest persistence);

}

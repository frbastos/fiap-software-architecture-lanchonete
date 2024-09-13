package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderRequest;

public interface CreateOrderUseCase {

    Order createOrder(OrderRequest persistence);

}

package com.fiap.lanchonete.domain.orders.ports.in;

import com.fiap.lanchonete.domain.orders.models.OrderPersistence;

public interface CreateOrderInputPort {

    void createOrder(OrderPersistence persistence);

}

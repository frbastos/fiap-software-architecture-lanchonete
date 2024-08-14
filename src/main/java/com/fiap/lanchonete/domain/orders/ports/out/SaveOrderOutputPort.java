package com.fiap.lanchonete.domain.orders.ports.out;

import com.fiap.lanchonete.domain.orders.models.Order;

public interface SaveOrderOutputPort {

    Order save(Order order);

    Order saveAndFlush(Order order);

}

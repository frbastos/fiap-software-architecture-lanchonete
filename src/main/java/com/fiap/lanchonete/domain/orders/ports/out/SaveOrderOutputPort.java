package com.fiap.lanchonete.domain.orders.ports.out;

import com.fiap.lanchonete.domain.orders.models.Order;

public interface SaveOrderOutputPort {

    void save(Order order);

}

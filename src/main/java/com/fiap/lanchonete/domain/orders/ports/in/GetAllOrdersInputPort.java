package com.fiap.lanchonete.domain.orders.ports.in;

import com.fiap.lanchonete.domain.orders.models.Order;

import java.util.List;

public interface GetAllOrdersInputPort {

    List<Order> getAll();

}

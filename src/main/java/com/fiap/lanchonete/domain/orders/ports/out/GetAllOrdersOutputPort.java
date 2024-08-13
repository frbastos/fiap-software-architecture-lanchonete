package com.fiap.lanchonete.domain.orders.ports.out;

import com.fiap.lanchonete.domain.orders.models.Order;

import java.util.List;

public interface GetAllOrdersOutputPort {

    List<Order> getAll();

}

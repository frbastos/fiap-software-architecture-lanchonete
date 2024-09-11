package com.fiap.lanchonete.application.orders.usecases;

import java.util.List;

import com.fiap.lanchonete.domain.orders.entities.Order;

public interface GetAllOrdersUseCase {

    List<Order> getAll();

}

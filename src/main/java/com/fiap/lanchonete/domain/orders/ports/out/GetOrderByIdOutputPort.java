package com.fiap.lanchonete.domain.orders.ports.out;

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.shared.exception.NotFoundException;

import java.util.Optional;
import java.util.UUID;

public interface GetOrderByIdOutputPort {

    Optional<Order> getById(UUID id) throws NotFoundException;

}

package com.fiap.lanchonete.domain.orders.ports.in;

import com.fiap.lanchonete.domain.orders.models.OrderState;

import java.util.UUID;

public interface UpdateOrderStateInputPort {

    void updateState(UUID id, OrderState state);

}

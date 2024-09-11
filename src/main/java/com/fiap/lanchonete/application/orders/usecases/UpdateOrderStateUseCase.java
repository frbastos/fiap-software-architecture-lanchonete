package com.fiap.lanchonete.application.orders.usecases;

import java.util.UUID;

import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;

public interface UpdateOrderStateUseCase {

    void updateState(UUID id, OrderState state);

}

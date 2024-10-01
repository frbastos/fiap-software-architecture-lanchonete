package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;

public interface UpdateOrderStateUseCase {

    void updateState(Long id, OrderState state);

}

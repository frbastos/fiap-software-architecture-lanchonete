package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;

public interface UpdateOrderStateUseCase {

    Order updateState(Long id, OrderState state);

}

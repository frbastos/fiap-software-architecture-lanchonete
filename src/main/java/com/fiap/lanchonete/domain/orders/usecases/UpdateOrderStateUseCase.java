package com.fiap.lanchonete.domain.orders.usecases;

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.models.OrderState;
import com.fiap.lanchonete.domain.orders.ports.in.UpdateOrderStateInputPort;
import com.fiap.lanchonete.domain.orders.ports.out.GetOrderByIdOutputPort;
import com.fiap.lanchonete.domain.orders.ports.out.SaveOrderOutputPort;
import com.fiap.lanchonete.shared.exception.NotFoundException;

import java.util.UUID;

public class UpdateOrderStateUseCase implements UpdateOrderStateInputPort {

    private final GetOrderByIdOutputPort getOrdersByIdRepository;
    private final SaveOrderOutputPort saveOrderOutputPort;

    public UpdateOrderStateUseCase(GetOrderByIdOutputPort getOrdersByIdRepository, SaveOrderOutputPort saveOrderOutputPort) {
        this.getOrdersByIdRepository = getOrdersByIdRepository;
        this.saveOrderOutputPort = saveOrderOutputPort;
    }

    @Override
    public void updateState(UUID id, OrderState state) {
        Order order = this.getOrdersByIdRepository.getById(id).orElseThrow((NotFoundException::new));

        order.updateState(state);

        this.saveOrderOutputPort.save(order);
    }

}

package com.fiap.lanchonete.infrastructure.orders.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.application.orders.usecases.CreateOrderUseCase;
import com.fiap.lanchonete.application.orders.usecases.GetAllOrdersUseCase;
import com.fiap.lanchonete.application.orders.usecases.GetOrderByIdUseCase;
import com.fiap.lanchonete.application.orders.usecases.UpdateOrderStateUseCase;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderRequest;

@RestController
@RequestMapping("/orders")
public class OrdersController implements OrdersApi {

    private final GetAllOrdersUseCase getAllOrdersInputPort;
    private final GetOrderByIdUseCase getOrderByIdInputPort;
    private final UpdateOrderStateUseCase updateOrderStateInputPort;

    private final CreateOrderUseCase createOrderInputPort;

    public OrdersController(
            GetAllOrdersUseCase getAllOrdersInputPort,
            GetOrderByIdUseCase getOrderByIdInputPort,
            UpdateOrderStateUseCase updateOrderStateInputPort,
            CreateOrderUseCase createOrderInputPort) {

        this.getAllOrdersInputPort = getAllOrdersInputPort;
        this.getOrderByIdInputPort = getOrderByIdInputPort;
        this.updateOrderStateInputPort = updateOrderStateInputPort;
        this.createOrderInputPort = createOrderInputPort;
    }

    @Override
    public List<Order> getAllOrders() {
        return this.getAllOrdersInputPort.getAll();
    }

    @Override
    public Optional<Order> getOrderById(UUID id) {
        return this.getOrderByIdInputPort.getOrderById(id);
    }

    @Override
    public void updateOrderState(UUID id, OrderState state) {
        this.updateOrderStateInputPort.updateState(id, state);
    }

    @Override
    public void createOrder(OrderRequest order) {
        this.createOrderInputPort.createOrder(order);
    }
}

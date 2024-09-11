package com.fiap.lanchonete.infrastructure.orders.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class OrdersController {

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

    @GetMapping("")
    public List<Order> getAllOrders() {
        return this.getAllOrdersInputPort.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable("id") UUID id) {
        return this.getOrderByIdInputPort.getOrderById(id);
    }

    @PatchMapping("/{id}/state")
    public void updateOrderState(@PathVariable("id") UUID id, @RequestBody OrderState state) {
        this.updateOrderStateInputPort.updateState(id, state);
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody OrderRequest order) {
        this.createOrderInputPort.createOrder(order);
    }
}

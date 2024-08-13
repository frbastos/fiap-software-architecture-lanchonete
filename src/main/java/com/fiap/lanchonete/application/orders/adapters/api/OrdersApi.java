package com.fiap.lanchonete.application.orders.adapters.api;

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.models.OrderState;
import com.fiap.lanchonete.domain.orders.ports.in.GetAllOrdersInputPort;
import com.fiap.lanchonete.domain.orders.ports.in.GetOrderByIdInputPort;
import com.fiap.lanchonete.domain.orders.ports.in.UpdateOrderStateInputPort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrdersApi {

    private final GetAllOrdersInputPort getAllOrdersInputPort;
    private final GetOrderByIdInputPort getOrderByIdInputPort;
    private final UpdateOrderStateInputPort updateOrderStateInputPort;

    public OrdersApi(
            GetAllOrdersInputPort getAllOrdersInputPort,
            GetOrderByIdInputPort getOrderByIdInputPort,
            UpdateOrderStateInputPort updateOrderStateInputPort
    ) {
        this.getAllOrdersInputPort = getAllOrdersInputPort;
        this.getOrderByIdInputPort = getOrderByIdInputPort;
        this.updateOrderStateInputPort = updateOrderStateInputPort;
    }

    @GetMapping("")
    public List<Order> getAllOrders() {
        return this.getAllOrdersInputPort.getAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable("id") UUID id) {
        return this.getOrderByIdInputPort.getOrderById(id);
    }

    @PatchMapping("/{id}/state")
    public void updateOrderState(@PathVariable("id") UUID id, @RequestBody OrderState state) {
        this.updateOrderStateInputPort.updateState(id, state);
    }

}

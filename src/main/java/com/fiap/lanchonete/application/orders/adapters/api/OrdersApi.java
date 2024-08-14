package com.fiap.lanchonete.application.orders.adapters.api;

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

import com.fiap.lanchonete.domain.orders.models.Order;
import com.fiap.lanchonete.domain.orders.models.OrderPersistence;
import com.fiap.lanchonete.domain.orders.models.OrderState;
import com.fiap.lanchonete.domain.orders.ports.in.CreateOrderInputPort;
import com.fiap.lanchonete.domain.orders.ports.in.GetAllOrdersInputPort;
import com.fiap.lanchonete.domain.orders.ports.in.GetOrderByIdInputPort;
import com.fiap.lanchonete.domain.orders.ports.in.UpdateOrderStateInputPort;

@RestController
@RequestMapping("/orders")
public class OrdersApi {

    private final GetAllOrdersInputPort getAllOrdersInputPort;
    private final GetOrderByIdInputPort getOrderByIdInputPort;
    private final UpdateOrderStateInputPort updateOrderStateInputPort;

    private final CreateOrderInputPort createOrderInputPort;

    public OrdersApi(
            GetAllOrdersInputPort getAllOrdersInputPort,
            GetOrderByIdInputPort getOrderByIdInputPort,
            UpdateOrderStateInputPort updateOrderStateInputPort,
            CreateOrderInputPort createOrderInputPort
    ) {
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
    public void createOrder(@RequestBody OrderPersistence order){
        this.createOrderInputPort.createOrder(order);
    }
}

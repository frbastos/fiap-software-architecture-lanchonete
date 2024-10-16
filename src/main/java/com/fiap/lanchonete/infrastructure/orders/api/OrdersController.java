package com.fiap.lanchonete.infrastructure.orders.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchonete.application.orders.usecases.CreateOrderUseCase;
import com.fiap.lanchonete.application.orders.usecases.GetAllOrdersUseCase;
import com.fiap.lanchonete.application.orders.usecases.GetOrderByIdUseCase;
import com.fiap.lanchonete.application.orders.usecases.GetOrderByOrderNumberUseCase;
import com.fiap.lanchonete.application.orders.usecases.UpdateOrderStateUseCase;
import com.fiap.lanchonete.application.payment.usecases.SendQRCODEPaymentToThirdPartyUseCase;
import com.fiap.lanchonete.application.payment.usecases.command.SendPaymentCommand;
import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderCommandMapper;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderCreateResponse;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderDTOMapper;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderFollowUp;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderGroupedMapper;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderGroupedResponse;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderRequest;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderResponse;
import com.fiap.lanchonete.infrastructure.orders.api.dto.OrderStatusPaymentResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final GetAllOrdersUseCase getAllOrdersUseCase;
    private final GetOrderByIdUseCase getOrderByIdUseCase;
    private final UpdateOrderStateUseCase updateOrderStateInputPort;
    private final CreateOrderUseCase createOrderInputPort;
    private final SendQRCODEPaymentToThirdPartyUseCase sendQRCODEPaymentToThirdPartyUseCase;
    private final OrderCommandMapper orderCommandMapper;
    private final OrderDTOMapper orderDTOMapper;
    private final GetOrderByOrderNumberUseCase getOrderByOrderNumberUseCase;

    private final OrderGroupedMapper orderGroupedMapper;

    public OrdersController(
            GetAllOrdersUseCase getAllOrdersUseCase,
            GetOrderByIdUseCase getOrderByIdUseCase,
            UpdateOrderStateUseCase updateOrderStateInputPort,
            CreateOrderUseCase createOrderInputPort,
            SendQRCODEPaymentToThirdPartyUseCase sendQRCODEPaymentToThirdPartyUseCase,
            OrderCommandMapper orderCommandMapper,
            OrderDTOMapper orderDTOMapper,
            GetOrderByOrderNumberUseCase getOrderByOrderNumberUseCase, OrderGroupedMapper orderGroupedMapper) {

        this.getAllOrdersUseCase = getAllOrdersUseCase;
        this.getOrderByIdUseCase = getOrderByIdUseCase;
        this.updateOrderStateInputPort = updateOrderStateInputPort;
        this.createOrderInputPort = createOrderInputPort;
        this.sendQRCODEPaymentToThirdPartyUseCase = sendQRCODEPaymentToThirdPartyUseCase;
        this.orderCommandMapper = orderCommandMapper;
        this.orderDTOMapper = orderDTOMapper;
        this.getOrderByOrderNumberUseCase = getOrderByOrderNumberUseCase;
        this.orderGroupedMapper = orderGroupedMapper;
    }

    private List<OrderResponse> mapToResponse(List<Order> orders) {
        return orders.stream().map((o) -> mapToResponse(o)).toList();
    }

    private OrderResponse mapToResponse(Order order) {
        return orderDTOMapper.toOrderResponse(order);
    }

    private List<OrderFollowUp> matToOrderFollowUp(List<Order> orders){
        return orders.stream().map(this::matToOrderFollowUp).toList();
    }

    private OrderFollowUp matToOrderFollowUp ( Order order){
        return orderGroupedMapper.toOrderFollowUp(order);
    }

    @GetMapping("")
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = getAllOrdersUseCase.getAll();
        return mapToResponse(orders);
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable("id") Long id) {
        return mapToResponse(this.getOrderByIdUseCase.getOrderById(id).get());
    }

    @PatchMapping("/{orderNumber}/state")
    public OrderResponse updateOrderState(
        @PathVariable("orderNumber") Long orderNumber, 
        @RequestParam(value = "updateState", required = true) OrderState state) {
        Order updateState = this.updateOrderStateInputPort.updateState(orderNumber, state);
        return mapToResponse(updateState);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderCreateResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        Order orderCreated = this.createOrderInputPort.createOrder(orderRequest);
        try {
            SendPaymentCommand sendPaymentQRCODECommand = orderCommandMapper.toSendPaymentQRCODECommand(orderCreated);
            sendQRCODEPaymentToThirdPartyUseCase.send(sendPaymentQRCODECommand);
        } catch (Exception e) {
            log.error("Error sending payment for order: " + orderCreated.getId(), e);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new OrderCreateResponse(orderCreated.getOrderNumber()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new OrderCreateResponse(orderCreated.getOrderNumber()));
    }

    @GetMapping("/statePayment/{orderNumber}")
    public ResponseEntity<OrderStatusPaymentResponse> findStatusPayment(@PathVariable Long orderNumber) {
        Order orderPaymentStatus = this.getOrderByOrderNumberUseCase.findOrderByOrderNumber(orderNumber).get();
        return ResponseEntity.status(HttpStatus.OK).body(new OrderStatusPaymentResponse(orderPaymentStatus.getOrderNumber(), orderPaymentStatus.getPaymentConfirmationStatus()));
    }

    @GetMapping("/follow-up")
    public ResponseEntity<OrderGroupedResponse> findFollowUp(){
        List<Order> orders = this.getAllOrdersUseCase.getAllOrderDesc();
        return ResponseEntity.status(HttpStatus.OK).body(orderGroupedMapper.getGropedOrders(orders));
    }
}

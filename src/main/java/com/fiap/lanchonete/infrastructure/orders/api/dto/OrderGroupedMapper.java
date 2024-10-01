package com.fiap.lanchonete.infrastructure.orders.api.dto;

import com.fiap.lanchonete.domain.orders.entities.Order;
import com.fiap.lanchonete.domain.orders.valueobjects.OrderState;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderGroupedMapper {

    public OrderGroupedResponse getGropedOrders(List<Order> orders){
        List<OrderFollowUp> orderFollowUps = orders.stream().map(this::toOrderFollowUp).toList();

        List<OrderFollowUp> readyOrders =
                orderFollowUps
                        .stream()
                        .filter(order -> OrderState.READY.toString().equals(order.status()))
                        .sorted(Comparator.comparing(OrderFollowUp::dateCreation)).toList();

        List<OrderFollowUp> preparingOrders =
                orderFollowUps
                        .stream()
                        .filter(order -> OrderState.PREPARING.toString().equals(order.status()))
                        .sorted(Comparator.comparing(OrderFollowUp::dateCreation)).toList();

        List<OrderFollowUp> receivedOrders =
                orderFollowUps
                        .stream()
                        .filter(order -> OrderState.RECEIVED.toString().equals(order.status()))
                        .sorted(Comparator.comparing(OrderFollowUp::dateCreation)).toList();

        return new OrderGroupedResponse(readyOrders, preparingOrders, receivedOrders);
    }

    public OrderFollowUp toOrderFollowUp(Order order){
        return new OrderFollowUp(order.getOrderNumber(),order.getState().toString(), order.getCreationTime().toString());
    }
}

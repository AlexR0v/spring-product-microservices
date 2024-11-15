package ru.alexrov.order.mapper;

import org.springframework.stereotype.Component;
import ru.alexrov.order.dto.OrderDtoReq;
import ru.alexrov.order.dto.OrderDtoRes;
import ru.alexrov.order.model.Order;

import java.util.UUID;

@Component
public class OrderMapper {

    public Order toOrder(OrderDtoReq orderDtoReq) {
        return Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .scuCode(orderDtoReq.getScuCode())
                .price(orderDtoReq.getPrice())
                .quantity(orderDtoReq.getQuantity())
                .build();
    }

    public OrderDtoRes toOrderRes(Order order) {
        return OrderDtoRes.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .scuCode(order.getScuCode())
                .price(order.getPrice())
                .quantity(order.getQuantity())
                .build();
    }
}

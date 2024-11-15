package ru.alexrov.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexrov.order.client.InventoryClient;
import ru.alexrov.order.dto.OrderDtoReq;
import ru.alexrov.order.dto.OrderDtoRes;
import ru.alexrov.order.mapper.OrderMapper;
import ru.alexrov.order.model.Order;
import ru.alexrov.order.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryClient inventoryClient;

    public OrderDtoRes placeOrder(OrderDtoReq orderDtoReq) {
        boolean isProductInStock = this.inventoryClient.isInStock(orderDtoReq.getScuCode(), orderDtoReq.getQuantity());
        if(isProductInStock){
            this.inventoryClient.changeQuantity(orderDtoReq.getScuCode(), orderDtoReq.getQuantity());
            Order order = this.orderMapper.toOrder(orderDtoReq);
            return this.orderMapper.toOrderRes(this.orderRepository.save(order));
        } else {
            throw new RuntimeException("Продукта нет на складе");
        }
    }

    public List<OrderDtoRes> getOrders() {
        return this.orderRepository.findAll().stream().map(this.orderMapper::toOrderRes).toList();
    }
};

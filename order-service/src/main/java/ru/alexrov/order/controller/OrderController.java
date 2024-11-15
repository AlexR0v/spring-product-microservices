package ru.alexrov.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexrov.order.dto.OrderDtoReq;
import ru.alexrov.order.dto.OrderDtoRes;
import ru.alexrov.order.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDtoRes>> getOrders() {
        return ResponseEntity.ok(this.orderService.getOrders());
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDtoRes> placeOrder(@RequestBody OrderDtoReq orderDtoReq) {
        return ResponseEntity.ok(this.orderService.placeOrder(orderDtoReq));
    }

}

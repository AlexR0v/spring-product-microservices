package ru.alexrov.order.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class OrderDtoRes {
    UUID id;
    String orderNumber;
    String scuCode;
    BigDecimal price;
    Integer quantity;
}
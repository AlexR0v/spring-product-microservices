package ru.alexrov.order.dto;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderDtoReq {
    String scuCode;
    BigDecimal price;
    Integer quantity;
}
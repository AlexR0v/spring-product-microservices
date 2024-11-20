package ru.alexrov.order.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDtoReq {
    String scuCode;
    BigDecimal price;
    Integer quantity;
    UserDetails userDetails;

    @Data
    public class UserDetails {

        String email;
        String firstName;
        String lastName;
    }
}
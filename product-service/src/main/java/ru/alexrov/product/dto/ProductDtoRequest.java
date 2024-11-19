package ru.alexrov.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDtoRequest {

    private String name;
    private String description;
    private String scuCode;
    private BigDecimal price;
}
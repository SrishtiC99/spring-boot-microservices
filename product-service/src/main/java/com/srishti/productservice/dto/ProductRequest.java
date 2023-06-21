package com.srishti.productservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String name;

    private String description;

    private BigDecimal price;
}

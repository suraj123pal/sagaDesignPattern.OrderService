package com.example.productservice.command.api.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class ProductRestTemplate {

    private String name;
    private BigDecimal price;
    private Integer quantity;
}
package com.freecodecamp.spring_boot_jpa.dtos;

import lombok.Data;

@Data
public class OrderDto {
    private String customerName;

    private String productName;

    private Integer quantity;
}

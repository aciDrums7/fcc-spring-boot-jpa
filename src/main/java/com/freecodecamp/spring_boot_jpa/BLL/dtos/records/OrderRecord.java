package com.freecodecamp.spring_boot_jpa.BLL.dtos.records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRecord(
        @JsonProperty("cName") String customerName,

        String productName,

        Integer quantity) {

}

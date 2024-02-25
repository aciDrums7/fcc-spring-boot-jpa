package com.freecodecamp.spring_boot_jpa.students;

import lombok.Builder;

@Builder
public record StudentResponseDto(
    String firstname,
    String lastname,
    String email,
    Integer age
) {}

package com.freecodecamp.springBootJpa.students;

import lombok.Builder;

@Builder
public record StudentResponseDto(
    String firstname,
    String lastname,
    String email,
    Integer age
) {}

package com.freecodecamp.spring_boot_jpa.students;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record StudentRequestDto(
    @NotBlank(message = "Firstname must not be empty or null") String firstname,
    @NotBlank(message = "Lastname must not be empty or null") String lastname,
    @NotBlank(message = "Email must not be empty or null") @Email String email,
    @NotNull(message = "Age must not be null") @Min(value = 3) Integer age,
    Long schoolId
) {}

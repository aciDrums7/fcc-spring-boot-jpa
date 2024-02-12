package com.freecodecamp.springBootJpa.BLL.dtos.students;

public record StudentRequestDto(String firstname, String lastname, String email, Integer age, Integer schoolId) {

}

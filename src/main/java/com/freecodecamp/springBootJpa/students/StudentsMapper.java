package com.freecodecamp.springBootJpa.students;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentsMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentProfile", ignore = true)
    @Mapping(target = "school", ignore = true)
    StudentEntity toEntity(StudentRequestDto dto);

    StudentResponseDto toDto(StudentEntity entity);
}

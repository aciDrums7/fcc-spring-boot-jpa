package com.freecodecamp.springBootJpa.students;

import com.freecodecamp.springBootJpa.misc.mappers.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentsMapper extends GenericMapper<StudentEntity, StudentRequestDto, StudentResponseDto> {}

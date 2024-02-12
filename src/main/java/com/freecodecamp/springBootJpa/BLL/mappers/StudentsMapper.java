package com.freecodecamp.springBootJpa.BLL.mappers;

import org.mapstruct.Mapper;

import com.freecodecamp.springBootJpa.BLL.dtos.students.StudentRequestDto;
import com.freecodecamp.springBootJpa.BLL.dtos.students.StudentResponseDto;
import com.freecodecamp.springBootJpa.DAL.entities.StudentEntity;

@Mapper(componentModel = "spring")
public interface StudentsMapper extends GenericMapper<StudentEntity, StudentRequestDto, StudentResponseDto> {

}

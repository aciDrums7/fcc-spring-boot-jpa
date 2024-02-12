package com.freecodecamp.springBootJpa.BLL.mappers;

import org.mapstruct.Mapper;

import com.freecodecamp.springBootJpa.BLL.dtos.schools.SchoolRequestDto;
import com.freecodecamp.springBootJpa.BLL.dtos.schools.SchoolResponseDto;
import com.freecodecamp.springBootJpa.DAL.entities.SchoolEntity;

@Mapper(componentModel = "spring")
public interface SchoolsMapper extends GenericMapper<SchoolEntity, SchoolRequestDto, SchoolResponseDto> {

}

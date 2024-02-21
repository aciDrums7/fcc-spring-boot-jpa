package com.freecodecamp.springBootJpa.schools;

import com.freecodecamp.springBootJpa.misc.mappers.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolsMapper extends GenericMapper<SchoolEntity, SchoolRequestDto, SchoolResponseDto> {}

package com.freecodecamp.spring_boot_jpa.schools;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolsMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    SchoolEntity toEntity(SchoolRequestDto dto);

    SchoolResponseDto toDto(SchoolEntity entity);
}

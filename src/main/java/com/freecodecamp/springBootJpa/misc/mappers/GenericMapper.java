package com.freecodecamp.springBootJpa.misc.mappers;

import java.util.List;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GenericMapper<E, REQ, RES> {
    RES toResponseDto(E entity);

    E toEntity(REQ requestDto);

    List<RES> toResponseDtoList(List<E> entitiesList);

    List<E> toEntitiesList(List<REQ> dtoList);
}

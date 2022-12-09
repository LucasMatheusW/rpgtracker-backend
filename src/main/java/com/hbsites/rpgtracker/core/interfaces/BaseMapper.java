package com.hbsites.rpgtracker.core.interfaces;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.List;

public interface BaseMapper<ENTITY, DTO> {

    @Named("toDTO")
    DTO toDTO(ENTITY entity);

    ENTITY toEntity(DTO dto);

    @IterableMapping(qualifiedByName = "toDTO")
    List<DTO> toDTO(List<ENTITY> entities);

    List<ENTITY> toEntity(List<DTO> dtos);
}

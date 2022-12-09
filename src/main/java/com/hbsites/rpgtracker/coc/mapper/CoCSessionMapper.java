package com.hbsites.rpgtracker.coc.mapper;

import com.hbsites.rpgtracker.coc.dto.CoCSessionDTO;
import com.hbsites.rpgtracker.coc.entity.CoCSessionEntity;
import com.hbsites.rpgtracker.core.interfaces.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoCSessionMapper extends BaseMapper<CoCSessionEntity, CoCSessionDTO> {
}

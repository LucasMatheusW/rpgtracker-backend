package com.hbsites.rpgtracker.coc.mapper;

import com.hbsites.rpgtracker.coc.dto.CoCPulpTalentDTO;
import com.hbsites.rpgtracker.coc.entity.CoCPulpTalentEntity;
import com.hbsites.rpgtracker.core.interfaces.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoCPulpTalentMapper extends BaseMapper<CoCPulpTalentEntity, CoCPulpTalentDTO> {
}

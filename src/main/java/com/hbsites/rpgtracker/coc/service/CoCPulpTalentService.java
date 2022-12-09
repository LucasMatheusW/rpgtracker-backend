package com.hbsites.rpgtracker.coc.service;

import com.hbsites.rpgtracker.coc.dto.CoCPulpTalentDTO;
import com.hbsites.rpgtracker.coc.entity.CoCPulpTalentEntity;
import com.hbsites.rpgtracker.coc.mapper.CoCPulpTalentMapper;
import com.hbsites.rpgtracker.coc.repository.CoCPulpTalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoCPulpTalentService {

    @Autowired
    @Lazy
    private CoCPulpTalentRepository repository;

    @Autowired
    @Lazy
    private CoCPulpTalentMapper mapper;

    public List<CoCPulpTalentDTO> getAllTalents() {
        return mapper.toDTO(repository.findAll());
    }

    public CoCPulpTalentDTO createPulpTalent(CoCPulpTalentDTO payload) {
        CoCPulpTalentEntity newE = mapper.toEntity(payload);
        newE = repository.save(newE);
        return mapper.toDTO(newE);
    }
}

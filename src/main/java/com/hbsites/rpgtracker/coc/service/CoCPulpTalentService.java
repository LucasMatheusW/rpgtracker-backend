package com.hbsites.rpgtracker.coc.service;

import com.hbsites.rpgtracker.coc.dto.CoCPulpTalentDTO;
import com.hbsites.rpgtracker.coc.entity.CoCPulpTalentEntity;
import com.hbsites.rpgtracker.coc.repository.CoCPulpTalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CoCPulpTalentService {

    @Autowired
    @Lazy
    private CoCPulpTalentRepository repository;

    public List<CoCPulpTalentDTO> getAllTalents() {
        return repository.findAll().stream().map(talent -> new CoCPulpTalentDTO(talent.getId(), talent.getName(), talent.getDescription()))
                .collect(Collectors.toList());
    }

    public CoCPulpTalentDTO createPulpTalent(CoCPulpTalentDTO payload) {
        CoCPulpTalentEntity newE = new CoCPulpTalentEntity();
        newE.setId(payload.getId());
        newE.setName(payload.getName());
        newE.setDescription(payload.getDescription());
        newE = repository.save(newE);
        return new CoCPulpTalentDTO(newE.getId(), newE.getName(), newE.getDescription());
    }
}

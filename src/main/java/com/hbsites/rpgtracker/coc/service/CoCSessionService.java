package com.hbsites.rpgtracker.coc.service;

import com.hbsites.rpgtracker.coc.dto.CoCSessionDTO;
import com.hbsites.rpgtracker.coc.entity.CoCSessionEntity;
import com.hbsites.rpgtracker.coc.mapper.CoCSessionMapper;
import com.hbsites.rpgtracker.coc.repository.CoCSessionRepository;
import com.hbsites.rpgtracker.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoCSessionService {

    @Autowired
    @Lazy
    private CoCSessionRepository repository;

    @Autowired
    @Lazy
    private CoCSessionMapper mapper;

    @Autowired
    @Lazy
    private UserService userService;

    public List<CoCSessionDTO> getAll() {
        return mapper.toDTO(repository.findAll());
    }

    public CoCSessionDTO createSession(CoCSessionDTO payload) {
        CoCSessionEntity newE = mapper.toEntity(payload);
        newE.setInPlay(newE.getInPlay() != null ? newE.getInPlay() : false);
        newE.setPulpCthulhu(newE.getPulpCthulhu() != null ? newE.getPulpCthulhu() : false);
        newE.setDmId(userService.getUserUUID());
        newE = repository.save(newE);
        return mapper.toDTO(newE);
    }
}

package com.hbsites.rpgtracker.coc.service;

import com.hbsites.rpgtracker.coc.dto.CoCSessionDTO;
import com.hbsites.rpgtracker.coc.entity.CoCSessionEntity;
import com.hbsites.rpgtracker.coc.repository.CoCSessionRepository;
import com.hbsites.rpgtracker.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoCSessionService {

    @Autowired
    @Lazy
    private CoCSessionRepository repository;

    @Autowired
    @Lazy
    private UserService userService;

    public List<CoCSessionDTO> getAll() {
        return repository.findAll().stream().map(CoCSessionEntity::toListingDTO).collect(Collectors.toList());
    }

    public CoCSessionDTO createSession(CoCSessionDTO payload) {
        CoCSessionEntity e = payload.toEntity();
        e.setDmId(userService.getUserUUID());
        e = repository.save(e);
        return e.toListingDTO();
    }
}

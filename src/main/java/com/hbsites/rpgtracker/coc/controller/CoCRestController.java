package com.hbsites.rpgtracker.coc.controller;

import com.hbsites.rpgtracker.coc.dto.CoCPulpTalentDTO;
import com.hbsites.rpgtracker.coc.dto.CoCSessionDTO;
import com.hbsites.rpgtracker.coc.entity.CoCPulpTalentEntity;
import com.hbsites.rpgtracker.coc.entity.CoCSessionEntity;
import com.hbsites.rpgtracker.coc.entity.CoCSkillEntity;
import com.hbsites.rpgtracker.coc.repository.CoCSessionRepository;
import com.hbsites.rpgtracker.coc.repository.CoCSkillRepository;
import com.hbsites.rpgtracker.coc.service.CoCPulpTalentService;
import com.hbsites.rpgtracker.coc.service.CoCSessionService;
import com.hbsites.rpgtracker.core.dto.SessionListingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coc")
public class CoCRestController {

    @Autowired
    @Lazy
    private CoCPulpTalentService pulpTalentService;

    @Autowired
    @Lazy
    private CoCSessionService sessionService;

    @Autowired
    @Lazy
    private CoCSkillRepository skillRepository;

    @GetMapping("/pulp-talents")
    public List<CoCPulpTalentDTO> getAll() {
        return pulpTalentService.getAllTalents();
    }

    @PostMapping("/pulp-talents")
    public CoCPulpTalentDTO save(@RequestBody CoCPulpTalentDTO payload) {
        return pulpTalentService.createPulpTalent(payload);
    }

    @GetMapping("/sessions")
    public List<CoCSessionDTO> getAllSessions() {
        return sessionService.getAll();
    }

    @PostMapping("/sessions")
    public CoCSessionDTO save(@RequestBody CoCSessionDTO payload) {
        return sessionService.createSession(payload);
    }

    @GetMapping("/skills")
    public List<CoCSkillEntity> getAllSkils() {
        return skillRepository.findAll();
    }
}

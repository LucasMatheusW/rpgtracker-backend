package com.hbsites.rpgtracker.core.controller;

import com.hbsites.rpgtracker.core.dto.CharacterSheetListingDTO;
import com.hbsites.rpgtracker.core.dto.ConfigDTO;
import com.hbsites.rpgtracker.core.entity.CharacterSheetEntity;
import com.hbsites.rpgtracker.core.entity.SessionEntity;
import com.hbsites.rpgtracker.core.repository.CharacterSheetRepository;
import com.hbsites.rpgtracker.core.repository.SessionRepository;
import com.hbsites.rpgtracker.core.service.CharacterSheetService;
import com.hbsites.rpgtracker.core.service.ConfigurationService;
import com.hbsites.rpgtracker.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoreRestController {

    @Autowired
    @Lazy
    private SessionRepository sessionRepository;

    @Autowired
    @Lazy
    private UserService userService;

    @Autowired
    @Lazy
    private CharacterSheetService characterSheetService;

    @Autowired
    @Lazy
    private ConfigurationService configurationService;

    @GetMapping("/user-config")
    public ConfigDTO getUserConfig() {
        return configurationService.getUserConfiguration();
    }

    @GetMapping("/my-dm-sessions")
    public List<SessionEntity> getMySessions() {
        return sessionRepository.findAllByDmId(userService.getUserUUID());
    }

    @GetMapping("/my-character-sheets")
    public List<CharacterSheetListingDTO> getMyCharacterSheets() {
        return characterSheetService.getAllCurrentUserSheets();
    }
}

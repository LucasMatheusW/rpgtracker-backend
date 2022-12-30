package com.hbsites.rpgtracker.core.service;

import com.hbsites.rpgtracker.coc.entity.CoCCharacterSheetEntity;
import com.hbsites.rpgtracker.coc.service.CoCCharacterSheetService;
import com.hbsites.rpgtracker.core.dto.BasicSessionListingDTO;
import com.hbsites.rpgtracker.core.dto.SessionListingDTO;
import com.hbsites.rpgtracker.core.entity.CharacterSheetEntity;
import com.hbsites.rpgtracker.core.repository.SessionRepository;
import com.hbsites.rpgtracker.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SessionService {

    @Lazy
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    @Lazy
    private UserService userService;
    @Autowired
    @Lazy
    private KeycloakService keycloakService;

    public List<BasicSessionListingDTO> getDMedSessions() {
        return sessionRepository.findAllByDmId(userService.getUserUUID()).stream().map(en -> {
            SessionListingDTO dto = ((SessionListingDTO) en.toListDTO());
            // Populate player list
            List<UUID> playerIds = (List<UUID>) en.getSheets().stream().map(sheet -> ((CharacterSheetEntity)sheet).getPlayerId()).collect(Collectors.toList());
            HashSet<UUID> playerIdsUnique = new HashSet<UUID>(playerIds);
            dto.setPlayers(playerIdsUnique.stream().map(uuid -> keycloakService.getUsernameById(uuid)).collect(Collectors.toList()));

            return dto.asBasic();
        }).collect(Collectors.toList());
    }

}

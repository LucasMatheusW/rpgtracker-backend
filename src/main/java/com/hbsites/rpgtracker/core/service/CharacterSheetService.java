package com.hbsites.rpgtracker.core.service;

import com.hbsites.rpgtracker.core.dto.CharacterSheetListingDTO;
import com.hbsites.rpgtracker.core.repository.CharacterSheetRepository;
import com.hbsites.rpgtracker.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CharacterSheetService {

    @Autowired
    @Lazy
    private CharacterSheetRepository characterSheetRepository;

    @Autowired
    @Lazy
    private UserService userService;

    public List<CharacterSheetListingDTO> getAllCurrentUserSheets() {
        return characterSheetRepository.findAllByPlayerId(userService.getUserUUID()).stream()
                .map(c -> ((CharacterSheetListingDTO) c.toListDTO())).collect(Collectors.toList());
    }
}

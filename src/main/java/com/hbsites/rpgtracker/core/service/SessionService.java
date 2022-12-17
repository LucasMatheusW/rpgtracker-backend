package com.hbsites.rpgtracker.core.service;

import com.hbsites.rpgtracker.core.dto.BasicSessionListingDTO;
import com.hbsites.rpgtracker.core.dto.SessionListingDTO;
import com.hbsites.rpgtracker.core.entity.SessionEntity;
import com.hbsites.rpgtracker.core.repository.SessionRepository;
import com.hbsites.rpgtracker.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SessionService {

    @Lazy
    @Autowired
    private SessionRepository sessionRepository;


    @Autowired
    @Lazy
    private UserService userService;

    public List<BasicSessionListingDTO> getDMedSessions() {
        return sessionRepository.findAllByDmId(userService.getUserUUID()).stream().map(en -> en.toListingDTO().asBasic()).collect(Collectors.toList());
    }

}

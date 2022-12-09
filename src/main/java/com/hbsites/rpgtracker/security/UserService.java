package com.hbsites.rpgtracker.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService {

    public UUID getUserUUID() {
        return UUID.fromString(((Jwt)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getSubject());
    }

}

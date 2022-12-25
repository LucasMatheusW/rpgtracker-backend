package com.hbsites.rpgtracker.core.dto;

import com.hbsites.rpgtracker.core.entity.SessionEntity;
import com.hbsites.rpgtracker.core.enumeration.ETRPGSystem;
import liquibase.repackaged.org.apache.commons.lang3.NotImplementedException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class BasicSessionListingDTO extends SessionListingDTO {
    public BasicSessionListingDTO(UUID uuid, String sessionName, ETRPGSystem system, boolean inPlay) {
        this.setUuid(uuid);
        this.setSessionName(sessionName);
        this.setSystem(system);
        this.setInPlay(inPlay);
    }

    @Override
    public SessionEntity toEntity() {
        throw new NotImplementedException();
    }
}

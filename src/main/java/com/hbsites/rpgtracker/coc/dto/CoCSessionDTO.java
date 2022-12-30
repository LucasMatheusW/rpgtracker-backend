package com.hbsites.rpgtracker.coc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hbsites.rpgtracker.coc.entity.CoCSessionEntity;
import com.hbsites.rpgtracker.core.dto.SessionListingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"system"})
public class CoCSessionDTO extends SessionListingDTO {
    private Boolean pulpCthulhu;
    private List<SessionSheet> characterSheets;

    @Override
    public CoCSessionEntity toEntity() {
        CoCSessionEntity e = new CoCSessionEntity();
        e.setSessionId(this.getUuid());
        e.setInPlay(this.isInPlay());
        e.setSessionName(this.getSessionName() != null ? this.getSessionName() : "");
        e.setPulpCthulhu(this.getPulpCthulhu() != null ? this.getPulpCthulhu() : false);
        return e;
    }

    @Data
    @AllArgsConstructor
    public static class SessionSheet {
        private UUID uuid;
        private String characterName;
    }
}

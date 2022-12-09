package com.hbsites.rpgtracker.coc.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CoCSessionDTO {
    private UUID sessionId;
    private String sessionName;
    private Boolean inPlay;
    private Boolean pulpCthulhu;
}

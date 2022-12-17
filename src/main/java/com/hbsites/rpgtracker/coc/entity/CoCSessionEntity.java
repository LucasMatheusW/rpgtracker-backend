package com.hbsites.rpgtracker.coc.entity;

import com.hbsites.rpgtracker.coc.dto.CoCSessionDTO;
import com.hbsites.rpgtracker.core.dto.SessionListingDTO;
import com.hbsites.rpgtracker.core.entity.SessionEntity;
import com.hbsites.rpgtracker.core.enumeration.ETRPGSystem;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "session_coc")
@PrimaryKeyJoinColumn(name = "session_id")
public class CoCSessionEntity extends SessionEntity {

    @Column(name = "pulp_cthulhu", columnDefinition = "boolean")
    private Boolean pulpCthulhu;

    @Override
    public CoCSessionDTO toListingDTO() {
        CoCSessionDTO dto = new CoCSessionDTO(this.getPulpCthulhu());
        dto.populate(this.getSessionId(), this.getSessionName(), ETRPGSystem.CALL_OF_CTHULU, this.getInPlay());
        return dto;
    }
}

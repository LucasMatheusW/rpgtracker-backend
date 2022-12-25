package com.hbsites.rpgtracker.coc.entity;

import com.hbsites.rpgtracker.coc.dto.CoCSessionDTO;
import com.hbsites.rpgtracker.core.entity.SessionEntity;
import com.hbsites.rpgtracker.core.enumeration.ETRPGSystem;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "session_coc")
@PrimaryKeyJoinColumn(name = "session_id")
public class CoCSessionEntity extends SessionEntity<CoCSessionDTO, CoCSessionDTO> {

    @Column(name = "pulp_cthulhu", columnDefinition = "boolean")
    private Boolean pulpCthulhu;

    @Override
    public CoCSessionDTO toListDTO() {
        CoCSessionDTO dto = new CoCSessionDTO(this.getPulpCthulhu(), null);
        dto.populate(this.getSessionId(), this.getSessionName(), ETRPGSystem.CALL_OF_CTHULU, this.getInPlay());
        return dto;
    }

    @Override
    public CoCSessionDTO toDetailDTO() {
        CoCSessionDTO dto = new CoCSessionDTO(this.getPulpCthulhu(), this.getSheets().stream().map(e -> ((CoCCharacterSheetEntity)e).toDetailDTO()).collect(Collectors.toList()));
        dto.populate(this.getSessionId(), this.getSessionName(), ETRPGSystem.CALL_OF_CTHULU, this.getInPlay());
        return dto;
    }
}

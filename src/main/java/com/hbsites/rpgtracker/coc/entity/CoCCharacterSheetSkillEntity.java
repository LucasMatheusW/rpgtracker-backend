package com.hbsites.rpgtracker.coc.entity;

import com.hbsites.rpgtracker.coc.dto.CoCCharacterSheetSkillDTO;
import com.hbsites.rpgtracker.coc.dto.CoCSessionDTO;
import com.hbsites.rpgtracker.coc.entity.ids.CoCSkillCharacterSheetID;
import com.hbsites.rpgtracker.core.dto.CharacterSheetListingDTO;
import com.hbsites.rpgtracker.core.entity.BaseEntity;
import com.hbsites.rpgtracker.core.entity.CharacterSheetEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "skills_character_sheet_coc")
@Entity
@IdClass(CoCSkillCharacterSheetID.class)
public class CoCCharacterSheetSkillEntity extends BaseEntity<CoCCharacterSheetSkillDTO, CoCCharacterSheetSkillDTO> {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_sheet_id", referencedColumnName = "character_sheet_id")
    private CharacterSheetEntity<CharacterSheetListingDTO, CharacterSheetListingDTO, CoCSessionDTO, CoCSessionDTO> characterSheet;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private CoCSkillEntity skill;

    @Column(name = "value", nullable = false, columnDefinition = "integer")
    private Integer value = 1;

    @Column(name = "improvement_check", nullable = false, columnDefinition = "boolean")
    private Boolean improvementCheck = false;

    @Override
    public CoCCharacterSheetSkillDTO toListDTO() {
        return new CoCCharacterSheetSkillDTO(this.skill.getId(), this.skill.getFullName(), this.value, this.improvementCheck);
    }

    @Override
    public CoCCharacterSheetSkillDTO toDetailDTO() {
        return new CoCCharacterSheetSkillDTO(this.skill.getId(), this.skill.getFullName(), this.value, this.improvementCheck);
    }
}

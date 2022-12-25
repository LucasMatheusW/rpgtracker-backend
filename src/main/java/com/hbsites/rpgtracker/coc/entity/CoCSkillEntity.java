package com.hbsites.rpgtracker.coc.entity;

import com.hbsites.rpgtracker.coc.dto.CoCSkillDTO;
import com.hbsites.rpgtracker.coc.dto.CoCSkillDetailDTO;
import com.hbsites.rpgtracker.coc.enumeration.ESkillKind;
import com.hbsites.rpgtracker.coc.enumeration.ESkillRarity;
import com.hbsites.rpgtracker.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "skills_coc")
public class CoCSkillEntity extends BaseEntity<CoCSkillDTO, CoCSkillDetailDTO> {

    @Column(name = "id", columnDefinition = "uuid")
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(50)")
    private String name;

    @Column(name = "base_value", columnDefinition = "integer")
    private Integer baseValue;

    @Column(name = "skill_rarity", nullable = false, columnDefinition = "varchar(45)")
    @Enumerated(EnumType.STRING)
    private ESkillRarity rarity;

    @Column(name = "skill_kind", nullable = false, columnDefinition = "varchar(45)")
    @Enumerated(EnumType.STRING)
    private ESkillKind kind;

    @Column(name = "usable", columnDefinition = "boolean", nullable = false)
    private Boolean usable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private CoCSkillEntity parentSkill;

    @Transient
    private Integer absoluteValue;

    @Transient
    private String fullName;

    @PostLoad
    private void postLoad() {
        this.absoluteValue = (this.parentSkill != null && (this.baseValue == null || this.baseValue == 0)) ? this.parentSkill.getBaseValue() : this.baseValue;
        this.fullName = this.parentSkill != null ? this.name+" ("+ this.parentSkill.getName() +")" : this.name;
    }

    @Override
    public CoCSkillDTO toListDTO() {
        return new CoCSkillDTO(this.id, this.getFullName(), this.getAbsoluteValue());
    }

    @Override
    public CoCSkillDetailDTO toDetailDTO() {
        return new CoCSkillDetailDTO(this.id, this.rarity, this.kind, this.usable, this.baseValue, this.name, this.parentSkill != null ? this.parentSkill.toDetailDTO() : null);
    }
}

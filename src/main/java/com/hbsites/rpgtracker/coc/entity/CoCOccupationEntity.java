package com.hbsites.rpgtracker.coc.entity;

import com.hbsites.rpgtracker.coc.enumeration.ESkillKind;
import com.hbsites.rpgtracker.coc.enumeration.ESkillPointCalculationRule;
import com.hbsites.rpgtracker.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "occupation_coc")
@Entity
public class CoCOccupationEntity extends BaseEntity {

    @Column(name = "character_sheet_id", columnDefinition = "uuid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name", columnDefinition = "varchar(50)", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;

    @Column(name = "skill_points_calculation_rule", nullable = false, columnDefinition = "varchar(45)")
    @Enumerated(EnumType.STRING)
    private ESkillPointCalculationRule skillPointCalculationRule;

    @Column(name = "minimum_credit_rating", columnDefinition = "integer", nullable = false)
    private Integer minimumCreditRating;

    @Column(name = "maximum_credit_rating", columnDefinition = "integer", nullable = false)
    private Integer maximumCreditRating;

    @Column(name = "suggested_contacts", columnDefinition = "text")
    private String suggestedContacts;

    @Column(name = "epoch_personal_skill_choices", columnDefinition = "integer")
    private Integer epochPersonalSkillChoices;

    @Column(name = "typed_skill_choices", columnDefinition = "integer")
    private Integer typedSkillChoices;

    @Column(name = "typed_skill_choices_kind", columnDefinition = "varchar(45)")
    @Enumerated(EnumType.STRING)
    private ESkillKind typedSkillChoicesKind;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "occupation_skills_coc",
            joinColumns = @JoinColumn(name = "occupation_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"))
    private List<CoCSkillEntity> skills;
}

package com.hbsites.rpgtracker.coc.entity;

import com.hbsites.rpgtracker.core.dto.CharacterSheetListingDTO;
import com.hbsites.rpgtracker.core.entity.CharacterSheetEntity;
import com.hbsites.rpgtracker.core.enumeration.ETRPGSystem;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "character_sheet_coc")
@PrimaryKeyJoinColumn(name = "character_sheet_id")
public class CoCCharacterSheetEntity extends CharacterSheetEntity {

    @Column(name = "pulp_cthulhu", columnDefinition = "boolean", nullable = false)
    private Boolean pulpCthulhu;

    @Column(name = "age", columnDefinition = "integer", nullable = false)
    private Integer age;

    @Column(name = "sex", columnDefinition = "varchar(50)", nullable = false)
    private String sex;

    @Column(name = "birthplace", columnDefinition = "varchar(100)", nullable = false)
    private String birthplace;

    @Column(name = "residence", columnDefinition = "varchar(100)", nullable = false)
    private String residence;

    @Column(name = "strength", columnDefinition = "integer", nullable = false)
    private Integer strength;

    @Column(name = "constitution", columnDefinition = "integer", nullable = false)
    private Integer constitution;

    @Column(name = "size", columnDefinition = "integer", nullable = false)
    private Integer size;

    @Column(name = "dexterity", columnDefinition = "integer", nullable = false)
    private Integer dexterity;

    @Column(name = "appearance", columnDefinition = "integer", nullable = false)
    private Integer appearance;

    @Column(name = "intelligence", columnDefinition = "integer", nullable = false)
    private Integer intelligence;

    @Column(name = "power", columnDefinition = "integer", nullable = false)
    private Integer power;

    @Column(name = "education", columnDefinition = "integer", nullable = false)
    private Integer education;

    @Column(name = "luck", columnDefinition = "integer", nullable = false)
    private Integer luck;

    @Column(name = "move_rate", columnDefinition = "integer", nullable = false)
    private Integer moveRate;

    @Column(name = "health_points", columnDefinition = "integer", nullable = false)
    private Integer healthPoints;

    @Column(name = "magic_points", columnDefinition = "integer", nullable = false)
    private Integer magicPoints;

    @Column(name = "sanity", columnDefinition = "integer", nullable = false)
    private Integer sanity;

    @Column(name = "starting_sanity", columnDefinition = "integer", nullable = false)
    private Integer startingSanity;

    @Column(name = "maximum_health_points", columnDefinition = "integer", nullable = false)
    private Integer maximumHealthPoints;

    @Column(name = "maximum_magic_points", columnDefinition = "integer", nullable = false)
    private Integer maximumMagicPoints;

    @Column(name = "maximum_sanity", columnDefinition = "integer", nullable = false)
    private Integer maximumSanity;

    @Column(name = "build", columnDefinition = "integer", nullable = false)
    private Integer build;

    @Column(name = "bonus_damage", columnDefinition = "varchar(10)", nullable = false)
    private String bonusDamage;

    @Column(name = "dodge", columnDefinition = "integer", nullable = false)
    private Integer dodge;

    @Column(name = "dodge_improvement_check", columnDefinition = "boolean", nullable = false)
    private Boolean dodgeImprovementCheck;

    @Column(name = "language_own", columnDefinition = "integer", nullable = false)
    private Integer languageOwn;

    @Column(name = "language_own_improvement_check", columnDefinition = "boolean", nullable = false)
    private Boolean languageOwnImprovementCheck;

    @Column(name = "occupational_skill_points", columnDefinition = "integer", nullable = false)
    private Integer occupationalSkillPoints;

    @Column(name = "personal_interest_skill_points", columnDefinition = "integer", nullable = false)
    private Integer personalInterestSkillPoints;

    @Column(name = "major_wounds", columnDefinition = "boolean", nullable = false)
    private Boolean majorWounds;

    @Column(name = "temporary_insanity", columnDefinition = "boolean", nullable = false)
    private Boolean temporaryInsanity;

    @Column(name = "indefinite_insanity", columnDefinition = "boolean", nullable = false)
    private Boolean indefiniteInsanity;

    @Column(name = "credit_rating", columnDefinition = "integer", nullable = false)
    private Integer creditRating;

    @Column(name = "cthulhu_mythos", columnDefinition = "integer", nullable = false)
    private Integer cthulhuMythos;

    @Override
    public CharacterSheetListingDTO toListingDTO() {
        return new CharacterSheetListingDTO(this.getId(), this.getCharacterName(), ETRPGSystem.CALL_OF_CTHULU);
    }
}

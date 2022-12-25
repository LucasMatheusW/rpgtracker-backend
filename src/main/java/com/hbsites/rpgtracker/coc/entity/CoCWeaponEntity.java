package com.hbsites.rpgtracker.coc.entity;

import com.hbsites.rpgtracker.coc.dto.CoCWeaponDetailDTO;
import com.hbsites.rpgtracker.coc.dto.CoCWeaponListDTO;
import com.hbsites.rpgtracker.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "weapon_coc")
public class CoCWeaponEntity extends BaseEntity<CoCWeaponListDTO, CoCWeaponDetailDTO> {

    @Column(name = "id", columnDefinition = "uuid")
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(50)")
    private String name;

    @Column(name = "range", columnDefinition = "varchar(20)")
    private String range;

    @Column(name = "damage", nullable = false, columnDefinition = "varchar(20)")
    private String damage;

    @Column(name = "attacks_per_round", nullable = false, columnDefinition = "integer")
    private Integer attacksPerRound = 1;

    @Column(name = "malfunction", columnDefinition = "integer")
    private Integer malfunction;

    @Column(name = "is_melee", nullable = false, columnDefinition = "boolean")
    private Boolean isMelee = false;

    @Column(name = "is_throwable", nullable = false, columnDefinition = "boolean")
    private Boolean isThrowable = false;

    @Column(name = "is_dual_wield", nullable = false, columnDefinition = "boolean")
    private Boolean isDualWield = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ammo_id")
    private CoCAmmoEntity ammo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skill_id")
    private CoCSkillEntity skillUsed;

    @Override
    public CoCWeaponListDTO toListDTO() {
        return new CoCWeaponListDTO(this.id, this.name, this.isMelee, this.isThrowable, this.isDualWield);
    }

    @Override
    public CoCWeaponDetailDTO toDetailDTO() {
        return new CoCWeaponDetailDTO(this.id, this.name, this.range, this.damage, this.attacksPerRound, this.malfunction,
                this.isMelee, this.isThrowable, this.isDualWield, this.ammo != null ? this.ammo.toDetailDTO() : null,
                this.skillUsed != null ? this.skillUsed.toDetailDTO() : null);
    }
}

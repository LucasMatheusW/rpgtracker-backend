package com.hbsites.rpgtracker.coc.entity;

import com.hbsites.rpgtracker.coc.dto.CoCAmmoDTO;
import com.hbsites.rpgtracker.core.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "ammo_coc")
public class CoCAmmoEntity extends BaseEntity<CoCAmmoDTO, CoCAmmoDTO> {

    @Column(name = "id", columnDefinition = "uuid")
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", columnDefinition = "varcahr(50)", nullable = false)
    private String name;

    @Column(name = "rounds_shot_with_each", columnDefinition = "integer", nullable = false)
    private Integer roundsShotWithEach = 1;

    @Override
    public CoCAmmoDTO toListDTO() {
        return new CoCAmmoDTO(this.id, this.name, this.roundsShotWithEach);
    }

    @Override
    public CoCAmmoDTO toDetailDTO() {
        return new CoCAmmoDTO(this.id, this.name, this.roundsShotWithEach);
    }
}

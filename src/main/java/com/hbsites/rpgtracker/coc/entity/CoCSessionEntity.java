package com.hbsites.rpgtracker.coc.entity;

import com.hbsites.rpgtracker.core.entity.SessionEntity;
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
}

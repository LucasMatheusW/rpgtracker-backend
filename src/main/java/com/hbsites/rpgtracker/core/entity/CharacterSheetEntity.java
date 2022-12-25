package com.hbsites.rpgtracker.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "character_sheet")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CharacterSheetEntity<LISTDTO, DETAILDTO, SESSIONLISTDTO, SESSIONDETAILDTO> extends BaseEntity<LISTDTO, DETAILDTO> {

    @Column(name = "character_sheet_id", columnDefinition = "uuid")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "character_name", columnDefinition = "varchar(100)", nullable = false)
    private String characterName;

    @Column(name = "player_id", columnDefinition = "uuid", nullable = false)
    private UUID playerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", referencedColumnName = "session_id")
    private SessionEntity<SESSIONLISTDTO, SESSIONDETAILDTO> session;
}

package com.example.demo.domain.model;

import com.example.demo.domain.model.CompositeKeys.GameMemberPK;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="gamemembers")
public class GameMember {
    @EmbeddedId
    private GameMemberPK id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("gameId")
    @JoinColumn(name = "GameID")
    private Game Game;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "UserID")
    private UserAdditional User;

    @Column(name="Position")
    private Integer PositionInGame;

    @Column(name="GameFouls")
    private Integer Fouls;

    @Column(name="GameExtraPoints")
    private Float ExtraPoints;

    @Column(name="GamePenalty")
    private Integer Penalty;

    @Column(name="bm_compensation")
    private Integer BM_Compensation;

    @Column(name="bm_2black")
    private Integer BM_2Black;

    @Column(name="bm_3black")
    private Integer BM_3Black;

    @Column(name="bm_3red")
    private Integer BM_3Red;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GameRoleID")
    private GameRole Role;

    public Boolean isWin()
    {
        return (((Role.getId() == 1 || Role.getId() == 10) && (Game.getResult().getId() == 20 || Game.getResult().getId() == 21 )) ||  ((Role.getId() == 2 || Role.getId() == 11) && (Game.getResult().getId() == 15 || Game.getResult().getId() == 16 )));
    }


}

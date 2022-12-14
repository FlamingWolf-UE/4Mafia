package com.example.demo.domain.entityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameMemberModel {
    private Integer GameId;
    private Integer UserId;
    private Integer PositionInGame;
    private Integer Fouls;
    private Float ExtraPoints;
    private Integer Penalty;
    private Integer BM_2Black;
    private Integer BM_3Black;
    private Integer BM_3Red;
    private Integer RoleId;
    private Boolean IsWinner;
}

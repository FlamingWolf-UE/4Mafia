package com.example.demo.domain.entityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDataModel {
    private String Nickname;
    private Float TotalPoints;
    private Integer NumberCounts;
    private Integer Wins;
    private Integer Loses;
    private Float TotalExtraPoints;
    private Float TotalPenaltyPoints;
    private Float TotalCompensationPoints;
    private Integer Total2B;
    private Integer Total3B;
    private Integer Total3R;


}

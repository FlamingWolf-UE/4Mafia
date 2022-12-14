package com.example.demo.domain.entityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameTypeModel {
    private Integer Id;
    private String Description;
    private String RatingInfo;
    private Integer Order;
    private Integer ReportGroup;
}

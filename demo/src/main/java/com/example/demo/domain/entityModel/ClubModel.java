package com.example.demo.domain.entityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClubModel {
    private Integer Id;
    private Boolean isDefaultClub;
    private String Name;
    private String ReportGroup;
}

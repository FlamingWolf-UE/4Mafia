package com.example.demo.domain.entityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceModel {
    private Integer Id;
    private Integer CityId;
    private String Description;
    private Boolean isArchived;
    private String Address;
}

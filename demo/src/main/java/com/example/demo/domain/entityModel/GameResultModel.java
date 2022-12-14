package com.example.demo.domain.entityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameResultModel {
    private Integer Id;
    private String Description;
    private Integer Order;
}

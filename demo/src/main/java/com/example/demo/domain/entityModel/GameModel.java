package com.example.demo.domain.entityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameModel {
    private Integer Id;
    private Date Date;
    @Nullable
    private String BlankImagePath;
    private Integer GameNumber;
    private Boolean isChecked;
    private String GameType;
    private String Result;
    private String Place;

}

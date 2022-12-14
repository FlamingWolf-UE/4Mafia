package com.example.demo.domain.entityModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRoleModel {
    private Integer Id;
    private String Name;
    private String RoleLogoName;
}

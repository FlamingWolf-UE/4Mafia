package com.example.demo.domain.entityModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAdditionalModel {
    private Integer Id;
    private String AltNickname;
    private String Nickname;
    private String Name;
    private String Email;
    private Boolean IsMale;
    private String PhotoImagePath;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;
    private String PhoneNumber;
    private String IsArchived;
    private Integer ClubId;
    private Integer StatusId;
    private List<Integer> RolesIds;
}


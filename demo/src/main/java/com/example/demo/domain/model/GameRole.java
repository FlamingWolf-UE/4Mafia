package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="gamerolesdict")
public class GameRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GameRoleID")
    private Integer Id;

    @Column(name="RoleName")
    private String Name;

    @Column(name="RoleLogo")
    private String RoleLogoName;



}

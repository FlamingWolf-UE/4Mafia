package com.example.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clubrolesdict")
public class ClubRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RoleID")
    private Integer Id;

    @Column(name="RoleName")
    private String Name;

    @Column(name="RoleDescription")
    private String Description;

    @JsonIgnore
    @ManyToMany(mappedBy = "Roles", fetch = FetchType.LAZY)
    private List<UserAdditional> usersWithThisRole;
}

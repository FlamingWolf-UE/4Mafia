package com.example.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clubsdict")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ClubID")
    private Integer Id;

    @Column(name = "DefaultClub")
    private Boolean isDefaultClub;

    @Column(name = "ClubName")
    private String ClubName;

    @Column(name = "ReportGroup")
    private String ReportGroup;

    @JsonIgnoreProperties({"ClubsOfCity", "PlacesOfCity", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CityID", nullable=true)
    private City City;

    @JsonIgnore
    @OneToMany(mappedBy = "Club", fetch = FetchType.LAZY)
    private List<UserAdditional> usersOfCLub;

}

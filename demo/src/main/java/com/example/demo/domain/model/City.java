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
@Table(name="citiesdict")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CityID")
    private Integer Id;

    @JsonIgnore
    @OneToMany(mappedBy = "City", fetch = FetchType.LAZY)
    private List<Club> ClubsOfCity;

    @JsonIgnore
    @OneToMany(mappedBy = "City", fetch = FetchType.LAZY)
    private List<Place> PlacesOfCity;

    @Column(name = "CityName")
    private String Name;


}

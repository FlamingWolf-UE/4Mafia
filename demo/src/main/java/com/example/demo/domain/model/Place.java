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
@Table(name="placesdict")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PlaceID")
    private Integer Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CityID", nullable=false)
    private City City;

    @Column(name = "Name")
    private String Description;

    @Column(name = "ForgetPlace")
    private Boolean isArchived;

    @Column(name="Address")
    private String Address;

    @JsonIgnore
    @OneToMany(mappedBy = "Place", fetch = FetchType.LAZY)
    private List<Game> GamesInThisPlace;
}

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
@Table(name="gametypedict")
public class GameType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GameTypeID")
    private Integer Id;

    @Column(name="Description")
    private String Description;

    @Column(name="RatingInfo")
    private String RatingInfo;

    @Column(name="ShowOrder")
    private Integer Order;

    //May be unnecessary
    @Column(name="ReportGroup")
    private Integer ReportGroup;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="ratingsbygametype",
            joinColumns = @JoinColumn(name="GameTypeID"),
            inverseJoinColumns = @JoinColumn(name="ClubStatuseID")
    )
    private List<ClubStatus> SupportedStatuses;

    @JsonIgnore
    @OneToMany(mappedBy = "Type", fetch = FetchType.LAZY)
    private List<Game> GamesByThisType;
}

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
@Table(name="gameresultsdict")
public class GameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GameResultID")
    private Integer Id;

    @Column(name="Description")
    private String Description;

    @Column(name="ord")
    private Integer Order;

    @JsonIgnore
    @OneToMany(mappedBy = "Result", fetch = FetchType.LAZY)
    private List<Game> GamesByThisResult;


}

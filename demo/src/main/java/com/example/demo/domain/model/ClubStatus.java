package com.example.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="clubstatusesdict")
public class ClubStatus {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ClubStatuseID")
    private Integer Id;

    @Column(name="StatusDesc")
    private String Description;

    @Column(name="ReportGroup")
    private String ReportGroup;

    @Column(name="DefaultRow")
    private Boolean isDefaultRow;

    @JsonIgnore
    @OneToMany(mappedBy = "Status")
    private List<UserAdditional> usersWithThisStatuses;

    @JsonIgnore
    @ManyToMany(mappedBy = "SupportedStatuses", fetch = FetchType.LAZY)
    private List<GameType> SupportedGameTypes;
}

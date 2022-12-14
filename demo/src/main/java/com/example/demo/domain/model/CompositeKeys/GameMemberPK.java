package com.example.demo.domain.model.CompositeKeys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MapsId;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameMemberPK implements Serializable {

    @Column(name="GameID")
    private Integer gameId;

    @Column(name="UserID")
    private Integer userId;
}

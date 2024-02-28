package com.example.demo.Players;

import java.io.Serializable;
import com.example.demo.Players.Player;

public class UpdatePlayersTeamDTO implements Serializable {
    private Integer teamNumber;
    //indien niet werkend: mogelijk omwissel naar Type Player
    private Integer id;

    public UpdatePlayersTeamDTO() {
    }

    public UpdatePlayersTeamDTO(Integer teamNumber) {
        this.teamNumber = teamNumber;
    }

    public UpdatePlayersTeamDTO(Integer teamNumber, Integer id) {
        this.teamNumber = teamNumber;
        this.id = id;
    }

    public Integer getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(Integer teamNumber) {
        this.teamNumber = teamNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdatePlayersTeamDTO{" +
                "teamNumber=" + teamNumber +
                ", id=" + id +
                '}';
    }
}

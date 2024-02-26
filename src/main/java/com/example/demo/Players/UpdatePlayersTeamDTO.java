package com.example.demo.Players;

import java.io.Serializable;
import com.example.demo.Players.Player;

public class UpdatePlayersTeamDTO implements Serializable {
    private Integer teamId;
    //indien niet werkend: mogelijk omwissel naar Type Player
    private Integer id;

    public UpdatePlayersTeamDTO() {
    }

    public UpdatePlayersTeamDTO(Integer teamId) {
        this.teamId = teamId;
    }

    public UpdatePlayersTeamDTO(Integer teamId, Integer id) {
        this.teamId = teamId;
        this.id = id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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
                "teamId=" + teamId +
                ", id=" + id +
                '}';
    }
}

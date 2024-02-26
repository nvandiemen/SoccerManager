package com.example.demo.Transfers;

import java.io.Serializable;

public class TransferDTO implements Serializable {

    private Integer playerId;

    private Integer oldTeamId;

    private Integer newTeamId;

    private Integer value;


    public TransferDTO(Integer playerId, Integer oldTeamId, Integer newTeamId, Integer value) {
        this.playerId = playerId;
        this.oldTeamId = oldTeamId;
        this.newTeamId = newTeamId;
        this.value = value;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getOldTeamId() {
        return oldTeamId;
    }

    public void setOldTeamId(Integer oldTeamId) {
        this.oldTeamId = oldTeamId;
    }

    public Integer getNewTeamId() {
        return newTeamId;
    }

    public void setNewTeamId(Integer newTeamId) {
        this.newTeamId = newTeamId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "TransferDTO{" +
                "playerId=" + playerId +
                ", oldTeamId=" + oldTeamId +
                ", newTeamId=" + newTeamId +
                ", value=" + value +
                '}';
    }
}

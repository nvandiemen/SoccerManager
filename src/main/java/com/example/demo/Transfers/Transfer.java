package com.example.demo.Transfers;

import com.example.demo.Players.Player;
import com.example.demo.Teams.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table (name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer transferId;
//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    @JsonBackReference
    private Integer transferedPlayerId;
    private Integer newTeamId;

    private Integer oldTeamId;
    private Integer transferedValue;


    public Transfer() {
    }


    public Transfer(Integer transferedPlayerId, Integer newTeamId, Integer oldTeamId, Integer transferedValue) {
        this.transferedPlayerId = transferedPlayerId;
        this.newTeamId = newTeamId;
        this.oldTeamId = oldTeamId;
        this.transferedValue = transferedValue;
    }


    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public Integer getTransferedPlayerId() {
        return transferedPlayerId;
    }

    public void setTransferedPlayerId(Integer transferedPlayerId) {
        this.transferedPlayerId = transferedPlayerId;
    }

    public Integer getNewTeamId() {
        return newTeamId;
    }

    public void setNewTeamId(Integer newTeamId) {
        this.newTeamId = newTeamId;
    }

    public Integer getOldTeamId() {
        return oldTeamId;
    }

    public void setOldTeamId(Integer oldTeamId) {
        this.oldTeamId = oldTeamId;
    }

    public Integer getTransferedValue() {
        return transferedValue;
    }

    public void setTransferedValue(Integer transferedValue) {
        this.transferedValue = transferedValue;
    }


    @Override
    public String toString() {
        return "Transfer{" +
                "transferId=" + transferId +
                ", transferedPlayerId=" + transferedPlayerId +
                ", newTeamId=" + newTeamId +
                ", oldTeamId=" + oldTeamId +
                ", transferedValue=" + transferedValue +
                '}';
    }
}

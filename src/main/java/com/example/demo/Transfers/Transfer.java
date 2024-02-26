package com.example.demo.Transfers;

import com.example.demo.Players.Player;
import com.example.demo.Teams.Team;
import com.example.demo.Transfers.TransferDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table (name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer transferId;
@ManyToOne
    private Player transferedPlayerId;
@ManyToOne
    private Team newTeamId;

@ManyToOne
    private Team oldTeamId;

    private Integer transferedValue;



    public Transfer() {
    }

    public Transfer(Player transferedPlayerId, Team newTeamId, Team oldTeamId, Integer transferedValue) {
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

    public Player getTransferedPlayerId() {
        return transferedPlayerId;
    }

    public void setTransferedPlayerId(Player transferedPlayerId) {
        this.transferedPlayerId = transferedPlayerId;
    }

    public Team getNewTeamId() {
        return newTeamId;
    }

    public void setNewTeamId(Team newTeamId) {
        this.newTeamId = newTeamId;
    }

    public Team getOldTeamId() {
        return oldTeamId;
    }

    public void setOldTeamId(Team oldTeamId) {
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

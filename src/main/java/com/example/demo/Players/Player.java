package com.example.demo.Players;

import com.example.demo.Teams.Team;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Set;

@Table(name = "player")
@Entity
public class Player {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;
    public String lastName;
    public String line;
    public String position;
    public Integer attackScore;
    public Integer defenseScore;
    public Integer averageScore;
    public Integer teamNumber;
    public Double transferValue;
    public Byte playerImage;





    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_team_id")
    @JsonBackReference
    private Team team;





    public Player(Integer id, String lastName, String line, String position, Integer attackScore, Integer defenseScore, Integer averageScore, Integer teamNumber, Double transferValue, Byte playerImage ) {
        this.id = id;
        this.lastName = lastName;
        this.line = line;
        this.position = position;
        this.attackScore = attackScore;
        this.defenseScore = defenseScore;
        this.averageScore = averageScore;
        this.teamNumber = teamNumber;
        this.transferValue = transferValue;
        this.playerImage = playerImage;





    }


    public Player(String lastName, String line, String position, Integer attackScore, Integer defenseScore, Integer averageScore, Integer teamNumber, Double transferValue, Byte playerImage) {
        this.lastName = lastName;
        this.line = line;
        this.position = position;
        this.attackScore = attackScore;
        this.defenseScore = defenseScore;
        this.averageScore = averageScore;
        this.teamNumber = teamNumber;
        this.transferValue = transferValue;
        this.playerImage = playerImage;




    }

    public Player() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(Integer attackScore) {
        this.attackScore = attackScore;
    }

    public Integer getDefenseScore() {
        return defenseScore;
    }

    public void setDefenseScore(Integer defenseScore) {
        this.defenseScore = defenseScore;
    }

    public Integer getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Integer averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(Integer teamNumber) {
        this.teamNumber = teamNumber;
    }

    public Double getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(Double transferValue) {
        this.transferValue = transferValue;
    }

    public Byte getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(Byte playerImage) {
        this.playerImage = playerImage;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", line='" + line + '\'' +
                ", position='" + position + '\'' +
                ", attackScore=" + attackScore +
                ", defenseScore=" + defenseScore +
                ", averageScore=" + averageScore +
                ", teamNumber=" + teamNumber +
                ", transferValue" + transferValue +
                ", playerImage" + playerImage +




                '}';
    }
}



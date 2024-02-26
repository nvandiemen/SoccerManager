package com.example.demo.Players;

import com.example.demo.Transfers.Transfer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "player")
@Entity
public class Player{
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
    public String teamName;
    public Double transferValue;
//    @OneToMany(mappedBy = "transferedPlayerId", cascade = CascadeType.ALL)
//    @JsonManagedReference
    //public Set<Transfer> playerTransfers;



    public byte[] playerImage;
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "player_images",
//    joinColumns = {
//            @JoinColumn(name = "player_id")
//    },
//            inverseJoinColumns = {
//            @JoinColumn(name = "image_id")
//            }
//    )


//    public Set<PlayerImage> playerImages;


//    public Set<PlayerImage> getPlayerImages() {
//        return playerImages;
//    }
//
//    public void setPlayerImages(Set<PlayerImage> playerImages) {
//        this.playerImages = playerImages;
//    }

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "player_team_id")
//    @JsonBackReference
//    private Team team;


    public Player(String lastName, String line, String position, Integer attackScore, Integer defenseScore, Integer averageScore, Integer teamNumber, String teamName, Double transferValue, byte[] playerImage) {
        this.lastName = lastName;
        this.line = line;
        this.position = position;
        this.attackScore = attackScore;
        this.defenseScore = defenseScore;
        this.averageScore = averageScore;
        this.teamNumber = teamNumber;
        this.teamName = teamName;
        this.transferValue = transferValue;
        //this.playerTransfers = playerTransfers;
        this.playerImage = playerImage;
    }


    public Player() {
    }

    public Player(Integer integer) {
    }

    public Player(String aNull, HttpStatus httpStatus) {
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

    public byte[] getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(byte[] playerImage) {
        this.playerImage = playerImage;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
                ", teamName" + teamName +




                '}';
    }
}



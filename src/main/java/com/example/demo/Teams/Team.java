package com.example.demo.Teams;

import com.example.demo.Players.Player;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.*;

@Table(name = "team")
@Entity
public class Team {
@Id
@GeneratedValue
//is de column in db die PK draagt
@Column(name = "team_id" )
public Integer teamId;
public String teamName;

    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private List<Player> players;



    public Team() {
    }

    public Team(Integer teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                '}';
    }

}

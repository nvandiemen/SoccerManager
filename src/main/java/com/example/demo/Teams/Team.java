package com.example.demo.Teams;

import com.example.demo.Players.Player;
import jakarta.persistence.*;
import java.util.*;

@Table(name = "team")
@Entity
public class Team {
@Id
@GeneratedValue
public Integer teamId;
public String teamName;

@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Player> players = new ArrayList<Player>();



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

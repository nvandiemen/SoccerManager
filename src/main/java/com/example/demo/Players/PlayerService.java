package com.example.demo.Players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
   private PlayerRepository playerRepository;

   public Iterable<Player> getPlayers(){
       return playerRepository.findAll();

    }


    public Iterable<Player> getAllDefenders() {
        Iterable<Player> allPlayersIterable = playerRepository.findAll();
        List<Player> allPlayersList = new ArrayList<Player>();
        allPlayersIterable.forEach(allPlayersList::add);
        List<Player> allDefendersList =
                allPlayersList.stream().filter(player -> player.line.equals("Defence")).collect(Collectors.toList());
        return allDefendersList;

    };

    public Iterable<Player> getAllMidfielders() {
        Iterable<Player> allPlayersIterable = playerRepository.findAll();
        List<Player> allPlayersList = new ArrayList<Player>();
        allPlayersIterable.forEach(allPlayersList::add);
        List<Player> allMidfieldersList =
                allPlayersList.stream().filter(player -> player.line.equals("Midfield")).collect(Collectors.toList());
        return allMidfieldersList;

    };

    public Iterable<Player> getAllAttackers() {
        Iterable<Player> allPlayersIterable = playerRepository.findAll();
        List<Player> allPlayersList = new ArrayList<Player>();
        allPlayersIterable.forEach(allPlayersList::add);
        List<Player> allAttackersList =
                allPlayersList.stream().filter(player -> player.line.equals("Attack")).collect(Collectors.toList());
        return allAttackersList;
    };

    public Iterable<Player> getAllGoalkeepers() {
        Iterable<Player> allPlayersIterable = playerRepository.findAll();
        List<Player> allPlayersList = new ArrayList<Player>();
        allPlayersIterable.forEach(allPlayersList::add);
        List<Player> allGoalkeepersList =
                allPlayersList.stream().filter(player -> player.line.equals("Keeper")).collect(Collectors.toList());
        return allGoalkeepersList;
    };

    public Iterable<Player> getAllPlayersByTeam(){
        Iterable<Player> allPlayersIterable = playerRepository.findAll();
        List<Player> allPlayersList = new ArrayList<Player>();
        allPlayersIterable.forEach(allPlayersList::add);
        List<Player> allPlayersByTeamId =
                allPlayersList.stream().filter(player -> player.line.equals("Keeper")).collect(Collectors.toList());
        return allPlayersByTeamId;
    };



public List<Player> getPlayersByTeamNumber(long teamNumber) {
    return playerRepository.findByteamNumber(teamNumber);
}


}

package com.example.demo.Players;

import com.example.demo.Teams.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping (path = "players")

public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;
    PlayerService playerService;

    @Autowired
    PlayerController (PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping
    public Iterable<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @PostMapping
    public Player save(@RequestBody Player newPlayer) {
        return playerRepository.save(newPlayer);
    }

    @RequestMapping (path = "defence")
    public Iterable<Player> getAllDefenders(){
        return playerService.getAllDefenders();
    }

    @RequestMapping (path = "midfield")
    public Iterable<Player> getAllMidfielders(){
        return  playerService.getAllMidfielders();
    }

    @RequestMapping (path = "attack")
    public Iterable<Player> getAllAttackers(){
        return playerService.getAllAttackers();
    }

    @RequestMapping (path = "goalkeeper")
    public Iterable<Player> getAllGoalkeepers(){
        return playerService.getAllGoalkeepers();
    }

    @GetMapping (path = "team/{teamNumber}")
    public Iterable<Player> getPlayersByTeamId(@PathVariable long teamNumber){
        return playerService.getPlayersByTeamNumber(teamNumber);
    }

}

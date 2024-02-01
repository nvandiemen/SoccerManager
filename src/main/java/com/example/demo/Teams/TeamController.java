package com.example.demo.Teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "teams")
public class TeamController {
@Autowired
    public TeamRepository teamRepository;
    public TeamService teamService;


    @Autowired
    TeamController (TeamService teamService){
        this.teamService = teamService;
    }
    @GetMapping
    public Iterable<Team> getTeams(){
        return teamService.getTeams();
    }


    @PostMapping
    public Team save(@RequestBody Team newTeam){
        return teamRepository.save(newTeam);
    }


    @DeleteMapping("/{teamId}")
    public void deleteTeam(@PathVariable("teamId") Integer teamId) {
        teamRepository.deleteById(teamId);
    }
}

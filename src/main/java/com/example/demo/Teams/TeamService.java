package com.example.demo.Teams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Iterable<Team> getTeams() {
        return teamRepository.findAll();

    }



}

package com.example.demo.Teams;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TeamRepository extends CrudRepository<Team, Integer> {

    List<Team> findByteamName (String teamName);

}

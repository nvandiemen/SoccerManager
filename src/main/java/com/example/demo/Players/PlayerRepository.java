package com.example.demo.Players;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

    List<Player> findBylastName (String lastName);
    List<Player> findByteamNumber (long teamNumber);
    List<Player> findByid (long id);



}

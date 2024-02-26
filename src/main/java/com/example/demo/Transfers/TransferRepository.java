package com.example.demo.Transfers;

import com.example.demo.Players.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TransferRepository extends CrudRepository<Transfer, Integer> {

    List <Transfer> findBytransferId (Player transferedPlayerId);
    Iterable <Transfer> findBytransferedPlayerId (Player transferedPlayerId);
}

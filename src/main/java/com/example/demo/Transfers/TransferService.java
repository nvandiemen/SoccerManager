package com.example.demo.Transfers;

import com.example.demo.Players.Player;
import com.example.demo.Players.PlayerRepository;
import com.example.demo.Teams.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferService {

    @Autowired
    TransferRepository transferRepository;
    TeamRepository teamRepository;
    PlayerRepository playerRepository;

    public Iterable getTransfers(){
        return transferRepository.findAll();
    }

    public Iterable <Transfer> getPlayerByPlayerTransfer(Player transferedPlayerId){
        return transferRepository.findBytransferedPlayerId(transferedPlayerId);
    }



}

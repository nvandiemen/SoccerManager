package com.example.demo.Transfers;

import com.example.demo.Players.Player;
import com.example.demo.Players.PlayerRepository;
import com.example.demo.Teams.Team;
import com.example.demo.Teams.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "transfers")
public class TransferController {

    @Autowired
    TransferRepository transferRepository;
    TransferService transferService;
    PlayerRepository playerRepository;
    TeamRepository teamRepository;

    @Autowired
    TransferController (TransferService transferService, TeamRepository teamRepository, PlayerRepository playerRepository){
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.transferService = transferService;
    }

    @GetMapping
    public Iterable<Transfer> getTransfers(){
        return transferService.getTransfers();

    }

    // Oude versie > werkt gewoon, hieronder is een test
//    @PostMapping
//    public Transfer addTransfer(@RequestBody Transfer newTransfer){
//   newTransfer.getNewTeamId();



        @PostMapping
        public Transfer addTransfer(@RequestBody TransferDTO dto){

        Player playerId = playerRepository.findByid(dto.getPlayerId()).get(0);
        Team oldTeam = teamRepository.findById(dto.getOldTeamId()).get();
        Team newTeam = teamRepository.findById(dto.getNewTeamId()).get();

        Transfer transfer = new Transfer();
        transfer.setTransferedPlayerId(playerId);
        transfer.setNewTeamId(newTeam);
        transfer.setOldTeamId(oldTeam);
        transfer.setTransferedValue(dto.getValue());

//
//        @PostMapping("/tutorials/{tutorialId}/comments")
//        public ResponseEntity<Comment> createComment(@PathVariable(value = "tutorialId") Long tutorialId,
//                @RequestBody Comment commentRequest) {
//            Comment comment = tutorialRepository.findById(tutorialId).map(tutorial -> {
//                commentRequest.setTutorial(tutorial);
//                return commentRepository.save(commentRequest);
//            }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));
//
//            return new ResponseEntity<>(comment, HttpStatus.CREATED);
//        }


        return  transferRepository.save(transfer);
    }

    @GetMapping(path = "player/{transferedPlayerId}")
    public Iterable <Transfer> getTransfersByPlayer(@PathVariable Player transferedPlayerId){
        return transferService.getPlayerByPlayerTransfer(transferedPlayerId);
    }

}

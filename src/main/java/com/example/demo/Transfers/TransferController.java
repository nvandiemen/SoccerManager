package com.example.demo.Transfers;

import com.example.demo.Players.PlayerService;
import com.example.demo.Teams.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "transfers")
public class TransferController {

    @Autowired
    TransferRepository transferRepository;
    TransferService transferService;

    @Autowired
    TransferController (TransferService transferService){
        this.transferService = transferService;
    }

    @GetMapping
    public Iterable <Transfer> getTransfers(){
        return transferService.getTransfers();

    }

    // Oude versie > werkt gewoon, hieronder is een test
//    @PostMapping
//    public Transfer addTransfer(@RequestBody Transfer newTransfer){
//   newTransfer.getNewTeamId();



        @PostMapping
        public Transfer addTransfer(@RequestBody Transfer newTransfer){



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


        return  transferRepository.save(newTransfer);
    }

}

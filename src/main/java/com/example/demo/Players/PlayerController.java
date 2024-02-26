package com.example.demo.Players;
import com.example.demo.Players.Player;
import com.example.demo.*;
import com.example.demo.Teams.TeamRepository;
import com.example.demo.Teams.TeamService;
import com.example.demo.Transfers.TransferRepository;
import com.example.demo.Transfers.TransferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping (path = "players")

public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;
    PlayerService playerService;
    ModelMapper modelMapper;
    TransferRepository transferRepository;
    TransferService transferService;

    TeamRepository teamRepository;

    @Autowired
    PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public Iterable<Player> getPlayers() {
        return playerService.getPlayers();
    }


//    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public Player save(@RequestPart("player") Player playerFormData,
//                       @RequestPart("player_image") MultipartFile[] file) {
//
//        //return playerRepository.save(newPlayer);
//        try {
//            Set<PlayerImage> images = uploadImage(file);
//            playerFormData.setPlayerImages(images);
//            playerRepository.save(playerFormData);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//        }
//        return null;
//    }
//
//
//
//
//    public Set<PlayerImage> uploadImage(MultipartFile[] multipartFile) throws IOException{
//        Set<PlayerImage> playerImages = new HashSet<>();
//        for (MultipartFile file: multipartFile){
//            PlayerImage playerImage = new PlayerImage(
//                    file.getOriginalFilename(),
//                    file.getContentType(),
//                    file.getBytes()
//            );
//            playerImages.add(playerImage);
//        }
//        return playerImages;
//    }
    @PostMapping
    public Player save(@RequestBody Player newPlayer) {

        return playerRepository.save(newPlayer);
    }

    @RequestMapping(path = "defence")
    public Iterable<Player> getAllDefenders() {
        return playerService.getAllDefenders();
    }

    @RequestMapping(path = "midfield")
    public Iterable<Player> getAllMidfielders() {
        return playerService.getAllMidfielders();
    }

    @RequestMapping(path = "attack")
    public Iterable<Player> getAllAttackers() {
        return playerService.getAllAttackers();
    }

    @RequestMapping(path = "goalkeeper")
    public Iterable<Player> getAllGoalkeepers() {
        return playerService.getAllGoalkeepers();
    }

    @GetMapping(path = "team/{teamNumber}")
    public Iterable<Player> getPlayersByTeamId(@PathVariable long teamNumber) {
        return playerService.getPlayersByTeamNumber(teamNumber);
    }
//was Iterable
    @GetMapping(path = "/{id}")
    public List <Player> findByid(@PathVariable Integer id){
       return playerService.getPlayerById(id);
    }


//    @PutMapping(value = "/{id}", consumes = {"*/*"})
//    public Player addImage(@PathVariable("id") Long id, @RequestBody MultipartFile imageSent) throws IOException {
//        Optional<Player> playerOptional = playerRepository.findByid(id);
//        if (playerOptional.isPresent()) {
//            Player player = playerOptional.get();
//            player.playerImage = imageSent.getBytes();
//
//
//            return playerRepository.save(player);
//        }
//        return null;
//    }



    @PatchMapping("/{id}")
   public Player save(@PathVariable("id") Integer id, @RequestBody UpdatePlayersTeamDTO playerToUpdate){



        Integer playerId = playerToUpdate.getId();
        Integer teamId = playerToUpdate.getTeamId();

         Player updatedPlayer = new Player();
         updatedPlayer.setId(playerId);
         updatedPlayer.setTeamNumber(teamId);

        Player updatedPlayerFinal = modelMapper.map(updatedPlayer, Player.class);


        return playerRepository.save(updatedPlayerFinal);
   }

}












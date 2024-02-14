package com.example.demo.Players;

import com.example.demo.Teams.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping (path = "players")

public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;
    PlayerService playerService;

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
    public Iterable<Player> getPlayersByid(@PathVariable long id) {
        return playerService.getPlayersByid(id);
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

}












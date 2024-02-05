package com.example.demo.Images;


import com.example.demo.Players.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "images")
public class ImageController {

    @Autowired
    public ImageService imageService;
    public ImageRepository imageRepository;

    @GetMapping
    public Iterable<Image> getImages(){
        return imageService.getImages();
    }

    @PostMapping
    public Image save(@RequestBody Image imageSent) {
        return imageRepository.save(imageSent);
    }



}

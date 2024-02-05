package com.example.demo.Images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;


    public Iterable<Image> getImages() {
        return imageRepository.findAll();
    }


}


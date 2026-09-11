package com.elezar.netflixlike.movie_module.controller;

import com.elezar.netflixlike.movie_module.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;


    @PostMapping(
            value = "/test-upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String testUpload(
            @RequestParam String title,
            @RequestParam MultipartFile video,
            @RequestParam MultipartFile poster
    ) {
        System.out.println("Title: " + title);

        System.out.println("Video: " + video.getOriginalFilename());
        System.out.println("Video size: " + video.getSize());

        System.out.println("Poster: " + poster.getOriginalFilename());
        System.out.println("Poster size: " + poster.getSize());

        return "Upload received!";
    }

}

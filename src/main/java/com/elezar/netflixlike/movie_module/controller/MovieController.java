package com.elezar.netflixlike.movie_module.controller;

import com.elezar.netflixlike.movie_module.dto.MovieCreateRequestDto;
import com.elezar.netflixlike.movie_module.dto.MovieResponseDto;
import com.elezar.netflixlike.movie_module.dto.MovieUploadRequest;
import com.elezar.netflixlike.movie_module.mapper.MovieMapper;
import com.elezar.netflixlike.movie_module.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

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


    @Operation(summary = "Upload movie")
    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<MovieResponseDto> saveVideo(
            @Parameter(
                    description = "Movie JSON data",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(
                                    implementation = MovieCreateRequestDto.class
                            )
                    )
            )
            @RequestPart(value = "data") MovieCreateRequestDto request,

            @Parameter(
                    description = "Video file",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE
                    )
            )
            @RequestPart("video") MultipartFile video
            ) {

        log.info("Got request for upload video: {}", request.title());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        movieMapper.domainToDto(movieService.saveVideo(
                                request,
                                video
                                )
                        )
                );
    }
}

package com.elezar.netflixlike.genre_module.controller;

import com.elezar.netflixlike.genre_module.dto.GenreCreateRequestDto;
import com.elezar.netflixlike.genre_module.dto.GenreResponseDto;
import com.elezar.netflixlike.genre_module.mapper.GenreMapper;
import com.elezar.netflixlike.genre_module.service.GenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;
    private final GenreMapper genreMapper;

    @PostMapping("/add")
    public ResponseEntity<GenreResponseDto> createGenre(
            @RequestBody GenreCreateRequestDto requestDto
    ) {
        log.info("Got request for create genre with name: {}", requestDto.name());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        genreMapper.domainToDto(
                                genreService.createGenre(
                                        genreMapper.createRequestDtoToDomain(requestDto)
                                )
                        )
                );
    }
}

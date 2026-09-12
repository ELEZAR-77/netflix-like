package com.elezar.netflixlike.movie_module.dto;

import com.elezar.netflixlike.genre_module.dto.GenreResponseDto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public record MovieResponseDto(
        Long id,

        String title,

        String description,

        Long durationSeconds,

        LocalDate releaseDate,

        String videoPath,

        String posterPath,

        Instant createdAt,

        List<GenreResponseDto> genres
) {
}

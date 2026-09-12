package com.elezar.netflixlike.movie_module.dto;

import com.elezar.netflixlike.genre_module.dto.GenreDomain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;


public record MovieDomain(
        Long id,

        String title,

        String description,

        Long durationSeconds,

        LocalDate releaseDate,

        String videoPath,

        String posterPath,

        Instant createdAt,

        List<GenreDomain> genres
) {
}

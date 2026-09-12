package com.elezar.netflixlike.movie_module.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record MovieCreateRequestDto(
        @NotBlank
        String title,

        @Size(max = 100)
        String description,

        @NotBlank
        List<Long> genreIds,

        @NotBlank
        LocalDate releaseDate
) {
}
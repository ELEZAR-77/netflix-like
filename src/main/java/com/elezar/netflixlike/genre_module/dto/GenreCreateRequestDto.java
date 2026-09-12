package com.elezar.netflixlike.genre_module.dto;

import jakarta.validation.constraints.NotBlank;

public record GenreCreateRequestDto(
        @NotBlank
        String name
) {
}

package com.elezar.netflixlike.genre_module.dto;

import com.elezar.netflixlike.movie_module.dto.MovieDomain;
import com.elezar.netflixlike.movie_module.dto.MovieResponseDto;

import java.util.List;

public record GenreResponseDto(
        Long id,

        String name,

        List<MovieResponseDto> movies
) {
}

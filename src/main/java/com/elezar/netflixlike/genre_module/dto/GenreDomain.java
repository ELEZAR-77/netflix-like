package com.elezar.netflixlike.genre_module.dto;

import com.elezar.netflixlike.movie_module.dto.MovieDomain;

import java.util.List;

public record GenreDomain(
        Long id,

        String name,

        List<MovieDomain> movies
) {
}

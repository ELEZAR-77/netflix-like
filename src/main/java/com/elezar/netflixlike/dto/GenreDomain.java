package com.elezar.netflixlike.dto;

import com.elezar.netflixlike.movie_module.dto.MovieDomain;

import java.util.List;

public record GenreDomain(
        Long id,

        String name,

        List<MovieDomain> movies
) {
}

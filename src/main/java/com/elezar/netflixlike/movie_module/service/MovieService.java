package com.elezar.netflixlike.movie_module.service;

import com.elezar.netflixlike.movie_module.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
}

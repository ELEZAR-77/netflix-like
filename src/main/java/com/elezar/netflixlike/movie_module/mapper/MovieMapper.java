package com.elezar.netflixlike.movie_module.mapper;

import com.elezar.netflixlike.genre_module.mapper.GenreMapper;
import com.elezar.netflixlike.movie_module.dto.MovieDomain;
import com.elezar.netflixlike.movie_module.dto.MovieResponseDto;
import com.elezar.netflixlike.movie_module.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapper {

    @Autowired
    private GenreMapper genreMapper;

    public MovieResponseDto domainToDto(
            MovieDomain movieDomain
    ) {
        return new MovieResponseDto(
                movieDomain.id(),
                movieDomain.title(),
                movieDomain.description(),
                movieDomain.durationSeconds(),
                movieDomain.releaseDate(),
                movieDomain.videoPath(),
                movieDomain.posterPath(),
                movieDomain.createdAt(),
                movieDomain.genres() == null
                ? List.of() : movieDomain.genres()
                              .stream()
                              .map(genreMapper::domainToDto)
                              .toList()
        );
    }

    public MovieDomain dtoToDomain(
            MovieResponseDto responseDto
    ) {
        return new MovieDomain(
                responseDto.id(),
                responseDto.title(),
                responseDto.description(),
                responseDto.durationSeconds(),
                responseDto.releaseDate(),
                responseDto.videoPath(),
                responseDto.posterPath(),
                responseDto.createdAt(),
                responseDto.genres() == null
                        ? List.of() : responseDto.genres()
                                      .stream()
                                      .map(genreMapper::dtoToDomain)
                                      .toList()
        );
    }

    public MovieEntity domainToEntity(
            MovieDomain movieDomain
    ) {
        return new MovieEntity(
                movieDomain.id(),
                movieDomain.title(),
                movieDomain.description(),
                movieDomain.durationSeconds(),
                movieDomain.releaseDate(),
                movieDomain.videoPath(),
                movieDomain.posterPath(),
                movieDomain.createdAt(),
                movieDomain.genres() == null
                        ? List.of() : movieDomain.genres()
                                      .stream()
                                      .map(genreMapper::domainToEntity)
                                      .toList()
        );
    }

    public MovieDomain entityToDomain(
            MovieEntity movieEntity
    ) {
        return new MovieDomain(
                movieEntity.getId(),
                movieEntity.getTitle(),
                movieEntity.getDescription(),
                movieEntity.getDurationSeconds(),
                movieEntity.getReleaseDate(),
                movieEntity.getVideoPath(),
                movieEntity.getPosterPath(),
                movieEntity.getCreatedAt(),
                movieEntity.getGenres() == null
                        ? List.of() : movieEntity.getGenres()
                                      .stream()
                                      .map(genreMapper::entityToDomain)
                                      .toList()
        );
    }
}

package com.elezar.netflixlike.genre_module.mapper;

import com.elezar.netflixlike.genre_module.dto.GenreCreateRequestDto;
import com.elezar.netflixlike.genre_module.dto.GenreDomain;
import com.elezar.netflixlike.genre_module.dto.GenreResponseDto;
import com.elezar.netflixlike.genre_module.entity.GenreEntity;
import com.elezar.netflixlike.movie_module.dto.MovieResponseDto;
import com.elezar.netflixlike.movie_module.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreMapper {

    public GenreDomain createRequestDtoToDomain(
            GenreCreateRequestDto createRequestDto
    ) {
        return new GenreDomain(
                null,
                createRequestDto.name(),
                List.of()
        );
    }

    public GenreResponseDto domainToDto(
            GenreDomain genreDomain
    ) {
        return new GenreResponseDto(
                genreDomain.id(),
                genreDomain.name(),
                List.of()
        );
    }

    public GenreDomain dtoToDomain(
            GenreResponseDto responseDto
    ) {
        return new GenreDomain(
                responseDto.id(),
                responseDto.name(),
                List.of()
        );
    }

    public GenreEntity domainToEntity(
            GenreDomain genreDomain
    ) {
        return new GenreEntity(
                genreDomain.id(),
                genreDomain.name(),
                List.of()
        );
    }

    public GenreDomain entityToDomain(
            GenreEntity genreEntity
    ) {
        return new GenreDomain(
                genreEntity.getId(),
                genreEntity.getName(),
                List.of()
        );
    }
}

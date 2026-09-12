package com.elezar.netflixlike.genre_module.service;

import com.elezar.netflixlike.genre_module.dto.GenreDomain;
import com.elezar.netflixlike.genre_module.mapper.GenreMapper;
import com.elezar.netflixlike.genre_module.repository.GenreRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Transactional
    public GenreDomain createGenre(GenreDomain request) {

        if (genreRepository.existsByName(request.name())) {
            throw new EntityExistsException("Entity with name %s already exists".formatted(request.name()));
        }

        var genreEntity = genreMapper.domainToEntity(request);
        genreRepository.save(genreEntity);

        return genreMapper.entityToDomain(genreEntity);
    }
}

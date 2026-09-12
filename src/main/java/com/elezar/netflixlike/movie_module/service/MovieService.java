package com.elezar.netflixlike.movie_module.service;

import com.elezar.netflixlike.genre_module.entity.GenreEntity;
import com.elezar.netflixlike.genre_module.repository.GenreRepository;
import com.elezar.netflixlike.movie_module.dto.MovieCreateRequestDto;
import com.elezar.netflixlike.movie_module.dto.MovieDomain;
import com.elezar.netflixlike.movie_module.dto.MovieResponseDto;
import com.elezar.netflixlike.movie_module.entity.MovieEntity;
import com.elezar.netflixlike.movie_module.infrastructure.metadata.FfmpegMediaMetadataService;
import com.elezar.netflixlike.movie_module.infrastructure.strogare.LocalFileStorageService;
import com.elezar.netflixlike.movie_module.mapper.MovieMapper;
import com.elezar.netflixlike.movie_module.repository.MovieRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final LocalFileStorageService localFileStorageService;
    private final FfmpegMediaMetadataService mediaMetadataService;
    private final GenreRepository genreRepository;

    @Transactional
    public MovieDomain saveVideo(MovieCreateRequestDto request, MultipartFile video) {

        if (movieRepository.existsByTitle(request.title())) {
            throw new EntityExistsException(
                    "Video with title %s is exists".formatted(request.title())
            );
        }

        String videoPath =
                localFileStorageService.saveVideo(video);

        List<GenreEntity> genres =
                genreRepository.findAllById(
                        request.genreIds()
                );

        if (genres.size() != request.genreIds().size()) {
            throw new IllegalArgumentException("Some genres were not found");
        }

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setTitle(request.title());
        movieEntity.setDescription(request.description());
        movieEntity.setDurationSeconds(mediaMetadataService.getDurationSeconds(
                Paths.get(videoPath)
        ));
        movieEntity.setReleaseDate(request.releaseDate());
        movieEntity.setVideoPath(videoPath);
        movieEntity.setPosterPath("/posters/poster.png");
        movieEntity.setCreatedAt(Instant.now());
        movieEntity.setGenres(genres);

        MovieEntity savedMovie = movieRepository.save(movieEntity);

        return movieMapper.entityToDomain(savedMovie);
    }
}

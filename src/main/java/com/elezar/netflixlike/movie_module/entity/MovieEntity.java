package com.elezar.netflixlike.movie_module.entity;

import com.elezar.netflixlike.genre_module.entity.GenreEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 256)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "duration_seconds", nullable = false)
    private Long durationSeconds;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "video_path", nullable = false, length = 256)
    private String videoPath;

    @Column(name = "poster_path", nullable = false, length = 256)
    private String posterPath;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<GenreEntity> genres;
}

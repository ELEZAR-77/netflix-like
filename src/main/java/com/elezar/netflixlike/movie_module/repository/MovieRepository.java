package com.elezar.netflixlike.movie_module.repository;

import com.elezar.netflixlike.movie_module.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    boolean existsByTitle(String title);
}

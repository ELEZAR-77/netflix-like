package com.elezar.netflixlike.genre_module.repository;

import com.elezar.netflixlike.genre_module.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    boolean existsByName(String name);
}

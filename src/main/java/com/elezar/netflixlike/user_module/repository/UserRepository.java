package com.elezar.netflixlike.user_module.repository;

import com.elezar.netflixlike.user_module.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

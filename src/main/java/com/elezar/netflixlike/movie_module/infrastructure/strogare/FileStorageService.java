package com.elezar.netflixlike.movie_module.infrastructure.strogare;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String saveVideo(MultipartFile video);
    Resource loadVideo(String path);
    void delete(String path);
}

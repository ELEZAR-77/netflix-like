package com.elezar.netflixlike.movie_module.dto;

import org.springframework.web.multipart.MultipartFile;

public class MovieUploadRequest {
    private MovieCreateRequestDto data;
    private MultipartFile video;
}

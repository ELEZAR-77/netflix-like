package com.elezar.netflixlike.movie_module.infrastructure.metadata;

import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class FfmpegMediaMetadataService implements MediaMetadataService{
    @Override
    public long getDurationSeconds(Path videoPath) {


        return 0;
    }
}

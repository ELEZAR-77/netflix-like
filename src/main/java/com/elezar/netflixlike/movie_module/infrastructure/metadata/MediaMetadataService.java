package com.elezar.netflixlike.movie_module.infrastructure.metadata;

import java.nio.file.Path;

public interface MediaMetadataService {
    long getDurationSeconds(Path videoPath);
}
